"""Solution to Egyptian Fraction  problem"""
import math
from typing import List


def solution(nr: int, dr: int) -> List[int]:
    """Returns the denominators in egyptian fraction

    Args:
        nr (int): numerator
        dr (int): denominator

    Returns:
        List[int]: list of denominators
    """
    denominators: List[int] = []

    # run loop until nr becomes 0
    while nr != 0:
        x = math.ceil(dr / nr)

        # storing value in ef list
        denominators.append(x)

        # update nr and dr
        nr = x * nr - dr
        dr = dr * x

    return denominators


testcases = int(input())
for _ in range(testcases):
    numerator, denominator = map(int, input().split(" "))
    print(solution(numerator, denominator))
