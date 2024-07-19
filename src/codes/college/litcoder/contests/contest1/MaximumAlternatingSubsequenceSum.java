package codes.college.litcoder.contests.contest1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaximumAlternatingSubsequenceSum {

    /**
     * Calculates the maximum alternating subsequence sum from the given list of
     * integers.
     *
     * @param arr The list of integers
     * @return The maximum alternating subsequence sum
     */
    public static int solution(List<Integer> arr) {
        int maxSum = 0;

        List<List<Integer>> subsequences = getAllSubsequences(arr);
        for (List<Integer> subsequence : subsequences) {
            int evenIndicesSum = getEvenIndicesSum(subsequence);
            int oddIndicesSum = getOddIndicesSum(subsequence);

            int alternatingSum = evenIndicesSum - oddIndicesSum;

            maxSum = Math.max(maxSum, alternatingSum);
        }

        return maxSum;
    }

    /**
     * Calculates the sum of elements at even indices in the given list.
     *
     * @param arr the list of integers
     * @return the sum of elements at even indices
     */
    public static int getEvenIndicesSum(List<Integer> arr) {
        if (arr.isEmpty()) {
            return 0;
        }
        return arr
                .stream()
                .filter(i -> arr.indexOf(i) % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    /**
     * Calculates the sum of elements at odd indices in the given list.
     *
     * @param arr the list of integers
     * @return the sum of elements at odd indices
     */
    public static int getOddIndicesSum(List<Integer> arr) {
        if (arr.isEmpty()) {
            return 0;
        }
        return arr
                .stream()
                .filter(i -> arr.indexOf(i) % 2 != 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    /**
     * Generates all possible subsequences of the given array starting from the
     * specified index.
     * Each subsequence is added to the result list.
     *
     * @param arr     the input array
     * @param start   the starting index
     * @param currSeq the current subsequence being generated
     * @param result  the list to store the generated subsequences
     */
    public static void getSubsequences(
            List<Integer> arr,
            int start,
            List<Integer> currSeq,
            List<List<Integer>> result) {
        result.add(new ArrayList<>(currSeq));

        for (int i = start; i < arr.size(); i++) {
            if (i > start && arr.get(i).equals(arr.get(i - 1))) {
                continue;
            }

            currSeq.add(arr.get(i));
            getSubsequences(arr, i + 1, currSeq, result);

            currSeq.removeLast();
        }
    }

    /**
     * Returns a list of all subsequences of the given array.
     *
     * @param arr the input array
     * @return a list of all subsequences
     */
    public static List<List<Integer>> getAllSubsequences(List<Integer> arr) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currSeq = new ArrayList<>();

        getSubsequences(arr, 0, currSeq, result);
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arrSize = scanner.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < arrSize; i++) {
            arr.add(scanner.nextInt());
        }

        System.out.println(solution(arr));

        scanner.close();
    }
}
