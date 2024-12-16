import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(br.readLine());
    while (testCases-- > 0) {
      int[] nx = inputIntArray(br);
      int[] budget = inputIntArray(br);

      System.out.println(better(nx[1], budget));
    }
    br.close();
  }

  private static int better(int x, int[] budget) {
    // find total excess and calculate already satisfied budget count
    int satisfiedBudgetCount = 0;
    long totalExcess = 0;
    for (int i : budget) {
      totalExcess += Math.max(i - x, 0);
      satisfiedBudgetCount += i >= x ? 1 : 0;
    }

    // get all places where you need to distribute the excess
    // set contains index mapped to (number needed to reach x)
    List<Long> differences = new ArrayList<>();
    for (int i : budget) {
      if (i < x) {
        differences.add((long) x - i);
      }
    }
    differences.sort(Long::compare);

    // now distribute it
    for (long i : differences) {
      if (totalExcess - i >= 0) {
        satisfiedBudgetCount++;
        totalExcess -= i;
      } else {
        break;
      }
    }

    return satisfiedBudgetCount;
  }

  private static int optimal(int x, int[] budget) {
    // sort the array in reverse order
    Arrays.sort(budget);
    reverse(budget);

    long surplus = 0;
    int count = 0;
    for (int i : budget) {
      // as the array is sorted in reverse conditions, it will first calculate
      // surplus and increment count if it exceeds x
      // after this calculate deficit and subtract from array
      if (i >= x) {
        surplus += i - x;
        count++;
      } else {
        long deficit = (long) x - i;
        if (surplus >= deficit) {
          surplus -= deficit;
          count++;
        } else {
          break;
        }
      }
    }

    return count;
  }

  private static int[] inputIntArray(BufferedReader br) throws IOException {
    String[] inp = br.readLine().split(" ");
    int[] intArr = new int[inp.length];
    for (int i = 0; i < inp.length; i++) {
      intArr[i] = Integer.parseInt(inp[i]);
    }
    return intArr;
  }

  private static void reverse(int[] arr) {
    for (int i = 0; i < arr.length / 2; i++) {
      int temp = arr[i];
      arr[i] = arr[arr.length - i - 1];
      arr[arr.length - i - 1] = temp;
    }
  }
}
