package codes.college.litcoder.contests.contest1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class JobSequencing {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfJobs = sc.nextInt();
        sc.nextLine();

        String[] jobNames = sc.nextLine().split(" ");
        int[] deadlines = Arrays
                .stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] profits = Arrays
                .stream(sc.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        sc.close();

        ArrayList<Job> arr = new ArrayList<>();
        for (int i = 0; i < noOfJobs; i++) {
            arr.add(new Job(jobNames[i], deadlines[i], profits[i]));
        }
        Job job = new Job();

        // Function call
        job.printJobScheduling(arr);
    }
}

class Job {

    // Each job has a unique-id,profit and deadline
    String id;
    int deadline;
    int profit;

    // Constructors
    public Job() {
    }

    public Job(String id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

    // Function to schedule the jobs take 2 arguments
    // arraylist and no of jobs to schedule
    void printJobScheduling(ArrayList<Job> arr) {
        // Length of array
        int n = arr.size();

        // Sort all jobs according to decreasing order of
        // profit
        arr.sort((a, b) -> b.profit - a.profit);

        // To keep track of free time slots
        boolean[] result = new boolean[3];

        // To store result (Sequence of jobs)
        String[] job = new String[3];

        // Iterate through all given jobs
        for (int i = 0; i < n; i++) {
            // Find a free slot for this job (Note that we
            // start from the last possible slot)
            for (int j = Math.min(3 - 1, arr.get(i).deadline - 1); j >= 0; j--) {
                // Free slot found
                if (!result[j]) {
                    result[j] = true;
                    job[j] = arr.get(i).id;
                    break;
                }
            }
        }

        // Print the sequence
        for (String jb : job)
            System.out.print(jb + " ");
        System.out.println();
    }
}
