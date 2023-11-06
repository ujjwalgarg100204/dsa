import { TestCase } from "@/types";
import { judgeProblem } from "@/utils";
import { cloneMatrix } from "@utils/array";

/* 
	Problem Link: https://leetcode.com/problems/rotate-image/
	Solution Link: https://takeuforward.org/data-structure/rotate-image-by-90-degree/
*/

type TProblem = (matrix: number[][]) => void;

const brute: TProblem = matrix => {
	const n = matrix.length;
	const clone = cloneMatrix(matrix);

	for (let iC = 0; iC < n; iC++) {
		let iA = 0,
			jA = n - 1 - iC;
		for (let jC = 0; jC < n; jC++) {
			matrix[iA++][jA] = clone[iC][jC];
		}
	}
};

const optimal: TProblem = matrix => {
	const n = matrix.length;

	// reverse the matrix
	matrix.reverse();

	// now take transpose of matrix
	for (let i = 0; i < n; i++) {
		for (let j = i; j < n; j++) {
			const temp = matrix[i][j];
			matrix[i][j] = matrix[j][i];
			matrix[j][i] = temp;
		}
	}
};

const optimal2: TProblem = matrix => {
	const n = matrix.length;

	// take transpose of the matrix
	for (let i = 0; i < n; i++) {
		for (let j = 0; j < n; j++) {
			if (i === j) break;
			const temp = matrix[i][j];
			matrix[i][j] = matrix[j][i];
			matrix[j][i] = temp;
		}
	}

	// reverse each array
	for (const arr of matrix) arr.reverse();
};

const solutions = [brute, optimal, optimal2];
const testCases: TestCase<TProblem>[] = [
	[
		[
			[
				[1, 2, 3],
				[4, 5, 6],
				[7, 8, 9],
			],
		],

		(() => {})(),
	],
];

judgeProblem(solutions, testCases, import.meta.file);
