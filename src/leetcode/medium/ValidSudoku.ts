/*	
	Problem Link: https://leetcode.com/problems/valid-sudoku/description/
*/

import { TestCase } from "@/types";
import { judgeProblem } from "@/utils";

type TProblem = (board: string[][]) => boolean;

type Cell = { row: number; col: number };

const occurrenceInRow = (board: string[][], cell: Cell): number => {
	let occurrence = 0;
	const cellValue = board[cell.row][cell.col];
	for (let i = 0; i < board.length; i++)
		if (board[cell.row][i] === cellValue) occurrence++;

	return occurrence;
};

const occurrenceInCol = (board: string[][], cell: Cell): number => {
	let occurrence = 0;
	const cellValue = board[cell.row][cell.col];
	for (const row of board) if (row[cell.col] === cellValue) occurrence++;

	return occurrence;
};

const getGridCenterCoords = (cell: Cell): Cell => {
	const center = { col: 0, row: 0 } satisfies Cell;

	// set column
	if (cell.col <= 2) center.col = 1;
	else if (cell.col <= 5) center.col = 4;
	else center.col = 7;

	// set row
	if (cell.row <= 2) center.row = 1;
	else if (cell.row <= 5) center.row = 4;
	else center.row = 7;

	return center;
};

const occurrenceOfCellInGrid = (board: string[][], cell: Cell): number => {
	const cellValue = board[cell.row][cell.col];
	let occurrence = 0;
	// get corresponding grid's center coordinates
	const center = getGridCenterCoords(cell);

	// check whole grid for occurrences
	for (let i = center.row - 1; i <= center.row + 1; i++) {
		for (let j = center.col - 1; j <= center.col + 1; j++) {
			if (board[i][j] === cellValue) occurrence++;
		}
	}
	return occurrence;
};

const brute: TProblem = board => {
	for (let i = 0; i < board.length; i++) {
		for (let j = 0; j < board.length; j++) {
			// if cell is empty continue to next non-empty cell
			if (board[i][j] === ".") continue;

			const cell = { row: i, col: j };
			// check occurrence of cell in row
			if (occurrenceInRow(board, cell) > 1) return false;

			// check occurrence of cell in col
			if (occurrenceInCol(board, cell) > 1) return false;

			// check occurrence of cell in current grid
			if (occurrenceOfCellInGrid(board, cell) > 1) return false;
		}
	}
	return true;
};

const solutions = [brute];
const testCases: TestCase<TProblem>[] = [
	[
		[
			[
				["5", "3", ".", ".", "7", ".", ".", ".", "."],
				["6", ".", ".", "1", "9", "5", ".", ".", "."],
				[".", "9", "8", ".", ".", ".", ".", "6", "."],
				["8", ".", ".", ".", "6", ".", ".", ".", "3"],
				["4", ".", ".", "8", ".", "3", ".", ".", "1"],
				["7", ".", ".", ".", "2", ".", ".", ".", "6"],
				[".", "6", ".", ".", ".", ".", "2", "8", "."],
				[".", ".", ".", "4", "1", "9", ".", ".", "5"],
				[".", ".", ".", ".", "8", ".", ".", "7", "9"],
			],
		],
		true,
	],
	[
		[
			[
				["8", "3", ".", ".", "7", ".", ".", ".", "."],
				["6", ".", ".", "1", "9", "5", ".", ".", "."],
				[".", "9", "8", ".", ".", ".", ".", "6", "."],
				["8", ".", ".", ".", "6", ".", ".", ".", "3"],
				["4", ".", ".", "8", ".", "3", ".", ".", "1"],
				["7", ".", ".", ".", "2", ".", ".", ".", "6"],
				[".", "6", ".", ".", ".", ".", "2", "8", "."],
				[".", ".", ".", "4", "1", "9", ".", ".", "5"],
				[".", ".", ".", ".", "8", ".", ".", "7", "9"],
			],
		],
		false,
	],
];

judgeProblem(solutions, testCases, import.meta.file);
