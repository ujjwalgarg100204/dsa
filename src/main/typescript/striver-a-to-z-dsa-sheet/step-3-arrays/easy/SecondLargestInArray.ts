import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";

type Input = { arr: number[] };
type Output = { secMin: number; secMax: number };

class SecondLargestInArraySolution implements Solution<Input, Output> {
	getName(): string {
		return "Second Largest Number";
	}
	getProblemLink(): string {
		return "https://www.codingninjas.com/studio/problems/ninja-and-the-second-order-elements_6581960";
	}
	getImplementations(): ((input: Input) => Output)[] {
		return [this.optimal];
	}
	getTestCases(): TestCase<Input, Output>[] {
		return [
			{
				input: { arr: [3, 4, 5, 2] },
				expected: {
					secMin: 3,
					secMax: 4,
				},
			},
			{
				input: { arr: [4, 5, 3, 6, 7] },
				expected: { secMax: 6, secMin: 4 },
			},
		];
	}

	optimal: SolutionImplementation<Input, Output> = ({ arr }) => {
		let firstMin = arr[0],
			secMin = arr[0],
			firstMax = arr[0],
			secMax = arr[0];

		for (const i of arr) {
			// find first minimum
			if (i < firstMin) {
				// update secMin to firstMin value
				secMin = firstMin;
				firstMin = i;
			}
			if (i < secMin && i > firstMin) {
				secMin = i;
			}

			// find first max
			if (i > firstMax) {
				// update secMax to firstMax value
				secMax = firstMax;
				firstMax = i;
			}
			if (i > secMax && i < firstMax) {
				secMax = i;
			}
		}

		return { secMax, secMin };
	};
}

new ManualTesting().test(new SecondLargestInArraySolution());
