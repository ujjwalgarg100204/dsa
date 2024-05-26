import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubArraysWithXorK {

    public String getProblemLink() {
        return "https://www.codingninjas.com/studio/problems/subarrays-with-xor-k_6826258";
    }

    public int brute(int[] arr, int k) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int xor = 0;
                for (int l = i; l <= j; l++) {
                    xor ^= arr[l];
                }
                if (xor == k)
                    count++;
            }
        }

        return count;
    }

    public int better(int[] arr, int k) {
        int count = 0;

        // generate all sub-arrays, and check xor of each array
        for (int i = 0; i < arr.length; i++) {
            int xor = 0;
            for (int j = i; j < arr.length; j++) {
                xor ^= arr[j];
                if (xor == k)
                    count++;
            }
        }

        return count;
    }

    public int optimal(int[] nums, int k) {
        // storing xor as key, count of that xor as value
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;
        int currXor = 0;
        for (int i : nums) {
            currXor ^= i;

            int x = currXor ^ k;
            if (map.containsKey(x)) {
                count += map.get(x);
            }
            map.merge(currXor, 1, Integer::sum);
        }

        return count;
    }
}
