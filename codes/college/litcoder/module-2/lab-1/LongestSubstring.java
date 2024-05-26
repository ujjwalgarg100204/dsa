import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class LongestSubstring {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        System.out.println(longestSubstring(str));

        sc.close();
    }

    /**
     * Calculates the length of the longest substring in the given string
     * without repeating characters.
     *
     * @param s the input string
     * @return the length of the longest substring without repeating characters
     */
    private static int longestSubstring(String s) {
        int lenLongestSubstring = 0;
        Set<Character> set = new HashSet<>();
        int i = 0;
        int j = 0;
        for (; j < s.length(); j++) {
            char c = s.charAt(j);
            // if current char is not in set then longest substring
            // can be extended
            if (!set.contains(c)) {
                set.add(c);
                continue;
            }

            // calculate length of substring and accordingly update
            // length
            lenLongestSubstring = Math.max(j - i, lenLongestSubstring);

            // clear set and set values for i & set accordingly
            i = j;
            set.clear();
            set.add(c);
        }

        return Math.max(lenLongestSubstring, j - i);
    }
}
