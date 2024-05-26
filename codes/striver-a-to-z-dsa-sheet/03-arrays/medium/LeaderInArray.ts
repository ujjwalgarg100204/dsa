import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";

type Input = {
	arr: number[];
};
type Output = number[];

class LeaderInArraySolution implements Solution<Input, Output> {
	getName(): string {
		return "Leader in an Array";
	}
	getProblemLink(): string {
		return "https://www.codingninjas.com/studio/problems/superior-elements_6783446";
	}
	getImplementations(): SolutionImplementation<Input, Output>[] {
		return [this.optimal];
	}
	getTestCases(): TestCase<Input, Output>[] {
		return [
			{ input: { arr: [1, 2, 3, 2] }, expected: [2, 3] },
			{
				input: { arr: [1, 2, 2, 1] },
				expected: [1, 2],
			},
			{ input: { arr: [5, 4, 3] }, expected: [3, 4, 5] },
		];
	}

	optimal: SolutionImplementation<Input, Output> = ({ arr }) => {
		const leaders: number[] = [arr.at(-1)!];

		let currMax = leaders[0];
		for (let i = arr.length - 2; i >= 0; i--) {
			if (arr[i] > currMax) {
				leaders.push(arr[i]);
				currMax = arr[i];
			}
		}

		return leaders;
	};
}

new ManualTesting().test(new LeaderInArraySolution());
