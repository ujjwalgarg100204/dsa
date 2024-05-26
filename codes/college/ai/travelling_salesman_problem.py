import math
import itertools


def total_distance(graph: list[list[int]], route: list[int]) -> int:
    distance = 0

    for index, vertex in enumerate(route):
        if index + 1 == len(route):
            break
        distance += graph[vertex][route[index + 1]]

    return distance


def travelling_salesman_problem(
    graph: list[list[int]], start_vertex: int
) -> tuple[float, list[int]]:
    cities_indices = list(range(1, len(graph)))
    min_distance = math.inf
    optimal_route: list[int] = list()
    permutations = itertools.permutations(cities_indices)

    for permutation in permutations:
        route = [start_vertex] + list(permutation) + [start_vertex]
        distance = total_distance(graph, route)

        if distance < min_distance:
            min_distance = distance
            optimal_route = route

    return min_distance, optimal_route


if __name__ == "__main__":
    graph = [
        [0, 10, 15, 20],
        [5, 0, 25, 10],
        [15, 30, 0, 5],
        [15, 10, 20, 0],
    ]
    start_vertex = 0
    print(travelling_salesman_problem(graph, start_vertex))
