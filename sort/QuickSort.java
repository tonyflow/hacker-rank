package test.hacker.rank.sort;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Arrays.toString;
import static java.util.Arrays.copyOfRange;

import org.apache.commons.lang3.time.StopWatch;

/**
 * Worst case : O(n^2) Average case : O(nlog(n)) Best case : O(nlog(n))
 * 
 */
public class QuickSort {

	private static AtomicInteger numberOfPartition = new AtomicInteger(0);

	public static void main(String[] args) {

		int[] A = new int[] { 3, 7, 8, 5, 2, 1, 9, 5, 4 };
		StopWatch timer = new StopWatch();
		timer.start();
		quickSort(A, 0, A.length - 1);
		timer.stop();
		System.out.println("After quick sort : " + Arrays.toString(A));
		System.out.println("Quick sort (including I/O) took : "
				+ timer.getNanoTime() / Math.pow(10, 9));

	}

	private static void quickSort(int[] A, int low, int high) {
		if (high > low) {
			int p = lomutoPartition(A, low, high);
			quickSort(A, low, p - 1);
			quickSort(A, p + 1, high);
		}
	}

	private static int lomutoPartition(int[] A, int low, int high) {

		int i = low;
		int pivot = A[high];

		System.out
				.println("============================================================================");
		System.out.println("Handling subarray "
				+ Arrays.toString(copyOfRange(A, low, high + 1)));
		System.out.println("Inside partition number "
				+ numberOfPartition.getAndIncrement() + " where low = " + low
				+ " and high = " + high);
		System.out.println("Pivot element is element residing on index " + high
				+ " with value " + A[high]);

		for (int j = low; j < high; j++) {
			System.out.println("------------------------------ " + j
					+ " --------------------------------------");
			if (A[j] <= pivot) {
				System.out.println("Swapping elements : " + A[i] + " and "
						+ A[j] + " because ( " + A[j] + " <= " + pivot + " )");
				int tmp = A[j];
				A[j] = A[i];
				A[i] = tmp;

				System.out.println("After swap array is : "
						+ Arrays.toString(A));
				i++;
				System.out.println("i was incremented to " + i);
			} else {
				System.out.println(" ( " + A[j] + " > " + pivot + " )");
			}

		}

		System.out
				.println("Loop ended... Swapping pivot element with element at last value of index i");
		int tmp = A[high];
		A[high] = A[i];
		A[i] = tmp;
		System.out.println("After swap array is : " + Arrays.toString(A));
		System.out.println("Partition index is " + i);

		return i;
	}
}
