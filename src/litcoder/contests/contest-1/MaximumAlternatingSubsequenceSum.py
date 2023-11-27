"""Solution to Maximum Alternating Subsequence Sum"""

from typing import List


def solution(arr: List[int]) -> int:
    """Returns maximum alternating sum of the array

    Args:
        arr (List[int]): array of numbers

    Returns:
        int: max alternating sum
    """
    max_sum = 0

    subsequences = get_all_subsequences(arr)
    for subsequence in subsequences:
        even_indices_sum = get_even_indices_sum(subsequence)
        odd_indices_sum = get_odd_indices_sum(subsequence)

        alternating_sum = even_indices_sum - odd_indices_sum

        max_sum = max(max_sum, alternating_sum)

    return max_sum


def get_even_indices_sum(arr: List[int]) -> int:
    """Returns  sum of numbers present at even indices

    Args:
        arr (List[int]): array of numbers

    Returns:
        int: sum
    """
    if len(arr) == 0:
        return 0
    return sum([i for i in arr[::2]])


def get_odd_indices_sum(arr: List[int]) -> int:
    """Returns sum of numbers present at odd indices

    Args:
        arr (List[int]): array of numbers

    Returns:
        int: sum
    """
    if len(arr) == 0:
        return 0
    return sum([i for i in arr[1::2]])


def get_subsequences(
    arr: List[int], start: int, curr_seq: List[int], result: List[List[int]]
) -> None:
    """Generates all possible subsequences for the given array starting from
    given index and stores the result in result array

    Args:
        arr (List[int]): array of numbers
        start (int): index to start at
        curr_seq (List[int]): current subsequence, meant to be used inside recur
        sion
        result (List[List[int]]): list of all subsequences
    """
    result.append(list(curr_seq))

    for i in range(start, len(arr)):
        if i > start and arr[i] == arr[i - 1]:
            continue

        curr_seq.append(arr[i])
        get_subsequences(arr, i + 1, curr_seq, result)

        curr_seq.pop()


def get_all_subsequences(arr: List[int]) -> List[List[int]]:
    """Wrapper function for get_subsequences to call it easily and get result
    without passing unnecessary arguments

    Args:
        arr (List[int]): array of numbers

    Returns:
        List[List[int]]: list of all subsequences
    """
    result: List[List[int]] = []
    curr_seq: List[int] = []

    get_subsequences(arr, 0, curr_seq, result)
    return result


testcases = int(input())
for _ in range(testcases):
    arr = list(map(int, input().split(" ")))
    print(solution(arr))
