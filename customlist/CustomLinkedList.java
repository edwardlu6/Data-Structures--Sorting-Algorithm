package customlist;

public class CustomLinkedList<E> implements ListInterface<E> {
	private Node<E> head;
	private int numItems;

	// Constructor 1: Creating an LinkedList with Dummy Head.
	// We consider that the index of Dummy Head as '-1'.
	public CustomLinkedList() { 			
		numItems = 0;
		head = new Node<>(null, null); 	//  Dummy Head (index = -1)
	}

	///////////////////////////////////////////////////////////////////////
	public String printAll() {
		Node<E> t;
		// System.out.print("Print list (#items=" + numItems + ") ");
		// for(t=head.next; t != null; t = t.next) {
		// 	System.out.print(t.item + " ");
		// }
		// System.out.println();

		String print_all = "Print list (#items=" + numItems + ") ";
		for(t=head.next; t != null; t = t.next) 
			print_all += t.item + " ";
		System.out.println(print_all);
		return print_all;

	}

	// Implementation of getNode(): Retrieving the i-th node in the list
	// If the index is -1, we consider that it as searching for the dummy head.
	// Return null if attempting to access an index that is out of bounds (exception)
	// Return the i-th node after the getNode operation in other cases

	public Node<E> getNode(int index) {
		if (index >= numItems || index < -1) {
			return null;
		}

		//Node<E> dummy = new Node<>(null); // Create a dummy node
		//dummy.next = head; // Set dummy's next to head, not altering the list itself
		Node<E> cur = head; // Start from dummy node
		for (int i = -1; i < index; i++) { // Loop allows starting from dummy (-1) to desired index
			cur = cur.next;
		}
		return cur;
	}
	
	// public Node<E> getNode(int index) {
	// 	try{
	// 		 Node<E> dummy = new Node(null);
	// 		 dummy.next = head;
	// 		 if (index == -1){
	// 		 	return dummy;
	// 		 }
	// 		 if (index < 0 || index >= numItems) {
    //          	// Index out of bounds
    //          	throw new IndexOutOfBoundsException("Index out of bounds");
    //     	 }
	// 		 Node<E> currNode = head;
	// 		 for (int i = 0; i < index; i++) {
	// 		 	currNode = currNode.next;
	// 		 }
	// 		 return currNode;
	// 		 /*
	// 		if (index >= numItems || index < -1) {
	// 			throw new IndexOutOfBoundsException("Index out of bounds");
	// 		}
	// 		//Node dummy = new Node(null);
	// 		dummy.next = head;
	// 		Node cur = dummy;
	// 		if (index == -1) {
	// 			return dummy;
	// 		}
	// 		for (int i = 0; i < index+1; i++){
	// 			cur = cur.next;
	// 		}
			
	// 		return cur;
	// 		*/
	// 	} catch(Exception exception){
	// 		System.out.println(exception.getMessage());
	// 		return null;
	// 	}
	// }
		// 	Node<E> cur = head; // Start from dummy node
		// for (int i = -1; i < index; i++) { // Loop allows starting from dummy (-1) to desired index
		// 	cur = cur.next;
		// }
		// return cur;
	
	// Implementation of add(): Inserting element x at the k-th position in the list
	// Return -1 if an exception occurs when inserting an element into the list
	// Return 0 after the add() operation in other cases
	public int add(int index, E item) {
		try{
			if (index < 0 || index > numItems) {
            	// Index out of bounds
            	throw new IndexOutOfBoundsException("Index out of bounds");
        	}
			numItems++;
			Node<E> prevNode = getNode(index-1);
			Node<E> newNode = new Node<>(item);
			newNode.next = prevNode.next;
			prevNode.next = newNode;
			return 0;
		} catch(Exception exception){
			System.out.println(exception.getMessage());
			return -1;
		}
	}
 
	// Implementation of append(): Adding an element to the end of the list
	// Return 0 after the add() operation
	public int append(E item) {
		numItems++;
		Node<E> lastNode = getNode(numItems-1);
		Node<E> newNode = new Node<>(item);
		lastNode.next = newNode;
		return 0;
	}

	// Implementation of remove(): Deleting the k-th element from the list
	// Return null if an exception occurs when deleting an element from the list
	// Return the removed element after the remove() operation in other cases
	public E remove(int index) {
		try{
			Node<E> prevNode = getNode(index);
        	Node<E> removedNode = prevNode.next;
			prevNode.next = prevNode.next.next;
			numItems--;
			return removedNode.item;

		}catch(Exception exception){
			System.out.println(exception.getMessage());
			return null;
		}
	}

	// Implementation of removeItem(): Removing element x from the list
	// Return false if element x does not exist in the list
	// Return true after the removal operation if x exists
	public boolean removeItem(E x) {
		try{
			int target = -1;
        	Node<E> currentNode = head.next;
			
			for (int i = 0; i < numItems; i++) {
				if (currentNode.item != null && currentNode.item.equals(x)) {
					target = i;
					break;
				}
				currentNode = currentNode.next;
			}
			
			if (target != -1) {
				currentNode = head;
				for (int i = 0; i < target; i++) {
					currentNode = currentNode.next;
				}
				
				currentNode.next = currentNode.next.next;
				
				numItems--;
				return true; // Removal successful
			} else {
				return false;
			}
		}catch(Exception exception){
			System.out.println(exception.getMessage());
			return false;
		}
	}

	// Implementation of get(): Retrieving the i-th element from the list
	// The first element is labeled as the 0-th element
	// Return null if attempting to access an index that is out of bounds (exception)
	// Return the element at the specified index in other cases
	public E get(int index) {
		try{
			if (index < 0 || index >= numItems) {
            	// Index out of bounds
            	throw new IndexOutOfBoundsException("Index out of bounds");
        	}
			Node<E> currentNode = head.next;
			for (int i = 0; i < index; i++) {
				currentNode = currentNode.next;
			}
			return currentNode.item;
		} catch (Exception exception){
			System.out.println(exception.getMessage());
			return null;
		}
	}

	// Implementation of set(): Replacing the i-th element in the list with x
	// Return -1 if attempting to access an index that is out of bounds (exception)
	// Return 0 after the set operation in other cases
	public int set(int index, E x) {
		try{
			if (index < 0 || index >= numItems) {
            	// Index out of bounds
            	throw new IndexOutOfBoundsException("Index out of bounds");
        	}

			Node<E> currentNode = head.next;
			for (int i = 0; i <= index; i++) {
				if (i == index){
					currentNode.item = x;
				}
				currentNode = currentNode.next;
			}
			return 0;
		} catch (Exception exception){
			System.out.println(exception.getMessage());
			return -1;
		}
		
	}

	// Implementation of indexOf(): Determining the position of element x in the list
	// Return -1 if the element does not exist in the list
	// Return the index of the element if it exists in other cases
	public int indexOf(E x) {
		try{
			Node<E> currentNode = head.next;
			for (int i = 0; i <= numItems; i++) {
				if (currentNode.item.equals(x)){
					return i;
				}
				currentNode = currentNode.next;
			}
			return -1;
		} catch(Exception exception){
			System.out.println(exception.getMessage());
			return -1;
		}
	}
	
	// Implementation of len(): Retrieving the total number of elements in the list
	// Return the total number of elements in the list
	public int len() {
		return numItems;
	}
	
	// Implementation of isEmpty(): Checking if the list is empty
	// Return true if the list is empty
	// Return false otherwise
	public boolean isEmpty() {
		Node<E> currentNode = head.next;
		for (int i = 0; i < numItems; i++){
			if (!currentNode.item.equals(null)){
				return false;
			}
			currentNode = currentNode.next;
		}
		return true;
	}

	// Implementation of clear(): Cleaning the list thoroughly
	// Empty the entire list
	public void clear() {
		head.next = null;
		numItems = 0;
		return;
	}
	
} 
