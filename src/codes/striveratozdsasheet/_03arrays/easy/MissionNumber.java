package codes.striveratozdsasheet._03arrays.easy;

/**
 * MissionNumber
 */
public class MissionNumber {

    public int brute(final int[] arr) {
        int i = 0;
        while (true) {
            boolean contains = false;
            for (int j : arr) {
                if (j == i) {
                    contains = true;
                    break;
                }
            }

            if (!contains)
                return i;
        }
    }

    public int optimized(final int[] arr) {
        final int N = arr.length;
        int sum = N * (N - 1) / 2;
        for (int i : arr) {
            sum -= i;
        }

        return sum;
    }

    public int optimal(final int[] arr) {
        int ans = 0;
        for (int i = 1; i <= arr.length; i++) {
            ans ^= i;
            ans ^= arr[i - 1];
        }

        return ans;
    }

}
