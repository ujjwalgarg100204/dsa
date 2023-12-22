from typing import List


def solution(arr: List[int]) -> int:
    longest_cont_arr_len = 0
    # check all sub-arrays for longest contiguous sub-array
    for i in range(len(arr)):
        zero_count, one_count = 0, 0
        for j, val in enumerate(arr[i:], i):
            if val == 0:
                zero_count += 1
            else:
                one_count += 1
            if zero_count == one_count:
                longest_cont_arr_len = max(longest_cont_arr_len, j - i + 1)
    return longest_cont_arr_len


inp = list(map(int, input().split(" ")))
print(solution(inp))
