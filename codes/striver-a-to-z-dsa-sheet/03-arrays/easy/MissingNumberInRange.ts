import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";

type Input = { arr: number[] };
type Output = number;

class MissingNumberInRange implements Solution<Input, Output> {
	getName(): string {
		return "Missing Number in Range";
	}
	getProblemLink(): string {
		return "https://leetcode.com/problems/missing-number/description";
	}
	getImplementations(): ((input: Input) => number)[] {
		return [this.optimal];
	}
	getTestCases(): TestCase<Input, number>[] {
		return [
			{
				input: {
					arr: [3, 0, 1],
				},
				expected: 2,
			},
			{
				input: {
					arr: [0, 1],
				},
				expected: 2,
			},
			{
				input: {
					arr: [9, 6, 4, 2, 3, 5, 7, 0, 1],
				},
				expected: 8,
			},
		];
	}

	optimal: SolutionImplementation<Input, Output> = ({ arr }) => {
		let sum = (arr.length * (arr.length + 1)) / 2;
		for (const i of arr) {
			sum -= i;
		}
		return sum;
	};
}

new ManualTesting().test(new MissingNumberInRange());
