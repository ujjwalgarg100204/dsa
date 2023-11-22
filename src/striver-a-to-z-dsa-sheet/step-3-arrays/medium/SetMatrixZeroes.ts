import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@/ManualTesting";
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
		return [this.brute, this.optimal];
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
					utils.makeRow0(matrix, row);
					utils.makeCol0(matrix, col);
				}
		return matrix;
	};

	optimal: SolutionImplementation<Input, number[][]> = ({ matrix }) => {
		let firstCell = 1;

		// mark the first row and column as 0s based on inner matrix
		for (let i = 0; i < matrix.length; i++)
			for (let j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] !== 0) continue;

				// matrix[i][j] is 0
				// if first column is being checked then mark the firstCell instead
				// of first row
				if (j === 0) {
					firstCell = 0;
				} else {
					// mark the top row
					matrix[0][j] = 0;
					// mark the left col
					matrix[i][0] = 0;
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
		if (firstCell === 0)
			for (let i = 0; i < matrix.length; i++) matrix[i][0] = 0;

		return matrix;
	};
}
const utils = {
	makeRow0(matrix: number[][], row: number): void {
		for (let i = 0; i < matrix[row].length; i++) matrix[row][i] = 0;
	},
	makeCol0(matrix: number[][], col: number): void {
		for (let i = 0; i < matrix.length; i++) matrix[i][col] = 0;
	},
};

new ManualTesting().test(new SetMatrixZeroesSolution());
