package org.binvin.samples.immutableq.core;

public class ImmutableQueue<T> implements Queue<T> {


	private Node list, head, tail;
	private ImmutableQueue() { // empty Q
	}

	private ImmutableQueue(Node list) {
		this.list = list;
	}

	public Queue<T> deQueue() {
		
		if(isEmpty() || tail.next == null )
			return new ImmutableQueue<T>();
		else {
			
			list = head.previous;
			list.next = null;
			head = list;
			
			return new ImmutableQueue<T>(list);
		}

	}

	public T head() {
		return head.t;
	}

	public boolean isEmpty() {
		return list == null;
	}

	public Queue<T> enQueue(T t) {

		Node newNode = new Node(t);
		tail = newNode;	
		
		if (isEmpty()) {
			head = newNode;
		}
		else {
			newNode.next = list;
			list.previous = newNode;
		}
		
		list = newNode;
		return new ImmutableQueue<T>(list);
	}

	
	 // Method to print the LinkedList. 
    public  void printList(ImmutableQueue<T> list) 
    { 
        Node currNode = list.tail; 
   
        System.out.println(" list.head: "+ list.head.t); 
        System.out.println(" list.tail: "+ list.tail.t); 
   
        // Traverse through the LinkedList 
        while (currNode != null) { 
            // Print the data at current node 
            System.out.print(currNode.t + " "); 
   
            // Go to next node 
            currNode = currNode.next; 
        } 
    } 
	
	class Node {
		
		Node next;
		Node previous;
		T t;

		Node(T t) {
			this.t = t;
		}
		
		
		  public void toSTring() { System.out.println(" "+t); }
		 

	}
	
	public static void main(String[] S) {
		
		ImmutableQueue<Integer> q = new ImmutableQueue<Integer>();
		q.enQueue(1);
		q.enQueue(2);
		q.enQueue(3);
		q.enQueue(4);
		q.deQueue();
		q.deQueue();
		q.deQueue();
		q.printList(q);
		
	}
	

}
