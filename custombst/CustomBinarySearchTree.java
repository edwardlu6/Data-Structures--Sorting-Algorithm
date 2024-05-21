package custombst;

import java.util.List;
import java.util.ArrayList;

public class CustomBinarySearchTree implements IndexInterface<TreeNode> {
	private TreeNode root;
	public List<Comparable> tree_print;

	// Constructor 1: Creating an empty BST.
	public CustomBinarySearchTree() { 
		root = null;
	}
	
	// Implementation of search(): Searching searchKey in the BST
	public TreeNode search(Comparable searchKey) {
		return searchItem(root, searchKey);
	}
	
	// Implement the searchItem function using the searchItem function recursively.
	// Perform a recursive search on the left and right subtrees based on key value comparisons.
	// Return null if the search fails.
	// If the search is successful, return the corresponding node.
	private TreeNode searchItem(TreeNode tNode, Comparable searchKey) {
	//***************Write your code in the below******************//
		if (tNode == null || tNode.key == searchKey){
			return tNode;
		} else if (searchKey.compareTo(tNode.key) < 0){
			return searchItem(tNode.left, searchKey);
		} else {
			return searchItem(tNode.right, searchKey);
		}
	//*************************************************************//
	}
	
	// Implementation of insert(): Inserting a node with newKey into the BST
	public void insert(Comparable newKey) {
		root = insertItem(root, newKey);
	}
 
	// Implement the insertItem function using the insertItem function recursively.
	// Perform a recursive search on the left and right subtrees based on key value comparisons.
	// When reaching a leaf node (or it is empty tree), create a new node and return that node.
	private TreeNode insertItem(TreeNode tNode, Comparable newItem) {
	//***************Write your code in the below******************//
		// tNode: a root node. newItem: the key for insertion
		// Finally, return the reference of the root node. 
		if (tNode == null){
			return new TreeNode(newItem);
		} else if (newItem.compareTo(tNode.key) < 0){
			tNode.left = insertItem(tNode.left, newItem);
			return tNode;
		} else{
			tNode.right = insertItem(tNode.right, newItem);
			return tNode;
		}
	//*************************************************************//
	}
	
	// Implementation of delete(): Deleting a node with searchKey from the BST
	public void delete(Comparable searchKey) {
		root = deleteItem(root, searchKey);
	}
	
	// Implement the deleteItem function using the deleteItem function recursively.
	// Perform a recursive search on the left and right subtrees based on key value comparisons.
	// Return null if the search fails.
	// If the search is successful, call deleteNode function.
	// Finally, deleteItem return the root node after recursive calls.
	private TreeNode deleteItem(TreeNode tNode, Comparable searchKey) {
	//***************Write your code in the below******************//
		// tNode: a root node
		// searchKey: a node to delete
		if (tNode == null){
			return null;
		}
		int compareResult = searchKey.compareTo(tNode.key);
		if (compareResult < 0) {
			tNode.left = deleteItem(tNode.left, searchKey); // Key is in the left subtree
		} else if (compareResult > 0) {
			tNode.right = deleteItem(tNode.right, searchKey); // Key is in the right subtree
		} else {
			// This is the node to be deleted
			tNode = deleteNode(tNode);
		}
		return tNode;
	//*************************************************************//
	}
 
	// To implement deleteNode, consider three cases
	// 1. if tNode is a leaf node
	// 2. if tNode has only one child node.
	// 3. if tNode has two child nodes.
	// For the case 3, call deleteMinItem function to delete the node which has two child nodes.
	private TreeNode deleteNode(TreeNode tNode) {
	//***************Write your code in the below******************//
		if (tNode.left == null && tNode.right == null){
			return null; // Case 1
		} else if (tNode.left == null) {
			return tNode.right; // Case 2
		} else if (tNode.right == null) {
			return tNode.left; // Case 2
		} else {
			// Case 3 (has two childs)
			returnPair minItem = deleteMinItem(tNode.right);
			tNode.key = minItem.key;
			tNode.right = minItem.node;
			return tNode;
		}
	//*************************************************************//
	}
	
	// Implement the deleteMinItem function using the returnPair function below.
	// Implement the deleteMinItem function using the deleteminItem function recursively.
	// Refer to the pseudo code on the lecture slide.
	private returnPair deleteMinItem(TreeNode tNode) {
	//***************Write your code in the below******************//
		if (tNode.left == null){
			// there is no left subtree 
			// SO tNode is the minimum tree
			return new returnPair(tNode.key, tNode.right);
		} 
		// find the minimum node recursively
		returnPair minPair = deleteMinItem(tNode.left);
		// 'minItem' is the minimum element (tNode.left node's key)
		// 'node' is the root node of the right subtree of tNode.left node

		// set the right subtree of tNode.left node to the left subtree of it
		tNode.left = minPair.node;

		return new returnPair(minPair.key, tNode);
		
	//*************************************************************//
	}
	
	// returnPair function has key and node variables
	// they are initialized by given it(key) and nd(node), respectively
	private class returnPair {
		private Comparable key;
		private TreeNode node;
		private returnPair(Comparable it, TreeNode nd) {
			key = it;
			node = nd;
		}
	}
	
	// Implementation of isEmpty(): Checking if the BSt is empty
	// Return true if the BST is empty
	// Return false otherwise
	public boolean isEmpty() {
	//***************Write your code in the below******************//
		if (root == null){
			return true;
		} else {
			return false;
		}
		
	//*************************************************************//
	}
	
	// Implementation of clear(): Clear the BST
	public void clear() {
	//***************Write your code in the below******************//
		root = null;
	//*************************************************************//
	}

	/////////////////////////////////////////////////
	public List printPreOrder() {
		tree_print = new ArrayList<Comparable>();
		prPreOrder(root);
		return tree_print;
	}
	public void prPreOrder(TreeNode tNode) {
		if (tNode != null) {
			// System.out.println(tNode.key);
			tree_print.add(tNode.key);
			prPreOrder(tNode.left);
			prPreOrder(tNode.right);
		}
	}
}  
