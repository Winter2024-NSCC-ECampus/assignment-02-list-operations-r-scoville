package linked_list;

public class LinkedList {

    public Node head = null;
    public Node tail = null;
    public boolean isSorted;

    // --------------------------------------------------------------------
    // A) INSERTION

    // A.1. Insertion at the beginning of a sorted list
    public Node prepend(int value) {
        Node newNode = new Node(value);

        // TODO:
        //  1. Check if list is empty or contains >1 node.
        //  2. Check if the list is sorted.
        //  3. If it is not sorted, call merge sort.

        newNode.next = head; // If the linked list is not empty, make the current head the next node.
        head = newNode; // Insert the new node at the head.
        return head;
    }

    // A.2. Insertion at the end of a sorted list
    public Node append(int value) {
        Node newNode = new Node(value);
        Node currentNode = head;
        if (head == null) { // Check if the linked list is empty.
            head = newNode; // If empty, make the new node the head.
        } else {
            // TODO: Check if list is sorted, call sort function if not
            while (currentNode.next != null) { // If the linked list is not empty, go to end of the list.
                currentNode = currentNode.next; // Reassign the current tail.
            }
            currentNode.next = newNode; // Set the current tail's next to point to the new node.
        }
        return head;
    }

    // A.3. Insertion at a given location in a sorted list
    public Node insertAtIndex(int value, int index) {

        Node currentNode = head;
        Node previousNode = null;
        Node newNode = new Node(value);
        int counter = 0;
        int indexRange = calculateLength() - 1;

        // TODO:
        //  1. Check if list is empty or contains >1 node.
        //  2. Check if the list is sorted.
        //  3. If it is not sorted, call merge sort.

        if (index > indexRange) { // Error handling for an out-of-bounds index request.
            System.out.println("The requested index is out of bounds. " +
                    "Please search for an index from 0 to " + indexRange +".");
            currentNode = null;
        } else { // Iterate through the nodes until the given index is found.
            while (currentNode.next != null && counter < index) {
                previousNode = currentNode;
                currentNode = currentNode.next;
                counter++;
                if (counter == index) {
                    newNode.next = currentNode;
                    previousNode.next = newNode;
                }
            }
        }
        return head;
    }

    // --------------------------------------------------------------------
    // B) DELETION

    // B.1. Deletion of first node
    public Node deleteHead() {
        // Check if the list is empty and return null if it is
        if (head == null) {
            System.out.println("This list is empty.");
            return null;
        } else {
            // TODO: Check if list is sorted, call sort function if not
            Node temp = head; // Store the current head in a temporary variable
            head = head.next; // Move the head pointer to the next node
            temp = null;
            return head;
        }
    }

    // B.2. Deletion of last node
    public Node deleteTail() {
        if (head != null) { // Check if the list contains any nodes.
            // TODO: Check if list is sorted, call sort function if not
            Node currentNode = head;
            Node prevNode = currentNode;
            while (currentNode.next != null) { // Iterate through the linked list to find the last node.
                prevNode = currentNode;
                currentNode = currentNode.next;
            }
            prevNode.next = null; // Set the second-last node to be the new tail.
            return currentNode; // Return the popped node.
        } else {
            System.out.println("There is no node to pop. This linked list is empty.");
            return null; // We have no node to return.
        }
    }

    // B.3. Deletion of a given item index from a sorted list
    public Node deleteAtIndex(int index) { // Take in the desired location.

        Node currentNode = head;
        Node previousNode = null;
        int counter = 0;
        int indexRange = calculateLength() - 1;

        // TODO:
        //  1. Check if list is empty or contains >1 node.
        //  2. Check if the list is sorted.
        //  3. If it is not sorted, call merge sort.
        //  4. If it is sorted, insert new node at given location

        if (index > indexRange) { // Error handling for an out-of-bounds index request.
            System.out.println("The requested index is out of bounds. " +
                    "Please search for an index from 0 to " + indexRange +".");
            currentNode = null;
        } else { // Iterate through the nodes until the given index is found.
            while (currentNode.next != null && counter < index) {
                previousNode = currentNode;
                currentNode = currentNode.next;
                counter++;
                if (counter == index) {
                    // When the index is found, set the previous node
                    // to point at the node after the one to be deleted
                    previousNode.next = currentNode.next;
                }
            }
        }
        return head;
    }

    // --------------------------------------------------------------------
    // C) MERGE SORT: SPLIT

    // Reference: ------------------------------------------------------
    // - Geeks for Geeks. (2024, Sept. 19). Merge Sort for Linked Lists.
    //      https://www.geeksforgeeks.org/merge-sort-for-linked-list/
    // -----------------------------------------------------------------

    // C.1. Split the list into two sub-lists — one for the front half and one for the back half.
    // C.2. If the number of elements is odd, put the extra element in the front list.

    public Node split() {

        Node length = head;
        Node mid = head;

        // Check for an empty or single-node linked list.
        while (length != null && length.next != null) {

            // TODO: Check for even or odd list length.

            // Traverse the list to find the midpoint.
            // When the length counter reaches the end of the list, the mid counter will be at the midpoint.
            length = length.next.next;
            if (length != null) {
                mid = mid.next;
            }
        }

        // Split the list into two halves
        Node midNode = mid.next;
        mid.next = null;
        return midNode;
    }

//        // Set the mid-point to divide the list.
//        if (length % 2 == 0) {
//            mid = length / 2;
//        } else {
//            mid = (length / 2) + 1;
//        }


    // --------------------------------------------------------------------
    // D) MERGE SORT: MERGE AND SORT

    // Reference: ------------------------------------------------------
    // - Geeks for Geeks. (2024, Sept. 19). Merge Sort for Linked Lists.
    //      https://www.geeksforgeeks.org/merge-sort-for-linked-list/
    // -----------------------------------------------------------------

    // D.1. Take in two one-way linked lists, A and B (sorted or unsorted)
    // D.2. Sort both lists independently and then merge as a list.

    // Merge
    public Node merge(Node a, Node b) {

        // Check for an empty list
        if (a == null) return b;
        if (b == null) return a;

        // Check for the node with the smaller value
        if (a.value < b.value) {

            // Recursively merge the first list and return the result
            a.next = merge(a.next, b);
            return a;
        }
        else {
            // Recursively merge the second list and return the result
            b.next = merge(a, b.next);
            return b;
        }
    }

    // Merge Sort
    public Node mergeSort(Node a) {

        // Check if the list is empty or single-node
        if (a == null || a.next == null) {
            return a;
        }

        // Split the list into two sub-lists
        Node b = split();

        // Recursively sort each sub-list
        a = mergeSort(a);
        b = mergeSort(b);

        // Merge the two sub-lists back into one sorted list
        return merge(a, b);
    }


    // PRINT LIST -----------------------------------------------
    public void printLL() {
        Node current = head; // Starting at the head, set a node to hold the current value to be printed.
        while (current != null) { // Traverse through the LinkedList.
            System.out.print(current.value + " --> "); // Print the value of the current node.
            current = current.next; // Go to the next node.
        }
        System.out.print("null \n");
    }

    // CALCULATE LENGTH -----------------------------------------
    public int calculateLength() {
        Node index = head;
        int length = 0;
        while (index != null) { // Check if the linked list is empty and loop through if not.
            index = index.next;
            length++; // Increment the count.
        }
        return length;
    }

}
