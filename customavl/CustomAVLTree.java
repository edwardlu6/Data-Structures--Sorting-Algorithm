package customavl;

import java.util.List;
import java.util.ArrayList;

public class CustomAVLTree implements IndexInterface<AVLNode>{
	private AVLNode root;

	// NIL is a special node in AVLTree that represents a NULL node with null values for item, right, and left attributes. 
	// However, it has a height of 0. 
	// This node is typically used as the root node for an empty tree or as a leaf node. 
	// In AVLTree implementation, we need to use this node as a leaf node or the root node for an empty node, 
	// because setting a leaf node as null (not a NULL node) would prevent us from calculating the height of its parent node.
	static final AVLNode NIL = new AVLNode(null, null, null, 0);

	public List<Comparable> tree_print;
	
	// Constructor 1: Creating an empty AVLTree.
	public CustomAVLTree() {
 		root = NIL;
 	} 
 
	// Implementation of search(): Searching searchKey in the AVLTree
 	public AVLNode search(Comparable x) {
 		return searchItem(root, x);
 	}

	// Implement the searchItem function using the searchItem function recursively.
	// Perform a recursive search on the left and right subtrees based on key value comparisons.
	// Return null if the search fails.
	// If the search is successful, return the corresponding node.
 	private AVLNode searchItem(AVLNode tNode, Comparable x) {
	//***************Write your code in the below******************//
		    // First check if the current node is NIL, which indicates the end of the search path
			if (tNode == NIL) {
				return NIL; // Return NIL if no matching node is found along this path
			}
		
			int compareResult = x.compareTo(tNode.item);
			
			if (compareResult < 0) {
				// If x is less than the node's item, search in the left subtree
				return searchItem(tNode.left, x);
			} else if (compareResult > 0) {
				// If x is greater than the node's item, search in the right subtree
				return searchItem(tNode.right, x);
			} else {
				// If x equals the node's item, return the current node as the search result
				return tNode;
			}
	//*************************************************************//
 	} 
  
	// Implementation of insert(): Inserting a node with newKey into the AVLTree
 	public void insert(Comparable x) {
	//***************Write your code in the below******************//
		root = insertItem(root, x);
	//*************************************************************//
 	}
 
	// Implement the insertItem function using the insertItem function recursively.
	// Perform a recursive search on the left and right subtrees based on key value comparisons.
	// When reaching a leaf node (or it is empty tree), create a new node and return that node.
	// Followings steps should be additionally considered for AVLTree.
	// 1) Upon adding a node, it's crucial to recalculate the height of certain nodes.
	// 2) Furthermore, this function needs to assess whether the subtree rooted at tNode is balanced or not.
 	private AVLNode insertItem(AVLNode tNode, Comparable x) {
	//***************Write your code in the below******************//
		if (tNode == NIL) {  // Check if the current node is the NIL node or contains a null item
			AVLNode newNode = new AVLNode(x,NIL,NIL,1); // Assuming height starts at 1 for new nodes
			return newNode;
		}  else if (x.compareTo(tNode.item)<0){ // new item is smaller than root node
			tNode.left = insertItem(tNode.left,x);
			tNode.height = 1 + Math.max(getHeight(tNode.right), getHeight(tNode.left)); // increase the root node's height
			int type = needBalance(tNode); // check if the tree needs balance
			if (type!=NO_NEED){
				tNode = balanceAVL(tNode, type);
			}
			return tNode;
		} else { // new item is greater than root node
			tNode.right = insertItem(tNode.right, x);
			tNode.height = 1 + Math.max(getHeight(tNode.right), getHeight(tNode.left));
			int type = needBalance(tNode);
			if (type!=NO_NEED){
				tNode = balanceAVL(tNode, type);
			}
			return tNode;
		}
	//*************************************************************//
 	} 
 	
	// Implementation of delete(): Deleting a node with searchKey from the AVLTree
 	public void delete(Comparable x) {
	//***************Write your code in the below******************//
		root = deleteItem(root, x);
	//*************************************************************//
 	}
	
	// Implement the deleteItem function using the deleteItem function recursively.
	// Perform a recursive search on the left and right subtrees based on key value comparisons.
	// Return null if the search fails.
	// If the search is successful, call deleteNode function.
	// Finally, deleteItem return the root node after recursive calls.
	// Followings steps should be additionally considered.
	// Followings steps should be additionally considered for AVLTree.
	// 1) Upon deleting a node, it's crucial to recalculate the height of certain nodes.
	// 2) Furthermore, this function needs to assess whether the subtree rooted at tNode is balanced or not.
	private AVLNode deleteItem(AVLNode tNode, Comparable x) {
		if (tNode == NIL) {
			return NIL;  // Base case: key not found, return NIL.
		}

		// Determine whether to search to the left or right.
		if (x.compareTo(tNode.item) < 0) {
			tNode.left = deleteItem(tNode.left, x);  // Search in the left subtree.
		} else if (x.compareTo(tNode.item) > 0) {
			tNode.right = deleteItem(tNode.right, x);  // Search in the right subtree.
		} else {
			// Node to delete found.
			tNode = deleteNode(tNode);
		}

		// Only update height and balance if tNode isn't NIL (which means the node was deleted).
		if (tNode != NIL) {
			updateHeight(tNode);
			return balanceTree(tNode);  // Balance the tree and return the new parent node.
		}
		return tNode;
	}

	private AVLNode balanceTree(AVLNode node) {
		int balanceFactor = getHeight(node.left) - getHeight(node.right);
		if (balanceFactor > 1) {
			// Left heavy situation: Check if left-right heavy to perform double rotation
			if (getHeight(node.left.right) > getHeight(node.left.left)) {
				node.left = rotateLeft(node.left);
			}
			node = rotateRight(node);
		} else if (balanceFactor < -1) {
			// Right heavy situation: Check if right-left heavy to perform double rotation
			if (getHeight(node.right.left) > getHeight(node.right.right)) {
				node.right = rotateRight(node.right);
			}
			node = rotateLeft(node);
		}
		return node;
	}
	
	private AVLNode rotateRight(AVLNode y) {
		AVLNode x = y.left;
		AVLNode T2 = x.right;
		x.right = y;
		y.left = T2;
		updateHeight(y);
		updateHeight(x);
		return x;
	}

	private AVLNode rotateLeft(AVLNode x) {
		AVLNode y = x.right;
		AVLNode T2 = y.left;
		y.left = x;
		x.right = T2;
		updateHeight(x);
		updateHeight(y);
		return y;
	}



 	
	// To implement deleteNode, consider three cases
	// 1. if tNode is a leaf node
	// 2. if tNode has only one child node.
	// 3. if tNode has two child nodes.
	// For the case 3, call deleteMinItem function to delete the node which has two child nodes.
	// Followings steps should be additionally considered for AVLTree.
	// 1) Upon deleting a node, it's crucial to recalculate the height of certain nodes.
	// 2) Furthermore, this function needs to assess whether the subtree rooted at tNode is balanced or not.
 	private AVLNode deleteNode(AVLNode tNode){
	//***************Write your code in the below******************//
		if (tNode.left == NIL && tNode.right == NIL){
			return NIL; // Case 1
		} else if (tNode.left ==  NIL){
			return tNode.right; // Case 2 (has left child)
		} else if (tNode.right == NIL){
			return tNode.left; // Case 2 (has right child)
		} else{ // Case 3 (has two childs)
			returnPair newPair = deleteMinItem(tNode.right);
			tNode.item = newPair.item;
			tNode.right = newPair.node;
			tNode.height = 1 + Math.max(tNode.right.height, tNode.left.height);
			int type = needBalance(tNode);
			if (type != NO_NEED){
				tNode = balanceAVL(tNode, type);
			}
			return tNode;
		}
	//*************************************************************//
 	}
 	 
	// Implement the deleteMinItem function using the returnPair function below
	// Implement the deleteMinItem function using the deleteminItem function recursively.
	// Refer to the pseudo code on the lecture slide.
	// Followings steps should be additionally considered for AVLTree.
	// 1) Upon deleting a node, it's crucial to recalculate the height of certain nodes.
	// 2) Furthermore, this function needs to assess whether the subtree rooted at tNode is balanced or not.
 	private returnPair deleteMinItem(AVLNode tNode) {
	//***************Write your code in the below******************//
		if (tNode.left == NIL) {
    		// This is the minimum node
    		return new returnPair(tNode.item, tNode.right);
		} else{
			// Find the minimum node recursively
			returnPair newPair = deleteMinItem(tNode.left);
			// 'minItem' is the minimum element (tNode.left node's key)
			// 'node' is the root node of the right subtree of tNdoe.left node. 

			// set the right subtree of tNode.left node to the left subtree of it
			tNode.left = newPair.node;

			tNode.height = 1 + Math.max(getHeight(tNode.right),getHeight(tNode.left));

			int type = needBalance(tNode);
			if (type != NO_NEED){
				tNode = balanceAVL(tNode, type);
			}
			return new returnPair(newPair.item, tNode);

		}
	//*************************************************************//
 	}
 	
 	private class returnPair {
 		private Comparable item;
 		private AVLNode node;
 		private returnPair(Comparable it, AVLNode nd) {
 			item = it;
 			node = nd;
 		}
 	}

 	// Implementation of balanceAVL()
	// This function addresses the four cases of imbalance in a subtree with node t as the root.
	// You must implement a solution for each case using the rightRotate or leftRotate functions.
 	private AVLNode balanceAVL(AVLNode tNode, int type) {
	//***************Write your code in the below******************//
	    if (tNode == NIL) {
        	return NIL;  // No action needed if the node is NIL
    	}
		switch (type) {
			case LL:
				return rightRotate(tNode);
			case LR:
				tNode.left = leftRotate(tNode.left);  // First rotate left on the left child
            	return rightRotate(tNode);  // Then rotate right on the current node
			case RR:
				return leftRotate(tNode);
			case RL:
				tNode.right = rightRotate(tNode.right);  // First rotate right on the right child
            	return leftRotate(tNode);  // Then rotate left on the current node
			default:
				return tNode;
		}
	//*************************************************************//
 	}
 	
	// Implementation of leftRotate()
	private AVLNode leftRotate(AVLNode t) {
		//***************Write your code in the below******************//
		if (t == NIL || t.right == NIL) {
				return t;  // Guard against rotation where there is no left child to rotate around
		}
		// t is the pivot node for rotation
		AVLNode RChild = t.right;
		AVLNode RLChild = RChild.left;

		RChild.left = t;
		t.right = RLChild;

		updateHeight(t);
    	updateHeight(RChild);

		return RChild;
		//*************************************************************//
	}
		
	// Implementation of rightRotate()
	private AVLNode rightRotate(AVLNode t) {
		//***************Write your code in the below******************//
		if (t == NIL || t.left == NIL) {
				return t;  // Guard against rotation where there is no left child to rotate around
		}
		// t is the pivot node for rotation
		AVLNode LChild = t.left;
		AVLNode LRChild = LChild.right;

		LChild.right = t;
		t.left = LRChild;

		updateHeight(t);
    	updateHeight(LChild);

		return LChild;
		//*************************************************************//
	}
	
	private void updateHeight(AVLNode node) {
		int oldHeight = node.height;
		node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
		System.out.println("Updated height for node with item: " + node.item + " from " + oldHeight + " to " + node.height);
	}

	 private int getHeight(AVLNode node) {
		if (node == null || node == NIL) {
			return 0; // Assuming height of NIL and null nodes is 0
		}
		return node.height;
	}
 
	// Static variables on the types of imbalance
 	private final int LL = 1, LR =2, RR = 3, RL = 4, NO_NEED = 0, ILLEGAL = -1;
	
	// Implementation of needBalance()
	// This function determines the type of imbalance for a given node t.
	// There are four cases of imbalance in a subtree with node t as the root.
	// The function returns one of the static variables: 'LL, LR, RR, RL, NO_NEED, ILLEGAL', as described above.
 	private int needBalance(AVLNode t) {
	//***************Write your code in the below******************//
		int leftHeight = getHeight(t.left);
		int rightHeight = getHeight(t.right);
		int balanceFactor = leftHeight - rightHeight;

		if (balanceFactor > 1) {  // More nodes in left subtree
			if (getHeight(t.left.left) >= getHeight(t.left.right)) {
				return LL;  // Left-Left case
			} else {
				return LR;  // Left-Right case
			}
		} else if (balanceFactor < -1) {  // More nodes in right subtree
			if (getHeight(t.right.right) >= getHeight(t.right.left)) {
				return RR;  // Right-Right case
			} else {
				return RL;  // Right-Left case
			}
		}
		return NO_NEED;  // Tree is either balanced or within allowable imbalance
	//*************************************************************//
 	}
 	
	// Implementation of isEmpty(): Checking if the AVLTree is empty
	// Return true if the AVLTree is empty
	// Return false otherwise
 	public boolean isEmpty() {
	//***************Write your code in the below******************//
		return root == NIL;  // Checks if the root is the NIL node, indicating the tree is empty
	//*************************************************************//
 	}
 
	// Implementation of clear(): Clear the AVLTree
 	public void clear() {
	//***************Write your code in the below******************//
		root = NIL;
	//*************************************************************//
 	 }

	private Comparable getItem(AVLNode node) {
		if (node == null || node == NIL) {
			return null; 
		}
		return node.item;
	}

	/////////////////////////////////////////////////////
	
	public List printPreOrderKey() {
		tree_print = new ArrayList<Comparable>();
		prPreOrderKey(root);
		return tree_print;
	}
	public void prPreOrderKey(AVLNode tNode) {
		if (tNode == null){
			System.out.print("Spotted!");
		} else if (tNode != NIL) {
			//System.out.println(tNode.key);
			tree_print.add(getItem(tNode));
			prPreOrderKey(tNode.left);
			prPreOrderKey(tNode.right);
		}	


	}
	public List printPreOrderHeight() {
		tree_print = new ArrayList<Comparable>();
		prPreOrderHeight(root);
		return tree_print;
	}
	public void prPreOrderHeight(AVLNode tNode) {
		if (tNode == null){
			System.out.print("Spotted!");
		} else if (tNode != NIL) {
			// System.out.println(tNode.key);
			tree_print.add(getHeight(tNode));
			prPreOrderHeight(tNode.left);
			prPreOrderHeight(tNode.right);
		}


	}
} 



