import java.util.HashMap;
import java.util.Map;

/**
 * LongestSubarrayWithSum
 */
public class LongestSubarrayWithSum {

    public int brute(final int[] arr, int k) {
        int maxLength = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }

    public int optimal(final int[] arr, int k) {
        int maxLen = Integer.MIN_VALUE;
        Map<Integer, Integer> prefixSum = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k) {
                maxLen = Math.max(maxLen, i + 1);
            } else if (prefixSum.containsKey(sum - k)) {
                maxLen = Math.max(maxLen, i - prefixSum.get(sum - k));
            }

            prefixSum.putIfAbsent(sum, i);
        }

        return maxLen;
    }

    public int optimalIfAllPositives(final int[] arr, int k) {
        if (arr.length == 1) {
            return arr[0] == k ? 1 : 0;
        }

        int maxLen = 0;

        int i = 0, j = 1;
        int sum = arr[i] + arr[j];

        while (j < arr.length) {
            if (sum == k) {
                maxLen = Math.max(maxLen, j - i + 1);
            }
            while (sum > k && i <= j) {
                sum -= arr[i];
                i++;
            }
            j++;
        }

        return maxLen;
    }

}
