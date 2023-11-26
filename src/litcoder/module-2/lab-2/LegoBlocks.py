MODULO = 10**9 + 7


def solution(height: int, width: int) -> int:
    """Returns no of ways to build a wall of given height
    and width using specified lego bricks

    Args:
        height (int): height of wall
        width (int): width of wall

    Returns:
        int: no of ways to build the wall
    """
    # step 1: no of layouts in a single row
    layouts = [0, 1, 2, 4, 8]
    for w in range(5, width + 1):
        layouts.append(
            (layouts[w - 1] + layouts[w - 2] + layouts[w - 3] + layouts[w - 4]) % MODULO
        )

    # step 2: total no of layouts in H rows
    total_layouts = layouts.copy()
    for _ in range(2, height + 1):
        for i in range(width + 1):
            total_layouts[i] = (layouts[i] * total_layouts[i]) % MODULO

    # step 3: no of bad layouts in H rows
    # step 4: no of good layouts in H rows
    solid_layouts = [0, 1]
    for w in range(2, width + 1):
        unsolid_sum = 0
        for i in range(1, w):
            unsolid_sum += (total_layouts[i] * solid_layouts[w - i]) % MODULO
        solid_layouts.append((total_layouts[w] - unsolid_sum) % MODULO)

    return solid_layouts[width] % MODULO


testcases = int(input())
for _ in range(testcases):
    height, width = map(int, input().split(" "))
    print(solution(height, width))
