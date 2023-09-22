export const isPrime = (n: number): boolean => {
	if (n < 2) return false;
	if (n == 2 || n == 3) return true;
	if (n % 2 == 0 || n % 3 == 0) return false;

	for (let i = 5; i * i <= n; i += 6)
		if (n % i == 0 || n % (i + 2) == 0) return false;

	return true;
};

export const reverseBits = (n: number): number => {
	let reversed = 0;
	while (n != 0) {
		reversed <<= 1;
		reversed |= n & 1;
		n >>= 1;
	}
	return reversed;
};

export const getDigits = (n: string): number[] => {
	return n.split("").map(i => +i);
};
