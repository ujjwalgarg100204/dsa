import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";

type Input = number[];
type Output = number[];

class MajorityElementIISolution implements Solution<Input, Output> {
	getName(): string {
		return "Majority Element II";
	}
	getProblemLink(): string {
		return "https://leetcode.com/problems/majority-element-ii/description";
	}
	getImplementations(): SolutionImplementation<Input, Output>[] {
		return [this.brute, this.better, this.betterThanBetter, this.optimal];
	}
	getTestCases(): TestCase<Input, Output>[] {
		return [
			{
				input: [3, 2, 3],
				expected: [3],
			},
			{ input: [1], expected: [1] },
			{ input: [1, 2], expected: [1, 2] },
			{ input: [2, 2], expected: [2] },
			{ input: [3, 3, 4], expected: [3] },
			{ input: [2, 2, 1, 3], expected: [2] },
		];
	}
	brute: SolutionImplementation<Input, Output> = arr => {
		const majorityElements: number[] = [];
		for (const i of arr) {
			if (majorityElements.indexOf(i) !== -1) {
				continue;
			}

			// find count of current element
			let count = 0;
			for (const j of arr) {
				if (j === i) {
					count++;
				}
			}
			if (count > arr.length / 3) {
				majorityElements.push(i);
			}
		}

		return majorityElements;
	};
	better: SolutionImplementation<Input, Output> = arr => {
		const majorityElements: number[] = [];
		const countMap = new Map<number, number>();
		// hash all counts
		for (const i of arr) {
			if (countMap.has(i)) {
				countMap.set(i, countMap.get(i)! + 1);
			} else {
				countMap.set(i, 1);
			}
		}
		// iterate over map to check all counts
		for (const [i, count] of countMap.entries()) {
			if (count > arr.length / 3) {
				majorityElements.push(i);
			}
		}

		return majorityElements;
	};

	betterThanBetter: SolutionImplementation<Input, Output> = arr => {
		const n = Math.floor(arr.length / 3);
		const majorityElements: number[] = [];
		const countMap = new Map<number, number>();

		for (const i of arr) {
			// if map doesn't have i, set it to 0, below code will increment it
			// to 1 accordingly
			if (!countMap.has(i)) {
				countMap.set(i, 0);
			}

			// map has the value
			const prevCount = countMap.get(i)!;
			// avoid additional iteration of map, by checking it right here
			if (prevCount + 1 > n) {
				majorityElements.push(i);
				// set the number to min_val, so that each increment will never amount
				// to n / 3
				countMap.set(i, Number.MIN_SAFE_INTEGER);
			} else {
				countMap.set(i, prevCount + 1);
			}
		}

		return majorityElements;
	};
	optimal: SolutionImplementation<Input, Output> = arr => {
		let firstMajorityElem = NaN,
			secMajorityElem = NaN,
			firstMajorityElemCount = 0,
			secMajorityElemCount = 0;

		for (const i of arr) {
			if (firstMajorityElemCount === 0 && secMajorityElem !== i) {
				firstMajorityElem = i;
				firstMajorityElemCount = 1;
			} else if (secMajorityElemCount === 0 && firstMajorityElem !== i) {
				secMajorityElem = i;
				secMajorityElemCount = 1;
			} else if (firstMajorityElem === i) {
				firstMajorityElemCount++;
			} else if (secMajorityElem === i) {
				secMajorityElemCount++;
			} else {
				secMajorityElemCount--;
				firstMajorityElemCount--;
			}
		}

		const majorityElements: number[] = [];
		// check count of both elements
		firstMajorityElemCount = 0;
		secMajorityElemCount = 0;
		for (const i of arr) {
			if (i === firstMajorityElem) {
				firstMajorityElemCount++;
			}
			if (i === secMajorityElem) {
				secMajorityElemCount++;
			}
		}

		const n = Math.floor(arr.length / 3);
		if (firstMajorityElemCount > n) {
			majorityElements.push(firstMajorityElem);
		}
		if (secMajorityElemCount > n) {
			majorityElements.push(secMajorityElem);
		}

		return majorityElements;
	};
}

new ManualTesting().test(new MajorityElementIISolution());
