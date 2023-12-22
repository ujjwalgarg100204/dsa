import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";

type Input = { arr: number[] };
type Output = number;

class MaxConsecutiveOnes implements Solution<Input, Output> {
	getName(): string {
		return "Maximum Consecutive Ones";
	}
	getProblemLink(): string {
		return "https://leetcode.com/problems/max-consecutive-ones/description";
	}
	getImplementations(): ((input: Input) => number)[] {
		return [this.optimal];
	}
	getTestCases(): TestCase<Input, number>[] {
		return [
			{ input: { arr: [1, 1, 0, 1, 1, 1] }, expected: 3 },
			{ input: { arr: [1, 0, 1, 1, 0, 1] }, expected: 2 },
		];
	}

	optimal: SolutionImplementation<Input, Output> = ({ arr }) => {
		let count = 0,
			maxCount = 0;
		for (const i of arr) {
			if (i === 1) {
				count++;
				continue;
			}
			// i === 0
			maxCount = Math.max(maxCount, count);
			count = 0;
		}
		maxCount = Math.max(maxCount, count);

		return maxCount;
	};
}

new ManualTesting().test(new MaxConsecutiveOnes());
