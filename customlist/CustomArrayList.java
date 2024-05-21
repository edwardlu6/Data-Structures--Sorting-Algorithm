package customlist;

public class CustomArrayList<E> implements ListInterface<E> {

	private E item[];        
	private int numItems;
	
	private static final int DEFAULT_CAPACITY = 10;
 
	// Constructor 1: Creating an ArrayList with DEFAULT_CAPACITY.
	public CustomArrayList() { 					
		item = (E[]) new Object[DEFAULT_CAPACITY];	
		numItems = 0;
	}

	// Constructor 2: Creating an ArrayList of size n.
	public CustomArrayList(int n) {			
		item = (E[]) new Object[n];		
		numItems = 0;
	}	
	
	// Implementation of add(): Inserting element x at the k-th position in the array list
	// Return -1 if an exception occurs when inserting an element into the list
	// Return 0 after the add() operation in other cases
	public int add(int index, E x) {
		try{

			if (index < 0 || index > numItems) {
            System.out.println("Index out of bounds");
            return -1;
        	}


			for (int i = numItems - 1; i >= index; i--) {
				item[i + 1] = item[i];
			}

			item[index] = x;
			numItems++;

			return 0;
			
		} catch(Exception exception) {
			System.out.println(exception.getMessage());
			return -1;
		}
	}
	
	// Implementation of append(): Adding an element to the end of the array list
	// Return -1 if an exception occurs when inserting an element into the list
	// Return 0 after the add() operation in other cases
	public int append(E x) {
		try{
			add(numItems,x);
			return 0;
		} catch(Exception exception){
			return -1;
		}
			
			
	}
	
	// Implementation of remove(): Deleting the k-th element from the array list
	// Return null if an exception occurs when deleting an element from the list
	// Return the removed element after the remove() operation in other cases
	public E remove(int index) {
		try{
			if (index < 0 || index >= numItems) {
            	throw new IndexOutOfBoundsException("Index out of bounds");
        	}
        	E removedItem = item[index];
			for (int i = index; i < numItems-1; i++){
				item[i] = item[i + 1];
			}
			item[numItems - 1] = null;
			numItems--;
			return removedItem;
		} catch (Exception exception){
			return null;
		}
	}

	// Implementation of removeItem(): Removing element x from the array list
	// Return false if element x does not exist in the list
	// Return true after the removal operation if x exists
	public boolean removeItem(E x) {
		try {
			int target = -1;
			for (int i = 0; i < item.length; i++){
				if (item[i] != null && item[i].equals(x)){
					target = i;
					break;
				}
			}

			if (target != -1) {
				for (int i = target; i < numItems - 1; i++) {
					item[i] = item[i + 1];
				}

				item[numItems - 1] = null;

				numItems--;

				return true; // Element successfully removed
			}
			return false;

		} catch (Exception exception) {
			System.out.println(exception.getMessage());
			return false;
		}
	}

	// Implementation of get(): Retrieving the i-th element from the list
	// The first element is labeled as the 0-th element
	// Return null if attempting to access an index that is out of bounds (exception)
	// Return the element at the specified index in other cases
	public E get(int index) { 
		try {
			for (int i = 0; i < numItems; i++){
				if (item[i].equals(item[index])){
					return item[index];
				}
			}
			return null;

		} catch(Exception exception) {
			System.out.println(exception.getMessage());
			return null;
		}
	}
 
	// Implementation of set(): Replacing the i-th element in the array list with x
	// Return -1 if attempting to access an index that is out of bounds (exception)
	// Return 0 after the set operation in other cases
	public int set(int index, E x) {
		try {
			if (index < 0 || index >= numItems) {
				// Index out of bounds
				throw new IndexOutOfBoundsException("Index out of bounds");
			}

			item[index] = x;
			return 0;

		} catch(Exception exception) {
			System.out.println(exception.getMessage());
			return -1;
		}
	}
	
	// Implementation of indexOf(): Determining the position of element x in the array list
	// Return -1 if the element does not exist in the list
	// Return the index of the element if it exists in other cases
	public int indexOf(E x) {
		try {
			for (int i = 0; i < numItems; i++){
				if (item[i].equals(x)){
					return i;
				}
			}
			return -1;

		} catch(Exception exception) {
			System.out.println(exception.getMessage());
			return -1;
  }
  	}
 
	// Implementation of len(): Retrieving the total number of elements in the list
	// Return the total number of elements in the list
	public int len() {
		int count = 0;
		for (int i = 0; i < numItems; i++){
			count++;
		}
		return count;
	}


	// Implementation of isEmpty(): Checking if the list is empty
	// Return true if the list is empty
	// Return false otherwise
	public boolean isEmpty() { 
		for (int i = 0; i < numItems; i++){
			if (item[i]!=null){
				return false;
			}
		}
		return true;
	}

	// Implementation of clear(): Cleaning the list thoroughly
	// Empty the entire list
	public void clear() {
		for (int i = 0; i < numItems; i++){
			item[i] = null;
		}
		numItems = 0;
		return;
	}

	///////////////////////////////////////////////////////////////////////
	public String printAll() {
		// System.out.print("Print list (#items=" + numItems + ") ");
		// for(int i = 0; i < numItems; i++) 
		// 	System.out.print(item[i] + " ");
		String print_all = "Print list (#items=" + numItems + ") ";
		for(int i = 0; i < numItems; i++) 
			print_all += item[i] + " ";
		System.out.println(print_all);
		return print_all;
	}
} 
