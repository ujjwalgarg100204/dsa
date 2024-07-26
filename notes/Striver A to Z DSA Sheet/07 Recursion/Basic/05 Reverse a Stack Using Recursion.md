- Problem Link: [GeeksForGeeks](https://bit.ly/3podAiY)
- Video Solution Link: NA
## Solution
Refer [[04 Sort a Stack Using Recursion]]
```java
  public static void solution(Stack<Integer> s) {
    if (s.isEmpty()) {
      return;
    }

    int n = s.pop();
    solution(s);
    pushElementInReversedOrder(s, n);
  }

  private static void pushElementInReversedOrder(Stack<Integer> s, int n) {
    if (s.isEmpty()) {
      s.push(n);
      return;
    }

    int curr = s.pop();
    pushElementInReversedOrder(s, n);
    s.push(curr);
  }
```