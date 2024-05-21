package customlist;

public class CustomLinkedListDemo2 {
	public static void main(String[] args) {
		System.out.println("Linked List Demo!");
		CustomLinkedList<Integer> list = new CustomLinkedList<>();

		// add()
        // list.add(0, 5);  
		// list.printAll(); 
		// list.add(0, 3);
		// list.printAll(); 
		// list.add(1, 100); 
		// list.printAll(); 
		// list.add(1, 23); 
		// list.printAll(); 
		// list.add(2, 12); 
		// list.printAll(); 
		// list.add(2, 32); 
		// list.printAll(); 
		// list.add(4, 1); 
		// list.printAll(); 
		// list.add(6, 2); 
		// list.printAll(); 
		// list.add(7, 41); 
		// list.printAll(); 
		// list.add(8, 2); 
		// list.printAll(); 
		// list.add(2, 38); 
		// list.printAll(); 
		// list.add(2, 58); 
		// list.printAll(); 
		// list.add(2, 72); 
		// list.printAll(); 

        list.add(0, 0);  
		list.printAll(); 
        list.add(0, 1);  
		list.printAll(); 
        list.add(0, 2);  
		list.printAll(); 
        list.add(0, 3);  
		list.printAll(); 
        list.add(0, 4);  
		list.printAll(); 

        System.out.println("list.getNode(0).item : " + list.getNode(0).item);
        System.out.println("list.getNode(1).item : " + list.getNode(1).item);
        System.out.println("list.getNode(2).item : " + list.getNode(2).item);
        System.out.println("list.getNode(3).item : " + list.getNode(3).item);
        System.out.println("list.getNode(4).item : " + list.getNode(4).item);

		// System.out.println("isEmpty() : " + bool2); // expected output: "isEmpty() : true"

	}
} 
