public class PrintSubarrayWithMaximumSubarraySum {

  public long[] followUpQuestion(final long[] arr) {
    long maxSum = Long.MIN_VALUE;
    int maxSumStartIndex = 0;
    int maxSumEndIndex = 0;

    int startIndex = 0;
    long sum = 0;
    for (int i = 0; i < arr.length; i++) {
      if (sum == 0) {
        startIndex = i;
      }
      sum += arr[i];
      if (sum < 0) {
        sum = 0;
      }

      if (sum > maxSum) {
        maxSumStartIndex = startIndex;
        maxSumEndIndex = i;
        maxSum = sum;
      }
    }

    return new long[] {maxSumStartIndex, maxSumEndIndex};
  }

  public long optimal(final long[] arr) {
    long maxSum = Long.MIN_VALUE;

    long sum = 0;
    for (long i : arr) {
      sum += i;
      if (sum < 0) {
        sum = 0;
      }

      maxSum = Math.max(sum, maxSum);
    }

    return maxSum;
  }

  public long geeksForGeeksOptimal(final long[] arr) {
    long maxScore = Long.MIN_VALUE;
    for (int i = 0; i < arr.length - 1; i++) {
      long score = arr[i] + arr[i + 1];
      maxScore = Math.max(maxScore, score);
    }

    return maxScore;
  }

  public long geeksForGeeksBrute(final long[] arr) {
    long maxScore = Long.MIN_VALUE;

    for (int i = 0; i < arr.length; i++) {
      for (int j = i; j < arr.length; j++) {
        long[] minNumbers = get2MinNumbers(arr, i, j);
        long score = minNumbers[0] + minNumbers[1];
        maxScore = Math.max(maxScore, score);
      }
    }

    return maxScore;
  }

  private static long[] get2MinNumbers(final long[] arr, int start, int end) {
    long firstMin = Long.MAX_VALUE;
    long secondMin = Long.MAX_VALUE;

    for (int i = start; i <= end; i++) {
      if (arr[i] < firstMin) {
        secondMin = firstMin;
        firstMin = arr[i];
      } else if (arr[i] < secondMin) {
        secondMin = arr[i];
      }
    }

    return new long[] {firstMin, secondMin};
  }
}
