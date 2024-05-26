import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";

type Input = { arr: number[] };
type Output = number;

class SingleNumber implements Solution<Input, Output> {
	getName(): string {
		return "Single Number";
	}
	getProblemLink(): string {
		return "https://leetcode.com/problems/single-number/description";
	}
	getImplementations(): ((input: Input) => number)[] {
		return [this.optimal];
	}
	getTestCases(): TestCase<Input, number>[] {
		return [
			{ input: { arr: [2, 2, 1] }, expected: 1 },
			{ input: { arr: [4, 1, 2, 1, 2] }, expected: 4 },
			{ input: { arr: [1] }, expected: 1 },
		];
	}
	optimal: SolutionImplementation<Input, Output> = ({ arr }) => {
		let num = arr[0];
		for (let i = 1; i < arr.length; i++) {
			num ^= arr[i];
		}
		return num;
	};
}

new ManualTesting().test(new SingleNumber());
