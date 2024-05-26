# 3 Missionaries and 3 Cannibals were on one side of river
# - All want to cross the river
# - On same side of river Missionaries count can't be
# less than that of cannibals
# - Only one boat available that can hold only two people
# at a time
# State Representation: <R, M, C>
#           R -> River Side (1 -> Starting Side, 2 -> Ending Side)
#           M -> No. of Missionaries
#           C -> No. of Cannibals


from collections import deque

State = tuple[tuple[int, int, int], tuple[int, int, int]]


def is_valid_state(state: State) -> bool:
    # starting side
    _, starting_side_missionary, starting_side_cannibal = state[0]
    _, ending_side_missionary, ending_side_cannibal = state[1]

    if any(
        [
            starting_side_missionary < 0,
            starting_side_cannibal < 0,
            ending_side_missionary < 0,
            ending_side_cannibal < 0,
        ]
    ):
        return False

    if starting_side_missionary < starting_side_cannibal:
        return False
    if ending_side_missionary < ending_side_cannibal:
        return False
    return True


def generate_successive_states(initial_state: State) -> list[State]:
    states: list[State] = list()
    starting_side, ending_side = initial_state

    for num_missionary in range(3):
        for num_cannibal in range(3):
            # create new state by moving missionary and cannibal on boat
            boat_occupancy = num_missionary + num_cannibal
            if boat_occupancy > 0 and boat_occupancy <= 2:
                new_state = (
                    (
                        1,
                        starting_side[1] - num_missionary,
                        starting_side[2] - num_cannibal,
                    ),
                    (2, ending_side[1] + num_missionary, ending_side[2] + num_cannibal),
                )
                if is_valid_state(new_state):
                    states.append(new_state)

    return states


def bfs_solution(initial_state: State, goal_state: State) -> bool:
    visited: set[State] = set()
    q: deque[State] = deque()
    q.append(initial_state)

    while q:
        curr_state = q.popleft()

        # check if the current state is the goal state, if so, then solution found
        if curr_state == goal_state:
            return True

        # mark the curr_state as visited
        visited.add(curr_state)

        # generate all possible valid successive states and check them all
        for state in generate_successive_states(curr_state):
            if state not in visited:
                q.append(state)

    return False


if __name__ == "__main__":
    INITIAL_STATE = ((1, 3, 3), (2, 0, 0))
    GOAL_STATE = ((1, 0, 0), (2, 3, 3))

    solution_found = bfs_solution(INITIAL_STATE, GOAL_STATE)
    if solution_found:
        print(f"Solution found from {INITIAL_STATE} to {GOAL_STATE}")
    else:
        print(f"No solution could be found from {INITIAL_STATE} to {GOAL_STATE}")
