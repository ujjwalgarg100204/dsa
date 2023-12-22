import { Solution, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";

type Input = { arr: unknown[] };
type Output = unknown[];

class ReverseArrayUsingRecursion implements Solution<Input, Output> {
	getName(): string {
		return "Reverse Array using Recursion";
	}
	getProblemLink(): string {
		return "https://www.codingninjas.com/studio/problems/reverse-an-array_8365444";
	}
	getImplementations(): ((input: Input) => Output)[] {
		return [this.optimal];
	}
	getTestCases(): TestCase<Input, Output>[] {
		return [
			{ input: { arr: [1, 2, 3, 4, 5] }, expected: [5, 4, 3, 2, 1] },
			{
				input: { arr: [3, 1, 1, 7, 4, 2, 6, 11] },
				expected: [11, 6, 2, 4, 7, 1, 1, 3],
			},
		];
	}
	optimal = ({ arr }: Input) => {
		const helper = (arr: unknown[], start: number, end: number): void => {
			if (start >= end) return;
			// swap start with end
			[arr[start], arr[end]] = [arr[end], arr[start]];
			helper(arr, start + 1, end - 1);
		};
		helper(arr, 0, arr.length - 1);

		return arr;
	};
}

new ManualTesting().test(new ReverseArrayUsingRecursion());
