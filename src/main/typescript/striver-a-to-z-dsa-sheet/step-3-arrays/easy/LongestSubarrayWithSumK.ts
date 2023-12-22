import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";

type Input = { arr: number[]; k: number };
type Output = number;

class LongestSubarrayWithSumPositiveOnly implements Solution<Input, Output> {
	getName(): string {
		return "Longest Subarray with Sum K (+ve only)";
	}
	getProblemLink(): string {
		return "https://www.codingninjas.com/studio/problems/longest-subarray-with-sum-k_6682399";
	}
	getImplementations(): ((input: Input) => Output)[] {
		return [this.brute, this.optimized, this.optimal];
	}
	getTestCases(): TestCase<Input, Output>[] {
		return [
			{
				input: {
					arr: [1, 2, 3, 1, 1, 1, 1],
					k: 3,
				},
				expected: 3,
			},
			{ input: { arr: [1, 2, 1, 3], k: 2 }, expected: 1 },
			{ input: { arr: [2, 2, 4, 1, 2], k: 2 }, expected: 1 },
			{ input: { arr: [0, 0, 0, 0, 0, 1], k: 1 }, expected: 6 },
		];
	}
	brute: SolutionImplementation<Input, Output> = ({ arr, k }) => {
		let longestSubarrayLength = 0;
		// check all subarray
		for (let i = 0; i < arr.length; i++) {
			let sum = 0;
			for (let j = i; j < arr.length; j++) {
				sum += arr[j];
				// check sum of all subarray
				if (sum === k) {
					longestSubarrayLength = Math.max(
						longestSubarrayLength,
						j - i + 1
					);
				}
			}
		}
		return longestSubarrayLength;
	};

	optimized: SolutionImplementation<Input, Output> = ({ arr, k }) => {
		const prefixSumMap = new Map<number, number>();
		let longestSubarrayLength = 0,
			sum = 0;
		for (let i = 0; i < arr.length; i++) {
			sum += arr[i];

			// if current sum is equal to k, then update longestSubArrayLength
			if (sum === k) {
				longestSubarrayLength = Math.max(longestSubarrayLength, i + 1);
			}

			// check if sum - 3 exists in the map
			if (prefixSumMap.has(sum - k)) {
				// get the index, at which that sum occurred
				const index = prefixSumMap.get(sum - k)!;
				longestSubarrayLength = Math.max(
					longestSubarrayLength,
					i - index // both are index, so need to add 1
				);
			}

			// save the current sum to hashmap, sum as key & index as val
			if (!prefixSumMap.has(sum - k)) {
				// don't overwrite, previous value of sum with current index
				prefixSumMap.set(sum, i);
			}
		}

		return longestSubarrayLength;
	};

	// works only with positive
	optimal: SolutionImplementation<Input, Output> = ({ arr, k }) => {
		let longestSubarrayLength = 0;

		let currSum = 0;
		for (let left = 0, right = 0; right < arr.length; right++) {
			currSum += arr[right];
			// currSum exceeds k, bring the left pointer forward
			while (currSum > k) {
				currSum -= arr[left];
				left++;
			}
			// if currSum is equal to k, then update the longest subarray length
			if (currSum === k) {
				longestSubarrayLength = Math.max(
					longestSubarrayLength,
					right - left + 1
				);
			}
		}

		return longestSubarrayLength;
	};
}

new ManualTesting().test(new LongestSubarrayWithSumPositiveOnly());
