/**
 * LargestElementInArray
 */
public class LargestElementInArray {

    public int solution(int[] arr) {
        int max = arr[0];
        for (int i : arr) {
            max = Math.max(max, i);
        }
        return max;
    }

}
