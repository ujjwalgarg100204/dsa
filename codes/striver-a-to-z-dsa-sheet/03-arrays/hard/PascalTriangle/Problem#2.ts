import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";
import { ncr } from "@utils/math";

type Output = number[];
class PascalTriangleSolution implements Solution<number, Output> {
	getName(): string {
		return "Given row number, generate entire row as in Pascal triangle";
	}
	getProblemLink(): string {
		return "https://takeuforward.org/strivers-a2z-dsa-course/strivers-a2z-dsa-course-sheet-2";
	}
	getImplementations(): SolutionImplementation<number, Output>[] {
		return [this.brute, this.optimal];
	}
	getTestCases(): TestCase<number, Output>[] {
		return [
			{ input: 1, expected: [1] },
			{ input: 2, expected: [1, 1] },
			{ input: 3, expected: [1, 2, 1] },
		];
	}

	brute: SolutionImplementation<number, Output> = row => {
		const arr = new Array(row) as number[];
		for (let i = 0; i < row; i++) {
			arr[i] = ncr(row - 1, i);
		}

		return arr;
	};

	optimal: SolutionImplementation<number, Output> = row => {
		const arr = new Array(row) as number[];
		// first element is always 1
		arr[0] = 1;

		// generate rest of elements
		for (let i = 1; i < row; i++) {
			arr[i] = (arr[i - 1] * (row - i)) / i;
		}

		return arr;
	};
}

new ManualTesting().test(new PascalTriangleSolution());
