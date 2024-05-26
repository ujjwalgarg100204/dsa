import java.util.ArrayDeque;
import java.util.Deque;

/**
 * StackPermutation
 */
public class StackPermutation {

    public boolean isStackPermutation(int[] original, int[] permutated) {
        Deque<Integer> stack = new ArrayDeque<>(original.length);

        int j = 0;
        for (int i = 0; i < original.length; i++) {
            stack.push(original[i]);

            if (stack.peek() == permutated[j]) {
                stack.pop();
                j++;
            }
        }

        return stack.isEmpty() && j == permutated.length;
    }
}
