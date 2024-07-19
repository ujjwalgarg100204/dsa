package codes.striveratozdsasheet._03arrays.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * FindTheNumberThatAppearsOnceAndOtherNumbersTwice
 */
public class FindTheNumberThatAppearsOnceAndOtherNumbersTwice {

    public int brute(final int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i : nums) {
            map.merge(i, 1, (key, value) -> value + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        // dummy return statement
        return -1;
    }

    public int optimal(final int[] nums) {
        int xor = 0;
        for (int i : nums) {
            xor ^= i;
        }
        return xor;
    }

}
