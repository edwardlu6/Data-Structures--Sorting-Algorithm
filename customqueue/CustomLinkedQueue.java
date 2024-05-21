package customqueue;
import customqueue.Node;

public class CustomLinkedQueue<E> implements QueueInterface<E>{
	private Node<E> tail;

	// Constructor 1: Creating an LinkedQueue.
	public CustomLinkedQueue( ) {
		//**********************************//
		// 			Initialize tail 		//
		//**********************************//
		tail = null;
	}
 
	// Implementation of enqueue(): Inserting element x to the queue
	// Return -1 if an exception occurs when inserting an element into the queue
	// Return 0 after the enqueue() operation in other cases
	public int enqueue(E newItem) {
		try {
			Node<E> newNode = new Node<>(newItem);
			if (isEmpty()){
				tail = newNode;
				tail.next = tail;
			} else{
				newNode.next = tail.next;
				tail.next = newNode;
				tail = newNode;
			}
			return 0;
		} catch(Exception exception){
			return -1;
		}
	}
		
	// Implementation of dequeue(): Removing an element from the queue
	// Return null if an exception occurs when removing an element from the queue
	// Return the removed element after the dequeue operation
	public E dequeue( ) {
		if (isEmpty()) {
			return null;
		}
		E removedItem;
		if (tail == tail.next) {
			removedItem = tail.item;
			tail = null;
		} else {
			Node<E> head = tail.next;
			removedItem = head.item;
			tail.next = head.next;
		}
		return removedItem;
	}
		
	// Implementation of front(): getting the front element in the queue
	// Return null if an exception occurs
	// Return  otherwise
	public E front() {
		try {
			return tail.next.item;
		} catch(Exception exception){
			return null;
		}
	}
		
	// Implementation of isEmpty(): Checking if the queue is empty
	// Return true if the queue is empty
	// Return false otherwise
	public boolean isEmpty() {
		return (tail == null);
	}
		 
	// Implementation of dequeueAll(): Empty queue
	public void dequeueAll ( ) {
		try{
			while (tail!=null){
			tail = null;
			tail = tail.next;
			}
		} catch (NullPointerException exception){
			System.out.println(exception.getMessage());
		}
		
	} 
	
	/////////////////////////////////////////////////////
	public void printAll() {
		Node<E> t = tail;
		System.out.println("Queue from front to tail");
		if (!isEmpty()) 
			do {
				t = t.next;
				System.out.println(t.item);
			} while (t != tail);
		else System.out.println("Empty Queue!");
	}
} 
