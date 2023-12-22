"""Solution to com.ujjwal.solutions.litcoder.contests.contest_2.Activity Selection Contest Problem"""

from typing import List


class com.ujjwal.solutions.litcoder.contests.contest_2.Activity:
    """Wrapper class for activity"""

    start_time: int
    end_time: int

    def __init__(self, start_time: int, end_time: int):
        self.start_time = start_time
        self.end_time = end_time

    def get_time_spent(self):
        return self.end_time - self.start_time

    def __str__(self):
        return f"{self.start_time} {self.end_time}"


def solution(activities: List[com.ujjwal.solutions.litcoder.contests.contest_2.Activity]) -> List[com.ujjwal.solutions.litcoder.contests.contest_2.Activity]:
    """Returns array of activities which contains the maximum number of
    non-overlapping activities that can be performed

    Args:
        activities (List[com.ujjwal.solutions.litcoder.contests.contest_2.Activity]): list of activities

    Returns:
        List[com.ujjwal.solutions.litcoder.contests.contest_2.Activity]:
    """
    # sort the activities in ascending order according to their
    # finishing time
    activities.sort(key=lambda activity: activity.end_time)

    act_order: List[com.ujjwal.solutions.litcoder.contests.contest_2.Activity] = [activities[0]]
    for activity in activities[1:]:
        if activity.start_time >= act_order[-1].end_time:
            act_order.append(activity)

    return act_order


testcases = int(input())
for _ in range(testcases):
    start_times = map(int, input().split(" "))
    end_times = map(int, input().split(" "))

    activities = [com.ujjwal.solutions.litcoder.contests.contest_2.Activity(*times) for times in zip(start_times, end_times)]
    for activity in solution(activities):
        print(activity)
