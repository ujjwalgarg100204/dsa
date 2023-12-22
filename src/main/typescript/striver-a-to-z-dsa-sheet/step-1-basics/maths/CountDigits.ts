import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";

type Input = { n: number };
class CountDigitsSolution implements Solution<Input, number> {
	getImplementations(): ((input: Input) => number)[] {
		return [this.optimal];
	}
	getName(): string {
		return "Count Digits";
	}
	getProblemLink(): string {
		return "https://www.codingninjas.com/studio/problems/count-digits_8416387";
	}
	getTestCases(): TestCase<Input, number>[] {
		return [
			{ input: { n: 35 }, expected: 1 },
			{ input: { n: 373 }, expected: 0 },
		];
	}

	optimal: SolutionImplementation<Input, number> = ({ n }) => {
		let count = 0;
		const numCpy = n;
		while (n != 0) {
			const lastDig = n % 10;

			// divide by 0 check
			if (lastDig != 0) count = count + (numCpy % lastDig == 0 ? 1 : 0);
			n = Math.floor(n / 10);
		}

		return count;
	};
}

new ManualTesting().test(new CountDigitsSolution());
