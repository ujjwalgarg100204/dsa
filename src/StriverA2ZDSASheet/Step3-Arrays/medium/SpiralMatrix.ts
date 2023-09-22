/*
	Problem Link: https://leetcode.com/problems/spiral-matrix/
*/

type TProblem = (matrix: number[][]) => number[];

const optimal: TProblem = matrix => {
	const ans: ReturnType<TProblem> = [];

	let top = 0,
		left = 0,
		right = matrix[0].length - 1,
		bottom = matrix.length - 1;

	while (top <= bottom && left <= right) {
		// top row
		for (let i = left; i <= right; i++) ans.push(matrix[top][i]);
		top++;
		// right row
		for (let i = top; i <= bottom; i++) ans.push(matrix[i][right]);
		right--;

		if (top <= bottom) {
			// bottom row
			for (let i = right; i >= left; i--) ans.push(matrix[bottom][i]);
			bottom--;
		}
		if (left <= right) {
			// left row
			for (let i = bottom; i >= top; i--) ans.push(matrix[i][left]);
			left++;
		}
	}
	return ans;
};

export const testCases: [Parameters<TProblem>[0], ReturnType<TProblem>][] = [
	[
		[
			[1, 2, 3],
			[4, 5, 6],
			[7, 8, 9],
		],
		[1, 2, 3, 6, 9, 8, 7, 4, 5],
	],
	[
		[
			[1, 2, 3, 4],
			[5, 6, 7, 8],
			[9, 10, 11, 12],
		],
		[1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7],
	],
];

export const solutions: TProblem[] = [optimal];
