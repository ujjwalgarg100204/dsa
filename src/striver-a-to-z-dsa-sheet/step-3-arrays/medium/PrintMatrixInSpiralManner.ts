/*
	Problem Link: https://leetcode.com/problems/spiral-matrix/
	Solution Link: https://takeuforward.org/data-structure/spiral-traversal-of-matrix/
*/

import { TestCase } from "@/types";
import { judgeProblem } from "@/utils";

type TProblem = (matrix: readonly number[][]) => number[];

const brute: TProblem = matrix => {
	const spiral: number[] = [];
	// first row
	for (const element of matrix[0]) {
		spiral.push(element);
	}

	// last col
	for (const element of matrix) {
		spiral.push(element[matrix.length - 1]);
	}

	// last row
	for (let i = matrix[0].length - 1; i >= 0; i--) {
		spiral.push(matrix[matrix.length - 1][i]);
	}

	// left col
	for (let i = matrix.length - 1; i > 0; i--) {
		spiral.push(matrix[i][0]);
	}

	return spiral;
};

const solutions = [brute];
const testCases: TestCase<TProblem>[] = [
	[
		[
			[
				[1, 2, 3],
				[8, 9, 4],
				[7, 6, 5],
			],
		],
		[1, 2, 3, 4, 5, 6, 7, 8, 9],
	],
	[
		[
			[
				[0, 1, 2, 0],
				[3, 4, 5, 2],
				[1, 3, 1, 5],
			],
		],
		[0, 1, 2, 0, 2, 5, 1, 3, 1, 3, 4, 5],
	],
];

judgeProblem(solutions, testCases, import.meta.file);
