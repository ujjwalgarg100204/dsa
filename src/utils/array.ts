import { getDigits } from "./math";

export const cloneMatrix = <T>(matrix: T[][]): T[][] => {
	const copy: T[][] = [];
	for (const arr of matrix) copy.push([...arr]);
	return copy;
};

export const print2DMatrix = (matrix: any[][]): void => {
	if (typeof matrix[0][0] === "number") {
		const maxDigits = getDigits(
			max(matrix.map(arr => max(arr))).toString()
		).length;
		matrix = matrix.map(arr =>
			arr.map(num => num.toString().padStart(maxDigits, " "))
		);
	}
	for (let i = 0; i < matrix.length; i++) {
		for (let j = 0; j < matrix[i].length; j++)
			console.write(matrix[i][j] + " ");
		console.write("\n");
	}
};

export const swap = (arr: any[], first: number, sec: number): void => {
	const temp = arr[first];
	arr[first] = arr[sec];
	arr[sec] = temp;
};

export const max = (arr: number[]): number => {
	let max = Number.MIN_SAFE_INTEGER;
	for (const i of arr) max = Math.max(max, i);
	return max;
};
