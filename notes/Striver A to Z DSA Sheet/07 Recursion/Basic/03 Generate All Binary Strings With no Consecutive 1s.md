- Problem Link: [LeetCode](https://leetcode.com/problems/count-good-numbers/)
- Video Solution Link: NA
## Solution
We use recursion to solve this. I recurse from n to base case, ie, `n==1`, now we iterate over the current string, and
- if last character is `1`, I only add `0` and move on
- if last character is `0`, I add both `0` and `1`
In the code, since I have to return only `n` sized strings, so I manipulate one string in-place and add another string to list.
```java
  private static List<String> solution(int n) {
    if (n == 1) {
      List<String> strings = new ArrayList<>();
      strings.add("1");
      strings.add("0");
      return strings;
    }
    var strings = solution(n - 1);
    // add 0 and 1 to both making sure that it doesn't become consecutive
    int size = strings.size();
    for (int i = 0; i < size; i++) {
      String s = strings.get(i);
      if (s.charAt(s.length() - 1) == '1') {
        strings.set(i, s.concat("0"));
      } else {
        // set the current string to have 0 appended
        strings.set(i, s.concat("0"));
        // add a new string with 1 at last
        strings.add(s.concat("1"));
      }
    }
    return strings;
  }
```