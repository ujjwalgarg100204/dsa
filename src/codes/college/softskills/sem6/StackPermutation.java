package codes.college.softskills.sem6;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * StackPermutation
 */
public class StackPermutation {

    public boolean isStackPermutation(int[] original, int[] permutated) {
        Deque<Integer> stack = new ArrayDeque<>(original.length);

        int j = 0;
      for (int k : original) {
        stack.push(k);

        if (stack.peek() == permutated[j]) {
          stack.pop();
          j++;
        }
      }

        return stack.isEmpty() && j == permutated.length;
    }
}
