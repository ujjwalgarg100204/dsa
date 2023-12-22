import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";

type Input = { arr: number[] };
type Output = number[];

class RearrangeElementsBySignSolution implements Solution<Input, Output> {
	getName(): string {
		return "Rearrange Elements By Sign";
	}
	getProblemLink(): string {
		return "https://leetcode.com/problems/rearrange-array-elements-by-sign/description";
	}
	getImplementations(): SolutionImplementation<Input, Output>[] {
		return [this.brute, this.better, this.optimal];
	}
	getTestCases(): TestCase<Input, Output>[] {
		return [
			{
				input: { arr: [3, 1, -2, -5, 2, -4] },
				expected: [3, -2, 1, -5, 2, -4],
			},
			{
				input: { arr: [-1, 1] },
				expected: [1, -1],
			},
		];
	}

	brute: SolutionImplementation<Input, Output> = ({ arr }) => {
		const positives: number[] = [];
		const negatives: number[] = [];

		// divide array into positives & negatives
		for (const i of arr) {
			if (i >= 0) {
				positives.push(i);
			} else {
				negatives.push(i);
			}
		}

		// merge arrays
		let i = 0;
		for (let j = 0, k = 0; i < arr.length; i++) {
			if ((i & 1) === 0) {
				arr[i] = positives[j];
				j++;
			} else {
				arr[i] = negatives[k];
				k++;
			}
		}

		return arr;
	};

	better: SolutionImplementation<Input, Output> = ({ arr }) => {
		const newArr = [] as number[];
		let pos = 0,
			neg = 0;

		// find first +ve & -ve element
		while (arr[pos] < 0) {
			pos++;
		}
		while (arr[neg] >= 0) {
			neg++;
		}

		while (pos < arr.length && neg < arr.length) {
			// add positive element
			newArr.push(arr[pos]);
			pos++;
			// find next positive element
			while (arr[pos] < 0) {
				pos++;
			}

			// add negative element
			newArr.push(arr[neg]);
			neg++;
			// find next -ve element
			while (arr[neg] >= 0) {
				neg++;
			}
		}
		// add remaining elements to array
		while (pos < arr.length) {
			newArr.push(arr[pos]);
			pos++;
		}
		while (neg < arr.length) {
			newArr.push(arr[neg]);
			neg++;
		}

		return newArr;
	};

	optimal: SolutionImplementation<Input, Output> = ({ arr }) => {
		const newArr = Array<number>(arr.length).fill(0);

		for (let pos = 0, neg = 1, i = 0; i < arr.length; i++) {
			if (arr[i] > 0) {
				newArr[pos] = arr[i];
				pos += 2;
			} else {
				newArr[neg] = arr[i];
				neg += 2;
			}
		}

		return newArr;
	};
}

new ManualTesting().test(new RearrangeElementsBySignSolution());
