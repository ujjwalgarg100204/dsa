from typing import Set


def longest_substring(s: str) -> int:
    len_longest_substring = 0
    hash_set: Set[str] = set()
    i = 0
    j = 0
    for j, c in enumerate(s):
        # if current char is not in set
        # then longest substring can be extended
        if c not in hash_set:
            hash_set.add(c)
            continue
        # calculate length of substring and
        # accordingly update length
        len_longest_substring = max(len_longest_substring, j - i)

        # clear set and set values for i & set
        # accordingly
        i = j
        hash_set.clear()
        hash_set.add(c)

    len_longest_substring = max(len_longest_substring, j - i + 1)
    return len_longest_substring
