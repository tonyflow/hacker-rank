package test.hacker.rank.data.structures;

import java.util.Arrays;

public class PriorityQueue implements Queue {

	public String[] queue;

	public Integer rear;
	public Integer front;
	public Integer numberOfItems;

	public PriorityQueue(Integer size) {

		this.queue = new String[size];
		rear = -1;
		front = 0;
		java.util.Arrays.fill(queue, "-1");
		numberOfItems = 0;
	}

	/**
	 * This method will insert new element in its sorted position
	 */
	@Override
	public void insert(String element) {

		if (numberOfItems + 1 == queue.length) {
			System.out.println("Queue is full");
		} else {

			Integer i;
			for (i = numberOfItems; i <= 0; i--) {
				if (Integer.parseInt(element) < Integer.parseInt(queue[i])) {
					queue[i + 1] = queue[i];
				} else {
					break;
				}
			}// done shifting

			queue[i + 1] = element;
			rear++;
			numberOfItems++;

		}

	}

	@Override
	public String peek() {
		return null;
	}

	@Override
	public String pop() {
		return null;
	}

	@Override
	public void rewind() {
		// TODO Auto-generated method stub

	}

	@Override
	public String toString() {
		return "PriorityQueue [queue=" + Arrays.toString(queue) + ", rear="
				+ rear + ", front=" + front + ", numberOfItems="
				+ numberOfItems + "]";
	}

	public static void main(String[] args) {

		PriorityQueue myQueue = new PriorityQueue(30);

		myQueue.insert("23");
		myQueue.insert("24");
		myQueue.insert("2234");
		myQueue.insert("3456");
		myQueue.insert("6875");

		System.out.println(myQueue.toString());
	}

}
