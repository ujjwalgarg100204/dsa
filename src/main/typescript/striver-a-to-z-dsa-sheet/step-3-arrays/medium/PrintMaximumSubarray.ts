import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";

type Input = { arr: number[] };
type Output = {
	maxSum: number;
	subArray: { startIndex: number; endIndex: number };
};

class PrintMaximumSubarraySolution implements Solution<Input, Output> {
	getName(): string {
		return "Print Maximum Subarray";
	}
	getProblemLink(): string {
		return "https://takeuforward.org/data-structure/kadanes-algorithm-maximum-subarray-sum-in-an-array";
	}
	getImplementations(): SolutionImplementation<Input, Output>[] {
		return [this.brute, this.optimal];
	}
	getTestCases(): TestCase<Input, Output>[] {
		return [
			{
				input: {
					arr: [-2, 1, -3, 4, -1, 2, 1, -5, 4],
				},
				expected: {
					maxSum: 6,
					subArray: { startIndex: 3, endIndex: 6 },
				},
			},
			{
				input: { arr: [1] },
				expected: {
					maxSum: 1,
					subArray: { startIndex: 0, endIndex: 0 },
				},
			},
			{
				input: { arr: [5, 4, -1, 7, 8] },
				expected: {
					maxSum: 23,
					subArray: { startIndex: 0, endIndex: 4 },
				},
			},
		];
	}

	brute: SolutionImplementation<Input, Output> = ({ arr }) => {
		let maxSum = Number.MIN_SAFE_INTEGER,
			startIndex = 0,
			endIndex = 0;
		for (let i = 0; i < arr.length; i++) {
			let sum = 0;
			for (let j = i; j < arr.length; j++) {
				sum += arr[j];
				if (maxSum < sum) {
					startIndex = i;
					endIndex = j;
					maxSum = sum;
				}
			}
		}

		return {
			maxSum,
			subArray: { endIndex, startIndex },
		};
	};

	optimal: SolutionImplementation<Input, Output> = ({ arr }) => {
		// kadane's algorithm
		let maxSum = arr[0],
			startIndex = 0,
			endIndex = 0,
			start = 0,
			sum = 0;

		for (let i = 0; i < arr.length; i++) {
			if (sum == 0) {
				start = i;
			}
			sum += arr[i];
			if (maxSum < sum) {
				maxSum = sum;
				startIndex = start;
				endIndex = i;
			}
			if (sum < 0) {
				sum = 0;
			}
		}

		return {
			maxSum,
			subArray: { endIndex, startIndex },
		};
	};
}

new ManualTesting().test(new PrintMaximumSubarraySolution());
