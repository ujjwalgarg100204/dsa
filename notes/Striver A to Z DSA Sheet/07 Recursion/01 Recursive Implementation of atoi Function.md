- Problem Link: [LeetCode](https://leetcode.com/problems/string-to-integer-atoi/)
- Video Solution Link: [Random YT](https://www.youtube.com/watch?v=hlxfbrgNgLg)
## Solutions
### Iterative
```java
  public int iterativeSolution(String s) {
    int idx = 0;
    // ignore all leading whitespaces
    while (idx < s.length() && s.charAt(idx) == ' ') {
      idx++;
    }
    if (idx == s.length()) {
      // boundary check
      return 0;
    }

    boolean isPositive = true;
    if (s.charAt(idx) == '-' || s.charAt(idx) == '+') {
      isPositive = s.charAt(idx) == '+';
      idx++;
    }

    // skip leading zeroes
    while (idx < s.length() && s.charAt(idx) == '0') {
      idx++;
    }

    // start conversion of number
    long number = 0;
    while (idx < s.length() && Character.isDigit(s.charAt(idx))) {
      number = number * 10 + Character.getNumericValue(s.charAt(idx));
      if (number > Integer.MAX_VALUE) {
        number = Integer.MAX_VALUE + 1L;
      }
      idx++;
    }

    if (isPositive) {
      return (int) Math.min(Integer.MAX_VALUE, number);
    } else {
      number *= -1;
      return (int) Math.max(Integer.MIN_VALUE, number);
    }
  }
```
### Recursive
