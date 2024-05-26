import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MaximumNumberOfSubsequencesInString {

    /**
     * Calculates the maximum number of occurrences of a pattern in a text by adding
     * each character of the pattern at all positions in the text.
     *
     * @param text    the input text
     * @param pattern the pattern to be added and checked for occurrences
     * @return the maximum number of occurrences of the pattern in the text
     */
    public static int solution(String text, String pattern) {
        int maxCount = 0;

        for (char ch : pattern.toCharArray()) {
            // add char at all positions in text
            for (int i = 0; i <= text.length(); i++) {
                StringBuilder newText = new StringBuilder(text);
                newText.insert(i, ch);

                // generate all subsequences and check count of pattern in it
                List<String> subsequences = getSubsequences(newText.toString());
                maxCount = Math.max(maxCount, countOccurrences(subsequences, pattern));
            }
        }

        return maxCount;
    }

    /**
     * Generates all possible subsequences of a given string.
     *
     * @param string the input string
     * @return a list of all subsequences of the input string
     */
    public static List<String> getSubsequences(String string) {
        List<String> subsequences = new ArrayList<>();
        subsequences.add("");

        for (char ch : string.toCharArray()) {
            List<String> currentSubsequence = new ArrayList<>();

            for (String subsequence : subsequences) {
                currentSubsequence.add(subsequence);
                currentSubsequence.add(subsequence + ch);
            }

            subsequences = currentSubsequence;
        }

        return subsequences;
    }

    /**
     * Counts the number of occurrences of a given pattern in a list of
     * subsequences.
     *
     * @param subsequences the list of subsequences to search for the pattern
     * @param pattern      the pattern to count occurrences of
     * @return the number of occurrences of the pattern in the subsequences
     */
    public static int countOccurrences(
            List<String> subsequences,
            String pattern) {
        int count = 0;
        for (String subsequence : subsequences) {
            if (subsequence.equals(pattern)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.next();
        String pattern = scanner.next();
        System.out.println(solution(text, pattern));

        scanner.close();
    }
}
