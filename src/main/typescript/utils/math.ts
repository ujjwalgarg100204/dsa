/**
 * Checks if a number is prime.
 * @param n - The number to check.
 * @returns True if the number is prime, false otherwise.
 */
export const isPrime = (n: number): boolean => {
	if (n < 2) return false;
	if (n == 2 || n == 3) return true;
	if (n % 2 == 0 || n % 3 == 0) return false;

	for (let i = 5; i * i <= n; i += 6)
		if (n % i == 0 || n % (i + 2) == 0) return false;

	return true;
};

/**
 * A map that stores pre-calculated factorials.
 * The keys represent the numbers for which the factorial is calculated,
 * and the values represent the corresponding factorial values.
 */
const calculatedFactorials = new Map<number, number>([
	[0, 1],
	[1, 1],
]);
/**
 * Calculates the factorial of a given number.
 * @param n - The number to calculate the factorial for.
 * @returns The factorial of the given number.
 */
export const factorial = (n: number): number => {
	const calculated = calculatedFactorials.get(n);
	if (calculated) return calculated;

	const ans = n * factorial(n - 1);
	calculatedFactorials.set(n, ans);
	return ans;
};

/**
 * Reverses the bits of a given number.
 * @param n - The number to reverse the bits of.
 * @returns The number with reversed bits.
 */
export const reverseBits = (n: number): number => {
	let reversed = 0;
	while (n != 0) {
		reversed <<= 1;
		reversed |= n & 1;
		n >>= 1;
	}
	return reversed;
};

/**
 * Converts a string into an array of its individual digits.
 *
 * @param n - The string to convert.
 * @returns An array of the individual digits of the input string.
 */
export const getDigits = (n: string): number[] => {
	return n.split("").map(i => +i);
};

/**
 * Calculates the value of nCr (combination) using the formula n! / (r! * (n-r)!).
 * @param n - The total number of items.
 * @param r - The number of items to be selected.
 * @returns The value of nCr.
 */
export const ncr = (n: number, r: number) => {
	let ans = 1;

	for (let i = 0; i < r; i++) {
		ans *= n - i;
		ans /= i + 1;
	}
	return ans;
};
