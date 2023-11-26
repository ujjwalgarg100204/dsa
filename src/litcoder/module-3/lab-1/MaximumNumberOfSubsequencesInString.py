from typing import List


def solution(text: str, pattern: str) -> int:
    """Returns the maximum no of times pattern can occur as a subsequence of
    modified text

    Args:
        text (str): text
        pattern (str): pattern

    Returns:
        int: max times pattern can  occur as a subsequence
    """
    max_count = 0
    for char in pattern:
        # add char at all positions in text
        for i in range(len(text) + 1):
            new_string = text[0:i] + char + text[i:]

            # generate all subsequence and check count of pattern in it
            subsequences = get_subsequences(new_string)
            max_count = max(max_count, subsequences.count(pattern))

    return max_count


def get_subsequences(string: str) -> List[str]:
    """Returns a list of all possible subsequences of given string

    Args:
        string (str): string

    Returns:
        List[str]: list of all subsequences
    """
    subsequences = [""]

    for char in string:
        curr_subsequence: List[str] = []

        for subsequence in subsequences:
            curr_subsequence.append(subsequence)
            curr_subsequence.append(subsequence + char)

        subsequences = curr_subsequence

    return subsequences


testcases = int(input())
for _ in range(testcases):
    text, pattern = input().split(" ")
    print(solution(text, pattern))
