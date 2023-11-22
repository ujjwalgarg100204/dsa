import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@/ManualTesting";
import { factorial } from "@utils/math";

type Input = { stairs: number };

class ClimbingStairsSolution implements Solution<Input, number> {
	getName(): string {
		return "Climbing Stairs";
	}

	getProblemLink(): string {
		return "https://leetcode.com/problems/climbing-stairs/";
	}

	getImplementations(): ((input: Input) => number)[] {
		return [this.brute, this.optimal];
	}

	getTestCases(): TestCase<Input, number>[] {
		return [
			{ input: { stairs: 4 }, expected: 4 },
			{ input: { stairs: 3 }, expected: 3 },
			{ input: { stairs: 4 }, expected: 5 },
		];
	}

	brute: SolutionImplementation<Input, number> = ({ stairs }) => {
		let ways = 0;

		for (let noOf2s = 0; noOf2s * 2 <= stairs; noOf2s++) {
			const noOf1s = stairs - noOf2s * 2;
			ways +=
				factorial(noOf2s + noOf1s) /
				(factorial(noOf2s) * factorial(noOf1s));
		}
		return ways;
	};

	optimal: SolutionImplementation<Input, number> = ({ stairs }) => {
		if (stairs == 1) return 1;

		// fibonacci seq
		let first = 1,
			sec = 2,
			sum = 0;
		for (; stairs > 2; stairs--) {
			sum = first + sec;
			first = sec;
			sec = sum;
		}

		return sec;
	};
}

new ManualTesting().test(new ClimbingStairsSolution());
