package test.hacker.rank.recursion;

import java.util.Scanner;
import java.util.Stack;

public class RecursionProblems {

	/**
	 * Factorial : The Hello world of recursion.
	 * 
	 * @param args
	 */
	public static void factorialMain(String[] args) {
		System.out.println(factorial(3));
	}

	public static int factorial(int n) {
		return n == 1 ? 1 : n * factorial(n - 1);
	}

	/**
	 * GCD(Greatest Common Divisor): Euclid's algorithm
	 */
	public static void gcdMain(String[] args) {

		System.out.println(gcd(66297, 16093));

		System.out.println(gcdNonRecursive(66297, 16093));

	}

	public static Integer gcd(Integer p, Integer q) {

		if (q == 0) {
			return p;
		} else {
			return gcd(q, p % q);
		}
	}

	public static Integer gcdNonRecursive(Integer p, Integer q) {

		while (q != 0) {
			int tmp = p;
			p = q;
			q = tmp % q;
			System.out.println("p:  " + p + ", q: " + q);
		}

		return p;
	}

	/**
	 * Hanoi Towers recursive implementation (Maybe the most amazing algorithm I
	 * have encountered).
	 * 
	 * (1) move n−1 discs from A to B. This leaves disc n alone on peg A
	 * 
	 * (2) move disc n from A to C
	 * 
	 * (3) move n−1 discs from B to C so they sit on disc n
	 * 
	 * If h>1, then somewhere along the sequence of moves, the largest disk must
	 * be moved from peg A to another peg, preferably to peg C. The only
	 * situation that allows this move is when all smaller h−1 disks are on peg
	 * B. Hence, first all h−1 smaller disks must go from A to B. Subsequently
	 * move the largest disk and finally move the h−1 smaller disks from peg B
	 * to peg C. The presence of the largest disk does not impede any move of
	 * the h−1 smaller disks and can temporarily be ignored. Now the problem is
	 * reduced to moving h−1 disks from one peg to another one, first from A to
	 * B and subsequently from B to C, but the same method can be used both
	 * times by renaming the pegs. The same strategy can be used to reduce the
	 * h−1 problem to h−2, h−3, and so on until only one disk is left.
	 * 
	 * @param args
	 */
	public static void hanoiMain(String[] args) {

		hanoiRecursive(3, 'A', 'B', 'C');

	}

	public static void hanoiRecursive(Integer disk, char source,
			char destination, char using) {

		// base case corresponds to the smallest disk of the pegs which we can
		// user safely wherever we want without fear of breaking the
		// "always greater under smaller" condition
		if (disk == 1) {
			System.out.println("Moving disk " + disk + " from " + source
					+ " to " + destination + " using " + using);
		} else {
			hanoiRecursive(disk - 1, source, using, destination);
			System.out.println("Moving disk " + disk + " from " + source
					+ " to " + destination + " using " + using);
			hanoiRecursive(disk - 1, using, destination, source);
		}

	}

	private void hanoiIterative() {
		// TODO Auto-generated method stub

	}

	private void hanoiGrayCode() {
		// TODO Auto-generated method stub

	}

	/**
	 * Given a value N, if we want to make change for N cents, and we have
	 * infinite supply of each of S = { S1, S2, .. , Sm} valued coins, how many
	 * ways can we make the change? The order of coins doesn’t matter.
	 * 
	 * For example, for N = 4 and S = {1,2,3}, there are four solutions:
	 * {1,1,1,1},{1,1,2},{2,2},{1,3}. So output should be 4. For N = 10 and S =
	 * {2, 5, 3, 6}, there are five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6},
	 * {2,3,5} and {5,5}. So the output should be 5.
	 */
	private void coins() {
		// TODO Auto-generated method stub

	}

	/*
	 * Testing bunny ears implementation
	 */
	public static Integer globalBunnyEars = 0;

	public static void bunnyEarsmain(String[] args) {

		Scanner s = new Scanner(System.in);

		Integer bunnies = s.nextInt();

		bunnyEarsSimple(bunnies);

		Integer bunnyEarsSimple2 = bunnyEarsSimple2(bunnies);

		System.out
				.println("Total bunny ears is (global variable implementation) "
						+ globalBunnyEars);

		System.out.println("Total bunny ears is " + bunnyEarsSimple2);

		System.out.println("Bunnies on hacked bunny line "
				+ bunnyEars2(bunnies));

		s.close();
	}

	/**
	 * We have a number of bunnies and each bunny has two big floppy ears. We
	 * want to compute the total number of ears across all the bunnies
	 * recursively (without loops or multiplication).
	 * 
	 * This implementation uses a global varialbe
	 */
	public static void bunnyEarsSimple(Integer bunnies) {

		if (bunnies >= 1) {
			globalBunnyEars += 2;
			bunnyEarsSimple(bunnies - 1);
		}

	}

	public static Integer bunnyEarsSimple2(Integer bunnies) {

		return bunnies == 0 ? bunnies : bunnyEarsSimple2(bunnies - 1) + 2;
	}

	public static void fibonacciMain(String[] args) {

		System.out.println(fibonacci(23));

	}

	public static int fibonacci(int i) {
		return i == 0 || i == 1 ? i : fibonacci(i - 1) + fibonacci(i - 2);
	}

	/**
	 * We have bunnies standing in a line, numbered 1, 2, ... The odd bunnies
	 * (1, 3, ..) have the normal 2 ears. The even bunnies (2, 4, ..) we'll say
	 * have 3 ears, because they each have a raised foot. Recursively return the
	 * number of "ears" in the bunny line 1, 2, ... n (without loops or
	 * multiplication).
	 * 
	 */
	public static int bunnyEars2(int bunnies) {

		if (bunnies == 0) {
			return bunnies;
		} else {
			return bunnies % 2 != 0 ? bunnyEars2(bunnies - 1) + 2
					: bunnyEars2(bunnies - 1) + 3;
		}
	}

	/**
	 * Comment out printings to test results of respective recursive call
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// System.out.println(triangle(2));

		// System.out.println(sumDigits(49));

		// System.out.println(count7(123));
		// System.out.println(count7(7));
		// System.out.println(count7(717));
		//
		// System.out.println(count8(8));
		// System.out.println(count8(818));
		// System.out.println(count8(8818));
		// System.out.println(count8(8088));

		// System.out.println(powerN(3, 2));

		// System.out.println(countHi("xhixhix"));
		// System.out.println(countHi("hi"));
		// System.out.println(countHi("xxhixx"));
		// System.out.println(countHi("hihih"));
		// System.out.println(countHi("ihihihihih"));
		// System.out.println(countHi("ihihihihihi"));

		// System.out.println(changeXY("codex"));
		// System.out.println(changeXY("xxhixx"));
		// System.out.println(changeXY("xhixhix"));

		// System.out.println(changePi("xpix"));
		// System.out.println(changePi("pipi"));
		// System.out.println(changePi("pip"));

		// System.out.println(noX("xaxb"));
		// System.out.println(noX("abc"));
		// System.out.println(noX("xx"));

		// System.out.println(array6(new int[] { 1, 6, 4 }, 0));
		// System.out.println(array6(new int[] { 1, 4 }, 0));
		// System.out.println(array6(new int[] { 6 }, 0));

		// System.out.println(array11(new int[] { 1, 2, 11 }, 0));
		// System.out.println(array11(new int[] { 11, 11 }, 0));
		// System.out.println(array11(new int[] { 1, 2, 3, 4 }, 0));

		// System.out.println(array220(new int[] { 1, 2, 20 }, 0));
		// System.out.println(array220(new int[] { 3, 30 }, 0));
		// System.out.println(array220(new int[] { 3 }, 0));

		// System.out.println(allStar("hello"));
		// System.out.println(allStar("abc"));
		// System.out.println(allStar("ab"));

		System.out.println(pairStar("hello"));
//		System.out.println(pairStar("xxyy"));
//		System.out.println(pairStar("aaaa"));
	}

	@SuppressWarnings("unused")
	public static int triangle(int rows) {
		return rows == 0 ? rows : triangle(rows - 1) + rows;
	}

	public static int sumDigits(int n) {

		return String.valueOf(n).length() == 1 ? n : sumDigits(n / 10)
				+ sumDigits(n % 10);
	}

	public static int count7(int n) {

		if (n == 7) {
			return 1;
		} else if (n < 10) {
			return 0;
		} else {
			return count7(n / 10) + count7(n % 10);
		}

	}

	public static int count8(int n) {

		if (n == 0) {
			return 0;
		}

		if (n % 10 == 8) {
			if (n % 100 == 88) {
				return count8(n / 10) + 2;
			} else {
				return count8(n / 10) + 1;
			}
		}

		return count8(n / 10);
	}

	/**
	 * Given base and n that are both 1 or more, compute recursively (no loops)
	 * the value of base to the n power, so powerN(3, 2) is 9 (3 squared).
	 * 
	 * @param base
	 * @param n
	 * @return
	 */
	public static int powerN(int base, int n) {

		if (n == 0) {
			return 1;
		} else {
			return base * powerN(base, n - 1);
		}

	}

	public static int countX(String str) {

		if (str.length() >= 1) {
			if (str.length() == 1 && str.equals("x")) {
				return 1;
			} else if (str.length() > 1) {
				return countX(str.substring(0, str.length() - 1))
						+ countX(str.substring(str.length() - 1, str.length()));
			}
		}

		return 0;
	}

	/**
	 * Given a string, compute recursively (no loops) the number of times
	 * lowercase "hi" appears in the string.
	 * 
	 * First recursive call handles string before supposedly found first 'hi'.
	 * Second recursive call handles supposedly found first 'hi'. Third
	 * recursive call handles string after supposedly found first 'hi'.
	 * 
	 * TCs: 'xxhixx','xhixhix',hi','hihih','ihihihihih','ihihihihihi'
	 * 
	 * @param str
	 * @return
	 */
	public static int countHi(String str) {

		if (str.length() >= 2) {

			if (str.equals("hi")) {
				return 1;
			} else if (str.length() >= 3) {
				// returns -1 on missing character
				int indexOfI = str.indexOf('i');
				if (indexOfI > 0) {

					return countHi(str.substring(0, indexOfI - 1))
							+ countHi(str.substring(indexOfI - 1, indexOfI + 1))
							+ countHi(str.substring(indexOfI + 1, str.length()));
				} else if (indexOfI == 0) {
					return countHi(str.substring(1, str.length()));
				}
			}

		}

		return 0;
	}

	// TODO understand what the fuck is going on here.
	public int countHiAlternative(String str) {
		if (str.length() <= 1)
			return 0;
		int count = 0;
		if (str.substring(0, 2).equals("hi"))
			count = 1; // could use startsWith()
		return count + countHi(str.substring(1));
	}

	/**
	 * Given a string, compute recursively (no loops) a new string where all the
	 * lowercase 'x' chars have been changed to 'y' chars.
	 * 
	 * @param str
	 * @return
	 */
	public static String changeXY(String str) {

		StringBuilder builder = new StringBuilder();

		if (str.length() > 0) {
			if (str.startsWith("x")) {
				builder.append("y");
			} else {
				builder.append(str.charAt(0));
			}

			builder.append(changeXY(str.substring(1)));

		}

		return builder.toString();
	}

	/**
	 * Given a string, compute recursively (no loops) a new string where all
	 * appearances of "pi" have been replaced by "3.14".
	 * 
	 * changePi("xpix") → "x3.14x"
	 * 
	 * changePi("pipi") → "3.143.14"
	 * 
	 * hangePi("pip") → "3.14p"
	 * 
	 * @param str
	 * @return
	 */
	public static String changePi(String str) {

		StringBuilder builder = new StringBuilder();

		if (str.length() > 0) {
			if (str.startsWith("pi")) {
				builder.append("3.14");
				builder.append(changePi(str.substring(2)));
			} else {
				builder.append(str.charAt(0));
				builder.append(changePi(str.substring(1)));
			}

		}

		return builder.toString();

	}

	/**
	 * Given a string, compute recursively a new string where all the 'x' chars
	 * have been removed.
	 * 
	 * noX("xaxb") → "ab"
	 * 
	 * noX("abc") → "abc"
	 * 
	 * noX("xx") → ""
	 * 
	 * @param str
	 * @return
	 */
	public static String noX(String str) {

		StringBuilder builder = new StringBuilder();

		if (str.length() > 0) {
			if (!str.startsWith("x")) {
				builder.append(str.charAt(0));
			}
			builder.append(noX(str.substring(1)));
		}

		return builder.toString();

	}

	/**
	 * 
	 Given an array of ints, compute recursively if the array contains a 6.
	 * We'll use the convention of considering only the part of the array that
	 * begins at the given index. In this way, a recursive call can pass index+1
	 * to move down the array. The initial call will pass in index as 0.
	 * 
	 * array6([1, 6, 4], 0) → true
	 * 
	 * array6([1, 4], 0) → false
	 * 
	 * array6([6], 0) → true
	 * 
	 * @param nums
	 * @param index
	 * @return
	 */
	public static boolean array6(int[] nums, int index) {

		if (index < nums.length) {
			if (nums[index] == 6) {
				return true;
			} else {
				return array6(nums, index + 1);
			}
		}

		return false;

	}

	/**
	 * Given an array of ints, compute recursively the number of times that the
	 * value 11 appears in the array. We'll use the convention of considering
	 * only the part of the array that begins at the given index. In this way, a
	 * recursive call can pass index+1 to move down the array. The initial call
	 * will pass in index as 0.
	 * 
	 * array11([1, 2, 11], 0) → 1
	 * 
	 * array11([11, 11], 0) → 2
	 * 
	 * array11([1, 2, 3, 4], 0) → 0
	 * 
	 * @param nums
	 * @param index
	 * @return
	 */
	public static int array11(int[] nums, int index) {

		int count = 0;

		if (index < nums.length) {
			if (nums[index] == 11) {
				count++;
			}

			return count + array11(nums, index + 1);
		}

		return 0;

	}

	/**
	 * Given an array of ints, compute recursively if the array contains
	 * somewhere a value followed in the array by that value times 10. We'll use
	 * the convention of considering only the part of the array that begins at
	 * the given index. In this way, a recursive call can pass index+1 to move
	 * down the array. The initial call will pass in index as 0.
	 * 
	 * array220([1, 2, 20], 0) → true
	 * 
	 * array220([3, 30], 0) → true
	 * 
	 * array220([3], 0) → false
	 * 
	 * @param nums
	 * @param index
	 * @return
	 */
	public static boolean array220(int[] nums, int index) {

		if (index < nums.length - 1) {

			if (nums[index + 1] == nums[index] * 10) {
				return true;
			}

			return array220(nums, index + 1);

		}

		return false;

	}

	/**
	 * Given a string, compute recursively a new string where all the adjacent
	 * chars are now separated by a "*".
	 * 
	 * allStar("hello") → "h*e*l*l*o"
	 * 
	 * allStar("abc") → "a*b*c"
	 * 
	 * allStar("ab") → "a*b"
	 * 
	 * @param str
	 * @return
	 */
	public static String allStar(String str) {

		StringBuilder builder = new StringBuilder();

		if (str.length() > 0) {
			builder.append(str.charAt(0));
			builder.append(str.length() != 1 ? "*" : "");
			builder.append(allStar(str.substring(1)));

		}

		return builder.toString();
	}

	/**
	 * Given a string, compute recursively a new string where identical chars
	 * that are adjacent in the original string are separated from each other by
	 * a "*".
	 * 
	 * pairStar("hello") → "hel*lo"
	 * 
	 * pairStar("xxyy") → "x*xy*y"
	 * 
	 * pairStar("aaaa") → "a*a*a*a"
	 * 
	 * @param str
	 * @return
	 */
	public static String pairStar(String str) {

		StringBuilder builder = new StringBuilder();

		if (str.length() > 1) {
			if (str.charAt(0) == str.charAt(1)) {
				builder.append(str.charAt(0)).append("*").append(str.charAt(1));
			}

			builder.append(pairStar(str.substring(1)));
		}

		return builder.toString();

	}
}
