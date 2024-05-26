import java.util.ArrayList;
import java.util.List;

/**
 * LongestSubsequencePalindrome
 */
public class LongestSubsequencePalindrome {

    public int solution(String s) {
        List<String> subsequences = _allSubsequences(s);
        int maxLength = -1;

        for (String str : subsequences) {
            if (_isPalindrome(str)) {
                maxLength = Math.max(maxLength, str.length());
            }
        }

        return maxLength;
    }

    private List<String> _allSubsequences(String s) {
        List<String> subsequences = new ArrayList<>();
        final int N = s.length();

        for (int i = 0; i < (1 << N); i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < N; j++) {
                if ((i & (1 << j)) != 0) {
                    sb.append(s.charAt(j));
                }
            }

            if (sb.length() > 0) {
                subsequences.add(sb.toString());
            }
        }

        return subsequences;
    }

    private boolean _isPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
