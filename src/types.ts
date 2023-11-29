/**
 * Represents a solution for a problem.
 * @template InputType The type of the input for the solution.
 * @template ReturnType The type of the return value of the solution.
 */
export interface Solution<InputType, ReturnType> {
	/**
	 * Gets the name of the solution.
	 * @returns The name of the solution.
	 */
	getName(): string;

	/**
	 * Gets the link to the problem.
	 * @returns The link to the problem.
	 */
	getProblemLink(): string;

	/**
	 * Gets the implementations of the solution.
	 * @returns An array of functions that implement the solution.
	 */
	getImplementations(): ((input: InputType) => ReturnType)[];

	/**
	 * Gets the test cases for the solution.
	 * @returns An array of test cases, where each test case is an array containing the input and the expected output.
	 */
	getTestCases(): TestCase<InputType, ReturnType>[];
}
/**
 * Represents a Tester object.
 */
export interface Test {
	/**
	 * Executes the test with the given solution.
	 * @param solution The solution to be tested.
	 */
	test: (solution: Solution<any, any>) => void;
}

/**
 * Represents a test case with an input value and an expected return value.
 * @template InputType The type of the input value.
 * @template ReturnType The type of the expected return value.
 */
export type TestCase<InputType, ReturnType> = {
	input: InputType;
	expected: ReturnType;
};

/**
 * Represents a solution implementation function.
 * @template Input The type of the input parameter.
 * @template Return The type of the return value.
 * @param input The input parameter.
 * @returns The return value.
 */
export type SolutionImplementation<Input, Return> = (input: Input) => Return;
