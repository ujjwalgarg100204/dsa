import java.util.Scanner;

public class ClumsyFactorial {

    /**
     * Calculates the clumsy factorial of a given number.
     *
     * @param n The number for which the clumsy factorial is to be calculated.
     * @return The clumsy factorial of the given number.
     */
    public static int solution(int n) {
        int ans = 0;
        int sign = 1;

        for (int i = n; i > 0; i -= 4) {
            int acc = i;

            // i - 1, i - 2, i - 3 might not exist, so check first
            if (i - 1 > 0) {
                acc *= i - 1;
            }
            if (i - 2 > 0) {
                acc /= i - 2;
            }

            // only the first operation is added, the rest are subtracted
            ans += sign * acc;

            if (i - 3 > 0) {
                ans += i - 3;
            }

            sign = -1;
        }

        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        System.out.println(solution(n));

        scanner.close();
    }
}
