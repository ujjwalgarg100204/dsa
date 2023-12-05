from typing import List, Tuple

SUDOKU_BOARD_DIMENSION = 9

SudokuBoard = List[List[str]]


def occurrence_in_row(board: SudokuBoard, row: int, col: int) -> int:
    occur = 0
    for i in range(SUDOKU_BOARD_DIMENSION):
        if board[row][i] == board[row][col]:
            occur += 1
    return occur


def occurrence_in_col(board: SudokuBoard, row: int, col: int) -> int:
    occur = 0
    for board_row in board:
        if board_row[col] == board[row][col]:
            occur += 1
    return occur


def grid_center_for_cell(row: int, col: int) -> Tuple[int, int]:
    center_row, center_col = 0, 0
    # calculate row of center
    if row <= 2:
        center_row = 1
    elif row <= 5:
        center_row = 4
    else:
        center_row = 7

    # calculate col of center
    if col <= 2:
        center_col = 1
    elif col <= 5:
        center_col = 4
    else:
        center_col = 7

    return center_row, center_col


def occurrence_in_grid(board: SudokuBoard, row: int, col: int) -> int:
    occur = 0

    grid_center_row, grid_center_col = grid_center_for_cell(row, col)
    for i in range(grid_center_row - 1, grid_center_row + 2):
        for j in range(grid_center_col - 1, grid_center_col + 2):
            if board[i][j] == board[row][col]:
                occur += 1
    return occur


def is_valid_sudoku_board(board: SudokuBoard) -> bool:
    for row in range(SUDOKU_BOARD_DIMENSION):
        for col in range(SUDOKU_BOARD_DIMENSION):
            # ignore empty values
            if board[row][col] == ".":
                continue
            # check occurrences in row
            if occurrence_in_row(board, row, col) > 2:
                return False
            # check occurrences in col
            if occurrence_in_col(board, row, col) > 2:
                return False
            # check occurences in grid
            if occurrence_in_grid(board, row, col) > 2:
                return False
    return True


def main() -> None:
    input()
    board = [input().split(" ") for _ in range(SUDOKU_BOARD_DIMENSION)]
    print("YES" if is_valid_sudoku_board(board) else "NO")


main()
