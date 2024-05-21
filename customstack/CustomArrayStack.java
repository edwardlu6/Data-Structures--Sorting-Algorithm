package customstack;

public class CustomArrayStack<E> implements StackInterface<E> {	
	private E stack[];
	private int topIndex;              // the top index of Stack
	private static final int DEFAULT_CAPACITY = 10; // Do not change this value
 
	// Constructor 1: Creating an ArrayStack with DEFAULT_CAPACITY.
	public CustomArrayStack() {	
		stack = (E[]) new Object[DEFAULT_CAPACITY];
		//**********************************//
		// Initialize topIndex			    //
		//**********************************//
		topIndex = -1;

	}

	// Constructor 2: Creating an ArrayStack of size n.
	public CustomArrayStack(int n) {	
		stack = (E[]) new Object[n];
		//**********************************//
		// Initialize topIndex 				//
		//**********************************//
		topIndex = -1;
	}
	
	// Implementation of push(): Inserting element x to the stack
	// Return -1 if an exception occurs when inserting an element into the stack
	// Return 0 after the push() operation in other cases
	public int push(E newItem) {
		try {
            if (topIndex < stack.length) {
                stack[topIndex+1] = newItem;
				topIndex++;
                return 0;
            } else {
                return -1; // Stack is full
            }
		} catch (Exception exception){
			return -1; 
		}
	}
	
	// Implementation of pop(): Removing an element from the queue
	// Return null if an exception occurs when removing an element from the queue
	// Return the returned element after the pop operation
	public E pop() {
		try {
			E elementToRemove = stack[topIndex];
            stack[topIndex]=null;
			topIndex--;
			return elementToRemove; 
		} catch (Exception exception){
			return null; 
		}
	}

	// Implementation of top(): getting the top element in the stack
	// Return null if an exception occurs
	// Return false otherwise
	public E top() {
		try {
			return stack[topIndex]; 
		} catch (Exception exception){
			return null; 
		}
	}
	
	// Implementation of isEmpty(): Checking if the stack is empty
	// Return true if the stack is empty
	// Return false otherwise
	public boolean isEmpty() {
		return (topIndex == 0);
	}
	
	// Implementation of isFull(): Checking if the list is full
	// Return true if the list is full
	// Return false otherwise
	public boolean isFull() {

		for (int i = 0; i < stack.length; i++){
			if (stack[i]==null){
				return false;
			}
		}
		return true;
	}
 
	// Implementation of dequeueAll(): Empty stack
	public void popAll( ) {
		topIndex = 0;
	}

	////////////////////////////////////////////
	public void printAll() {
		System.out.print("Stack from top:");
		for(int i=topIndex-1; i>=0; i--) {
			System.out.print(stack[i] + " ");
		}
		System.out.println();
	}

	public int getTopIndex() {
		return topIndex;
	}
} // 코드 6-2
