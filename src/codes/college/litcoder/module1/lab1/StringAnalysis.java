package codes.college.litcoder.module1.lab1;

import java.util.Scanner;

public class StringAnalysis {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        for (double i : analyzeStr(str)) {
            System.out.printf("%.3f%%\n", i);
        }

        sc.close();
    }

    private static double[] analyzeStr(String str) {
        int uppercaseLetters = 0;
        int lowercaseLetters = 0;
        int digits = 0;
        int otherChars = 0;

        // calculate no of respective occurrences
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isUpperCase(c)) {
                uppercaseLetters++;
            } else if (Character.isLowerCase(c)) {
                lowercaseLetters++;
            } else if (Character.isDigit(c)) {
                digits++;
            } else {
                otherChars++;
            }
        }

        // calculate percentages
        double len = str.length();
        return new double[] {
                (uppercaseLetters / len) * 100,
                (lowercaseLetters / len) * 100,
                (digits / len) * 100,
                (otherChars / len) * 100,
        };
    }
}
