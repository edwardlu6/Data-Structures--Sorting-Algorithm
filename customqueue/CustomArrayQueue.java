package customqueue;

public class CustomArrayQueue<E> implements QueueInterface<E> {

	private E[] queue;
	private int front, tail, numItems;
	private static final int DEFAULT_CAPACITY = 10; // Do not change this value

	// Constructor 1: Creating an ArrayQueue with DEFAULT_CAPACITY.
	public CustomArrayQueue() { 
		queue = (E[]) new Object[DEFAULT_CAPACITY];
		//**********************************//
		// Initialize front, tail, numItems //
		//**********************************//
        front = 0;
        tail = DEFAULT_CAPACITY - 1;
        numItems = 0;
	}

	// Constructor 2: Creating an ArrayQueue of size n.
	public CustomArrayQueue(int n) { 
		queue = (E[]) new Object[n];
		//**********************************//
		// Initialize front, tail, numItems //
		//**********************************//
		front = 0;
        tail = n - 1;
        numItems = 0;
	}

	// Implementation of enqueue(): Inserting element x to the queue
	// Return -1 if an exception occurs when inserting an element into the queue
	// Return 0 after the enqueue() operation in other cases
	public int enqueue(E newItem) {
		try{
			numItems++;
			queue[numItems-1] = newItem;
			tail = numItems-1;
			return 0;
		} catch(Exception exception){
			return -1;
		}
	}

	// Implementation of isFull(): Checking if the list is full
	// Return true if the list is full
	// Return false otherwise
	public boolean isFull() {
		for (int i = 0; i <queue.length;i++){
			if (queue[i]==null){
				return false;
			}
		}
		return true;
	}
 
	// Implementation of dequeue(): Removing an element from the queue
	// Return null if an exception occurs when removing an element from the queue
	// Return the returned element after the dequeue operation
	public E dequeue() {
		// Exception
		if (isEmpty()) {
			return null;
		}
		E removed = queue[front];
		queue[front] = null;
		front = (front + 1) % queue.length;
		numItems--;
		return removed;
	}

	// Implementation of front(): getting the front element in the queue
	// Return null if an exception occurs
	// Return false otherwise
	public E front() {
		try{
			return queue[front];
		} catch(Exception exception){
			return null;
		}
	}

	// Implementation of isEmpty(): Checking if the queue is empty
	// Return true if the queue is empty
	// Return false otherwise
	public boolean isEmpty( ) {
		for (int i = 0; i<queue.length; i++){
			if (queue[i] != null){
				return false;
			}
		}
		return true;
	}

	// Implementation of dequeueAll(): Empty queue
	public void dequeueAll ( ) {
		for (int i = 0; i<queue.length; i++){
			queue[i] = null;
		}
	}

	//////////////////////////////////////////////////////////////////
	public void printAll() {
		int j = front;
		System.out.print("PrintAll: ");
		for(int i = 0; i < numItems; i++) {
			System.out.print(queue[j] + " ");
			j = (j+1) % queue.length;
		}
		System.out.println();
	}
}  
