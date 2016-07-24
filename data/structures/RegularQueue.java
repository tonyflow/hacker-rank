package test.hacker.rank.data.structures;

/**
 * Regular and priority queues
 * 
 * @author niko.strongioglou
 *
 */
public class RegularQueue implements Queue {

	public String[] queue;

	public Integer rear;
	public Integer front;
	public Integer numberOfItems;

	public RegularQueue(Integer size) {
		this.queue = new String[size];
		rear = -1;
		front = 0;
		java.util.Arrays.fill(queue, "-1");
		numberOfItems = 0;
	}

	@Override
	public void insert(String element) {

		if (numberOfItems + 1 <= queue.length) {

			queue[rear + 1] = element;
			rear++;
			numberOfItems++;

		} else {
			System.out.println("Queue is full");
		}
	}

	@Override
	public String peek() {

		return queue[front];
	}

	@Override
	public String pop() {

		String toReturn = null;

		if (numberOfItems == 0) {
			System.out.println("Queue is empty");

		} else {

			toReturn = queue[front];
			front++;
		}

		return toReturn;
	}

	@Override
	public void rewind() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {

		RegularQueue myQueue = new RegularQueue(30);

		myQueue.insert("23");
		myQueue.insert("24");
		myQueue.insert("2234");
		myQueue.insert("3456");
		myQueue.insert("6875");

		System.out.println(myQueue.pop());
	}

}
