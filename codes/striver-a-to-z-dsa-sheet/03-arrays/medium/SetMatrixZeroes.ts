import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";
import { cloneMatrix } from "@utils/array";

type Input = { matrix: number[][] };
class SetMatrixZeroesSolution implements Solution<Input, number[][]> {
	getName(): string {
		return "Set Matrix Zeroes";
	}
	getProblemLink(): string {
		return "https://leetcode.com/problems/set-matrix-zeroes/";
	}
	getImplementations(): ((input: Input) => number[][])[] {
		return [this.brute, this.myOptimal, this.striverOptimal];
	}
	getTestCases(): TestCase<Input, number[][]>[] {
		return [
			{
				input: {
					matrix: [
						[1, 1, 1],
						[1, 0, 1],
						[1, 1, 1],
					],
				},
				expected: [
					[1, 0, 1],
					[0, 0, 0],
					[1, 0, 1],
				],
			},
		];
	}

	brute: SolutionImplementation<Input, number[][]> = ({ matrix }) => {
		const copy = cloneMatrix(matrix);

		for (let row = 0; row < copy.length; row++)
			for (let col = 0; col < copy[row].length; col++)
				if (copy[row][col] === 0) {
					// make row 0
					for (let i = 0; i < matrix[row].length; i++) {
						matrix[row][i] = 0;
					}
					// make col 0
					for (const row of matrix) {
						row[col] = 0;
					}
				}

		return matrix;
	};

	myOptimal: SolutionImplementation<Input, number[][]> = ({ matrix }) => {
		// check whether marker row and col should be made 0
		let shouldMakeMarkerRow0 = false,
			shouldMakeMarkerCol0 = false;
		// check first column
		for (const i of matrix[0]) {
			if (i === 0) {
				shouldMakeMarkerRow0 = true;
				break;
			}
		}
		// check first row
		for (const row of matrix) {
			if (row[0] === 0) {
				shouldMakeMarkerCol0 = true;
				break;
			}
		}

		// iterate on the inner matrix, ie, from row 1 and col 1
		for (let i = 1; i < matrix.length; i++) {
			for (let j = 1; j < matrix[i].length; j++) {
				if (matrix[i][j] !== 0) continue;
				// cell is 0 then mark the row and column
				matrix[0][j] = 0; //  mark the col
				matrix[i][0] = 0; // mark the row
			}
		}

		// iterate again to make cells 0
		for (let i = 1; i < matrix.length; i++) {
			for (let j = 1; j < matrix[i].length; j++) {
				if (matrix[0][j] === 0 || matrix[i][0] === 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (shouldMakeMarkerRow0) {
			matrix[0].fill(0);
		}

		if (shouldMakeMarkerCol0) {
			for (const row of matrix) {
				row[0] = 0;
			}
		}

		return matrix;
	};
	striverOptimal: SolutionImplementation<Input, number[][]> = ({
		matrix,
	}) => {
		let firstCell = 1;

		// mark the first row and column as 0s based on inner matrix
		for (const row of matrix)
			for (let j = 0; j < row.length; j++) {
				if (row[j] !== 0) continue;

				// matrix[i][j] is 0
				// if first column is being checked then mark the firstCell instead
				// of first row
				if (j === 0) {
					firstCell = 0;
				} else {
					// mark the top row
					matrix[0][j] = 0;
					// mark the left col
					row[0] = 0;
				}
			}

		// make element as 0 if first column or row is 0
		for (let i = 1; i < matrix.length; i++)
			for (let j = 1; j < matrix[i].length; j++)
				if (matrix[0][j] === 0 || matrix[i][0] === 0) matrix[i][j] = 0;

		// handle top row first
		if (matrix[0][0] === 0)
			for (let i = 0; i < matrix[0].length; i++) matrix[0][i] = 0;

		// handle leftmost col
		if (firstCell === 0) for (const row of matrix) row[0] = 0;

		return matrix;
	};
}

new ManualTesting().test(new SetMatrixZeroesSolution());
