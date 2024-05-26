import math
from queue import PriorityQueue
from collections import deque
from pprint import pprint

# ██████╗ ███████╗███████╗
# ██╔══██╗██╔════╝██╔════╝
# ██████╔╝█████╗  ███████╗
# ██╔══██╗██╔══╝  ╚════██║
# ██████╔╝██║     ███████║
# ╚═════╝ ╚═╝     ╚══════╝


def breadth_first_search(
    graph: list[list[int]], start_vertex: int, goal_vertex: int
) -> tuple[bool, list[int]]:
    """
    Perform Breadth-First Search (BFS) on a graph to find a path from
    a start vertex to a goal vertex.

    Args:
    - graph (list[list[int]]): An adjacency list representation of the graph.
    - start_vertex (int): starting vertex (0 indexed)
    - goal_vertex (int): goal vertex (0 indexed)

    Returns:
    - tuple[bool, list[int]]: A tuple containing a boolean indicating whether
      a path from start to goal exists, and a list representing the path (empty if no path found).
    """

    path: list[int] = []
    visited: list[bool] = [False for _ in graph]
    q: deque[int] = deque()
    q.append(start_vertex)

    while q:
        curr_vertex = q.popleft()
        if visited[curr_vertex]:
            continue

        # add the curr_vertex to path
        path.append(curr_vertex)
        visited[curr_vertex] = True
        if curr_vertex == goal_vertex:
            return True, path

        # add all neighours of current vertex in q
        for vertex in graph[curr_vertex]:
            q.append(vertex)

    return False, path


# ██████╗ ███████╗███████╗
# ██╔══██╗██╔════╝██╔════╝
# ██║  ██║█████╗  ███████╗
# ██║  ██║██╔══╝  ╚════██║
# ██████╔╝██║     ███████║
# ╚═════╝ ╚═╝     ╚══════╝


def depth_first_search_recursive(
    graph: list[list[int]], start_vertex: int, goal_vertex: int
) -> tuple[bool, list[int]]:
    """
    Perform Depth-First Search (DFS) recursively on a graph to find a path from
    a start vertex to a goal vertex.

    Args:
    - graph (list[list[int]]): An adjacency list representation of the graph.
    - start_vertex (int): starting vertex (0-indexed)
    - goal_vertex (int): goal vertex (0-indexed)

    Returns:
    - tuple[bool, list[int]]: A tuple containing a boolean indicating whether
      a path from start to goal exists, and a list representing the path (empty if no path found).
    """

    path: list[int] = list()
    visited = [False for _ in graph]

    is_found = _depth_first_search_recursive_util(
        graph, start_vertex, goal_vertex, visited, path
    )

    return is_found, path


def _depth_first_search_recursive_util(
    graph: list[list[int]],
    curr_vertex: int,
    goal_vertex: int,
    visited: list[bool],
    path: list[int],
) -> bool:
    """
    Utility function for performing Depth-First Search (DFS) recursively on a graph.

    Args:
    - graph (list[list[int]]): An adjacency list representation of the graph.
    - curr_vertex (int): current vertex (0-indexed)
    - goal_vertex (int): goal vertex (0-indexed)
    - visited (list[bool]): A list to track visited vertices.
    - path (list[int]): A list to store the current path being explored.

    Returns:
    - bool: True if the goal vertex is found along the current path, False otherwise.
    """

    visited[curr_vertex] = True
    path.append(curr_vertex)

    if curr_vertex == goal_vertex:
        return True

    for neighbour_vertex in graph[curr_vertex]:
        if visited[neighbour_vertex]:
            continue

        is_found = _depth_first_search_recursive_util(
            graph, neighbour_vertex, goal_vertex, visited, path
        )
        if is_found:
            return True

    return False


def depth_first_search_iterative(
    graph: list[list[int]], start_vertex: int, goal_vertex: int
) -> tuple[bool, list[int]]:
    """
    Perform Depth-First Search (DFS) iteratively on a graph to find a path from
    a start vertex to a goal vertex.

    Args:
    - graph (list[list[int]]): An adjacency list representation of the graph.
    - start_vertex (int): The number representing the starting vertex (0-indexed).
    - goal_vertex (int): The number representing the goal vertex (0-indexed).

    Returns:
    - tuple[bool, list[int]]: A tuple containing a boolean indicating whether
      a path from start to goal exists, and a list representing the path (empty if no path found).
    """

    path: list[int] = list()
    visited = [False for _ in graph]
    stack: deque[int] = deque()
    stack.append(start_vertex)

    while stack:
        curr_vertex = stack.pop()

        # mark thec curr_vertex as visited
        visited[curr_vertex] = True
        path.append(curr_vertex)
        if curr_vertex == goal_vertex:
            return True, path

        for neighour_vertex in graph[curr_vertex][::-1]:
            if not visited[neighour_vertex]:
                stack.append(neighour_vertex)

    return False, path


# ██████╗ ███████╗██████╗ ████████╗██╗  ██╗    ██╗     ██╗███╗   ███╗██╗████████╗███████╗██████╗     ███████╗██╗██████╗ ███████╗████████╗    ███████╗███████╗ █████╗ ██████╗  ██████╗██╗  ██╗
# ██╔══██╗██╔════╝██╔══██╗╚══██╔══╝██║  ██║    ██║     ██║████╗ ████║██║╚══██╔══╝██╔════╝██╔══██╗    ██╔════╝██║██╔══██╗██╔════╝╚══██╔══╝    ██╔════╝██╔════╝██╔══██╗██╔══██╗██╔════╝██║  ██║
# ██║  ██║█████╗  ██████╔╝   ██║   ███████║    ██║     ██║██╔████╔██║██║   ██║   █████╗  ██║  ██║    █████╗  ██║██████╔╝███████╗   ██║       ███████╗█████╗  ███████║██████╔╝██║     ███████║
# ██║  ██║██╔══╝  ██╔═══╝    ██║   ██╔══██║    ██║     ██║██║╚██╔╝██║██║   ██║   ██╔══╝  ██║  ██║    ██╔══╝  ██║██╔══██╗╚════██║   ██║       ╚════██║██╔══╝  ██╔══██║██╔══██╗██║     ██╔══██║
# ██████╔╝███████╗██║        ██║   ██║  ██║    ███████╗██║██║ ╚═╝ ██║██║   ██║   ███████╗██████╔╝    ██║     ██║██║  ██║███████║   ██║       ███████║███████╗██║  ██║██║  ██║╚██████╗██║  ██║
# ╚═════╝ ╚══════╝╚═╝        ╚═╝   ╚═╝  ╚═╝    ╚══════╝╚═╝╚═╝     ╚═╝╚═╝   ╚═╝   ╚══════╝╚═════╝     ╚═╝     ╚═╝╚═╝  ╚═╝╚══════╝   ╚═╝       ╚══════╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝


def depth_limited_first_search(
    graph: list[list[int]], start_vertex: int, goal_vertex: int, max_depth: int
) -> tuple[bool, list[int]]:
    """
    Perform Depth-Limited First Search (DLFS) on a graph to find a path from
    a start vertex to a goal vertex within a specified maximum depth.

    Args:
    - graph (list[list[int]]): An adjacency list representation of the graph.
    - start_vertex (int): The number representing the starting vertex (0-indexed).
    - goal_vertex (int): The number representing the goal vertex (0-indexed).
    - max_depth (int): The maximum depth to search within.

    Returns:
    - tuple[bool, list[int]]: A tuple containing a boolean indicating whether
      a path from start to goal exists within the specified maximum depth, and a list representing the path
      (empty if no path found within the maximum depth).
    """

    path: list[int] = list()
    visited: list[bool] = [False for _ in graph]

    is_found = _depth_limited_first_search_util(
        graph, start_vertex, goal_vertex, visited, 1, max_depth, path
    )

    return is_found, path


def _depth_limited_first_search_util(
    graph: list[list[int]],
    curr_vertex: int,
    goal_vertex: int,
    visited: list[bool],
    curr_depth: int,
    max_depth: int,
    path: list[int],
) -> bool:
    """
    Utility function for performing Depth-Limited First Search (DLFS) on a graph.

    Args:
    - graph (list[list[int]]): An adjacency list representation of the graph.
    - curr_vertex (int): The number representing the current vertex being explored.
    - goal_vertex (int): The number representing the goal vertex (0-indexed).
    - visited (list[bool]): A list to track visited vertices.
    - curr_depth (int): The current depth of the exploration.
    - max_depth (int): The maximum depth allowed for the search.
    - path (list[int]): A list to store the current path being explored.

    Returns:
    - bool: True if the goal vertex is found within the specified maximum depth, False otherwise.
    """

    # don't go beyond specified depth
    if curr_depth > max_depth:
        return False

    # mark the curr_vertex as visited
    visited[curr_vertex] = True
    path.append(curr_vertex)
    if curr_vertex == goal_vertex:
        return True

    for neighbour_vertex in graph[curr_vertex]:
        if visited[neighbour_vertex]:
            continue
        is_found = _depth_limited_first_search_util(
            graph,
            neighbour_vertex,
            goal_vertex,
            visited,
            curr_depth + 1,
            max_depth,
            path,
        )
        if is_found:
            return True

    return False


# ██╗   ██╗ ██████╗███████╗
# ██║   ██║██╔════╝██╔════╝
# ██║   ██║██║     ███████╗
# ██║   ██║██║     ╚════██║
# ╚██████╔╝╚██████╗███████║
#  ╚═════╝  ╚═════╝╚══════╝


def uniform_cost_search(
    graph: list[list[tuple[int, int]]],
    start_vertex: int,
    goal_vertex: int,
) -> tuple[bool, int | float, list[int]]:
    """
    Perform Uniform Cost Search (UCS) on a graph to find the lowest-cost path from
    a start vertex to a goal vertex.

    Args:
    - graph (list[list[tuple[int, int]]]): An adjacency list representation of the graph,
      where each inner list contains tuples representing neighboring vertices and their edge weights.
    - start_vertex (int): The number representing the starting vertex (0-indexed).
    - goal_vertex (int): The number representing the goal vertex (0-indexed).

    Returns:
    - tuple[bool, int | float, list[int]]: A tuple containing:
        - a boolean indicating whether a path from start to goal exists,
        - the cumulative cost of the lowest-cost path (either an integer or float),
        - a list representing the lowest-cost path (empty if no path found).
    """

    path: list[int] = list()
    visited = [False for _ in graph]
    pq: PriorityQueue[tuple[int, int]] = PriorityQueue()
    pq.put((0, start_vertex))

    while pq:
        cumulative_cost, curr_vertex = pq.get()
        if visited[curr_vertex]:
            continue

        visited[curr_vertex] = True
        path.append(curr_vertex)
        if curr_vertex == goal_vertex:
            return True, cumulative_cost, path

        # add all neighbours of curr_node to queue
        for neighbour_vertex, edge_weight in graph[curr_vertex]:
            if not visited[neighbour_vertex]:
                pq.put((cumulative_cost + edge_weight, neighbour_vertex))

    # If the goal vertex is not found, return False, infinity cost, and an empty path
    return False, math.inf, path


# ██╗██████╗ ██████╗ ███████╗███████╗
# ██║██╔══██╗██╔══██╗██╔════╝██╔════╝
# ██║██║  ██║██║  ██║█████╗  ███████╗
# ██║██║  ██║██║  ██║██╔══╝  ╚════██║
# ██║██████╔╝██████╔╝██║     ███████║
# ╚═╝╚═════╝ ╚═════╝ ╚═╝     ╚══════╝


def iterative_deepening_depth_first_search(
    graph: list[list[int]],
    start_vertex: int,
    goal_vertex: int,
) -> tuple[bool, list[int]]:
    """
    Perform Iterative Deepening Depth-First Search (IDDFS) on a graph to find a path from
    a start vertex to a goal vertex.

    Args:
    - graph (list[list[int]]): An adjacency list representation of the graph.
    - start_vertex (int): The number representing the starting vertex (0-indexed).
    - goal_vertex (int): The number representing the goal vertex (0-indexed).

    Returns:
    - tuple[bool, list[int]]: A tuple containing a boolean indicating whether
      a path from start to goal exists, and a list representing the path (empty if no path found).
    """

    depth = 1
    while True:
        is_found, path = depth_limited_first_search(
            graph, start_vertex, goal_vertex, depth
        )
        if is_found:
            return is_found, path
        depth += 1


# ██████╗ ██╗██████╗ ██╗██████╗ ███████╗ ██████╗████████╗██╗ ██████╗ ███╗   ██╗ █████╗ ██╗
# ██╔══██╗██║██╔══██╗██║██╔══██╗██╔════╝██╔════╝╚══██╔══╝██║██╔═══██╗████╗  ██║██╔══██╗██║
# ██████╔╝██║██║  ██║██║██████╔╝█████╗  ██║        ██║   ██║██║   ██║██╔██╗ ██║███████║██║
# ██╔══██╗██║██║  ██║██║██╔══██╗██╔══╝  ██║        ██║   ██║██║   ██║██║╚██╗██║██╔══██║██║
# ██████╔╝██║██████╔╝██║██║  ██║███████╗╚██████╗   ██║   ██║╚██████╔╝██║ ╚████║██║  ██║███████╗
# ╚═════╝ ╚═╝╚═════╝ ╚═╝╚═╝  ╚═╝╚══════╝ ╚═════╝   ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝╚═╝  ╚═╝╚══════╝


def bidirectional_search(
    graph: list[list[int]], start_vertex: int, goal_vertex: int
) -> tuple[bool, list[int]]:
    path: list[int] = []
    visited_start: list[bool] = [False for _ in graph]
    visited_goal: list[bool] = [False for _ in graph]
    q_start: deque[int] = deque()
    q_start.append(start_vertex)

    q_goal: deque[int] = deque()
    q_goal.append(goal_vertex)

    return True, list()


# ██████╗ ███████╗███████╗████████╗    ███████╗██╗██████╗ ███████╗████████╗    ███████╗███████╗ █████╗ ██████╗  ██████╗██╗  ██╗
# ██╔══██╗██╔════╝██╔════╝╚══██╔══╝    ██╔════╝██║██╔══██╗██╔════╝╚══██╔══╝    ██╔════╝██╔════╝██╔══██╗██╔══██╗██╔════╝██║  ██║
# ██████╔╝█████╗  ███████╗   ██║       █████╗  ██║██████╔╝███████╗   ██║       ███████╗█████╗  ███████║██████╔╝██║     ███████║
# ██╔══██╗██╔══╝  ╚════██║   ██║       ██╔══╝  ██║██╔══██╗╚════██║   ██║       ╚════██║██╔══╝  ██╔══██║██╔══██╗██║     ██╔══██║
# ██████╔╝███████╗███████║   ██║       ██║     ██║██║  ██║███████║   ██║       ███████║███████╗██║  ██║██║  ██║╚██████╗██║  ██║
# ╚═════╝ ╚══════╝╚══════╝   ╚═╝       ╚═╝     ╚═╝╚═╝  ╚═╝╚══════╝   ╚═╝       ╚══════╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝


def best_first_search(
    graph: list[list[tuple[int, int]]],
    heuristic: list[int],
    start_vertex: int,
    goal_vertex: int,
) -> tuple[bool, int | float, list[int]]:
    """
    Perform Best-First Search (BFS) on a graph to find a path from
    a start vertex to a goal vertex using a heuristic function.

    Args:
    - graph (list[list[tuple[int, int]]]): An adjacency list representation of the graph,
      where each inner list contains tuples representing neighboring vertices and their edge costs.
    - heuristic (list[int]): A heuristic function providing an estimate of the cost
      from each vertex to the goal vertex. heuristic[i]-> heuristic value of vertex i
    - start_vertex (int): The number representing the starting vertex (0-indexed).
    - goal_vertex (int): The number representing the goal vertex (0-indexed).

    Returns:
    - tuple[bool, int | float, list[int]]: A tuple containing:
        - a boolean indicating whether a path from start to goal exists,
        - the total cost of the path (either an integer or float),
        - a list representing the path (empty if no path found).
    """

    path: list[int] = list()
    visited = [False for _ in graph]
    pq: PriorityQueue[tuple[int, tuple[int, int]]] = PriorityQueue()
    pq.put((0, (start_vertex, 0)))
    total_cost = 0

    while pq:
        _, curr_vertex_with_cost = pq.get()
        curr_vertex, cost = curr_vertex_with_cost

        if visited[curr_vertex]:
            continue

        total_cost += cost
        path.append(curr_vertex)
        visited[curr_vertex] = True
        if curr_vertex == goal_vertex:
            return True, total_cost, path

        # add its neighours according to heuristic in priority queue
        for neighbour_vertex, cost in graph[curr_vertex]:
            if not visited[neighbour_vertex]:
                pq.put((heuristic[neighbour_vertex], (neighbour_vertex, cost)))

    return False, math.inf, path


#  █████╗           ███████╗███████╗ █████╗ ██████╗  ██████╗██╗  ██╗
# ██╔══██╗▄ ██╗▄    ██╔════╝██╔════╝██╔══██╗██╔══██╗██╔════╝██║  ██║
# ███████║ ████╗    ███████╗█████╗  ███████║██████╔╝██║     ███████║
# ██╔══██║▀╚██╔▀    ╚════██║██╔══╝  ██╔══██║██╔══██╗██║     ██╔══██║
# ██║  ██║  ╚═╝     ███████║███████╗██║  ██║██║  ██║╚██████╗██║  ██║
# ╚═╝  ╚═╝          ╚══════╝╚══════╝╚═╝  ╚═╝╚═╝  ╚═╝ ╚═════╝╚═╝  ╚═╝
def a_star_search(
    graph: list[list[tuple[int, int]]],
    heuristic: list[int],
    start_vertex: int,
    goal_vertex: int,
) -> tuple[bool, int | float, list[int]]:
    """
    Perform A* Search on a graph to find a path from a start vertex to a goal vertex,
    using a heuristic function to guide the search.

    Args:
    - graph (list[list[tuple[int, int]]]): An adjacency list representation of the graph,
      where each inner list contains tuples representing neighboring vertices and their edge costs.
    - heuristic (list[int]): A heuristic function providing an estimate of the cost
      from each vertex to the goal vertex. heuristic[i]-> heuristic value of vertex i
    - start_vertex (int): The number representing the starting vertex (0-indexed).
    - goal_vertex (int): The number representing the goal vertex (0-indexed).

    Returns:
    - tuple[bool, int | float, list[int]]: A tuple containing:
        - a boolean indicating whether a path from start to goal exists,
        - the total cost of the path (either an integer or float),
        - a list representing the path (empty if no path found).
    """

    path: list[int] = list()
    visited = [False for _ in graph]
    pq: PriorityQueue[tuple[int, tuple[int, int]]] = PriorityQueue()
    pq.put((0, (start_vertex, 0)))
    total_cost = 0

    while pq:
        _, curr_vertex_with_cost = pq.get()
        curr_vertex, cost = curr_vertex_with_cost

        if visited[curr_vertex]:
            continue

        total_cost += cost
        path.append(curr_vertex)
        visited[curr_vertex] = True
        if curr_vertex == goal_vertex:
            return True, total_cost, path

        # add its neighours according to heuristic in priority queue
        for neighbour_vertex, cost in graph[curr_vertex]:
            if not visited[neighbour_vertex]:
                priority = heuristic[neighbour_vertex] + cost
                pq.put((priority, (neighbour_vertex, cost)))

    return False, math.inf, path


if __name__ == "__main__":
    graph = [[1, 2], [0, 2, 3], [0, 1, 4], [1, 4], [2, 3]]
    start_vertex = 0
    goal_vertex = 4

    # pprint(breadth_first_search(graph, start_vertex, goal_vertex))
    # pprint(depth_first_search_recursive(graph, start_vertex, goal_vertex))
    # pprint(depth_first_search_iterative(graph, start_vertex, goal_vertex))
    # pprint(depth_limited_first_search(graph, start_vertex, goal_vertex, 3))
    pprint(
        iterative_deepening_depth_first_search(
            graph,
            start_vertex,
            goal_vertex,
        )
    )

    weighted_graph = [
        [(2, 3), (1, 7)],
        [(0, 7), (2, 2), (4, 6)],
        [(0, 3), (1, 2), (3, 9)],
        [(2, 9), (4, 3), (7, 13)],
        [(1, 6), (3, 3), (5, 2), (6, 1)],
        [(4, 2)],
        [(4, 1)],
        [(3, 13)],
    ]
    # pprint(uniform_cost_search(weighted_graph, 0, 7))

    graph_bfs = [
        [(1, 11), (3, 7), (2, 14)],
        [(0, 11), (4, 15)],
        [(0, 14), (4, 8), (5, 10)],
        [(0, 7), (5, 25)],
        [(1, 15), (7, 9), (2, 8)],
        [(2, 10), (6, 20), (3, 25)],
        [(5, 20), (7, 10)],
        [(4, 9), (6, 10)],
    ]
    heuristic = [40, 32, 25, 35, 19, 17, 10, 0]
    pprint(best_first_search(graph_bfs, heuristic, 0, 6), indent=4)
    pprint(
        a_star_search(
            [
                [(1, 4), (2, 3)],
                [(4, 12), (5, 5)],
                [(3, 7), (4, 10)],
                [(4, 2)],
                [(6, 5)],
                [(6, 16)],
                [],
            ],
            [14, 12, 11, 6, 4, 11, 0],
            0,
            6,
        ),
        indent=4,
    )
