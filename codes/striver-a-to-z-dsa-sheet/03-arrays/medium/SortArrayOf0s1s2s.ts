import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";
import { swap } from "@utils/array";

type Input = { arr: number[] };
type Output = number[];

class SortArrayOf0s1s2s implements Solution<Input, Output> {
	getName(): string {
		return "Sort Array of 0s 1s 2s";
	}
	getProblemLink(): string {
		return "https://leetcode.com/problems/sort-colors/description";
	}
	getImplementations(): ((input: Input) => Output)[] {
		return [this.brute, this.optimized, this.optimal, this.striverOptimal];
	}
	getTestCases(): TestCase<Input, Output>[] {
		return [
			{
				input: { arr: [2, 0, 2, 1, 1, 0] },
				expected: [0, 0, 1, 1, 2, 2],
			},
			{ input: { arr: [2, 0, 1] }, expected: [0, 1, 2] },
			{ input: { arr: [1, 0, 2] }, expected: [0, 1, 2] },
			{ input: { arr: [0, 1, 2] }, expected: [0, 1, 2] },
		];
	}

	brute: SolutionImplementation<Input, Output> = ({ arr }) => {
		return arr.toSorted((a, b) => a - b);
	};

	optimized: SolutionImplementation<Input, Output> = ({ arr }) => {
		const count = { 0: 0, 1: 0, 2: 0 };
		for (const i of arr) {
			switch (i) {
				case 0:
					count[0]++;
					break;
				case 1:
					count[1]++;
					break;
				case 2:
					count[2]++;
					break;
			}
		}
		// recreate the array
		for (let i = 0; i < arr.length; i++) {
			if (count[0] !== 0) {
				arr[i] = 0;
				count[0]--;
			} else if (count[1] !== 0) {
				arr[i] = 1;
				count[1]--;
			} else {
				arr[i] = 2;
				count[2]--;
			}
		}

		return arr;
	};

	optimal: SolutionImplementation<Input, Output> = ({ arr }) => {
		let zeroPtr = -1,
			twoPtr = arr.length;
		for (let i = 0; i < twoPtr; ) {
			if (i === zeroPtr || arr[i] === 1) {
				i++;
			} else if (arr[i] === 0) {
				// swap ith index with (zeroPtr + 1)
				swap(arr, zeroPtr + 1, i);
				zeroPtr++;
			} else if (arr[i] === 2) {
				swap(arr, twoPtr - 1, i);
				twoPtr--;
			}
		}

		return arr;
	};

	striverOptimal: SolutionImplementation<Input, Output> = ({ arr }) => {
		let low = 0,
			high = arr.length - 1;
		// from 0 to low (not including low) every element is 0, while from (height
		// - arr.length) every element is 2. So only unsorted elements are from
		// mid to height
		for (let mid = 0; mid <= high; ) {
			if (arr[mid] === 1) {
				mid++;
			} else if (arr[mid] === 0) {
				swap(arr, low, mid);
				low++;
				mid++;
			} else if (arr[mid] === 2) {
				swap(arr, high, mid);
				high--;
			}
		}
		return arr;
	};
}

new ManualTesting().test(new SortArrayOf0s1s2s());
