import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@/ManualTesting";

type Input = { arr: number[]; k: number };
class SubArraySumEqualsKSolution implements Solution<Input, number> {
	getName(): string {
		return "Sub Array Sum Equals K";
	}
	getProblemLink(): string {
		return "https://leetcode.com/problems/subarray-sum-equals-k";
	}
	getImplementations(): ((input: Input) => number)[] {
		return [this.brute, this.optimal];
	}
	getTestCases(): TestCase<Input, number>[] {
		return [
			{ input: { arr: [1, 1, 1], k: 2 }, expected: 2 },
			{ input: { arr: [1, 2, 3], k: 3 }, expected: 2 },
			{
				input: { arr: [1, 2, 3, -3, 1, 1, 1, 4, 2, -2], k: 3 },
				expected: 8,
			},
		];
	}

	brute: SolutionImplementation<Input, number> = ({ arr, k }) => {
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

	optimal: SolutionImplementation<Input, number> = ({ arr, k }) => {
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
}

new ManualTesting().test(new SubArraySumEqualsKSolution());
