import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";

type Input = { arr: number[] };
type Output = number;

class MaximumSubarraySolution implements Solution<Input, Output> {
	getName(): string {
		return "Maximum Subarray";
	}
	getProblemLink(): string {
		return "https://leetcode.com/problems/maximum-subarray/description/";
	}
	getImplementations(): SolutionImplementation<Input, number>[] {
		return [this.brute, this.optimal];
	}
	getTestCases(): TestCase<Input, number>[] {
		return [
			{
				input: {
					arr: [-2, 1, -3, 4, -1, 2, 1, -5, 4],
				},
				expected: 6,
			},
			{ input: { arr: [1] }, expected: 1 },
			{ input: { arr: [5, 4, -1, 7, 8] }, expected: 23 },
		];
	}

	brute: SolutionImplementation<Input, Output> = ({ arr }) => {
		let maxSum = Number.MIN_SAFE_INTEGER;
		for (let i = 0; i < arr.length; i++) {
			let sum = 0;
			for (let j = i; j < arr.length; j++) {
				sum += arr[j];
				maxSum = Math.max(maxSum, sum);
			}
		}

		return maxSum;
	};

	optimal: SolutionImplementation<Input, Output> = ({ arr }) => {
		// kadane's algorithm
		let maxSum = arr[0],
			sum = 0;
		for (const i of arr) {
			sum += i;
			if (sum < 0) {
				sum = 0;
			}
			maxSum = Math.max(sum, maxSum);
		}
		return maxSum;
	};
}

new ManualTesting().test(new MaximumSubarraySolution());
