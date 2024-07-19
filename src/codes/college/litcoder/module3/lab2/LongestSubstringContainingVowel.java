package codes.college.litcoder.module3.lab2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LongestSubstringContainingVowel {

    public static int solution(String string) {
        int longestSubstringLength = 0;

        // iterate over all substrings of the given string
        for (int i = 0; i < string.length(); i++) {
            for (int j = i; j < string.length(); j++) {
                // get count of vowels in the current substring
                Map<Character, Integer> vowelCount = countVowels(
                        string.substring(i, j + 1));

                // check if all counts are even
                boolean allEven = true;
                for (int count : vowelCount.values()) {
                    if (!isEven(count)) {
                        allEven = false;
                        break;
                    }
                }
                if (!allEven) {
                    continue;
                }

                // update length of longestSubstringLength
                longestSubstringLength = Math.max(longestSubstringLength, j + 1 - i);
            }
        }

        return longestSubstringLength;
    }

    public static boolean isEven(int n) {
        return (n & 1) == 0;
    }

    public static Map<Character, Integer> countVowels(String substring) {
        Map<Character, Integer> vowelCounts = new HashMap<>();
        vowelCounts.put('a', 0);
        vowelCounts.put('e', 0);
        vowelCounts.put('i', 0);
        vowelCounts.put('o', 0);
        vowelCounts.put('u', 0);

        for (char ch : substring.toCharArray()) {
            if (vowelCounts.containsKey(ch)) {
                vowelCounts.put(ch, vowelCounts.get(ch) + 1);
            }
        }

        return vowelCounts;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testcases = scanner.nextInt();
        scanner.nextLine(); // consume the newline after reading the integer

        for (int t = 0; t < testcases; t++) {
            String string = scanner.nextLine();
            System.out.println(solution(string));
        }
    }
}
