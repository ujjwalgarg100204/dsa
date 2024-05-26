import java.util.Scanner;

public class RecursiveDigitSum {

    /**
     * Calculates the recursive digit sum of a given number after repeating it a
     * certain number of times.
     *
     * @param number The input number as a string.
     * @param reps   The number of times the input number should be repeated.
     * @return The recursive digit sum of the repeated number.
     */
    public static int solution(String number, int reps) {
        String afterReps = number.repeat(reps);

        int superSum = sumOfDigits(afterReps);
        if (superSum > 10) {
            return solution(Integer.toString(superSum), 1);
        }

        return superSum;
    }

    /**
     * Calculates the sum of the digits in a given number.
     *
     * @param number the number for which the sum of digits needs to be calculated
     * @return the sum of the digits in the given number
     */
    public static int sumOfDigits(String number) {
        int sum = 0;
        for (char digit : number.toCharArray()) {
            sum += Character.getNumericValue(digit);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String number = scanner.next();
        int reps = scanner.nextInt();
        System.out.println(solution(number, reps));

        scanner.close();
    }
}
