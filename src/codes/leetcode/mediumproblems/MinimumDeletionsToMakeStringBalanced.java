package codes.leetcode.mediumproblems;

public class MinimumDeletionsToMakeStringBalanced {

  private static final String PROBLEM_LINK = "https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/description/?envType=daily-question&envId=2024-07-30";

  public int minimumDeletions(String s) {
    StringBuilder sb = new StringBuilder(s);
    int minimumDeletion = 0;

    // delete each character and see if string is balanced or not
    for (int i = 0; i < s.length(); i++) {

    }

    return minimumDeletion;
  }

  private static boolean isBalanced(StringBuilder s) {
    boolean bAppeared = false;
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == 'b') {
        bAppeared = true;
      } else {
        if (bAppeared) {
          return false;
        }
      }
    }

    return true;
  }
}
