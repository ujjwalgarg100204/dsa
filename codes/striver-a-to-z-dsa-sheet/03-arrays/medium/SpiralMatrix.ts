import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";

type Input = { matrix: number[][] };
class SpiralMatrixSolution implements Solution<Input, number[]> {
	getName(): string {
		return "Spiral Matrix";
	}
	getProblemLink(): string {
		return "https://leetcode.com/problems/spiral-matrix/";
	}
	getImplementations(): ((input: Input) => number[])[] {
		return [this.optimal];
	}
	getTestCases(): TestCase<Input, number[]>[] {
		return [
			{
				input: {
					matrix: [
						[1, 2, 3],
						[4, 5, 6],
						[7, 8, 9],
					],
				},
				expected: [1, 2, 3, 6, 9, 8, 7, 4, 5],
			},
			{
				input: {
					matrix: [
						[1, 2, 3, 4],
						[5, 6, 7, 8],
						[9, 10, 11, 12],
					],
				},
				expected: [1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7],
			},
		];
	}

	optimal: SolutionImplementation<Input, number[]> = ({ matrix }) => {
		const ans: number[] = [];

		let top = 0,
			left = 0,
			right = matrix[0].length - 1,
			bottom = matrix.length - 1;

		while (top <= bottom && left <= right) {
			// top row
			for (let i = left; i <= right; i++) ans.push(matrix[top][i]);
			top++;
			// right row
			for (let i = top; i <= bottom; i++) ans.push(matrix[i][right]);
			right--;

			if (top <= bottom) {
				// bottom row
				for (let i = right; i >= left; i--) ans.push(matrix[bottom][i]);
				bottom--;
			}
			if (left <= right) {
				// left row
				for (let i = bottom; i >= top; i--) ans.push(matrix[i][left]);
				left++;
			}
		}
		return ans;
	};
}

new ManualTesting().test(new SpiralMatrixSolution());
