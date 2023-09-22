/*
	Problem Link: https://leetcode.com/problems/two-sum/
*/
type ProblemSolution = (arr: number[], k: number) => "YES" | "NO";

const brute: ProblemSolution = (arr, k) => {
	for (let i = 0; i < arr.length; i++)
		for (let j = i + 1; j < arr.length; j++)
			if (arr[i] + arr[j] == k) return "YES";
	return "NO";
};

const optimal: ProblemSolution = (arr, k) => {
	arr.sort();

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

(() => {
	const solution = optimal([3, 2, 4], 6);
	console.log(solution);
})();
