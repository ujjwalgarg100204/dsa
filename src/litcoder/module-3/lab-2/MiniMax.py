from typing import List, Tuple


def solution(numbers: List[int]) -> Tuple[int, int]:
    """
    Returns a tuple of minimum sum and maximum sum achieved by adding
    4 numbers from given six numbers

    Args:
        numbers (List[int]): list of 6 numbers

    Returns:
        Tuple[int, int]: min sum, max sum
    """
    # sort the numbers first
    sorted_numbers = sorted(numbers)

    # calculate min and max numbers
    min_num = sum(sorted_numbers[0:4])
    max_num = sum(sorted_numbers[2:])

    return min_num, max_num


testcases = int(input())
for _ in range(testcases):
    numbers = list(map(int, input().split(" ")))
    print(solution(numbers))
