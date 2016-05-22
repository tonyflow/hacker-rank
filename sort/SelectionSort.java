package test.hacker.rank.sort;

/**
 * Best: O(n^2) Average: O(n^2) Worst: O(n^2) The algorithm runs runs through
 * each element in the list repeatedly. Each time the smallest element in the
 * list is selected and placed in the front / sorted part of the list. The
 * algorithm sorts numbers in place thus the time complexity of it is O(1).
 * 
 * @author niko.strongioglou
 *
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] r = new int[] { 3, 0, 9, 4, 1 };

		selectionSort(r);

	}

	private static void selectionSort(int r[]) {

		int N = r.length;

		/*
		 * Will not iterate till last element since last element remaining
		 * should definitely be the minimum thus we will just leave it as is
		 */
		for (int i = 0; i < N; i++) {

			System.out.println("=========== Iteration " + i
					+ " ===================================");
			System.out.print("Before iteration table is : ");
			for (int k = 0; k < r.length; k++) {
				System.out.print(r[k] + " ");
			}
			System.out.println();
			System.out.println("Iterating...");
			int minIndex = i;

			for (int j = i + 1; j < N; j++) {
				if (r[j] < r[minIndex]) {
					minIndex = j;
				}
			}

			int minimum = r[minIndex];
			if (minIndex != i) {
				// swap i with minimun
				int tmp = r[i];
				r[i] = r[minIndex];
				r[minIndex] = tmp;
			}

			for (int k = 0; k < r.length; k++) {
				System.out.print(r[k] + " ");
			}
			System.out.print(" starting point was " + r[i]
					+ " while minimun found was " + minimum);
			System.out.println();

		}
	}

}
