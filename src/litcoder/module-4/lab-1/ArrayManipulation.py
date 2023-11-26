"""Solution to Array Manipulation problem"""

from typing import List


def solution(n: int, queries: List[List[int]]) -> int:
    arr = [0 for _ in range(n)]

    for query in queries:
        start, end, increment = query
        # 1 index queries
        for i in range(start - 1, end):
            arr[i] += increment

    return max(arr)


testcases = int(input())
for _ in range(testcases):
    n, no_of_queries = map(int, input().split(" "))
    queries = [list(map(int, input().split(" "))) for _ in range(no_of_queries)]

    print(solution(n, queries))
