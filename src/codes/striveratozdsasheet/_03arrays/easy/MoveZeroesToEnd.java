package codes.striveratozdsasheet._03arrays.easy;

/**
 * MoveZeroesToEnd
 */
public class MoveZeroesToEnd {

    public void brute(int[] arr) {
        int[] cpy = new int[arr.length];

        int zeroCount = 0;
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                cpy[j] = arr[i];
                j++;
            } else {
                zeroCount++;
            }
        }

        for (int i = arr.length - 1, j = 0; j < zeroCount; j++, i--) {
            cpy[i] = 0;
        }

        System.arraycopy(cpy, 0, arr, 0, arr.length);
    }

    public void optimal(int[] arr) {
        int i = -1;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != 0) {
                arr[i + 1] = arr[j];
                i++;
            }
        }
        // in case there is no non-zero element in the array
        if (i == -1) {
            return;
        }
        i++;
        while (i < arr.length) {
            arr[i] = 0;
            i++;
        }
    }
}
