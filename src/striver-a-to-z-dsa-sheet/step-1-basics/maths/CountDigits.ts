/*	
	Problem Link: https://www.codingninjas.com/studio/problems/count-digits_8416387
*/
import { TestCase } from "@/types";
import { judgeProblem } from "@/utils";

type TProblem = (n: number) => number;

const optimal: TProblem = n => {
	let count = 0;
	const numCpy = n;
	while (n != 0) {
		const lastDig = n % 10;

		// divide by 0 check
		if (lastDig != 0) count = count + (numCpy % lastDig == 0 ? 1 : 0);
		n = Math.floor(n / 10);
	}

	return count;
};

const solutions = [optimal];
const testCases: TestCase<TProblem>[] = [
	[[35], 1],
	[[373], 0],
];

judgeProblem(solutions, testCases, import.meta.file);
