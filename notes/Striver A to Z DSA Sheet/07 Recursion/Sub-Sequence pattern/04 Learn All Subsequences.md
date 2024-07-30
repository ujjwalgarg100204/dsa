- Problem Link: [GeeksForGeeks](https://bit.ly/3US225G)
- Video Solution Link: [Striver](https://youtu.be/b7AYbpM5YrE)
# Print All Sub-sequences with Sum K
- We modify the subsets code [[03 Generate Power set]], and take one more variable called sum and if the at the end when `curr index == arr.length`, then we check if sum is equal to k then we add current sequence to answer 
```java
  private static final class PrintSubsequencesWithSumK {

    public List<List<Integer>> solution(int[] arr, int k) {
      List<List<Integer>> answer = new ArrayList<>();
      helper(arr, k, answer, new ArrayList<>(), 0, 0);
      return answer;
    }

    private void helper(int[] arr, int k, List<List<Integer>> sequences, List<Integer> currSeq,
        int sum, int currIdx) {
      if (currIdx == arr.length) {
        if (sum == k) {
          sequences.add(new ArrayList<>(currSeq));
        }
        return;
      }

      // pick case
      currSeq.add(arr[currIdx]);
      sum += arr[currIdx];
      helper(arr, k, sequences, currSeq, sum, currIdx + 1);
      sum -= arr[currIdx];
      currSeq.removeLast();

      // not pick case
      helper(arr, k, sequences, currSeq, sum, currIdx + 1);
    }
  }
```

# Print First Subsequence with Sum K
- We figure out a way to send to each function call if we found the subsequence, we do this by modifying the return type of the `helper` function, and we check on each call if we found it or not, and if did find then we return true otherwise we keep checking
```java
  private static final class PrintFirstSubsequencesWithSumK {

    public List<Integer> solution(int[] arr, int k) {
      List<Integer> ans = new ArrayList<>();
      helper(arr, k, ans, 0, 0);
      return ans;
    }

    private boolean helper(int[] arr, int k, List<Integer> seq,
        int sum, int currIdx) {
      if (currIdx == arr.length) {
        return sum == k;
      }

      // pick case
      seq.add(arr[currIdx]);
      sum += arr[currIdx];
      boolean subSeqFnd = helper(arr, k, seq, sum, currIdx + 1);
      if (subSeqFnd) {
        return true;
      }
      seq.removeLast();
      sum -= arr[currIdx];

      // not pick case
      subSeqFnd = helper(arr, k, seq, sum, currIdx + 1);
      return subSeqFnd;
    }
  }
```
# GeeksForGeeks Problem: Better String
- Problem Link: [GeeksForGeeks](https://www.geeksforgeeks.org/problems/better-string/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=better-string)
## Solutions
### Brute
- This gives `TLE`
```java
  // Brute solution
  public static String betterString(String s1, String s2) {
    Set<String> s1SubSequences = getSubSequences(s1, new HashSet<>(), new StringBuilder(), 0);
    Set<String> s2SubSequences = getSubSequences(s2, new HashSet<>(), new StringBuilder(), 0);

    return s2SubSequences.size() > s1SubSequences.size() ? s2 : s1;
  }

  private static Set<String> getSubSequences(String s, Set<String> ans, StringBuilder currStr,
      int idx) {
    if (idx == s.length()) {
      ans.add(currStr.toString());
      return ans;
    }

    // pick case
    currStr.append(s.charAt(idx));
    getSubSequences(s, ans, currStr, idx + 1);
    currStr.deleteCharAt(currStr.length() - 1);

    // not pick case
    return getSubSequences(s, ans, currStr, idx + 1);
  }
```