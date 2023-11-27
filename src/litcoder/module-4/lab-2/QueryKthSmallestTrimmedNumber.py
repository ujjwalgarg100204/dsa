"""Solution to Kth Smallest Trimmed Number problem"""

from typing import List


def solution(nums: List[str], queries: List[List[int]]) -> List[int]:
    """Solution to Kth smallest trimmed number problem

    Args:
        nums (List[str]): list of nums in sting format
        queries (List[List[int]]): list of queries

    Returns:
        List[int]: queried kth smallest trimmed number list
    """
    ans: List[int] = []

    for query in queries:
        k, trim = query

        # trim the numbers to its rightmost trim(i) digits
        trimmed_arr = list(map(lambda num: trim_number(num, trim), nums))
        # determine index of kth smallest number's index & add it to ans
        ans.append(kth_smallest_num_index(trimmed_arr, k))

    return ans


def trim_number(num: str, trim_len: int) -> str:
    """Trims the number to its rightmost side and leaves trim_len numbers in
    string

    Args:
        num (str): number
        trim_len (int): length to trim to

    Returns:
        str: trimmed number
    """
    return num[len(num) - trim_len :]


def kth_smallest_num_index(arr: List[str], k: int) -> int:
    """Returns index of kth smallest number in the list

    Args:
        arr (List[str]): array of numbers
        k (int): k

    Returns:
        int: index of kth smallest number in the list
    """
    int_mapped_arr = list(map(int, arr))
    num = sorted(int_mapped_arr)[k - 1]
    return list(int_mapped_arr).index(num)


testcases = int(input())
for _ in range(testcases):
    nums = input().split(" ")
    queries = [list(map(int, input().split(" "))) for _ in range(int(input()))]

    print(solution(nums, queries))
