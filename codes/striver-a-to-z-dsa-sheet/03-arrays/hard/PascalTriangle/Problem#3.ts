import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";

type Output = number[][];

class PascalTriangleSolution implements Solution<number, Output> {
	getName(): string {
		return "Pascal's Triangle";
	}
	getProblemLink(): string {
		return "https://leetcode.com/problems/pascals-triangle/description/";
	}
	getImplementations(): SolutionImplementation<number, Output>[] {
		return [this.brute];
	}
	getTestCases(): TestCase<number, Output>[] {
		return [
			{
				input: 5,
				expected: [
					[1],
					[1, 1],
					[1, 2, 1],
					[1, 3, 3, 1],
					[1, 4, 6, 4, 1],
				],
			},
			{
				input: 1,
				expected: [[1]],
			},
			{ input: 2, expected: [[1], [1, 1]] },
		];
	}

	brute: SolutionImplementation<number, Output> = rows => {
		const triangle: number[][] = new Array(rows);
		triangle[0] = [1];
		if (rows > 1) {
			triangle[1] = [1, 1];
		}

		for (let row = 3; row <= rows; row++) {
			const currRow: number[] = new Array(row);
			// first element is always 1
			currRow[0] = 1;

			for (let i = 1; i < currRow.length - 1; i++) {
				currRow[i] = triangle[row - 2][i] + triangle[row - 2][i - 1];
			}

			// last row is always 1 too
			currRow[currRow.length - 1] = 1;
			// add to ans
			triangle[row - 1] = currRow;
		}

		return triangle;
	};
}

new ManualTesting().test(new PascalTriangleSolution());
