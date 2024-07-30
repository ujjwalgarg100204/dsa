package codes.leetcode.mediumproblems;

public class CountNumberOfTeams {

  public int brute(int[] rating) {
    int teamCount = 0;
    for (int i = 0; i < rating.length; i++) {
      for (int j = i + 1; j < rating.length; j++) {
        for (int k = j + 1; k < rating.length; k++) {
          if (rating[i] < rating[j] && rating[j] < rating[k]
              || rating[i] > rating[j] && rating[j] > rating[k]) {
            teamCount++;
          }
        }
      }
    }
    return teamCount;
  }
}
