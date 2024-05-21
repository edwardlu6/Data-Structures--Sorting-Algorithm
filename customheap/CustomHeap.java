package customheap;

public class CustomHeap<E extends Comparable> implements PQInterface<E> {
	private E[] A;
	private int numItems;
	int count = 0;
	// Constructor 1: Creating an empty heap.
	public CustomHeap(int arraySize) {
		A = (E[]) new Comparable[arraySize];
		numItems = 0;
	}

	// Constructor 2: Creating a heap using the given array.
	public CustomHeap(E[] B, int numElements) {
		A = B; 
		numItems = numElements;
	}



	// Subject to Deletion---------Self-added Function for swaping elements
	/* 
	private void swap(int i, int j) {
        E temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
	*/
	// Implementation of insert(): Inserting newItem to the heap
	// You should consider using percorlateUp() function
	// Return -1 if an exception occurs when inserting newItem into the heap
	// Return 0 after the insert() operation in other cases
	public int insert(E newItem) {
	//***************Write your code in the below******************//
	try{
		
		A[numItems] = newItem;
		percolateUp(numItems);
		numItems++;
		count++;
		System.out.println(count+"Insert!");
		for (int i = 0; i < numItems; i++) {
				System.out.print(A[i] + " ");
			}
		System.out.println();
		return 0;
	} catch(ArrayIndexOutOfBoundsException exception){
		return -1;
	}
		
	//*************************************************************//
	} 

	// Implementation of percolateUp()
	// Adjust the elements starting from A[i] to satisfy the heap property
	// The elements in A[0...i-1] are already satisfying the heap property
	// You need to implement this function using a recursive approach
	private void percolateUp(int i) {
	//***************Write your code in the below******************//
		//if (i == 0) return; // Base case: root of the heap

		int parentIndex = (i - 1) / 2;
		if (i>0 && A[i].compareTo(A[parentIndex]) > 0) {
			// Swap A[i] with its parent
			E temp = A[i];
			A[i] = A[parentIndex];
			A[parentIndex] = temp;
			
			// Recursively adjust from the parent's position
			percolateUp(parentIndex);
		}
	//*************************************************************//
	}

	// Implementation of deleteMax(): Deleting a root node from the heap
	// You should consider using percolateDown() function
	// Return the maximum value if the operation is successful 
	// Return null if an exception occurs
	public E deleteMax() {
	//***************Write your code in the below******************//
		try{
			E max = A[0];
			A[0] = A[numItems-1]; // set the root to the last element
			numItems--; // decrease the size of heap
			percolateDown(0); // reordering the heap
			count++;
			System.out.println(count+"Delete!");
			for (int i = 0; i < numItems; i++) {
				System.out.print(A[i] + " ");
			}
			System.out.println();
			return max;
			
		} catch(ArrayIndexOutOfBoundsException exception){
			return null;
		}
	//*************************************************************//
	}
	
	// Implementation of percolateDown(): Inserting newItem to the heap
	// Percolating down A[i] to become the root in A[0...numItems-1]
	// You need to implement this function using a recursive approach
	private void percolateDown(int i) {
	//***************Write your code in the below******************//
		int child = 2*i+1;
		int right = 2*i+2;
		int largest = i;

		if (child < numItems && A[child].compareTo(A[largest]) > 0) {
			largest = child;
		}
		if (right < numItems && A[right].compareTo(A[largest]) > 0) {
			largest = right;
		}
		if (largest != i) {
			E temp = A[i];
			A[i] = A[largest];
			A[largest] = temp;
			percolateDown(largest); // Recursively percolate down
		}
		
		/*
		if (child <= numItems - 1){
			if (right<= numItems -1 && A[child].compareTo(A[right])<0){
				child = right;
				// child = the index of the largest element
			}
			if (A[i].compareTo(A[child])<0){
				E temp = A[i];
				A[i] = A[child];
				A[child] = temp;
				percolateDown(child);		
			}

		}
		*/
	//*************************************************************//
	}
	
	// Implementation of buildHeap():  Building a new heap
	// Note that array A[] is already initialized by a Constructor
	// You need to implement this function using percolateDown()
	public void buildHeap() {
	//***************Write your code in the below******************//
		for (int i = (numItems-1)/2; i>=0; i--){
			percolateDown(i);
		}
	//*************************************************************//
	}
	
	// Implementation of max(): Getting the maximum value from the heap
	// You should consider using percolateDown() function
	// Return the maximum value if the operation is successful 
	// Return null if an exception occurs
	public E max() {
	//***************Write your code in the below******************//
		if (numItems>0){
			count++;
			System.out.println(count+"Max!");
			for (int i = 0; i < numItems; i++) {
				System.out.print(A[i] + " ");
			}
			System.out.println();
			return A[0]; // Return the root element, which is the maximum
		}
		else{
			return null;
		}
	//*************************************************************//
	}

	// Implementation of isEmpty(): Checking if the heap is empty
	// Return true if the heap is empty
	// Return false otherwise
	public boolean isEmpty() { 
	//***************Write your code in the below******************//
		if (numItems==0)
			return true;
		else
			return false;
	//*************************************************************//
	}

	// Implementation of clear(): Clear the heap
	public void clear() {
	//***************Write your code in the below******************//
		count++;
		System.out.println(count+"Clear!");
		A = (E[]) new Comparable[A.length];
		numItems = 0;
	//*************************************************************//
    }

	//////////////////////////////////////////////////
	public String heapPrint() {
		String print_all = "Print list (#items=" + numItems + ") ";
		for(int i=0; i<=numItems-1; i++) {
			print_all += A[i] + " ";
		}
		return print_all;
	}
}  
