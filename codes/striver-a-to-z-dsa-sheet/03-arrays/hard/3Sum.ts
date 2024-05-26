import { Solution, SolutionImplementation, TestCase } from "@/types.ts";

import ManualTesting from "@testing/ManualTesting.ts";

type Input = number[];
type Output = number[][];

const existsInArr = (arr: number[][], elem: number[]) => {
	for (const [a, b, c] of arr) {
		if (a === elem[0] && b === elem[1] && c === elem[2]) {
			return true;
		}
	}
	return false;
};

class ThreeSumSolution implements Solution<Input, Output> {
	getName(): string {
		return "3 Sum";
	}
	getProblemLink(): string {
		return "https://leetcode.com/problems/3sum/description/";
	}
	getImplementations(): SolutionImplementation<Input, Output>[] {
		return [this.brute, this.better];
	}
	getTestCases(): TestCase<Input, Output>[] {
		return [
			{
				input: [-1, 0, 1, 2, -1, -4],
				expected: [
					[-1, -1, 2],
					[-1, 0, 1],
				],
			},
			{
				input: [0, 1, 1],
				expected: [],
			},
			{
				input: [-1, 0, 1, 0],
				expected: [[-1, 0, 1]],
			},
		];
	}

	// it works just results are out of order
	brute: SolutionImplementation<Input, Output> = arr => {
		const threeSum: number[][] = [];

		for (let i = 0; i < arr.length; i++) {
			for (let j = i + 1; j < arr.length; j++) {
				for (let k = j + 1; k < arr.length; k++) {
					const sum = [arr[i], arr[j], arr[k]];

					if (sum.reduce((p, c) => p + c, 0) === 0) {
						sum.sort((a, b) => a - b);
						// check if sum already exists in arr
						if (!existsInArr(threeSum, sum)) {
							threeSum.push(sum);
						}
					}
				}
			}
		}

		return threeSum;
	};

	// Intuition: fix first number and find rest two numbers using TwoSum problem
	// solution
	better: SolutionImplementation<Input, Output> = arr => {
		const threeSum: number[][] = [];
		const map = new Map<number, number>();
		// put element: count in map
		for (const i of arr) {
			if (map.has(i)) {
				map.set(i, map.get(i)! + 1);
			} else {
				map.set(i, 1);
			}
		}

		for (let i = 0; i < arr.length; i++) {
			// set arr[i] as first digit, and now find two other numbers which sums
			// to  -arr[i]
			const reqSum = -1 * arr[i];
			// decrement count of arr[i] in map, because can't use arr[i] again
			map.set(arr[i], map.get(arr[i])! - 1);

			// find rest of two numbers
			for (let j = 0; j < arr.length; j++) {
				if (i === j) {
					continue;
				}

				// decrement count of arr[j] in map, because can't use arr[j] again
				map.set(arr[j], map.get(arr[j])! - 1);

				const thirdNum = reqSum - arr[j];
				// if third num exists and its count is > 0
				if (map.has(thirdNum) && map.get(thirdNum)! > 0) {
					const sum = [arr[i], arr[j], thirdNum];
					sum.sort((a, b) => a - b);

					if (!existsInArr(threeSum, sum)) {
						threeSum.push(sum);
					}
				}

				// re-increment arr[j] in map
				map.set(arr[j], map.get(arr[j])! + 1);
			}

			// re-increment arr[i] in map
			map.set(arr[i], map.get(arr[i])! + 1);
		}

		return threeSum;
	};
}

new ManualTesting().test(new ThreeSumSolution());
