from typing import List


def get_min_time(
    cache_size: int, cache_time: int, server_time: int, urls: List[str]
) -> List[int]:
    cache: List[str] = []
    resolution_times: List[int] = []

    for url in urls:
        if url in cache:
            resolution_times.append(cache_time)
        else:
            resolution_times.append(server_time)
            if len(cache) == cache_size:
                cache.pop()
            cache.insert(0, url)

    return resolution_times


testcases = int(input())
for _ in range(testcases):
    cache_size, cache_time, server_time = map(int, input().split(" "))
    urls = input().split(" ")
    print(get_min_time(cache_size, cache_time, server_time, urls))
