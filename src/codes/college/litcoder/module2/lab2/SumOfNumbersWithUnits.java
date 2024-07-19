package codes.college.litcoder.module2.lab2;

import java.util.Scanner;

public class SumOfNumbersWithUnits {

    /**
     * Calculates the minimum number of terms required to form a sum equal to 'n'
     * using multiples of 'k'.
     *
     * @param n The target sum.
     * @param k The multiple to be used.
     * @return The minimum number of terms required. Returns -1 if it is not
     *         possible to form the sum.
     */
    public static int solution(int n, int k) {
        // if num is 0 then it's an empty set
        if (n == 0) {
            return 0;
        } else if (n < k) {
            return -1;
        }

        int minKTerms = -1;
        int nUnitDig = n % 10;
        for (int i = 1; i <= 10; i++) {
            if (nUnitDig == (i * k) % 10) {
                minKTerms = i;
                break;
            }
        }

        if (minKTerms * k > n) {
            return -1;
        }

        return minKTerms;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(solution(n, k));

        scanner.close();
    }
}
