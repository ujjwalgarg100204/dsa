export type TestCase<Problem extends (...args: any) => any> = [
	Parameters<Problem>,
	ReturnType<Problem>
];
