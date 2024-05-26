import java.util.List;

/**
 * RepeatingAndMissingNumber
 */
public class RepeatingAndMissingNumber {

    public String getProblemLink() {
        return "https://www.codingninjas.com/studio/problems/missing-and-repeating-numbers_6828164";
    }

    public int[] brute(int[] arr) {
        int[] countArr = new int[arr.length + 1];
        // find count of each element
        for (int i : arr) {
            countArr[i]++;
        }

        // find p, which appears exactly twice and q which doesn't appear
        int p = 0, q = 0;
        for (int i = 1; i < countArr.length; i++) {
            if (countArr[i] == 2)
                p = i;
            else if (countArr[i] == 0)
                q = i;
        }

        // find q, which doesn't appear
        return new int[] { p, q };
    }

    public int[] optimalUsingMaths(int[] arr) {
        // p = repeating twice
        // q = not occuring
        // find all the required sum
        int n = arr.length;
        int sumN = (n * (n + 1)) / 2;
        long sumOfSqN = (n * (n + 1) * (2 * n + 1)) / 6;
        int sumArr = 0;
        long sumOfSqArr = 0;
        for (int i : arr) {
            sumArr += i;
            sumOfSqArr += (long) i * i;
        }

        // find p and q through solution
        int pMinusq = sumN - sumArr;
        int pPlusq = (int) (sumOfSqN - sumOfSqArr) / pMinusq;

        int p = (pMinusq + pPlusq) / 2;
        int q = (pPlusq - pMinusq) / 2;

        return new int[] { q, p };
    }

}
