"""Solution to Recursive Digit Sum problem"""


def solution(number: str, reps: int) -> int:
    """Returns super sum calculated reps times of the number

    Args:
        number (str): number
        reps (int): repetitions

    Returns:
        int: super-sum
    """
    after_reps = number * reps

    super_sum = sum_of_digits(after_reps)
    if super_sum > 10:
        return solution(str(super_sum), 1)

    return super_sum


def sum_of_digits(number: str) -> int:
    """Returns sum of digits of given number

    Args:
        number (str): number

    Returns:
        int: sum
    """
    ans = 0
    for n in number:
        ans += int(n)

    return ans


testcases = int(input())
for _ in range(testcases):
    number, reps = input().split(" ")
    print(solution(number, int(reps)))
