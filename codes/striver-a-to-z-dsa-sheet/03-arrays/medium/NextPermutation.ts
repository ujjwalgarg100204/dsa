import { Solution, SolutionImplementation, TestCase } from "@/types";
import { quickSort, reverseArr, swap } from "@utils/array";

import ManualTesting from "@testing/ManualTesting";

type Input = { arr: number[] };
type Output = number[];

class NextPermutationSolution implements Solution<Input, Output> {
	getName(): string {
		return "Next Permutation";
	}
	getProblemLink(): string {
		return "https://leetcode.com/problems/next-permutation/description/";
	}
	getImplementations(): SolutionImplementation<Input, Output>[] {
		return [this.optimal];
	}
	getTestCases(): TestCase<Input, Output>[] {
		return [
			{ input: { arr: [1, 2, 3] }, expected: [1, 3, 2] },
			{ input: { arr: [3, 2, 1] }, expected: [1, 2, 3] },
			{ input: { arr: [1, 1, 5] }, expected: [1, 5, 1] },
			{ input: { arr: [3, 2, 1] }, expected: [1, 2, 3] },
			{ input: { arr: [1, 3, 2] }, expected: [2, 1, 3] },
		];
	}

	optimal: SolutionImplementation<Input, Output> = ({ arr }) => {
		// find last pivot point
		let pivotIndex = -1;
		for (let i = 0; i < arr.length - 1; i++) {
			if (arr[i] < arr[i + 1]) {
				pivotIndex = i;
			}
		}

		// if no pivot found, means array is in descending order
		if (pivotIndex === -1) {
			reverseArr(arr, 0, arr.length - 1);
			return arr;
		}

		// find the minimum num right side of pivot which is > arr[i]
		let minIndex = pivotIndex + 1;
		for (let i = minIndex; i < arr.length; i++) {
			if (arr[i] > arr[pivotIndex] && arr[i] < arr[minIndex]) {
				minIndex = i;
			}
		}
		swap(arr, pivotIndex, minIndex);

		// sort the rest of the array
		quickSort(arr, pivotIndex + 1, arr.length - 1);
		return arr;
	};
}

new ManualTesting().test(new NextPermutationSolution());
