"""Solution to problem Balanced Brackets Problem"""

from collections import deque


def solution(exp: str) -> bool:
    stack: deque[str] = deque()
    for c in exp:
        if not stack:
            stack.append(c)
        elif (
            (stack[-1] == "(" and c == ")")
            or (stack[-1] == "{" and c == "}")
            or (stack[-1] == "[" and c == "]")
        ):
            stack.pop()
        else:
            stack.append(c)

    # if stack is not empty then some open brackets are left
    if stack:
        return False
    return True


testcases = int(input())
for _ in range(testcases):
    expression = input()
    if solution(expression):
        print("YES")
    else:
        print("NO")
