/*
	Problem Link: https://leetcode.com/problems/longest-consecutive-sequence/description
*/
import { inputLeetCodeArr } from "../../../utils/input";

type ProblemSolution = (arr: number[]) => number;

const brute: ProblemSolution = arr => {
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

const optimized: ProblemSolution = arr => {
	// sort the array
	arr.sort();

	let longestSubSeq = 1;
	let lastElem = arr[0],
		currSubSeq = 1;
	for (let i = 1; i < arr.length; i++) {
		if (lastElem == arr[i]) continue;

		const diff = arr[i] - lastElem;
		if (diff == 1) currSubSeq++;
		else {
			longestSubSeq = Math.max(longestSubSeq, currSubSeq);
			currSubSeq = 1;
		}

		lastElem = arr[i];
	}

	return longestSubSeq;
};

const optimal: ProblemSolution = arr => {
	if (arr.length === 0) return 0;

	const set = new Set(arr);
	let longestSubSeq = 1;

	for (let i of set)
		if (!set.has(i - 1)) {
			let currSubSeq = 1;
			while (set.has(i + 1)) {
				i++;
				currSubSeq++;
			}
			longestSubSeq = Math.max(longestSubSeq, currSubSeq);
		}

	return longestSubSeq;
};

(() => {
	console.log(optimal([100, 4, 200, 1, 3, 2]));
	process.exit();
})();
