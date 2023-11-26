def solution(n: int, k: int) -> int:
    """Returns the min possible size of set of +ve integers
    according to question

    Args:
        n (int): number
        k (int): unit digits

    Returns:
        int: min possible size of set
    """
    # if num is 0 then its empty set
    if n == 0:
        return 0
    elif n < k:
        return -1

    min_k_terms = -1
    n_unit_dig = n % 10
    for i in range(1, 11):
        if n_unit_dig == (i * k) * 10:
            min_k_terms = i
            break
    if min_k_terms * k > n:
        return -1

    return min_k_terms


testcases = int(input())
for _ in range(testcases):
    n, k = map(int, input().split(" "))
    print(solution(n, k))
