import { Solution, Test, TestCase } from "./types";

import chalk from "chalk";
import { log } from "console";
import _ from "lodash";

class ManualTesting implements Test {
	/**
	 * Runs the test for the given solution.
	 *
	 * @param solution - The solution to test.
	 */
	test: (solution: Solution<any, any>) => void = solution => {
		// get all the implementations and test-cases
		const implementations = solution.getImplementations();
		const testCases = solution.getTestCases();

		// let the client know test has started
		console.log("\x1b[2J"); // clears the terminal
		log(chalk.whiteBright(`\n\nRunning ${solution.getName()}`));

		// measure all test-case runs
		const totalTestCaseRuns = testCases.length * implementations.length;
		let successfulRuns = 0;

		for (const implementation of implementations) {
			let successfulRunsOfCurrImplementation = 0;

			for (const testCase of testCases) {
				// log current solution name with input
				log(
					`\n${chalk.gray("Solution")} ${chalk.blue(
						chalk.underline(implementation.name)
					)} ${chalk.gray("with")} ${chalk.magenta(
						JSON.stringify(testCase.input)
					)}: `
				);

				const wasSuccessful = this.runTestCase(
					implementation,
					testCase
				);
				if (wasSuccessful) {
					successfulRuns++;
					successfulRunsOfCurrImplementation++;
				}
			}

			// inform client about how many test cases passed for current
			// implementation
			log(
				chalk.bold(
					`\nRan ${chalk.underline(
						testCases.length
					)} test-cases for ${chalk.blue(implementation.name)}:`
				)
			);
			log(
				chalk.bold(
					chalk.greenBright(
						`\tTotal Passed: ${successfulRunsOfCurrImplementation}`
					)
				)
			);
			const failedTestCasesForCurrImplementation =
				testCases.length - successfulRunsOfCurrImplementation;
			if (failedTestCasesForCurrImplementation === 0) {
				log(
					chalk.bold(
						chalk.magenta(
							`\tTotal Failed: ${failedTestCasesForCurrImplementation}`
						)
					)
				);
			} else {
				log(
					chalk.bold(
						chalk.redBright(
							`\tTotal Failed: ${failedTestCasesForCurrImplementation}`
						)
					)
				);
			}
		}

		// inform client about stats about all test-cases
		log(
			chalk.bold(
				`\n\nOverall Result on running ${chalk.underline(
					"all test-cases"
				)} with ${chalk.underline("all implementations")}:`
			)
		);
		log(chalk.bold(chalk.greenBright(`\tTotal Passed: ${successfulRuns}`)));
		const totalFailedTestCasesRuns = totalTestCaseRuns - successfulRuns;
		if (totalFailedTestCasesRuns === 0) {
			log(
				chalk.bold(
					chalk.magenta(`\tTotal Failed: ${totalFailedTestCasesRuns}`)
				)
			);
		} else {
			log(
				chalk.bold(
					chalk.redBright(
						`\tTotal Failed: ${totalFailedTestCasesRuns}`
					)
				)
			);
		}
	};

	/**
	 * Runs a test case for a given implementation.
	 *
	 * @param implementation - The implementation function to test.
	 * @param testCase - The test case to run.
	 * @returns `true` if the test case passes, `false` otherwise.
	 */
	private runTestCase(
		implementation: (input: any) => any,
		testCase: TestCase<any, any>
	): boolean {
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

			if (_.isEqual(solReturnVal, expected)) {
				log(chalk.greenBright(`\t✓ ${str}`));
				return true;
			} else {
				log(chalk.redBright(`\t✗ ${str}`));
				return false;
			}
		} catch (err) {
			end = performance.now();
			log(chalk.redBright(`✗ Error: ${err}`));
		} finally {
			log(chalk.gray(`\tRan in: ${(end - start).toPrecision(3)}ms`));
		}
		return false;
	}
}

export default ManualTesting;
