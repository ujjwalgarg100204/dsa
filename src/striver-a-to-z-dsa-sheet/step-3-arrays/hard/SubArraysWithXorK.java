import java.util.Arrays;
import java.util.Collections;
import java.util.List;

final class TestCase {

	public int[] arr;
	public int k;

	public TestCase(int[] arr, int k) {
		this.arr = arr;
		this.k = k;
	}
}

public class SubArraysWithXorK {

	public static final String NAME = "Majority Element";
	public static final String PROBLEM_LINK =
		"https://leetcode.com/problems/majority-element/description";

	public static final List<TestCase> TEST_CASES =
		Collections.unmodifiableList(
			Arrays.asList(
				new TestCase(new int[] { 1, 2, 3, 2 }, 2),
				new TestCase(new int[] { 1, 2, 3, 3 }, 3),
				new TestCase(new int[] { 1, 3, 3, 3, 5 }, 6),
				new TestCase(new int[] { 4, 2, 2, 6, 4 }, 6)
			)
		);

	public static void main(String[] args) {
		for (TestCase t : TEST_CASES) {
			System.out.println(brute(t.arr, t.k));
		}
	}

	public static final int brute(int[] arr, int k) {
		int count = 0;

		// generate all the sub-arrays
		for (int i = 0; i < arr.length; i++) {
			int xor = 0;
			for (int j = i; j < arr.length; j++) {
				xor ^= arr[j];
				if (xor == k) {
					count++;
				}
			}
		}

		return count;
	}
}
