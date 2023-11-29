import { Solution, Test, TestCase } from "./types";

import chalk from "chalk";
import { log } from "console";
import _ from "lodash";

class ManualTesting implements Test {
	test: (solution: Solution<any, any>) => void = solution => {
		const implementations = solution.getImplementations();
		const testCases = solution.getTestCases();

		log(`Running ${solution.getName()}`);

		for (const implementation of implementations) {
			for (const testCase of testCases) {
				log(
					`\n${chalk.gray("Solution")} ${chalk.blue(
						chalk.underline(implementation.name)
					)} ${chalk.gray("with")} ${chalk.magenta(
						JSON.stringify(testCase.input)
					)}: `
				);

				this.runTestCase(implementation, testCase);
			}
		}
	};

	private runTestCase(
		implementation: (input: any) => any,
		testCase: TestCase<any, any>
	) {
		const { input, expected } = testCase;

		let end = 1;
		const start = performance.now();
		try {
			const solReturnVal = implementation(_.cloneDeep(input));
			end = performance.now();

			const str = `Expected ${chalk.bold(
				chalk.underline(JSON.stringify(expected))
			)} and got ${chalk.bold(
				chalk.underline(JSON.stringify(solReturnVal))
			)}`;

			if (_.isEqual(solReturnVal, expected))
				log(chalk.greenBright(`\t✓ ${str}`));
			else log(chalk.redBright(`\t✗ ${str}`));
		} catch (err) {
			end = performance.now();
			log(chalk.redBright(`✗ Error: ${err}`));
		} finally {
			log(chalk.gray(`\tRan in: ${(end - start).toPrecision(3)}ms`));
		}
	}
}
export default ManualTesting;
