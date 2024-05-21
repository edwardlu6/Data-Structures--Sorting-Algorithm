package customsorting;

public class Sorting {

	int A[];

	public Sorting(int B[]) {
		A = B;
	}
	
	// Please write code in the given function to complete the bubble sort.
	// Utilize the 'swapped' variable to check whether any element swaps occur in the for-loop.
	// This will enable achieving the best-case time complexity of 'n'.
	// Code should be written exclusively within the designated sections. 
	// Modifying other parts of the code may result in penalties.
	public void bubbleSort() {
		int tmp = 0;
		boolean swapped = false;
		// ----------------- write your code here ----------------- //
		for (int i = 0; i < A.length-1; i++){ // Starting from the first element of the array
			swapped = false;
			for (int j = 0; j < A.length - i - 1; j++){ // find and put the largest element at the end of the array.
				if(A[j]>A[j+1]){
					int temp = A[j];
					A[j] = A[j+1];
					A[j+1] = temp;
					swapped = true;
				}
			}
			if (!swapped) {
				break;
			}
		}

		
		// -------------------------------------------------------- //
	}

	// Please complete the selection sort by writing code in the given function.
	// Implement it using the theLargest function, which finds the largest number A[k] among A[0,...,last].
	// Code should be written exclusively within the designated sections. 
	// Modifying other parts of the code may result in penalties.
	public void selectionSort() {
		int k; int tmp;
		// ----------------- write your code here ----------------- //
		for (int i = A.length-1; i > 0; i--){
			k = theLargest(i);
			tmp = A[i];
			A[i] = A[k];
			A[k] = tmp;
		}
		// -------------------------------------------------------- //
	}
	
	// Implement the theLargest function that returns the index of the largest element in the array A[0...last].
	// Code should be written exclusively within the designated sections. 
	// Modifying other parts of the code may result in penalties.
	private int theLargest(int last) {
		int largest = 0;
		// ----------------- write your code here ----------------- //
		for (int i = 1; i <= last; i++){
			if (A[largest] < A[i]){
				largest = i;
			}
		}
		// -------------------------------------------------------- //
		return largest;
	}
	
	
	// Write code in the provided function to complete the insertion sort.
	// Code should be written exclusively within the designated sections. 
	// Modifying other parts of the code may result in penalties.
	public void insertionSort() {
		// ----------------- write your code here ----------------- //
		for (int i = 1; i < A.length; i++) {
			int newItem = A[i];
			int j = i - 1;
			
			// The case when the largest element in sorted array is greater than the newItem. 
			while (j >= 0 && A[j] > newItem) {
				A[j + 1] = A[j];
				j--;
			}
			
			A[j + 1] = newItem;
		}
		// -------------------------------------------------------- //
	}
	
	// write code in the functions mSort() and merge() to complete the merge sort.
	public void mergeSort() { 
		int[] B = new int[A.length];
		mSort(0, A.length-1, B);	
	}
	
	// write code in the given function to complete the mSort() function.
	// The mSort function should be structured as follows:
	// First, calculate the midpoint between p and r.
	// Second, perform sorting on the first half.
	// Third, perform sorting on the second half.
	// Finally, merge the results using the merge() function.
	// Notably, the second and third steps should be implemented as recursive calls to mSort().
	// Code should be written exclusively within the designated sections. 
	// Modifying other parts of the code may result in penalties.
	private void mSort(int p, int r, int[] B) { 
		if (p < r) {
		// ----------------- write your code here ----------------- //
			// Divide and Conquer 分治法
			int q = (p+r)/2; // Calculate midpoint.
			mSort(p,q,B); // mSort from left to midpoint
			mSort(q+1,r,B); // mSort from midpoint to right
			merge(p,q,r,B); // merge the two subarrays

		// -------------------------------------------------------- //
		} 
	}

	// Write code in the provided function to complete the merge() function.
	// Merge the arrays A[p, ..., q] and A[q+1, ..., r] to create a sorted array A[p, ..., r]. 
	// Note that A[p, ..., q] and A[q+1, ..., r] are already sorted.
	// Code should be written exclusively within the designated sections. 
	// Modifying other parts of the code may result in penalties.
	private void merge(int p, int q, int r, int[] sortedArray) {
	// ----------------- write your code here ----------------- //
		int i = p; // left pointer
		int j = q + 1; // right pointer
		int t = p; // pointer of the sorted array

		// Compare each element in the two subarrays and put them into the sorted Array. 
		while (i <= q && j <= r) {
			// Compare the two elements, put the smaller one into the sorted array.
			if (A[i] <= A[j]) { // left side is smaller than the right side.
				sortedArray[t] = A[i]; // put the smaller element into the array
				i++; // move the left pointer
			} else { // right side is smaller than the left side
				sortedArray[t] = A[j]; // put the smaller element into the array
				j++; // move the left pointer
			}
			t++; // increment or move the pointer of the sorted array. 
		}

		// After comparing both of the arrays.
		// ------------
		// If the first subarray is longer than the second one,  we put the rest of them into sorted array.
		while (i <= q) {
			sortedArray[t] = A[i];
			i++;
			t++;
		}
	
		// If the second subarray is longer than the first one,  we put the rest of them into sorted array.
		while (j <= r) {
			sortedArray[t] = A[j];
			j++;
			t++;
		}

		// Copy all elements in the sorted array to the original array. 
		for (int k = p; k <= r; k++) {
			A[k] = sortedArray[k];
		}


	// -------------------------------------------------------- //
	}
	
	// Write code in the functions qSort() and partition() to complete the quicksort.
	public void quickSort() {
			qSort(0, A.length-1);
	}

	// Write code in the given function to complete the qSort() function.
	// The qSort function should be structured as follows:
	// First, the partition() function returns the pivot element q.
	// Second, sort the left sub-array using p and q.
	// Third, sort the right sub-array using q and r.
	// Notably, the second and third steps should be implemented as recursive calls to qSort().
	// Code should be written exclusively within the designated sections. 
	// Modifying other parts of the code may result in penalties.
	private void qSort(int p, int r) {
		if (p < r) {
		// ----------------- write your code here ----------------- //
			// Divide and Conquer 分治法
			int q = partition(p, r);
			qSort(p, q - 1);
			qSort(q + 1, r);
				
		// -------------------------------------------------------- //
		}
	}
	
	// The partition() function rearranges the elements of the array A[p, ..., r] on either side 
	// based on their relative sizes compared to the pivot element A[r]. 
	// It then returns the position where the pivot element is placed.
	// Code should be written exclusively within the designated sections. 
	// Modifying other parts of the code may result in penalties.
	private int	partition(int p, int r) {	
	// ----------------- write your code here ----------------- //
		int pivot = A[r];
		int i = p - 1;
		
		for (int j = p; j < r; j++) {
			if (A[j] <= pivot) {
				i++;
				swap(i, j);
			}
		}
		
		swap(i + 1, r);
		return i + 1;
	// -------------------------------------------------------- //
	}

	private void swap(int i, int j) {
		int temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}
	
} 
