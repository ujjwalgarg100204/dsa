import chalk from "chalk";
import { log } from "console";
import { TestCase } from "./types";

export const judgeProblem = <Problem extends (...args: any) => any>(
	solutions: Problem[],
	testCases: TestCase<Problem>[],
	problemName?: string
) => {
	if (problemName) log(chalk.cyanBright(`Running ${problemName}`));

	solutions.forEach(s =>
		testCases.forEach(testCase => {
			log(
				`\n${chalk.gray("Solution")} ${chalk.blue(
					chalk.underline(s.name)
				)} ${chalk.gray("with")} ${chalk.magenta(
					JSON.stringify(testCase[0])
				)}: `
			);
			judgeTestCase(s, testCase);
		})
	);
};

const judgeTestCase = <Problem extends (...args: any) => any>(
	solution: Problem,
	testCase: TestCase<Problem>
) => {
	const [t, right] = testCase;

	let end = 1;
	const start = performance.now();
	try {
		// @ts-ignore
		const problemReturnVal = solution(...t) as ReturnType<Problem>;
		end = performance.now();

		const str = `Expected ${chalk.bold(
			chalk.underline(right)
		)} and got ${chalk.bold(chalk.underline(problemReturnVal))}`;

		if (checkEquality(problemReturnVal, right))
			log(chalk.greenBright(`\t✓ ${str}`));
		else log(chalk.redBright(`\t✗ ${str}`));
	} catch (err) {
		end = performance.now();

		log(chalk.redBright(`✗ Error: ${err}`));
	} finally {
		log(chalk.gray(`\tRan in: ${(end - start).toPrecision(3)}ms`));
	}
};

const arrayEquals = (a: unknown[], b: unknown[]): boolean => {
	return a.length === b.length && a.every((val, index) => val === b[index]);
};

const checkEquality = (a: unknown, b: unknown): boolean => {
	if (Array.isArray(a) && Array.isArray(b)) return arrayEquals(a, b);
	return a === b;
};
