import java.util.ArrayList;
import java.util.List;

public class RearrangeArrayInAlternatingPositiveandNegativeItems {

  public int[] brute(int[] arr) {
    int[] positives = new int[arr.length / 2];
    int[] negatives = new int[arr.length / 2];

    int p = 0, n = 0;
    for (int i : arr) {
      if (i > 0) {
        positives[p] = i;
        p++;
      } else {
        negatives[n] = i;
        n++;
      }
    }

    for (int i = 0; i < positives.length; i++) {
      arr[2 * i] = positives[i];
    }

    for (int i = 0; i < negatives.length; i++) {
      arr[2 * i + 1] = negatives[i];
    }

    return arr;
  }

  public int[] optimal(int[] arr) {
    int[] cpy = new int[arr.length];
    int pos = 0, neg = 1;
    for (int i : arr) {
      if (i > 0) {
        cpy[pos] = i;
        pos += 2;
      } else {
        cpy[neg] = i;
        neg += 2;
      }
    }

    return cpy;
  }

  public int[] optimalWithUnequalPositivesAndNegatives(int[] arr) {
    List<Integer> positives = new ArrayList<>();
    List<Integer> negatives = new ArrayList<>();

    for (int i : arr) {
      if (i > 0) {
        positives.add(i);
      } else {
        negatives.add(i);
      }
    }

    for (int i = 0; i < positives.size(); i++) {
      arr[2 * i] = positives.get(i);
    }

    for (int i = 0; i < negatives.size(); i++) {
      arr[2 * i + 1] = negatives.get(i);
    }

    return arr;
  }
}
