import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";
import { factorial } from "@utils/math";

type Input = { row: number; col: number };

class PascalTriangleSolution implements Solution<Input, number> {
	getName(): string {
		return "Given row & col, find element in Pascal Triangle";
	}
	getProblemLink(): string {
		return "https://takeuforward.org/strivers-a2z-dsa-course/strivers-a2z-dsa-course-sheet-2";
	}
	getImplementations(): SolutionImplementation<Input, number>[] {
		return [this.brute, this.optimal];
	}
	getTestCases(): TestCase<Input, number>[] {
		return [
			{ input: { row: 3, col: 1 }, expected: 1 },
			{ input: { row: 3, col: 2 }, expected: 2 },
			{ input: { row: 3, col: 3 }, expected: 1 },
		];
	}

	brute: SolutionImplementation<Input, number> = ({ row, col }) => {
		return factorial(row - 1) / (factorial(col - 1) * factorial(row - col));
	};

	optimal: SolutionImplementation<Input, number> = ({ row, col }) => {
		row -= 1;
		col -= 1;

		// calculate ncr
		let ans = 1;

		for (let i = 0; i < col; i++) {
			ans *= row - i;
			ans /= i + 1;
		}
		return ans;
	};
}

new ManualTesting().test(new PascalTriangleSolution());
