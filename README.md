# List Operations
Assignment 02 <br>
PROG2400 / Data Structures <br>
Rose Scoville, W0249159 <br>
March 2025

## Program Overview & Execution
- This program is written in Java and is run in the command line interface (CLI).
- Contains a custom linked list data structure and its required classes.
- Performs 3 insertion and 3 deletion operations on the linked list.
- Performs a custom merge sort on the linked list.
- Runs required tests and checks on all implemented functionality.

## Program Requirements
This program performs the following operations on a linked list: <br>
### a) Insertion in the sorted list:
  - At the beginning (prepend)
  - At the end (append)
  - At the given location

### b) Deletion from the sorted list: 
  - Of first node
  - Of last node (pop)
  - Of node at a given index

### c) Split
This is the initial step in the merge sort process.
- Given a list, the program splits it into two sub lists — one for the front half, 
and one for the back half. 
  - If the number of elements is odd, the extra element goes in the front list. 
  So frontBackSplit() on the list {2, 3, 5, 7, 11} would yield the two lists {2, 3, 5} and 
  {7, 11}.

### d) Sort & Merge
This is the final step in the merge sort process.
- Takes in two one-way-link lists, A and B (sorted or unsorted), sorts them 
independently, then merges them into a single sorted list.