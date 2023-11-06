/*
	Problem Link: https://leetcode.com/problems/subarray-sum-equals-k/description/
*/

import { TestCase } from "@/types";
import { judgeProblem } from "@/utils";

type TProblem = (arr: number[], k: number) => number;

const brute: TProblem = (arr, k) => {
	let ans = 0;
	for (let i = 0; i < arr.length; i++) {
		let sum = 0;
		for (let j = i; j < arr.length; j++) {
			sum += arr[j];
			if (sum === k) ans++;
		}
	}

	return ans;
};

const optimal: TProblem = (arr, k) => {
	let ans = 0;
	const prefixSumMap = new Map<number, number>();
	// populate the map
	let sum = 0;
	for (let i = 0; i < arr.length; i++) {
		sum += i;
		prefixSumMap.set(sum, i);

		if (prefixSumMap.has(sum - k)) {
			ans += 2;
		}
	}

	return ans;
};

export const solutions: TProblem[] = [brute, optimal];
export const testCases: TestCase<TProblem>[] = [
	[[[1, 1, 1], 2], 2],
	[[[1, 2, 3], 3], 2],
	[[[1, 2, 3, -3, 1, 1, 1, 4, 2, -2], 3], 8],
];

judgeProblem(solutions, testCases, import.meta.file);
