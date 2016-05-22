package test.hacker.rank.sort;

/**
 * Algorithm passes through the list repeatedly, compares adjacent elements
 * swaps them if they are in the wrong order. By doing so it creates two areas :
 * a sorted and an unsorted one. The algorithm sorts elements in place making
 * its time complexity O(1).
 * 
 * Best: O(n) //sorted array Average : O(n) Worst: O(n^2) //
 * 
 * @author niko.strongioglou
 *
 */
public class BubbleSort {

	public static void main(String[] args) {

		int[] r = new int[] { 3, 8, 5, 2, 7 };
		bubbleSort(r);
		for (int i = 0; i < r.length; i++) {
			System.out.print(r[i] + " ");
		}
	}

	private static void bubbleSort(int[] r) {

		for (int i = 0; i < r.length; i++) {
			for (int j = 1; j < (r.length - i); j++) {
				if (r[j - 1] > r[j]) {
					int tmp = r[j - 1];
					r[j - 1] = r[j];
					r[j] = tmp;
				}
			}
		}

	}
}
