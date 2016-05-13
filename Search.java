package test.hacker.rank;

import java.util.Arrays;
import java.util.Scanner;

public class Search {

	/**
	 * Timed out on large data sets
	 * 
	 * @param args
	 */
	public static void pairsSmallSets(String[] args) {

		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] numbers = new int[n];
		int k = s.nextInt();
		for (int i = 0; i < n; i++) {
			numbers[i] = s.nextInt();
		}

		int pairs = 0;
		for (int i = 0, j = n - 1; i <= j && j > i; i++, j--) {
			int l = 1;
			while (i + l <= j || j - l > i) {
				if (Math.abs(numbers[j] - numbers[j - l]) == k && j - l > i) {
					pairs++;
				}
				if (Math.abs(numbers[i] - numbers[i + l]) == k) {
					pairs++;
				}
				l++;
			}
		}
		System.out.println(pairs);
		s.close();
	}

	public static void pairs(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] numbers = new int[n];
		int k = s.nextInt();
		for (int i = 0; i < n; i++) {
			numbers[i] = s.nextInt();
		}

		Arrays.sort(numbers);
		int pairs = 0;
		for (int i : numbers) {
			if (Arrays.binarySearch(numbers, i + k) > 0) {
				pairs++;
			}
		}
		System.out.println(pairs);
		s.close();
	}

	/**
	 * Sherlock and Arrays
	 * 
	 * @param args
	 */
	public static void sherlockAndArrays(String[] args) {
		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();

		for (int i = 0; i < tc; i++) {
			int N = s.nextInt();
			if (N == 1) {
				s.nextInt();
				System.out.println("YES");
				continue;
			}
			int[] A = new int[N];
			A[1] = s.nextInt();
			int[] sum = new int[N];
			sum[0] = A[1];
			int total = A[1];
			for (int j = 1; j < N; j++) {
				A[j] = s.nextInt();
				sum[j] = sum[j - 1] + A[j];
				total += A[j];
			}

			boolean found = false;
			for (int j = 1; j < N; j++) {
				if (sum[j - 1] == total - sum[j]) {
					found = true;
					break;
				}
			}
			if (found) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}
		}
		s.close();
	}

	/**
	 * 
	 * @param args
	 */
	public static void iceCreamParlor(String[] args) {
		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();
		for (int i = 0; i < tc; i++) {
			int M = s.nextInt();
			int N = s.nextInt();
			int[] costs = new int[N];
			for (int j = 0; j < N; j++) {
				costs[j] = s.nextInt();
			}
			int[] sortedCosts = costs.clone();
			Arrays.sort(sortedCosts);
			int firstCost = -1;
			int secondCost = -1;
			int helper = -1;
			for (int j = 0; j < N; j++) {
				if ((helper = Arrays.binarySearch(sortedCosts, j + 1, N, M
						- sortedCosts[j])) > 0) {
					firstCost = sortedCosts[j];
					secondCost = sortedCosts[helper];
					break;
				} else {
					continue;
				}
			}

			int firstIndex = -1;
			int secondIndex = -1;
			int j = 0;
			while (j <= N - 1) {
				if ((costs[j] == firstCost || costs[j] == secondCost)
						&& firstIndex == -1) {
					firstIndex = j + 1;
					j++;
					continue;
				}
				if ((costs[j] == firstCost || costs[j] == secondCost)
						&& firstIndex != -1 && secondIndex == -1) {
					secondIndex = j + 1;
					break;
				}

				j++;
			}

			System.out.println(firstIndex + " " + secondIndex);
		}
		s.close();

	}

	public static void magicNumbers(String[] args) {
		Scanner s = new Scanner(System.in);
		final int RANGE = 10_001;
		int[] cacheN = new int[RANGE];
		int[] cacheM = new int[RANGE];
		Arrays.fill(cacheN, 0);
		int n = s.nextInt();
		int[] rn = new int[n];
		for (int i = 0; i < n; i++) {
			rn[i] = s.nextInt();
			cacheN[rn[i]]++;
		}

		int m = s.nextInt();
		int[] rm = new int[m];
		for (int i = 0; i < m; i++) {
			rm[i] = s.nextInt();
			cacheM[rm[i]]++;
		}

		for (int i = 0; i < RANGE; i++) {
			if (cacheN[i] < cacheM[i]) {
				System.out.print(i + " ");
			}
		}
		s.close();
	}

	/**
	 * Maximize sum
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int tc = s.nextInt();

		for (int i = 0; i < tc; i++) {

			int N = s.nextInt();
			int M = s.nextInt();
			int[] A = new int[N];

			for (int j = 0; j < A.length; j++) {
				A[j] = s.nextInt();
			}

			if (A.length == 1) {
				System.out.println(A[0] + " " + A[0]);
				continue;
			}

			int ans = 0, sum = 0;

			for (int j = 0; j < N; j++) {
				if (sum + A[j] > 0) {
					sum += A[j];
				} else {
					sum = 0;
				}
				ans = Math.max(ans, sum % M);
			}
			System.out.println(ans);
		}

		s.close();

	}
}
