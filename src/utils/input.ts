import readline from "readline/promises";

const rl = readline.createInterface({
	input: process.stdin,
	output: process.stdout,
});

export const input = async (dataType: "number" | "string", prompt?: string) => {
	const userInp = await rl.question(prompt ?? "");
	if (dataType === "number") return +userInp;
	return userInp;
};

export const inputArr = async (
	dataType: "number" | "string",
	sep: string = " ",
	prompt?: string
) => {
	const line = (await input("string", prompt)) as string;
	const arr = line.split(sep);
	return dataType === "number" ? arr.map(i => +i) : arr;
};

export const inputLeetCodeArr = (arr: string): number[] => {
	return arr
		.slice(1, -1)
		.split(",")
		.map(i => +i);
};

export const inputLeetCodeMatrix = (matrix: string): number[][] => {
	const matches = matrix.slice(1, -1).matchAll(/(\[(.*?)\])/g);
	const finalMat: number[][] = [];

	for (const match of matches) finalMat.push(inputLeetCodeArr(match[1]));
	return finalMat;
};
