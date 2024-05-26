import java.util.Arrays;
import java.util.Scanner;

public class ContiguousArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = Arrays
                .stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(solution(arr));

        sc.close();
    }

    private static int solution(int[] arr) {
        int longestContArrLen = 0;

        // check all sub-arrays for all longest contiguous sub-array
        for (int i = 0; i < arr.length; i++) {
            int zeroCount = 0;
            int oneCount = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] == 0) {
                    zeroCount++;
                } else {
                    oneCount++;
                }

                if (zeroCount == oneCount) {
                    longestContArrLen = Math.max(longestContArrLen, j - i + 1);
                }
            }
        }
        return longestContArrLen;
    }
}
