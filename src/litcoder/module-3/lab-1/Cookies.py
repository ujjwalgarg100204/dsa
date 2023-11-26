from typing import List, Tuple


class ArrayElement:
    """Wrapper for element of array which holds index and value
    of element"""

    index: int
    value: int

    def __init__(self, index: int, value: int):
        self.index = index
        self.value = value

    def set_index(self, index: int):
        self.index = index
        return self

    def set_value(self, value: int):
        self.value = value
        return self

    def __str__(self):
        return f"index: {self.index} value: {self.value}"


def least_two_elements(arr: List[int]) -> Tuple[ArrayElement, ArrayElement]:
    """Gives first min and sec min

    Args:
        arr (List[int]): list of integers

    Returns:
        Tuple[ArrayElement, ArrayElement]: first_min, sec_min
    """
    first_min = ArrayElement(0, arr[0])
    sec_min = ArrayElement(0, arr[1])

    for i, val in enumerate(arr):
        # if value lies bw first min and sec min
        # update sec min
        if first_min.value < val and sec_min.value > val:
            # change the second minimum
            sec_min.set_index(i).set_value(val)

        # if values lies between first min update both of
        # them
        elif first_min.value > val:
            # assign second minimum value to minimum
            sec_min.set_index(first_min.index).set_value(first_min.value)
            # change the current minimum
            first_min.set_index(i).set_value(val)

    return first_min, sec_min


def solution(target_sweetness: int, candy_sweetness: List[int]) -> int:
    """Changes given candy sweetness to target sweetness according
    to specified rules

    Args:
        target_sweetness (int): target sweetness
        candy_sweetness (List[int]): list of candy sweetness

    Returns:
        int: no of steps it took to reach target sweetness
    """
    first_min, sec_min = least_two_elements(candy_sweetness)
    steps = 0
    while first_min.value < target_sweetness:
        new_sweetness = first_min.value + 2 * sec_min.value

        # delete least two sweetness
        del candy_sweetness[first_min.index]
        del candy_sweetness[sec_min.index]

        # add new sweetness
        candy_sweetness.append(new_sweetness)

        # recalculate first and second minimums
        first_min, sec_min = least_two_elements(candy_sweetness)

        steps += 1

    return steps


testcases = int(input())
for _ in range(testcases):
    target = int(input())
    candy_sweetness = list(map(int, input().split(" ")))
    print(solution(target, candy_sweetness))
