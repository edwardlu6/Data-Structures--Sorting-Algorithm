# Data Structures and Sorting Algorithms

This repository contains implementations of classic data structures and sorting algorithms. Each implementation is designed to be clear, efficient, and easy to understand.

## Data Structures

### 1. ArrayList
- **Description**: A dynamic array that resizes automatically when elements are added or removed.
- **Operations**: Insertion, deletion, resizing, access by index.
- **Complexity**: 
  - Access: O(1)
  - Insertion: O(1) amortized
  - Deletion: O(n)

### 2. LinkedList
- **Description**: A linear collection of elements, where each element points to the next.
- **Types**: Singly Linked List, Doubly Linked List.
- **Operations**: Insertion, deletion, traversal.
- **Complexity**:
  - Access: O(n)
  - Insertion: O(1)
  - Deletion: O(1)

### 3. Array Stack
- **Description**: A stack implementation using an array.
- **Operations**: Push, pop, peek, isEmpty.
- **Complexity**:
  - Access: O(1)
  - Push: O(1) amortized
  - Pop: O(1)

### 4. Linked Stack
- **Description**: A stack implementation using a linked list.
- **Operations**: Push, pop, peek, isEmpty.
- **Complexity**:
  - Access: O(1)
  - Push: O(1)
  - Pop: O(1)

### 5. Array Queue
- **Description**: A queue implementation using an array.
- **Operations**: Enqueue, dequeue, peek, isEmpty.
- **Complexity**:
  - Access: O(1)
  - Enqueue: O(1) amortized
  - Dequeue: O(1)

### 6. Linked Queue
- **Description**: A queue implementation using a linked list.
- **Operations**: Enqueue, dequeue, peek, isEmpty.
- **Complexity**:
  - Access: O(1)
  - Enqueue: O(1)
  - Dequeue: O(1)

### 7. Heap
- **Description**: A binary tree-based data structure that satisfies the heap property.
- **Types**: Min-Heap, Max-Heap.
- **Operations**: Insert, delete, extract-min/max, heapify.
- **Complexity**:
  - Access: O(1)
  - Insert: O(log n)
  - Delete: O(log n)

### 8. Binary Search Tree (BST)
- **Description**: A binary tree where each node has at most two children, with the left child less than the parent and the right child greater.
- **Operations**: Insert, delete, search, traversal (in-order, pre-order, post-order).
- **Complexity**:
  - Access: O(log n) on average, O(n) worst case
  - Insert: O(log n) on average, O(n) worst case
  - Delete: O(log n) on average, O(n) worst case

### 9. AVL Tree
- **Description**: A self-balancing binary search tree where the difference between heights of left and right subtrees cannot be more than one.
- **Operations**: Insert, delete, search, rotation (left, right).
- **Complexity**:
  - Access: O(log n)
  - Insert: O(log n)
  - Delete: O(log n)

### 10. Hashing
- **Description**: A data structure that maps keys to values using a hash function.
- **Types**: Hash Table, Hash Map.
- **Operations**: Insert, delete, search.
- **Complexity**:
  - Access: O(1) on average
  - Insert: O(1) on average
  - Delete: O(1) on average

## Sorting Algorithms

### 1. Bubble Sort
- **Description**: A simple comparison-based sorting algorithm that repeatedly steps through the list, compares adjacent elements, and swaps them if they are in the wrong order.
- **Complexity**:
  - Time: O(n^2)
  - Space: O(1)

### 2. Selection Sort
- **Description**: A comparison-based sorting algorithm that divides the input list into a sorted and an unsorted region, and iteratively selects the smallest element from the unsorted region and moves it to the end of the sorted region.
- **Complexity**:
  - Time: O(n^2)
  - Space: O(1)

### 3. Insertion Sort
- **Description**: A comparison-based sorting algorithm that builds the final sorted array one item at a time, inserting each new item into the correct position within the sorted part of the array.
- **Complexity**:
  - Time: O(n^2)
  - Space: O(1)

### 4. Merge Sort
- **Description**: A divide-and-conquer sorting algorithm that divides the input array into halves, recursively sorts them, and then merges the sorted halves.
- **Complexity**:
  - Time: O(n log n)
  - Space: O(n)

### 5. Quick Sort
- **Description**: A divide-and-conquer sorting algorithm that selects a 'pivot' element and partitions the array around the pivot, recursively sorting the subarrays.
- **Complexity**:
  - Time: O(n log n) on average, O(n^2) worst case
  - Space: O(log n) on average

### 6. Heap Sort
- **Description**: A comparison-based sorting algorithm that uses a binary heap data structure. It first builds a max-heap and then repeatedly extracts the maximum element from the heap and rebuilds the heap.
- **Complexity**:
  - Time: O(n log n)
  - Space: O(1)
