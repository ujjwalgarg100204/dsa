package codes.college.litcoder.module4.lab1;

import java.util.Scanner;

public class ArrayManipulation {

    /**
     * Calculates the maximum value in an array after performing a series of
     * queries.
     *
     * @param n       The size of the array.
     * @param queries The queries to be performed on the array.
     * @return The maximum value in the array after performing the queries.
     */
    public static long solution(int n, int[][] queries) {
        long[] arr = new long[n];

        for (int[] query : queries) {
            int start = query[0];
            int end = query[1];
            int increment = query[2];

            // 1 index queries
            for (int i = start - 1; i < end; i++) {
                arr[i] += increment;
            }
        }

        long max = arr[0];
        for (long num : arr) {
            if (num > max) {
                max = num;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int noOfQueries = scanner.nextInt();
        int[][] queries = new int[noOfQueries][3];

        for (int i = 0; i < noOfQueries; i++) {
            for (int j = 0; j < 3; j++) {
                queries[i][j] = scanner.nextInt();
            }
        }

        System.out.println(solution(n, queries));

        scanner.close();
    }
}
