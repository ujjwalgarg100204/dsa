package codes.college.litcoder.module4.lab2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EgyptianFraction {

    /**
     * Calculates the Egyptian fraction representation of a given fraction.
     * An Egyptian fraction is a sum of distinct unit fractions, where a unit
     * fraction is a fraction with numerator 1.
     * The function takes the numerator and denominator of the fraction as input and
     * returns a list of denominators
     * representing the Egyptian fraction.
     *
     * @param nr the numerator of the fraction
     * @param dr the denominator of the fraction
     * @return a list of denominators representing the Egyptian fraction
     */
    public static List<Integer> solution(int nr, int dr) {
        List<Integer> denominators = new ArrayList<>();

        // Run the loop until nr becomes 0
        while (nr != 0) {
            int x = (int) Math.ceil((double) dr / nr);

            // Storing value in the ef list
            denominators.add(x);

            // Update nr and dr
            nr = x * nr - dr;
            dr = dr * x;
        }

        return denominators;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numerator = scanner.nextInt();
        int denominator = scanner.nextInt();

        List<Integer> result = solution(numerator, denominator);
        for (int i : result) {
            System.out.println(i);
        }

        scanner.close();
    }
}
