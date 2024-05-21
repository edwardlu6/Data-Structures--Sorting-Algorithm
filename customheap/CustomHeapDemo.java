package customheap;

public class CustomHeapDemo {

	public static void main(String[] args) {
			Integer[] elements = new Integer[]{5, 7, 42, 5, 7, 45, 4547, 32, 99};
			CustomHeap<Integer> h = new CustomHeap<>(elements, elements.length);
			/*
			h.insert(1);
			h.insert(10);
			h.insert(30); 
			h.clear();
			h.insert(10);
			h.insert(30); 
			h.insert(20); 
			h.insert(40);
			*/
			h.clear();
			System.out.println("deleteMax(): " + h.deleteMax()); 
			h.insert(32);
			System.out.println("deleteMax(): " + h.deleteMax()); 

			h.clear();
			h.insert(32);
			h.insert(101);

			System.out.print(h.max());


			System.out.println(h.heapPrint()); //expected output: "PrintAll: 20 10 1"
	  }
} 
