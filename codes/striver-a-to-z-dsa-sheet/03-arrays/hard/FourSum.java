import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {

    public String getProblemLink() {
        return "https://leetcode.com/problems/4sum/description/";
    }

    public static List<List<Integer>> optimal(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> choplets = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue;
            for (int j = i + 1; j < arr.length; j++) {
                if (j > i + 1 && arr[j] == arr[j - 1])
                    continue;

                int k = j + 1;
                int l = arr.length - 1;
                while (k < l) {
                    long sum = (long) arr[i] + arr[j] + arr[k] + arr[l];
                    if (sum > target) {
                        l--;
                    } else if (sum < target) {
                        k++;
                    } else {
                        choplets.add(List.of(arr[i], arr[j], arr[k], arr[l]));
                        k++;
                        l--;
                        while (k < l && arr[k] == arr[k - 1]) {
                            k++;
                        }
                        while (k < l && arr[l] == arr[l + 1]) {
                            l--;
                        }
                    }
                }
            }
        }

        return choplets;
    }
}
