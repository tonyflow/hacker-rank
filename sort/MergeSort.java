package test.hacker.rank.sort;

import java.util.Arrays;

import org.apache.commons.lang3.time.StopWatch;

public class MergeSort {

	public static void main(String[] args) throws InterruptedException {

		StopWatch timer = new StopWatch();
		timer.start();

		int[] A = new int[] { 4, 2, 6, 1, 8, 5, 7, 3 };
		mergeSort(A);

		System.out.print("Arrays after merge sort is :: [ ");
		for (int i = 0; i < A.length; i++) {
			System.out.print(A[i] + " ");
		}
		System.out.print("]");
		System.out.println();
		timer.stop();
		System.out.println("Test took :: " + timer.getNanoTime());
	}

	/**
	 * p <= q < r . The procedure assumes that arrays A[p:q],A[q+1:r]. It merges
	 * them together to form a single sorted subarray which replaces the current
	 * subarray A[p:r]
	 * 
	 * @param A
	 * @param p
	 * @param q
	 * @param r
	 */
	private static void merge(int[] A, int[] L, int[] R) {
		System.out
				.println("======================================================");
		System.out.println(Thread.currentThread() + " :: Merging : "
				+ Arrays.toString(L) + " and " + Arrays.toString(R)
				+ " back into " + Arrays.toString(A));
		int i = 0; // index of L
		int j = 0; // index of R
		int k = 0; // index of A
		while (i < L.length && j < R.length) {
			if (L[i] < R[j]) {
				A[k] = L[i];
				i++;
			} else {
				A[k] = R[j];
				j++;
			}
			k++;
		}
		// on completion of previous loop one of two sub-arrays will be fully
		// traversed, consequently we should add to initial array the
		// remaining
		// sorted element from the one sub-array which was not fully traversed
		while (i < L.length) {
			A[k] = L[i];
			i++;
			k++;
		}
		while (j < R.length) {
			A[k] = R[j];
			j++;
			k++;
		}
		System.out
				.println("======================================================");
	}

	private static void mergeSort(int[] A) {

		if (A.length < 2) {
			return;
		}
		// divide initial array to left and right subarrays
		int mid = A.length / 2;
		int[] left = createLeftSubarray(A, mid);
		int[] right = createRightSubarray(A, mid);

		mergeSort(left);
		mergeSort(right);
		merge(A, left, right);
	}

	private static int[] createRightSubarray(int[] A, int mid) {
		int[] right = new int[A.length - mid];
		for (int i = mid; i < A.length; i++) {
			right[i - mid] = A[i];
		}
		System.out.println(Thread.currentThread() + " :: Created : "
				+ Arrays.toString(right));
		return right;
	}

	private static int[] createLeftSubarray(int[] A, int mid) {
		int[] left = new int[mid];
		for (int i = 0; i < mid; i++) {
			left[i] = A[i];
		}
		System.out.println(Thread.currentThread() + " :: Created : "
				+ Arrays.toString(left));
		return left;
	}

}
