package test.hacker.rank;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class DynamicProgramming {

	/**
	 * Fibonacci Modified
	 * 
	 * @param args
	 */
	public static void fibonacciModified(String[] args) {
		Scanner s = new Scanner(System.in);
		BigInteger A = s.nextBigDecimal().toBigInteger();
		BigInteger B = s.nextBigDecimal().toBigInteger();
		int N = s.nextInt();
		BigInteger C = BigInteger.ZERO;
		for (int i = 0; i < N - 2; i++) {
			C = B.pow(2).add(A);
			BigInteger tmp = B;
			A = B;
			B = C;

		}
		System.out.println(C);
		s.close();
	}

	/**
	 * The coin change problem.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int tc = s.nextInt();
		for (int i = 0; i < tc; i++) {

			int N = s.nextInt();
			int M = s.nextInt();
			int[] coins = new int[M];
			for (int j = 0; j < M; j++) {
				coins[i] = s.nextInt();
			}
			Arrays.sort(coins);
			int maxBoxes = N / coins[0];

		}
		s.close();
	}

}
