import java.util.List;

/**
 * NumberOfInversions
 */
public class NumberOfInversions {

    public String getProblemLink() {
        return "https://www.codingninjas.com/studio/problems/number-of-inversions_6840276";
    }

    public int brute(int[] arr) {
        int pairCount = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    pairCount++;
                }
            }
        }

        return pairCount;
    }

    // TODO: solve it using optimal approach
    @Solution
    public int optimal(int[] arr) {
        int pairCount = 0;

        return pairCount;
    }

}
