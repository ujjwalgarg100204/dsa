- Problem Link: [GeeksForGeeks](https://bit.ly/3Pu0YBn)
- Video Solution Link: NA
## Solution
![[IMG_20240726_111247.jpg]]
```java
  public Stack<Integer> sort(Stack<Integer> stack) {
    sortStack(stack);
    return stack;
  }

  // I am using recursion to iterate till stack is completely empty and each element is
  // stored in its recursion context this is O(N)</p>
  private static void sortStack(Stack<Integer> stack) {
    if (stack.isEmpty()) {
      return;
    }
    int n = stack.pop();
    sortStack(stack);
    sortStackHelper(stack, n);
  }

  // In this function, I have to put `n` in correct position to stack,
  // I will push `n` to stack only if the top of stack is smaller than current
  // element or stack is empty
  // To make sure that stack is sorted, I use trick of previous question
  // I iterate till I find the correct position in the stack and store each
  // element in recursion context
  private static void sortStackHelper(Stack<Integer> stack, int n) {
    if (stack.isEmpty() || stack.peek() < n) {
      stack.push(n);
      return;
    }

    int el = stack.pop();
    sortStackHelper(stack, n);
    stack.push(el);
  }
```