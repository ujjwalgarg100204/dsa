"""Solution to Clumsy Factorial problem"""


def solution(n: int) -> int:
    """Solution to Clumsy Factorial

    Args:
        n (int): number

    Returns:
        int: clumsy factorial
    """
    ans = 0
    sign = 1

    for i in range(n, 0, -4):
        acc = i

        # i - 1, i - 2, i - 3 might not exist, so check first
        if i - 1 > 0:
            acc *= i - 1
        if i - 2 > 0:
            acc //= i - 2

        # only first operation is added, rest are subtracted
        ans += sign * acc

        if i - 3 > 0:
            ans += i - 3

        sign = -1

    return ans


testcases = int(input())
for _ in range(testcases):
    n = int(input())
    print(solution(n))
