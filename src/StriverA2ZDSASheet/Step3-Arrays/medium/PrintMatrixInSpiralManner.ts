/*
	Problem Link: https://leetcode.com/problems/spiral-matrix/
	Solution Link: https://takeuforward.org/data-structure/spiral-traversal-of-matrix/
*/

type ProblemSolution = (matrix: readonly number[][]) => number[];

const brute: ProblemSolution = matrix => {
	const spiral: number[] = [];
	// first row
	for (let i = 0; i < matrix[0].length; i++) {
		spiral.push(matrix[0][i]);
	}

	// last col
	for (let i = 0; i < matrix.length; i++) {
		spiral.push(matrix[i][matrix.length - 1]);
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

(() => {
	const solutions = [brute] as const;
	const testCases: number[][][] = [
		[
			[1, 2, 3],
			[8, 9, 4],
			[7, 6, 5],
		],
		[
			[0, 1, 2, 0],
			[3, 4, 5, 2],
			[1, 3, 1, 5],
		],
	];

	for (const sol of solutions) {
		console.log(`Running solution ${sol.name}:`);
		for (const test of testCases) {
			console.log(sol(test));
			console.log();
		}
	}
})();
