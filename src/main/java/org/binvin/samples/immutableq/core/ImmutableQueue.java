package org.binvin.samples.immutableq.core;

public class ImmutableQueue<T> implements Queue<T> {

	private Node list, head, tail;

	public ImmutableQueue() { // empty Q
	}

	private ImmutableQueue(Node list, Node head, Node tail) {
		this.list = list;
		this.head = head;
		this.tail = tail;
	}

	public Queue<T> deQueue() {

		if (isEmpty() || tail.next == null)
			return new ImmutableQueue<T>();
		else {

			list = head.previous;
			list.next = null;
			head = list;

			return new ImmutableQueue<T>(list, head, tail);
		}

	}

	public T head() {

		return head == null ? null : head.t;
	}

	public boolean isEmpty() {
		return list == null;
	}

	public Queue<T> enQueue(T t) {

		Node newNode = new Node(t);
		tail = newNode;

		if (isEmpty()) {
			head = newNode;
		} else {
			newNode.next = list;
			list.previous = newNode;
		}

		list = newNode;
		return new ImmutableQueue<T>(list, head, tail);

	}


	class Node {

		Node next;
		Node previous;
		T t;

		Node(T t) {
			this.t = t;
		}
	}

}
