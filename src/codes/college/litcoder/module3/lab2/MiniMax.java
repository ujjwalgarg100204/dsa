package codes.college.litcoder.module3.lab2;

import java.util.Arrays;
import java.util.Scanner;

public class MiniMax {

    public static int[] solution(int[] numbers) {
        // Sort the numbers first
        Arrays.sort(numbers);

        // Calculate min and max numbers
        int minSum = numbers[0] + numbers[1] + numbers[2] + numbers[3];
        int maxSum = numbers[2] + numbers[3] + numbers[4] + numbers[5];

        return new int[] { minSum, maxSum };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcases = scanner.nextInt();

        for (int t = 0; t < testcases; t++) {
            int[] numbers = new int[6];
            for (int i = 0; i < 6; i++) {
                numbers[i] = scanner.nextInt();
            }

            int[] result = solution(numbers);
            System.out.println(result[0] + " " + result[1]);
        }
    }
}
