import { Solution, SolutionImplementation } from "@/types";

import { TestCase } from "@/types";
import ManualTesting from "@testing/ManualTesting";

type Input = { n: number };

class ArmstrongNumberSolution implements Solution<Input, boolean> {
	getName(): string {
		return "Armstrong Number";
	}
	getProblemLink(): string {
		return "";
	}
	getImplementations(): ((input: Input) => boolean)[] {
		return [this.optimal];
	}
	getTestCases(): TestCase<Input, boolean>[] {
		return [
			{ input: { n: 1 }, expected: true },
			{ input: { n: 1634 }, expected: true },
			{ input: { n: 103 }, expected: false },
			{ input: { n: 103 }, expected: true },
		];
	}

	optimal: SolutionImplementation<Input, boolean> = ({ n }) => {
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
}

new ManualTesting().test(new ArmstrongNumberSolution());
