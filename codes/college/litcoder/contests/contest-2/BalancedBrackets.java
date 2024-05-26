import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedBrackets {

    /**
     * Checks if the given expression has balanced brackets.
     *
     * @param exp the expression to be checked
     * @return true if the brackets are balanced, false otherwise
     */
    public static boolean solution(String exp) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : exp.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else if ((stack.peek() == '(' && c == ')') ||
                    (stack.peek() == '{' && c == '}') ||
                    (stack.peek() == '[' && c == ']')) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        // If the stack is not empty, then some open brackets are left
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String expression = scanner.next();
        if (solution(expression)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

        scanner.close();
    }
}
