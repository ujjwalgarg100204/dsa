package codes.striveratozdsasheet.recursion._02SubsequencesPaterrn;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

  private int n;
  private final StringBuilder sb = new StringBuilder();
  private final List<String> ans = new ArrayList<>();

  public List<String> generateParenthesis(int n) {
    this.n = n;
    backtrack(0, 0);
    return ans;
  }

  private void backtrack(int openBracketCount, int closedBracketCount) {
    if (openBracketCount == n && closedBracketCount == n) {
      ans.add(sb.toString());
      return;
    }

    if (openBracketCount < n) {
      sb.append(')');
      backtrack(openBracketCount + 1, closedBracketCount);
      sb.deleteCharAt(sb.length() - 1);
    }

    if (closedBracketCount < openBracketCount) {
      sb.append('(');
      backtrack(openBracketCount, closedBracketCount + 1);
      sb.deleteCharAt(sb.length() - 1);
    }
  }
}
