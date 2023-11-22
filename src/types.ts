export interface Solution<InputType, ReturnType> {
	getName(): string;
	getProblemLink(): string;
	getImplementations(): ((input: InputType) => ReturnType)[];
	getTestCases(): TestCase<InputType, ReturnType>[]; // [input, expectedOutput]
}

export interface Test {
	test: (solution: Solution<any, any>) => void;
}

export type TestCase<InputType, ReturnType> = {
	input: InputType;
	expected: ReturnType;
};

export type SolutionImplementation<Input, Return> = (input: Input) => Return;

