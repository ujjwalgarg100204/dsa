/*	
	Problem Link: https://leetcode.com/problems/climbing-stairs/
*/

import { TestCase } from "@/types";
import { judgeProblem } from "@/utils";
import { factorial } from "@utils/math";

type TProblem = (stairs: number) => number;

const brute: TProblem = stairs => {
	let ways = 0;

	for (let noOf2s = 0; noOf2s * 2 <= stairs; noOf2s++) {
		const noOf1s = stairs - noOf2s * 2;
		ways +=
			factorial(noOf2s + noOf1s) /
			(factorial(noOf2s) * factorial(noOf1s));
	}
	return ways;
};

const optimal: TProblem = stairs => {
	if (stairs == 1) return 1;

	// fibonacci seq
	let first = 1,
		sec = 2,
		sum = 0;
	for (; stairs > 2; stairs--) {
		sum = first + sec;
		first = sec;
		sec = sum;
	}

	return sec;
};

const solutions = [brute, optimal];
const testCases: TestCase<TProblem>[] = [
	[[2], 4],
	[[3], 3],
	[[4], 5],
];

judgeProblem(solutions, testCases, import.meta.file);
