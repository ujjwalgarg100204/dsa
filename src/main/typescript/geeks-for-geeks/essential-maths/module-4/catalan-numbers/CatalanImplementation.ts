// recursive approach
const catalan = (n: number): number => {
	if (n <= 1) return 1;

	let ans = 0;
	for (let i = 0; i < n; i++) ans += catalan(i) * catalan(n - i - 1);

	return ans;
};

const memoisedCatalan = (n: number): number => {
	const memo = new Map<number, number>([
		[0, 1],
		[1, 1],
	]);

	const catalan = (n: number): number => {
		if (memo.has(n)) return memo.get(n)!;

		let ans = 0;
		for (let i = 0; i < n; i++) ans += catalan(i) * catalan(n - i - 1);

		memo.set(n, ans);
		return ans;
	};

	return catalan(n);
};

const dpCatalan = (n: number): number => {
	const dp = new Array<number>(n + 1);
	dp[0] = 1;

	for (let i = 1; i <= n; i++) {
		dp[i] = 0;
		for (let j = 0; j < i; j++) dp[i] += dp[j] * dp[i - j - 1];
	}
	return dp[n];
};
