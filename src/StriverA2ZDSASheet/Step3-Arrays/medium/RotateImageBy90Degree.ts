import { cloneMatrix, print2DMatrix } from "@utils/array";

/* 
	Problem Link: https://leetcode.com/problems/rotate-image/
	Solution Link: https://takeuforward.org/data-structure/rotate-image-by-90-degree/
*/

type ProblemSolution = (matrix: number[][]) => void;

const brute: ProblemSolution = matrix => {
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

const optimal: ProblemSolution = matrix => {
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

const optimal2: ProblemSolution = matrix => {
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

(() => {
	const testCases = [
		[
			[1, 2, 3],
			[4, 5, 6],
			[7, 8, 9],
		],
		[
			[5, 1, 9, 11],
			[2, 4, 8, 10],
			[13, 3, 6, 7],
			[15, 14, 12, 16],
		],
	];

	const solutions = [brute, optimal, optimal2] as const;

	for (const solution of solutions) {
		console.log(`Running solution ${solution.name}:`);
		for (const testCase of testCases) {
			const clone = cloneMatrix(testCase);
			solution(clone);
			print2DMatrix(clone);
			console.log();
		}
	}
})();
