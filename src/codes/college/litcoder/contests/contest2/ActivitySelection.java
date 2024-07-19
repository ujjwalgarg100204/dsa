package codes.college.litcoder.contests.contest2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Activity {

    final int startTime;
    final int endTime;

    /**
     * Constructs an Activity object with the given start time and end time.
     *
     * @param startTime the start time of the activity
     * @param endTime   the end time of the activity
     */
    public Activity(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    /**
     * Calculates and returns the time spent on the activity.
     *
     * @return the time spent on the activity
     */
    public int getTimeSpent() {
        return endTime - startTime;
    }

    /**
     * Returns a string representation of the Activity object.
     *
     * @return a string representation of the Activity object
     */
    @Override
    public String toString() {
        return startTime + " " + endTime;
    }
}

public class ActivitySelection {

    /**
     * Sorts the activities in ascending order according to their finishing time and
     * returns a list of activities in the order they can be performed.
     *
     * @param activities the list of activities to be sorted
     * @return a list of activities in the order they can be performed
     */
    public static List<Activity> solution(List<Activity> activities) {
        // Sort the activities in ascending order according to their finishing time
        activities.sort(Comparator.comparingInt(a -> a.endTime));

        List<Activity> actOrder = new ArrayList<>();
        actOrder.add(activities.getFirst());

        for (int i = 1; i < activities.size(); i++) {
            Activity activity = activities.get(i);
            if (activity.startTime >= actOrder.getLast().endTime) {
                actOrder.add(activity);
            }
        }

        return actOrder;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int activityCount = scanner.nextInt();
        List<Activity> activities = new ArrayList<>();

        for (int i = 0; i < activityCount; i++) {
            int startTime = scanner.nextInt();
            int endTime = scanner.nextInt();
            activities.add(new Activity(startTime, endTime));
        }

        List<Activity> result = solution(activities);
        for (Activity activity : result) {
            System.out.println(activity);
        }

        scanner.close();
    }
}
