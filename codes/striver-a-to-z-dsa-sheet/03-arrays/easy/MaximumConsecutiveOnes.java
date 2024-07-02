/**
 * MaximumConsecutiveOnes
 */
public class MaximumConsecutiveOnes {

    public int solution(final int[] nums) {
        int currCnt = 0;
        int maxCnt = 0;
        for (int i : nums) {
            if (i == 1) {
                currCnt++;
            } else {
                maxCnt = Math.max(maxCnt, currCnt);
                currCnt = 0;
            }
        }

        maxCnt = Math.max(maxCnt, currCnt);

        return maxCnt;
    }
}
