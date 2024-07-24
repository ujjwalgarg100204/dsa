package codes.codechef.START144D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SavingsAccount {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int testCases = Integer.parseInt(br.readLine());
    while (testCases-- > 0) {
      String[] xyz = br.readLine().split(" ");
      int x = Integer.parseInt(xyz[0]);
      int y = Integer.parseInt(xyz[1]);
      int z = Integer.parseInt(xyz[2]);
      System.out.println(solution(x, y, z));
    }
    br.close();
  }

  private static int solution(int x, int y, int z) {
    int maximumSavings = z / y;
    if (x <= maximumSavings) {
      return 0;
    }
    return x - maximumSavings;
  }
}
