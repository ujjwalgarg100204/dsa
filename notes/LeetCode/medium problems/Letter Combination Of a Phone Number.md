 - Problem Link: [LeetCode](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)
## Solution using Recursion
- We use similar approach used in [[03 Generate Power set]] problem in which we generated all subsets using recursion, here, instead of having choose or not to choose, we only have to choose
```java
  private static final Map<Character, List<Character>> phone = Map.of(
      '2', List.of('a', 'b', 'c'),
      '3', List.of('d', 'e', 'f'),
      '4', List.of('g', 'h', 'i'),
      '5', List.of('j', 'k', 'l'),
      '6', List.of('m', 'n', 'o'),
      '7', List.of('p', 'q', 'r', 's'),
      '8', List.of('t', 'u', 'v'),
      '9', List.of('w', 'x', 'y', 'z')
  );


  public List<String> letterCombinations(String digits) {
    if (digits.isEmpty()) {
      return new ArrayList<>(0);
    }
    int maxSize = getMaxSize(digits);
    List<String> answerList = new ArrayList<>(maxSize);
    helper(digits, answerList, new StringBuilder(), 0);
    return answerList;
  }

  private int getMaxSize(String digits) {
    int size = 1;
    for (int i = 0; i < digits.length(); i++) {
      char c = digits.charAt(i);
      size *= phone.get(c).size();
    }

    return size;
  }

  private void helper(String digits, List<String> answerList, StringBuilder curr, int currIndex) {
    if (currIndex == digits.length()) {
      answerList.add(curr.toString());
      return;
    }

    List<Character> possibleChars = phone.get(digits.charAt(currIndex));
    for (var c : possibleChars) {
      curr.append(c);
      helper(digits, answerList, curr, currIndex + 1);
      curr.deleteCharAt(curr.length() - 1);
    }
  }
```