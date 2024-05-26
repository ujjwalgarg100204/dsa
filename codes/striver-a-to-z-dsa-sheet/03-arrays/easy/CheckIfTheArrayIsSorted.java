/**
 * CheckIfTheArrayIsSorted
 */
public class CheckIfTheArrayIsSorted {

    public boolean optimal(int[] nums) {
        /*
         * Observations:
         * An array may or may not be rotated
         * An array if rotated, then rotatedPt would where arr[i] > arr[i + 1],
         * rotatedPt would i;
         * On rotation, max of array would lie on rotatedPt
         * On rotation, the min of the subarray from 0 to rotatedPt should be >
         * each element of the subarray from rotatedPt + 1 till end
         */

        // find the rotatedPt
        int rotatedPt = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            min = Math.min(min, nums[i]);
            if (nums[i] > nums[i + 1]) {
                rotatedPt = i;
                break;
            }
        }

        // no rotated point found in the array
        if (rotatedPt == -1)
            return true;

        // iterate over the left over array, no element should exceed min
        for (int i = rotatedPt + 1; i < nums.length - 1; i++) {
            if (nums[i] > min)
                return false;
            if (nums[i] > nums[i + 1])
                return false;
        }

        // last element is skipped in the loop
        if (nums[nums.length - 1] > min)
            return false;

        return true;
    }
}
