import { TestCase } from "@/types";
import { judgeProblem } from "@/utils";

/*
	Problem Link: https://leetcode.com/problems/two-sum/
*/
type TProblem = (arr: number[], k: number) => "YES" | "NO";

const brute: TProblem = (arr, k) => {
	for (let i = 0; i < arr.length; i++)
		for (let j = i + 1; j < arr.length; j++)
			if (arr[i] + arr[j] == k) return "YES";
	return "NO";
};

const optimal: TProblem = (arr, k) => {
	arr.sort((a, b) => a - b);

	let left = 0,
		right = arr.length - 1;
	while (left <= right) {
		const sum = arr[left] + arr[right];
		if (sum === k) return "YES";
		else if (sum < k) left++;
		else right--;
	}
	return "NO";
};

const solutions = [brute, optimal];
const testCases: TestCase<TProblem>[] = [[[[2, 7, 11, 15], 9], "YES"]];
judgeProblem(solutions, testCases, import.meta.file);
