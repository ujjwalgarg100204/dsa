package codes.striveratozdsasheet.recursion._02SubsequencesPaterrn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPatternsOfSubsequences {

  private static final int[] ARR = new int[]{1, 2, 1};
  private static final int K = 2;

  private static final class PrintSubsequencesWithSumK {

    public static void main(String[] args) {
      System.out.println(new PrintSubsequencesWithSumK().solution(ARR, K));
    }

    public List<List<Integer>> solution(int[] arr, int k) {
      List<List<Integer>> answer = new ArrayList<>();
      helper(arr, k, answer, new ArrayList<>(), 0, 0);
      return answer;
    }

    private void helper(int[] arr, int sum, List<List<Integer>> sequences, List<Integer> currSeq,
        int currIdx) {
      if (currIdx == arr.length) {
        if (sum == 0) {
          sequences.add(new ArrayList<>(currSeq));
        }
        return;
      }

      // pick case
      currSeq.add(arr[currIdx]);
      helper(arr, sum - arr[currIdx], sequences, currSeq, currIdx + 1);
      currSeq.removeLast();

      // not pick case
      helper(arr, sum, sequences, currSeq, currIdx + 1);
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

  private static final class PrintFirstSubsequencesWithSumK {

    public static void main(String[] args) {
      System.out.println(new PrintFirstSubsequencesWithSumK().solution(ARR, K));
    }

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

  // TODO: It's Optimal Solution Requires DP, so until you learn that skip it
  // Geeks for Geeks question: Better String
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
}
