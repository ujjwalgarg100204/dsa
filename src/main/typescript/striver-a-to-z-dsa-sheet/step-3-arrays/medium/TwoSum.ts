import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";

type Input = { arr: number[]; k: number };
class TwoSumSolution implements Solution<Input, "YES" | "NO"> {
	getName(): string {
		return "Two Sum";
	}
	getProblemLink(): string {
		return "https://leetcode.com/problems/two-sum/";
	}
	getImplementations(): ((input: Input) => "YES" | "NO")[] {
		return [this.brute, this.optimal, this.optimalWithMem];
	}
	getTestCases(): TestCase<Input, "YES" | "NO">[] {
		return [
			{ input: { arr: [2, 7, 11, 15], k: 9 }, expected: "YES" },
			{ input: { arr: [2, 7, 11, 15], k: 10 }, expected: "NO" },
			{ input: { arr: [2, 7, 11, 15], k: 17 }, expected: "YES" },
			{ input: { arr: [2, 7, 11, 15], k: 18 }, expected: "YES" },
			{ input: { arr: [2, 7, 11, 15], k: 26 }, expected: "YES" },
			{ input: { arr: [2, 7, 11, 15], k: 27 }, expected: "NO" },
			{ input: { arr: [2, 7, 11, 15], k: 13 }, expected: "YES" },
			{ input: { arr: [2, 7, 11, 15], k: 14 }, expected: "NO" },
			{ input: { arr: [2, 7, 11, 15], k: 22 }, expected: "YES" },
		];
	}

	brute: SolutionImplementation<Input, "YES" | "NO"> = ({ arr, k }) => {
		for (let i = 0; i < arr.length; i++)
			for (let j = i + 1; j < arr.length; j++)
				if (arr[i] + arr[j] == k) return "YES";
		return "NO";
	};

	optimal: SolutionImplementation<Input, "YES" | "NO"> = ({ arr, k }) => {
		arr.sort((a, b) => a - b);

		let left = 0,
			right = arr.length - 1;
		while (left < right) {
			const sum = arr[left] + arr[right];
			if (sum === k) return "YES";
			else if (sum < k) left++;
			else right--;
		}
		return "NO";
	};

	optimalWithMem: SolutionImplementation<Input, "YES" | "NO"> = ({
		arr,
		k,
	}) => {
		const set = new Set<number>(arr);

		for (const i of arr) {
			if (set.has(k - i)) {
				return "YES";
			}
		}
		return "NO";
	};
}

new ManualTesting().test(new TwoSumSolution());
