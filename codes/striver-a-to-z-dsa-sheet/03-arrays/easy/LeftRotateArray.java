/**
 * LeftRotateArray
 */
public class LeftRotateArray {

    public void leftRotateArrayBy1Place(int[] arr) {
        int temp = arr[0];
        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;
    }

    public void brute(int[] arr, int k) {
        k %= arr.length;

        int[] cpy = new int[arr.length];
        // copy last k elments from arr to cpy
        for (int i = arr.length - 1, j = k - 1; j >= 0; j--, i--) {
            cpy[j] = arr[i];
        }

        // copy rest of the elements to cpy
        for (int i = 0; i < arr.length - k; i++) {
            cpy[i + k] = arr[i];
        }

        // copy `cpy` array back to `arr`
        for (int i = 0; i < arr.length; i++) {
            arr[i] = cpy[i];
        }
    }

    public void optimal(int[] arr, int k) {
        if (k == 0)
            return;
        k = arr.length - (k % arr.length);

        _reverseArr(arr, 0, k);
        _reverseArr(arr, k, arr.length);
        _reverseArr(arr, 0, arr.length);
    }

    private void _reverseArr(int[] arr, int start, int end) {
        int left = start, right = end - 1;

        while (left < right) {
            _swap(arr, left, right);
            left++;
            right--;
        }
    }

    private void _swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
