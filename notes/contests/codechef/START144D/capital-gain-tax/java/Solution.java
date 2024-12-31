import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] xy = br.readLine().split(" ");
    int x = Integer.parseInt(xy[0]);
    int y = Integer.parseInt(xy[1]);

    System.out.println(solution(x, y));
    br.close();
  }

  public static String solution(int x, int y) {
    if (x == y) {
      return "SAME";
    } else if (x > y) {
      return "DECREASED";
    } else {
      return "INCREASED";
    }
  }
}
