import { getDigits } from "./math";

/**
 * Creates a deep copy of a matrix.
 *
 * @template T The type of elements in the matrix.
 * @param matrix The matrix to be cloned.
 * @returns A new matrix that is a deep copy of the original matrix.
 */
export const cloneMatrix = <T>(matrix: T[][]): T[][] => {
	const copy: T[][] = new Array(matrix.length);
	for (let i = 0; i < matrix.length; i++) {
		copy[i] = cloneArr(matrix[i]);
	}
	return copy;
};

/**
 * Prints a 2D matrix.
 * If the matrix contains numbers, it will format them with equal spacing.
 * @param matrix - The matrix to be printed.
 */
export const print2DMatrix = (matrix: any[][]): void => {
	if (typeof matrix[0][0] === "number") {
		const maxDigits = getDigits(
			max(matrix.map(arr => max(arr))).toString()
		).length;
		matrix = matrix.map(arr =>
			arr.map(num => num.toString().padStart(maxDigits, " "))
		);
	}
	for (const row of matrix) {
		for (const i of row) {
			console.write(i + " ");
		}
		console.write("\n");
	}
};

/**
 * Swaps two elements in an array.
 * @param arr - The array in which the elements will be swapped.
 * @param first - The index of the first element to be swapped.
 * @param sec - The index of the second element to be swapped.
 */
export const swap = (arr: unknown[], first: number, sec: number): void => {
	const temp = arr[first];
	arr[first] = arr[sec];
	arr[sec] = temp;
};

/**
 * Finds the maximum value in an array of numbers.
 * @param arr - The array of numbers.
 * @returns The maximum value in the array.
 */
export const max = (arr: number[]): number => {
	let max = Number.MIN_SAFE_INTEGER;
	for (const i of arr) max = Math.max(max, i);
	return max;
};

/**
 * Creates a shallow clone of an array.
 *
 * @template T The type of elements in the array.
 * @param {T[]} arr The array to clone.
 * @returns {T[]} The cloned array.
 */
export const cloneArr = <T>(arr: T[]): T[] => {
	const clone: T[] = new Array(arr.length);
	for (let i = 0; i < arr.length; i++) {
		clone[i] = arr[i];
	}
	return clone;
};

/**
 * Reverses a portion of an array in-place.
 *
 * @param arr - The array to be reversed.
 * @param start - The starting index of the portion to be reversed.
 * @param end - The ending index of the portion to be reversed. (included)
 */
export const reverseArr = (arr: unknown[], start: number, end: number) => {
	for (let i = start, j = 0; i < (start + end) / 2; i++) {
		swap(arr, i, end - j);
		j++;
	}
};

/**
 * Partitions an array based on a pivot element.
 * @param arr - The array to be partitioned.
 * @param left - The left index of the partition range.
 * @param right - The right index of the partition range.
 * @returns The index of the pivot element after partitioning.
 */
const partition = (arr: number[], left: number, right: number) => {
	let pivot = arr[Math.floor((right + left) / 2)];
	let i = left;
	let j = right;
	while (i <= j) {
		while (arr[i] < pivot) {
			i++;
		}
		while (arr[j] > pivot) {
			j--;
		}

		if (i <= j) {
			let k = arr[i];
			arr[i] = arr[j];
			arr[j] = k;
			i++;
			j--;
		}
	}

	return i;
};

/**
 * Sorts an array using the Quick Sort algorithm.
 * @param arr - The array to be sorted.
 * @param left - The starting index of the subarray to be sorted.
 * @param right - The ending index of the subarray to be sorted.
 */
export const quickSort = (arr: number[], left: number, right: number): void => {
	let i: number;
	if (arr.length > 1) {
		i = partition(arr, left, right);
		if (left < i - 1) {
			quickSort(arr, left, i - 1);
		}
		if (i < right) {
			quickSort(arr, i, right);
		}
	}
};
