import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class SlidingSubarrayBeauty {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = Arrays
                .stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int subArrSize = sc.nextInt();
        int k = sc.nextInt();

        for (int beauty : getBeautyOfArr(arr, subArrSize, k)) {
            System.out.print(beauty + " ");
        }
        System.out.println();

        sc.close();
    }

    /**
     * Calculates the beauty of each subarray in the given array.
     *
     * @param arr        the input array
     * @param subArrSize the size of each subarray
     * @param k          the position of the smallest element in each subarray
     * @return an array containing the beauty of each subarray
     */
    private static int[] getBeautyOfArr(int[] arr, int subArrSize, int k) {
        int[] beauties = new int[arr.length - subArrSize + 1];

        // iterate over all sub-arrays
        for (int i = 0; i + subArrSize <= arr.length; i++) {
            // find sub-array parameters
            int subArrStart = i;
            int subArrEnd = i + subArrSize;

            // find kth smallest element in sub-array
            beauties[i] = kthSmallestInArr(arr, subArrStart, subArrEnd, k);
        }

        return beauties;
    }

    /**
     * Finds the kth smallest element in a subarray of an integer array.
     *
     * @param arr   the integer array
     * @param start the starting index of the subarray
     * @param stop  the ending index of the subarray (exclusive)
     * @param k     the position of the smallest element to find
     * @return the kth smallest element in the subarray
     */
    private static int kthSmallestInArr(int[] arr, int start, int stop, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int i = start; i < stop; i++) {
            pq.offer(arr[i]);

            // if size of max heap exceeds K, remove largest element
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
