from typing import Dict

def solution(string: str) -> int:
    """Returns the length of longest substring of the passed string which
    contains even number of vowels

    Args:
        string (str): string

    Returns:
        int: length of longest substring with even number of vowels
    """
    longest_substring_length = 0

    # iterate over all the substring of given string
    for i in range(len(string)):
        for j in range(i, len(string)):
            # get count vowels in current substring
            vowel_count = count_vowels(string[i : j + 1])

            # check all count is even
            all_even = True
            for count in vowel_count.values():
                if not is_even(count):
                    all_even = False
                    break
            if not all_even:
                continue

            # replace length of longest_substring_length
            longest_substring_length = max(longest_substring_length, j + 1 - i)

    return longest_substring_length


def is_even(n: int) -> bool:
    return (n & 1) == 0


def count_vowels(string: str) -> Dict[str, int]:
    """Returns the counts of each vowel in the string as dictionary

    Args:
        string (str): string to count vowels in

    Returns:
        dict[str, int]: dictionary mapped with vowel as key and its count its value
    """
    vowel_counts = {"a": 0, "e": 0, "i": 0, "o": 0, "u": 0}
    for char in string:
        if char in vowel_counts.keys():
            vowel_counts[char] += 1

    return vowel_counts


testcases: int = int(input())
for _ in range(testcases):
    string = input()
    print(solution(string))
