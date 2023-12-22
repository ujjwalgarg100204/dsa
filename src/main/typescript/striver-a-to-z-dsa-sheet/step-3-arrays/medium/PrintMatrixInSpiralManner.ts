import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";

type Input = { matrix: number[][] };

class MatrixInSpiralMannerSolution implements Solution<Input, number[]> {
	getName(): string {
		return "Matrix In Spiral Manner";
	}
	getProblemLink(): string {
		return "https://leetcode.com/problems/spiral-matrix/";
	}
	getImplementations(): ((input: Input) => number[])[] {
		return [this.brute];
	}
	getTestCases(): TestCase<Input, number[]>[] {
		return [
			{
				input: {
					matrix: [
						[1, 2, 3],
						[8, 9, 4],
						[7, 6, 5],
					],
				},
				expected: [1, 2, 3, 4, 5, 6, 7, 8, 9],
			},
			{
				input: {
					matrix: [
						[0, 1, 2, 0],
						[3, 4, 5, 2],
						[1, 3, 1, 5],
					],
				},
				expected: [0, 1, 2, 0, 2, 5, 1, 3, 1, 3, 4, 5],
			},
		];
	}

	brute: SolutionImplementation<Input, number[]> = ({ matrix }) => {
		const spiral: number[] = [];
		// first row
		for (const element of matrix[0]) {
			spiral.push(element);
		}

		// last col
		for (const element of matrix) {
			spiral.push(element[matrix.length - 1]);
		}

		// last row
		for (let i = matrix[0].length - 1; i >= 0; i--) {
			spiral.push(matrix[matrix.length - 1][i]);
		}

		// left col
		for (let i = matrix.length - 1; i > 0; i--) {
			spiral.push(matrix[i][0]);
		}

		return spiral;
	};
}

new ManualTesting().test(new MatrixInSpiralMannerSolution());
