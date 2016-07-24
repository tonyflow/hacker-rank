package test.hacker.rank.data.structures;

import java.util.List;

public class LinkedListMain {

	private static class LinkedList {

		public LinkedListNode first;

		public LinkedList() {
			this.first = null;
		}

		public LinkedList(LinkedListNode first) {
			this.first = first;
		}

	}

	private static class LinkedListNode {

		public String name;
		public Integer age;

		public LinkedListNode(String name, Integer age) {
			super();
			this.name = name;
			this.age = age;
		}

		

	}

	public static void main(String[] args) {

		
		LinkedList list = new LinkedList();
		
	}

}
