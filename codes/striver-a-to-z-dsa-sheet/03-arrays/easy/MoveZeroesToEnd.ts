import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";

type Input = { arr: number[] };
type Output = number[];

class MoveZeroesToEnd implements Solution<Input, Output> {
	getName(): string {
		return "Move Zeroes to End";
	}
	getProblemLink(): string {
		return "https://leetcode.com/problems/move-zeroes/description";
	}
	getImplementations(): ((input: Input) => Output)[] {
		return [this.brute];
	}
	getTestCases(): TestCase<Input, Output>[] {
		return [
			{ input: { arr: [0, 1, 0, 3, 12] }, expected: [1, 3, 12, 0, 0] },
			{ input: { arr: [1, 1, 1, 3, 12] }, expected: [1, 1, 1, 3, 12] },
			{ input: { arr: [0, 1, 1, 3, 12] }, expected: [1, 1, 3, 12, 0] },
			{ input: { arr: [0] }, expected: [0] },
		];
	}

	brute: SolutionImplementation<Input, Output> = ({ arr }) => {
		// first occurrence of 0 in arr
		let i = arr.indexOf(0);
		let zeroCount = i === -1 ? 0 : 1;

		// no zero found in the arr
		if (i === -1) return arr;
		// move all non-zero elements backward
		for (let j = i + 1; j < arr.length; j++) {
			if (arr[j] == 0) {
				zeroCount++;
				continue;
			}
			arr[i] = arr[j];
			i++;
		}
		// fill remaining array with 0
		for (let i = arr.length - 1, j = 0; j < zeroCount; j++, i--) {
			arr[i] = 0;
		}

		return arr;
	};
}

new ManualTesting().test(new MoveZeroesToEnd());
