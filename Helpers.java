package test.hacker.rank;

public class Helpers {

	public class Point {
		private int x;
		private int y;

		public Point() {
		}

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

	}
	
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
