import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";
import { cloneMatrix } from "@utils/array";

type Input = { matrix: number[][] };
class RotateImageBy90DegreeSolution implements Solution<Input, number[][]> {
	getName(): string {
		return "Rotate Image By 90 Degree";
	}

	getProblemLink(): string {
		return "https://leetcode.com/problems/rotate-image/";
	}

	getImplementations(): ((input: Input) => number[][])[] {
		return [this.brute, this.optimal, this.optimal2];
	}

	getTestCases(): TestCase<Input, number[][]>[] {
		return [
			{
				input: {
					matrix: [
						[1, 2, 3],
						[4, 5, 6],
						[7, 8, 9],
					],
				},
				expected: [
					[7, 4, 1],
					[8, 5, 2],
					[9, 6, 3],
				],
			},
			{
				input: {
					matrix: [
						[5, 1, 9, 11],
						[2, 4, 8, 10],
						[13, 3, 6, 7],
						[15, 14, 12, 16],
					],
				},
				expected: [
					[15, 13, 2, 5],
					[14, 3, 4, 1],
					[12, 6, 8, 9],
					[16, 7, 10, 11],
				],
			},
			{
				input: {
					matrix: [[1]],
				},
				expected: [[1]],
			},
			{
				input: {
					matrix: [
						[1, 2],
						[3, 4],
					],
				},
				expected: [
					[3, 1],
					[4, 2],
				],
			},
		];
	}

	brute: SolutionImplementation<Input, number[][]> = ({ matrix }) => {
		const n = matrix.length;
		const clone = cloneMatrix(matrix);

		for (let iC = 0; iC < n; iC++) {
			let iA = 0,
				jA = n - 1 - iC;
			for (let jC = 0; jC < n; jC++) {
				matrix[iA++][jA] = clone[iC][jC];
			}
		}
		return matrix;
	};

	optimal: SolutionImplementation<Input, number[][]> = ({ matrix }) => {
		// reverse the matrix
		matrix.reverse();

		// now take transpose of matrix
		for (let i = 0, n = matrix.length; i < n; i++) {
			for (let j = i; j < n; j++) {
				// swap
				[matrix[i][j], matrix[j][i]] = [matrix[j][i], matrix[i][j]];
			}
		}
		return matrix;
	};

	optimal2: SolutionImplementation<Input, number[][]> = ({ matrix }) => {
		// take transpose of the matrix
		for (let i = 0, n = matrix.length; i < n; i++) {
			for (let j = 0; j < n; j++) {
				if (i === j) break;
				// swap
				[matrix[i][j], matrix[j][i]] = [matrix[j][i], matrix[i][j]];
			}
		}

		// reverse each array
		for (const arr of matrix) {
			arr.reverse();
		}
		return matrix;
	};
}

new ManualTesting().test(new RotateImageBy90DegreeSolution());
