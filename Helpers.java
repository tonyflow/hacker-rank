package test.hacker.rank;

public class Helpers {

//	public static boolean checkAdjacency(int[][] matrix,int m,int n){
//		
//		for (int i = 0; i < m; i++) {
//			for (int j = 0; j < n; j++) {
//				if (matrix[i + 1][j] == 1) { // above
//					adjList.get(i + "_" + j).add(i + 1 + "_" + j);
//				} else if (matrix[i - 1][j + 1] == 1) { // down
//					adjList.get(i + "_" + j).add(i - 1 + "_" + j + 1);
//				} else if (matrix[i][j + 1] == 1) { // right
//					adjList.get(i + "_" + j).add(i + "_" + j + 1);
//				} else if (matrix[i][j - 1] == 1) { // left
//					adjList.get(i + "_" + j).add(i + "_" + (j - 1));
//				} else if (matrix[i + 1][j + 1] == 1) { // diagonally :
//															// up and right
//					adjList.get(i + "_" + j).add(i + 1 + "_" + j);
//				} else if (matrix[i + 1][j - 1] == 1) { // diagonally :
//															// up and left
//					adjList.get(i + "_" + j).add((i + 1) + "_" + (j - 1));
//				} else if (matrix[i - 1][j + 1] == 1) { // diagonally :
//															// down and
//															// right
//					adjList.get(i + "_" + j).add((i - 1) + "_" + (j + 1));
//				} else if (matrix[i + 1][j + 1] == 1) { // diagonally :
//															// down and left
//					adjList.get(i + "_" + j).add((i + 1) + "_" + (j + 1));
//				}
//			}
//		}
//		
//		return true;
//	}
	
	public static class LomutoPartitionResult {
		private int sumOfSwaps;
		private int p;

		public LomutoPartitionResult() {
			this.sumOfSwaps = 0;
			this.p = 0;
		}

		public LomutoPartitionResult(int sumOfSwaps, int p) {
			super();
			this.sumOfSwaps = sumOfSwaps;
			this.p = p;
		}

		public int getSumOfSwaps() {
			return sumOfSwaps;
		}

		public void setSumOfSwaps(int sumOfSwaps) {
			this.sumOfSwaps = sumOfSwaps;
		}

		public int getP() {
			return p;
		}

		public void setP(int p) {
			this.p = p;
		}

	}
	
}
