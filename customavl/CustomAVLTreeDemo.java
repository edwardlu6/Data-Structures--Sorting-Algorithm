package customavl;

import java.util.Arrays;

public class CustomAVLTreeDemo {

	public static void main(String[] args) {
		System.out.println("AVL Tree!!");
		CustomAVLTree avl = new CustomAVLTree(); 

		System.out.println(Arrays.toString(avl.printPreOrderKey().toArray())); 
		System.out.println(Arrays.toString(avl.printPreOrderHeight().toArray())); 

		System.out.println("isEmpty(): " + avl.isEmpty()); // Expected output: "isEmpty(): true"

		System.out.println(Arrays.toString(avl.printPreOrderKey().toArray())); 
		System.out.println(Arrays.toString(avl.printPreOrderHeight().toArray())); 

		

		avl.insert(10);
		avl.insert(20);

		System.out.println(Arrays.toString(avl.printPreOrderKey().toArray())); 
		System.out.println(Arrays.toString(avl.printPreOrderHeight().toArray())); 
		avl.insert(5);

		System.out.println(Arrays.toString(avl.printPreOrderKey().toArray())); 
		System.out.println(Arrays.toString(avl.printPreOrderHeight().toArray())); 
		
		avl.insert(80);
		avl.insert(90);

		System.out.println(Arrays.toString(avl.printPreOrderKey().toArray())); 
		System.out.println(Arrays.toString(avl.printPreOrderHeight().toArray())); 
		avl.insert(30);
		avl.insert(40);
		System.out.println(Arrays.toString(avl.printPreOrderKey().toArray())); // Expected output: "[20, 10, 5, 80, 30, 40, 90]"
		System.out.println(Arrays.toString(avl.printPreOrderHeight().toArray())); // Expected output: "[4, 2, 1, 3, 2, 1, 1]"

		avl.delete(80);
		System.out.println("Deleted!");
		System.out.println(Arrays.toString(avl.printPreOrderKey().toArray())); // Expected output: "[20, 10, 5, 40, 30, 90]"
		System.out.println(Arrays.toString(avl.printPreOrderHeight().toArray())); // Expected output: "[3, 2, 1, 2, 1, 1]"

		Integer tmp = 755;
		AVLNode res = avl.search(tmp);
		if(res ==  CustomAVLTree.NIL) {
				System.out.println("Search for " + tmp + " Failed"); //Expected output: "Search for 755 Failed"
		} else {
				System.out.println("Search for " + res.item + " succeeded" );
		}
		tmp = 5;
		res = avl.search(tmp);
		if(res ==  CustomAVLTree.NIL) {
				System.out.println("Search for " + tmp + " Failed");
		} else {
				System.out.println("Search for " + res.item + " succeeded" ); //Expected output: "Search for 5 succeeded"
		}

	}
} 
