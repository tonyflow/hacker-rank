package test.hacker.rank.sort;

public class InsertionSort {

	public static void main(String[] args) {

		int[] r = new int[] { 5, 4, 6, 3, 7, 2, 8, 0 };
		insertionSort(r);
		System.out.println();
		System.out.print("After sort result : ");
		for (int k = 0; k < r.length; k++) {
			System.out.print(r[k] + " ");
		}
		System.out.println();

	}

	private static void insertionSort(int[] r) {

		for (int i = 1; i < r.length; i++) {

			System.out.println("=========== Iteration " + i
					+ " ===================================");
			System.out.print("Before iteration table is : ");
			for (int k = 0; k < r.length; k++) {
				System.out.print(r[k] + " ");
			}
			System.out.println();
			int key = r[i];
			System.out.println("Iterating with key " + key + "...");

			int j = i - 1;
			while (j >= 0 && r[j] > key) {
				System.out.println("Shifting element " + r[j]);
				r[j + 1] = r[j];
				// should swap elements
				System.out.print("After shift table is : ");
				for (int k = 0; k < r.length; k++) {
					System.out.print(r[k] + " ");
				}
				System.out.println();
				j--;
			}
			r[j + 1] = key;
		}
	}
}
