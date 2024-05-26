import java.util.Scanner;

public class LengthOfCommonChild {

    /**
     * Calculates the length of the longest common child string between two given
     * strings.
     *
     * @param s1 The first string.
     * @param s2 The second string.
     * @return The length of the longest common child string.
     */
    public static int solution(String s1, String s2) {
        int n = s1.length();
        s1 = "0" + s1;
        s2 = "1" + s2;
        int[][] count = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    count[i][j] = count[i - 1][j - 1] + 1;
                } else {
                    count[i][j] = Math.max(count[i - 1][j], count[i][j - 1]);
                }
            }
        }

        return count[n][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String s1 = scanner.next();
        String s2 = scanner.next();
        System.out.println(solution(s1, s2));

        scanner.close();
    }
}
