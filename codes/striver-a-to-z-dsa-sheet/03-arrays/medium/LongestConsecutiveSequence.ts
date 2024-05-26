import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";

type Input = { arr: number[] };

class LongestConsecutiveSequenceSolution implements Solution<Input, number> {
	getName(): string {
		return "Longest Consecutive Sequence";
	}
	getProblemLink(): string {
		return "https://leetcode.com/problems/longest-consecutive-sequence/description";
	}
	getImplementations(): ((input: Input) => number)[] {
		return [this.brute, this.optimized, this.optimal];
	}
	getTestCases(): TestCase<Input, number>[] {
		return [
			{ input: { arr: [100, 4, 200, 1, 3, 2] }, expected: 4 },
			{ input: { arr: [0, 3, 7, 2, 5, 8, 4, 6, 0, 1] }, expected: 9 },
		];
	}

	brute: SolutionImplementation<Input, number> = ({ arr }) => {
		if (arr.length === 0) return 0;

		let longestConsecutiveSeq = 1;
		for (const i of arr) {
			let currConsecutiveSeq = 1,
				element = i;
			while (arr.includes(element + 1)) {
				element++;
				currConsecutiveSeq++;
			}

			longestConsecutiveSeq = Math.max(
				currConsecutiveSeq,
				longestConsecutiveSeq
			);
		}

		return longestConsecutiveSeq;
	};

	optimized: SolutionImplementation<Input, number> = ({ arr }) => {
		// sort the array
		arr.sort((a, b) => a - b);

		let longestSubSeq = 1;
		let lastElem = arr[0],
			currSubSeq = 1;
		for (let i = 1; i < arr.length; i++) {
			if (lastElem === arr[i]) continue;

			const diff = arr[i] - lastElem;
			if (diff === 1) currSubSeq++;
			else {
				longestSubSeq = Math.max(longestSubSeq, currSubSeq);
				currSubSeq = 1;
			}
			lastElem = arr[i];
		}
		longestSubSeq = Math.max(longestSubSeq, currSubSeq);

		return longestSubSeq;
	};

	optimal: SolutionImplementation<Input, number> = ({ arr }) => {
		if (arr.length === 0) return 0;

		const set = new Set(arr);
		let longestSubSeq = 1;

		for (const i of set) {
			if (!set.has(i - 1)) {
				let currSubSeq = 1;
				let j = i;
				while (set.has(j + 1)) {
					j++;
					currSubSeq++;
				}
				longestSubSeq = Math.max(longestSubSeq, currSubSeq);
			}
		}

		return longestSubSeq;
	};
}

new ManualTesting().test(new LongestConsecutiveSequenceSolution());
