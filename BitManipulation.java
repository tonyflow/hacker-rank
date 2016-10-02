package test.hacker.rank;

import java.util.Arrays;
import java.util.Scanner;

public class BitManipulation {
	
	
	/**
	 * Lonely Integer
	 * 
	 * @param args
	 */
	public static void lonelyInteger(String[] args) {

		Scanner s = new Scanner(System.in);

		int N = s.nextInt();
		int[] numberCounts = new int[101];
		Arrays.fill(numberCounts, 0);

		for (int i = 0; i < N; i++) {
			int number = s.nextInt();
			if (numberCounts[number] == -1) {
				numberCounts[number] = 1;
			} else {
				numberCounts[number] = -1;
			}
		}

		for (int i = 0; i <= 100; i++) {
			if (numberCounts[i] == -1) {
				System.out.println(i);
				break;
			}

		}
		s.close();
	}
	
	public static void flippingBits(String[] args) {

		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();
		for (int i = 0; i < tc; i++) {
			System.out.println(Long.parseLong(Long
					.toBinaryString(~s.nextLong()).substring(32, 64), 2));
		}
		s.close();

	}

}
