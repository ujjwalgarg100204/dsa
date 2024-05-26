import { Solution, SolutionImplementation, TestCase } from "@/types";

import ManualTesting from "@testing/ManualTesting";

type Input = { arr: number[] };
type Output = number;

class StockBuyAndSellSolution implements Solution<Input, Output> {
	getName(): string {
		return "Best Time to Buy and Sell Stock";
	}
	getProblemLink(): string {
		return "https://leetcode.com/problems/best-time-to-buy-and-sell-stock";
	}
	getImplementations(): SolutionImplementation<Input, number>[] {
		return [this.brute, this.optimal];
	}
	getTestCases(): TestCase<Input, number>[] {
		return [
			{ input: { arr: [7, 1, 5, 3, 6, 4] }, expected: 5 },
			{ input: { arr: [7, 6, 4, 3, 1] }, expected: 0 },
		];
	}

	brute: SolutionImplementation<Input, Output> = ({ arr }) => {
		let maxProfit = 0;
		for (let i = 0; i < arr.length; i++) {
			let profit = 0;
			for (let j = i + 1; j < arr.length; j++) {
				profit = arr[j] - arr[i];
				maxProfit = Math.max(profit, maxProfit);
			}
		}

		return maxProfit;
	};

	optimal: SolutionImplementation<Input, Output> = ({ arr }) => {
		let minPrice = arr[0],
			maxProfit = Number.MIN_SAFE_INTEGER;
		for (const price of arr) {
			let currProfit = price - minPrice;
			maxProfit = Math.max(maxProfit, currProfit);
			minPrice = Math.min(minPrice, price);
		}
		return maxProfit;
	};
}

new ManualTesting().test(new StockBuyAndSellSolution());
