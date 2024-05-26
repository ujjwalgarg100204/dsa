import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";

type Input = { arr: number[] };
type Output = number[];

class RemoveDuplicatesFromSortedArray implements Solution<Input, Output> {
	getName(): string {
		return "Remove Duplicates From Sorted Array";
	}
	getProblemLink(): string {
		return "https://leetcode.com/problems/remove-duplicates-from-sorted-array/description";
	}
	getImplementations(): ((input: Input) => Output)[] {
		return [this.brute, this.myOptimal, this.conciseOptimal];
	}
	getTestCases(): TestCase<Input, Output>[] {
		return [
			{ input: { arr: [1, 1, 2] }, expected: [1, 2] },
			{
				input: { arr: [0, 0, 1, 1, 1, 2, 2, 3, 3, 4] },
				expected: [0, 1, 2, 3, 4],
			},
			{ input: { arr: [1, 2, 3, 4] }, expected: [1, 2, 3, 4] },
			{
				input: { arr: [0, 1, 2, 3, 3, 4, 5] },
				expected: [0, 1, 2, 3, 4, 5],
			},
			{ input: { arr: [1, 1] }, expected: [1] },
		];
	}

	brute: SolutionImplementation<Input, Output> = ({ arr }) => {
		// put the whole array into HashMap
		const set = new Set<number>(arr);
		// rewrite the array
		let i = 0;
		for (const val of set) {
			arr[i] = val;
			i++;
		}
		return arr.slice(0, i);
	};

	myOptimal: SolutionImplementation<Input, Output> = ({ arr }) => {
		let lastVal = arr[0],
			lastSwappedIndex = 0;

		for (let i = 1; i < arr.length; ) {
			while (arr[i] === lastVal) {
				i++;
				if (i === arr.length) break;
			}
			// if array is completely iterated, then break out
			if (i === arr.length) break;

			// update lastVal
			lastVal = arr[i];
			// swap arr[i] with lastSwappedIndex + 1
			[arr[lastSwappedIndex + 1], arr[i]] = [
				arr[i],
				arr[lastSwappedIndex + 1],
			];
			// update lastSwappedIndex
			lastSwappedIndex++;
			i++;
		}

		return arr.slice(0, lastSwappedIndex + 1);
	};

	conciseOptimal: SolutionImplementation<Input, Output> = ({ arr }) => {
		let i = 0;
		for (let j = 1; j < arr.length; j++) {
			if (arr[j] === arr[i]) {
				continue;
			}

			// now arr[i] and arr[j] are different values
			arr[i + 1] = arr[j];
			i++;
		}

		return arr.slice(0, i + 1);
	};
}

new ManualTesting().test(new RemoveDuplicatesFromSortedArray());
