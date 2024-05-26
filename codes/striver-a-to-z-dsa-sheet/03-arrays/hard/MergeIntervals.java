import java.util.*;

public class MergeIntervals {

    public String getProblemLink() {
        return "https://leetcode.com/problems/merge-intervals/description";
    }

    public int[][] brute(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        Arrays.sort(intervals, Comparator.comparingInt(ints -> ints[0]));

        for (int i = 0; i < intervals.length;) {
            int[] newInterval = intervals[i];

            // start one place ahead of newInterval
            int j = i + 1;
            while (j < intervals.length) {
                int[] currInterval = intervals[j];
                // check if lower limit of currInterval lies between newInterval limits and
                // upper limit should be out of newInterval limits towards right
                if (currInterval[0] >= newInterval[0] && currInterval[0] <= newInterval[1]) {
                    // upper limit should be > newInterval to update newInterval, otherwise,
                    // we don't need to change upper limit
                    newInterval[1] = Math.max(newInterval[1], currInterval[1]);
                } else {
                    // no more intervals can be merged, we know this because array is sorted
                    break;
                }
                j++;
            }
            // increment i by how many places j went ahead
            i += j - i;
            merged.add(newInterval);
        }

        return merged.toArray(new int[0][]);
    }

    public int[][] optimal(int[][] intervals) {
        List<int[]> merged = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(ints -> ints[0]));

        int[] newInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];
            if (curr[0] <= newInterval[1]) {
                newInterval[1] = Math.max(curr[1], newInterval[1]);
            } else {
                merged.add(newInterval);
                newInterval = curr;
            }
        }
        // if there is just one interval, or last merged interval doesn't make
        // it to merged array
        if (merged.isEmpty() || merged.getLast()[1] < newInterval[0]) {
            merged.add(newInterval);
        }

        return merged.toArray(new int[0][]);
    }

}
