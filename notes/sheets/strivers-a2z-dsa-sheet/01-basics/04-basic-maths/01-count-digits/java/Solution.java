public class Solution {

  public static int evenlyDivides(int n) {
    int answer = 0;
    int digit = 0;
    int nCpy = n;

    while (n > 0) {
      digit = n % 10;
      if (digit != 0 && nCpy % digit == 0) {
        answer++;
      }

      n /= 10;
    }

    return answer;
  }
}
