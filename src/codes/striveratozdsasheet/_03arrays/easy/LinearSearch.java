package codes.striveratozdsasheet._03arrays.easy;

/**
 * LinearSearch
 */
public class LinearSearch {

    public int solution(final int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == k) {
                return i;
            }
        }

        return -1;
    }
}
