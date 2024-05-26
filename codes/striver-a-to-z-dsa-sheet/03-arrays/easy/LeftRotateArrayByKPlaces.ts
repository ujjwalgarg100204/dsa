import { Solution, SolutionImplementation, TestCase } from "@/types";
import { cloneArr, reverseArr } from "@utils/array";

import ManualTesting from "@testing/ManualTesting";

type Input = { arr: number[]; k: number };
type Output = number[];

class LeftRotateArrayByKPlaces implements Solution<Input, Output> {
	getName(): string {
		return "Left Rotate Array by K Places";
	}
	getProblemLink(): string {
		return "https://leetcode.com/problems/rotate-array/description";
	}
	getImplementations(): ((input: Input) => Output)[] {
		return [this.brute, this.optimal];
	}
	getTestCases(): TestCase<Input, Output>[] {
		return [
			{
				input: { arr: [1, 2, 3, 4, 5, 6, 7], k: 3 },
				expected: [5, 6, 7, 1, 2, 3, 4],
			},
			{
				input: {
					arr: [-1, -100, 3, 99],
					k: 2,
				},
				expected: [3, 99, -1, -100],
			},
			{
				input: { arr: [1, 2, 3, 4, 5, 6, 7], k: 7 },
				expected: [1, 2, 3, 4, 5, 6, 7],
			},
		];
	}

	brute: SolutionImplementation<Input, Output> = ({ arr, k }) => {
		k = k % arr.length;

		// create a new array
		const rotatedArr = cloneArr(arr);

		let i = 0;
		// copy k elements from the right side of the arr to the beginning of the
		// rotated arr
		for (let j = arr.length - k; j < arr.length; j++) {
			rotatedArr[i] = arr[j];
			i++;
		}

		// copy the rest of the elements from arr to rotated arr
		for (let j = 0; j < arr.length - k; j++) {
			rotatedArr[i] = arr[j];
			i++;
		}

		// copy the new rotated arr to original arr
		for (let j = 0; j < arr.length; j++) {
			arr[j] = rotatedArr[j];
		}

		return arr;
	};

	optimal: SolutionImplementation<Input, Output> = ({ arr, k }) => {
		k = k % arr.length;
		// reverse the array from indices 0 to arr.length - k
		reverseArr(arr, 0, arr.length - k - 1);
		// reverse the array from indices arr.length - k to arr.length
		reverseArr(arr, arr.length - k, arr.length - 1);
		// reverse the entire array
		reverseArr(arr, 0, arr.length - 1);

		return arr;
	};
}

new ManualTesting().test(new LeftRotateArrayByKPlaces());
