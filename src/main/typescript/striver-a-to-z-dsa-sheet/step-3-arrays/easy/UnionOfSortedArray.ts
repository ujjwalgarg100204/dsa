import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";

type Input = { arr1: number[]; arr2: number[] };
type Output = number[];

class UnionOfSortedArrays implements Solution<Input, Output> {
	getName(): string {
		return "Union of Sorted Arrays";
	}
	getProblemLink(): string {
		return "https://www.codingninjas.com/studio/problems/sorted-array_6613259";
	}
	getImplementations(): ((input: Input) => Output)[] {
		return [this.optimal];
	}
	getTestCases(): TestCase<Input, Output>[] {
		return [
			{
				input: {
					arr1: [1, 2, 3, 4, 6],
					arr2: [2, 3, 5],
				},
				expected: [1, 2, 3, 4, 5, 6],
			},
			{
				input: {
					arr1: [1, 2, 3, 3],
					arr2: [2, 2, 4],
				},
				expected: [1, 2, 3, 4],
			},
		];
	}

	optimal: SolutionImplementation<Input, Output> = ({ arr1, arr2 }) => {
		const newArr: number[] = [];
		let i = 0,
			j = 0;

		// iterate till one of the array is completed
		while (i < arr1.length && j < arr2.length) {
			// if arr1 contains duplicate, remove them
			if (arr1[i] === newArr.at(-1)) {
				i++;
			} else if (arr2[j] === newArr.at(-1)) {
				// remove duplicates from arr2
				j++;
			} else if (arr1[i] < arr2[j]) {
				newArr.push(arr1[i]);
				i++;
			} else {
				newArr.push(arr2[j]);
				j++;
			}
		}

		// iterate over the left over elements of arr1
		while (i < arr1.length) {
			if (newArr.at(-1) === arr1[i]) {
				i++;
			} else {
				newArr.push(arr1[i]);
				i++;
			}
		}

		// iterate over the right over elements of arr2
		while (j < arr2.length) {
			if (newArr.at(-1) === arr2[j]) {
				j++;
			} else {
				newArr.push(arr2[j]);
				j++;
			}
		}

		return newArr;
	};
}

new ManualTesting().test(new UnionOfSortedArrays());
