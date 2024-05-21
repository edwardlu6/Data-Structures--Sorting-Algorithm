package customstack;
import customstack.Node;

public class CustomLinkedStack<E> implements StackInterface<E> {
	private Node<E> topNode; // the top node of stack

	// Constructor 1: Creating an Linked.
	public CustomLinkedStack() {
		//**********************************//
		// Initialize topNode			    //
		//**********************************//
		topNode = null;
	}
	
	// Implementation of push(): Inserting element x to the stack
	// Return 0 after the push() operation in other cases
	public int push(E newItem) {
		// Create a new node with the given element
        Node<E> newNode = new Node<>(newItem);

        // Set the next reference of the new node to the current top node
        newNode.next = topNode;

        // Update the top node to the new node
        topNode = newNode;

        return 0;
	}
	
	// Implementation of pop(): Removing an element from the queue
	// Return null if an exception occurs when removing an element from the queue
	// Return the returned element after the pop operation
	public E pop() {
		if (isEmpty()) {
			return null; // or throw an exception indicating an empty stack
		}
	
		Node<E> removedNode = topNode;
		topNode = topNode.next;
		return removedNode.item;
	}
	
	// Implementation of top(): getting the top element in the stack
	// Return null if an exception occurs
	// Return false otherwise
	public E top() {
		try{
			return topNode.item;
		} catch(Exception exception){
			return null;
		}
	}
	
	// Implementation of isEmpty(): Checking if the stack is empty
	// Return true if the stack is empty
	// Return false otherwise
	public boolean isEmpty() {
		return (topNode == null);
	}
	
	// Implementation of dequeueAll(): Empty stack
	public void popAll() {
		try{
			topNode = null;
		} catch(NullPointerException exception){
			System.out.print(exception.getMessage());
		}

	}

	//////////////////////////////////////////////
	public void printAll() {
		Node<E> t;
		System.out.print("Stack from top: ");
		for(t=topNode; t != null; t = t.next) {
			System.out.print(t.item + " ");
		}
		System.out.println();
	}
} // 코드 6-4
