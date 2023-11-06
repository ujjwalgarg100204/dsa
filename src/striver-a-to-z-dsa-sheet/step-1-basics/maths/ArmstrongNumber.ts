import { TestCase } from "@/types";
import { judgeProblem } from "@/utils";

type TProblem = (n: number) => boolean;

const optimal: TProblem = n => {
	const numOfDigs = Math.floor(Math.log10(n)) + 1;

	let numCpy = n;
	let sum = 0;
	while (n != 0) {
		const lastDig = n % 10;
		sum += Math.pow(lastDig, numOfDigs);
		n = Math.floor(n / 10);
	}
	return numCpy === sum;
};

const solutions = [optimal];

const testCases: TestCase<TProblem>[] = [
	[[1], true],
	[[1634], true],
	[[103], false],
	[[103], true],
];

judgeProblem(solutions, testCases, import.meta.file);
