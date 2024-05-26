import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";

type Input = { arr: number[]; k: number };

class CountSubArraysWithGivenSumSolution implements Solution<Input, number> {
	getName(): string {
		return "Count Sub-arrays with Given Sum";
	}
	getProblemLink(): string {
		return "https://leetcode.com/problems/subarray-sum-equals-k";
	}
	getImplementations(): SolutionImplementation<Input, number>[] {
		return [this.brute, this.optimal];
	}
	getTestCases(): TestCase<Input, number>[] {
		return [
			{ input: { arr: [1, 1, 1], k: 2 }, expected: 2 },
			{ input: { arr: [1, 2, 3], k: 3 }, expected: 2 },
			{ input: { arr: [1], k: 0 }, expected: 0 },
			{ input: { arr: [1], k: 1 }, expected: 1 },
			{
				input: { arr: [1, 2, 3, -3, 1, 1, 1, 4, 2, -3], k: 3 },
				expected: 8,
			},
		];
	}

	brute: SolutionImplementation<Input, number> = ({ arr, k }) => {
		let countSubArrays = 0;

		// generate all sub-arrays
		for (let i = 0; i < arr.length; i++) {
			let sum = 0;
			for (let j = i; j < arr.length; j++) {
				sum += arr[j];
				if (sum === k) {
					countSubArrays++;
				}
			}
		}
		return countSubArrays;
	};

	optimal: SolutionImplementation<Input, number> = ({ arr, k }) => {
		let count = 0;
		// stores prefixSum: count
		const prefixSumMap = new Map<number, number>([[0, 1]]);
		// populate the map
		let sum = 0;
		for (const i of arr) {
			sum += i;

			// check for some sub-array with sum k
			if (prefixSumMap.has(sum - k)) {
				count += prefixSumMap.get(sum - k)!;
			}

			// increment count of current sum if already present
			// otherwise put it in map
			if (prefixSumMap.has(sum)) {
				prefixSumMap.set(sum, prefixSumMap.get(sum)! + 1);
			} else {
				prefixSumMap.set(sum, 1);
			}
		}

		return count;
	};
}

new ManualTesting().test(new CountSubArraysWithGivenSumSolution());
