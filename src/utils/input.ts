import readline from "readline/promises";

const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});

/**
 * Takes user input from the command line.
 * @param dataType - The type of data expected from the user input. Can be "number" or "string".
 * @param prompt - Optional prompt message to display before taking user input.
 * @returns The user input converted to the specified data type.
 */
export const input = async (dataType: "number" | "string", prompt?: string) => {
	const userInp = await rl.question(prompt ?? "");
	if (dataType === "number") return +userInp;
	return userInp;
};

/**
 * Converts a string input into an array of numbers or strings.
 *
 * @param dataType - The type of data to convert the input into. Can be "number" or "string".
 * @param sep - The separator used to split the input string into an array. Defaults to a space (" ").
 * @param prompt - An optional prompt message to display before taking the input.
 * @returns An array of numbers or strings based on the specified data type.
 */
export const inputArr = async (
	dataType: "number" | "string",
	sep: string = " ",
	prompt?: string
) => {
	const line = (await input("string", prompt)) as string;
	const arr = line.split(sep);
	return dataType === "number" ? arr.map(i => +i) : arr;
};

/**
 * Converts a string representation of an array to an array of numbers.
 *
 * @param arr - The string representation of the array.
 * @returns An array of numbers.
 */
export const inputLeetCodeArr = (arr: string): number[] => {
	return arr
		.slice(1, -1)
		.split(",")
		.map(i => +i);
};

/**
 * Converts a string representation of a matrix into a 2D number array.
 * The matrix should be in the format "[[1,2,3],[4,5,6],[7,8,9]]".
 * @param matrix - The string representation of the matrix.
 * @returns The converted 2D number array.
 */
export const inputLeetCodeMatrix = (matrix: string): number[][] => {
	const matches = matrix.slice(1, -1).matchAll(/(\[(.*?)\])/g);
	const finalMat: number[][] = [];

	for (const match of matches) finalMat.push(inputLeetCodeArr(match[1]));
	return finalMat;
};
