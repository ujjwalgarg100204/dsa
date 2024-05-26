import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class QueryKthSmallestTrimmedNumber {

    /**
     * Calculates the index of the kth smallest trimmed number for each query.
     *
     * @param nums    The list of numbers.
     * @param queries The list of queries, where each query contains the value of k
     *                and the trim value.
     * @return The list of indices of the kth smallest trimmed number for each
     *         query.
     */
    public static List<Integer> solution(
            List<String> nums,
            List<List<Integer>> queries) {
        List<Integer> ans = new ArrayList<>();

        for (List<Integer> query : queries) {
            int k = query.get(0);
            int trim = query.get(1);

            // Trim the numbers to its rightmost trim(i) digits
            List<String> trimmedArr = trimNumbers(nums, trim);
            // Determine the index of the kth smallest number and add it to ans
            ans.add(kthSmallestNumIndex(trimmedArr, k));
        }

        return ans;
    }

    /**
     * Trims the numbers in the given list to the specified length.
     *
     * @param nums    the list of numbers to be trimmed
     * @param trimLen the length to which the numbers should be trimmed
     * @return a new list containing the trimmed numbers
     */
    public static List<String> trimNumbers(List<String> nums, int trimLen) {
        List<String> trimmedArr = new ArrayList<>();
        for (String num : nums) {
            trimmedArr.add(trimNumber(num, trimLen));
        }
        return trimmedArr;
    }

    /**
     * Trims the given number by removing the specified number of digits from the
     * beginning.
     *
     * @param num     the number to be trimmed
     * @param trimLen the number of digits to be removed from the beginning of the
     *                number
     * @return the trimmed number
     */
    public static String trimNumber(String num, int trimLen) {
        return num.substring(num.length() - trimLen);
    }

    /**
     * Returns the index of the kth smallest number in the given list of strings.
     *
     * @param arr The list of strings containing numbers.
     * @param k   The position of the desired smallest number.
     * @return The index of the kth smallest number.
     * @throws NoSuchElementException if the list is empty or if k is out of range.
     */
    public static int kthSmallestNumIndex(List<String> arr, int k) {
        List<Integer> intMappedArr = new ArrayList<>();
        for (String str : arr) {
            intMappedArr.add(Integer.parseInt(str));
        }

        int num = intMappedArr
                .stream()
                .sorted()
                .skip(k - 1)
                .findFirst()
                .orElseThrow();
        return intMappedArr.indexOf(num);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> nums = Arrays
                .stream(scanner.nextLine().split(" "))
                .collect(Collectors.toList());

        int queryCount = scanner.nextInt();
        List<List<Integer>> queries = new ArrayList<>();
        for (int i = 0; i < queryCount; i++) {
            List<Integer> query = new ArrayList<>();
            query.add(scanner.nextInt());
            query.add(scanner.nextInt());
            queries.add(query);
        }

        List<Integer> result = solution(nums, queries);
        for (int i : result) {
            System.out.print(i + " ");
        }
        System.out.println();

        scanner.close();
    }
}
