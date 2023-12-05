"""Solution to Common Child problem"""


def solution(s1: str, s2: str) -> int:
    """Solution to Common Child problem

    Args:
        s1 (str): string
        s2 (str): string

    Returns:
        int: common child
    """
    n = len(s1)
    s1 = "0" + s1
    s2 = "1" + s2
    count = [[0 for _ in range(n + 1)] for _ in range(n + 1)]

    for i in range(1, n + 1):
        for j in range(1, n + 1):
            if s1[i] == s2[j]:
                count[i][j] = count[i - 1][j - 1] + 1
            else:
                count[i][j] = max(count[i - 1][j], count[i][j - 1])

    return count[n][n]


testcases = int(input())
for _ in range(testcases):
    s1, s2 = input().split(" ")
    print(solution(s1, s2))
