package customhash;

public class CustomChainedHashTable implements IndexInterface_list {	
	// Note that our hash table is implemented as Integer LinkedList using LinkList class
	private LinkedList<Integer>[] table;
	int numItems = 0;

	//This is global variable representing NOT_FOUND. 
	// Please use it directly in your function implementation.
	public final int NOT_FOUND = -12345, DELETED = -12345;
	
	// Constructor 1: Creating an empty linked hash table with the size of n.
	public CustomChainedHashTable(int n) {
		table = (LinkedList<Integer>[]) new LinkedList[n]; 
		for (int i = 0; i < n; i++)
			table[i] = new LinkedList<>();
		numItems = 0;
	} 
	
	// Hash function: we only considr this hash function for implementation
	// Please do not modify this function
	// below is the hash function of h(x) = x % m, where m is the size of hash table
	private int hash(Integer x) {                         
		return x % table.length; 
	}
	
	// Implementation of insert(): Inserting a key value with x into the hash table
	// If there is space in the hash table, use the hash function to obtain the hash value 
	// and store 'x' at the appropriate position in the hash table.
	// Consider to use add() operation in LinkList
	public void insert(Integer x) {	
	//***************Write your code in the below******************//
		int index = hash(x);
		table[index].add(0, x);  // Insert x at the beginning of the list at index 'index'
		numItems++;
	//*************************************************************//
	}
	
	// Implementation of search(): Searching a key value with x from the hash table
	// If the key value being searched for does not exist in the hash table, return null.
	// If it does exist, return the index where the key value is located.
	// To get the index of node with x in LinkedList, consider to use indexof() function.
	// To get the value of node with x, consider to use getNode() function
	public Node search(Integer x) {
	//***************Write your code in the below******************//
		int index = hash(x);
		LinkedList<Integer> list = table[index];
		int position = list.indexOf(x);

		if (position != NOT_FOUND) {
			return list.getNode(position);
		} else {
			return null;
		}
	//*************************************************************//
	}
	
	// Implementation of delete(): Deleteting a key value with x from the hash table
	// If the key value 'x' exists in the hash table, delete it.
	// Don't forget to store the global variable DELETED in the position 
	// where it was deleted to indicate that it has been removed.
	public void delete(Integer x) {
	//***************Write your code in the below******************//
		int index = hash(x);
		LinkedList<Integer> list = table[index];
		int position = list.indexOf(x);
		
		if (position != NOT_FOUND) {
			list.removeItem(x);
			list.add(position, DELETED); // Insert DELETED at the position where x was removed
		}
	//*************************************************************//
	}
	
	// Implementation of isEmpty(): check whether the hash table is empty
	public boolean isEmpty() {
	//***************Write your code in the below******************//
		for (int i = 0; i < table.length; i++){
			if (!table[i].isEmpty()){
				return false;
			}
		}
		return true;
	//*************************************************************//
	}
	
	// Implementation of clear(): Clear the hash table
	public void clear() {
	//***************Write your code in the below******************//
		for (int i = 0; i < table.length; i++) {
        	table[i].clear();  // Clear each linked list
    	}
    	numItems = 0;
	//*************************************************************//
	}

	//////////////////////////////////////////////

	public void printAll() {
		for (int i=0; i < table.length; i++) {
			System.out.print("Slot " + i + " : ");
			table[i].printAll();
		}
	}
} // 코드 12-1
