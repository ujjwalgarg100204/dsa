import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@/ManualTesting";

type Input = { arr: number[] };
type Output = number;

class MajorityElementSolution implements Solution<Input, Output> {
	getName(): string {
		return "Majority Elment";
	}
	getProblemLink(): string {
		return "https://leetcode.com/problems/majority-element/description";
	}
	getImplementations(): SolutionImplementation<Input, number>[] {
		return [this.brute, this.optimal];
	}
	getTestCases(): TestCase<Input, number>[] {
		return [
			{ input: { arr: [3, 2, 3] }, expected: 3 },
			{ input: { arr: [2, 2, 1, 1, 1, 2, 2] }, expected: 2 },
		];
	}

	brute: SolutionImplementation<Input, Output> = ({ arr }) => {
		for (const el of arr) {
			let count = 0;
			for (const currEl of arr) {
				if (currEl === el) {
					count++;
				}
			}
			if (count > arr.length / 2) {
				return el;
			}
		}

		return -1;
	};

	optimal: SolutionImplementation<Input, Output> = ({ arr }) => {
		let majorityEl = arr[0],
			count = 1;
		for (let i = 1; i < arr.length; i++) {
			if (count === 0) {
				majorityEl = arr[i];
				count++;
			} else if (arr[i] === majorityEl) {
				count++;
			} else {
				count--;
			}
		}

		return majorityEl;
	};
}

new ManualTesting().test(new MajorityElementSolution());
