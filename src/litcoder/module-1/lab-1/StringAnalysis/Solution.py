from typing import Tuple


def analyse_str(email: str) -> Tuple[float, float, float, float]:
    uppercase_letters = 0
    lowercase_letters = 0
    digits = 0
    other_chars = 0

    # calculate no of respective occurences
    for c in email:
        if c.isupper():
            uppercase_letters += 1
        elif c.islower():
            lowercase_letters += 1
        elif c.isdigit():
            digits += 1
        else:
            other_chars += 1

    # calculate percentages
    length = len(email)
    return (
        uppercase_letters / length * 100,
        lowercase_letters / length * 100,
        digits / length * 100,
        other_chars / length * 100,
    )


inp = input()
for i in analyse_str(inp):
    print(f"{i:.3f}%")
