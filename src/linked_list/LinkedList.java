package linked_list;

public class LinkedList {

    public Node head = null;


    // --------------------------------------------------------------------
    // A) INSERTION

    // A.1. Insertion at the beginning of a sorted list
    public Node prepend(int value) {
        Node newNode = new Node(value);

        // Check if the list is sorted and sort if it is unsorted.
        if (!isSorted(head)) {
            head = this.mergeSort(head);
        }

        newNode.next = head; // If the linked list is not empty, make the current head the next node.
        head = newNode; // Insert the new node at the head.
        return head;
    }

    // A.2. Insertion at the end of a sorted list
    public Node append(int value) {
        Node newNode = new Node(value);
        Node currentNode = head;

        // Check if the list is sorted and sort if it is unsorted.
        if (!isSorted(head)) {
            head = this.mergeSort(head);
        }

        if (head == null) { // Check if the linked list is empty.
            head = newNode; // If empty, make the new node the head.
        } else {
            while (currentNode.next != null) { // If the list is not empty, go to end of the list.
                currentNode = currentNode.next; // Reassign the current tail.
            }
            currentNode.next = newNode; // Set the current tail's next to point to the new node.
        }
        return head;
    }

    public Node appendUnsorted(int value) {
        Node newNode = new Node(value);
        Node currentNode = head;

        if (head == null) { // Check if the linked list is empty.
            head = newNode; // If empty, make the new node the head.
        } else {
            while (currentNode.next != null) { // If the list is not empty, go to end of the list.
                currentNode = currentNode.next; // Reassign the current tail.
            }
            currentNode.next = newNode; // Set the current tail's next to point to the new node.
        }
        return head;
    }

    // A.3. Insertion at a given location in a sorted list
    public Node insertAtIndex(int value, int index) {

        Node currentNode = head;
        Node previousNode;
        Node newNode = new Node(value);
        int counter = 0;
        int indexRange = calculateLength() - 1;

        // Check if the list is sorted and sort if it is unsorted.
        if (!isSorted(head)) {
            head = this.mergeSort(head);
        }

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

        // Check if the list is sorted and sort if it is unsorted.
        if (!isSorted(head)) {
            head = this.mergeSort(head);
        }

        // Check if the list is empty and return null if it is
        if (head == null) {
            System.out.println("This list is empty.");
            return null;
        } else {
            Node temp = head; // Store the current head in a temporary variable
            head = head.next; // Move the head pointer to the next node
            temp = null;
            return head;
        }
    }

    // B.2. Deletion of last node
    public Node deleteTail() {

        // Check if the list is sorted and sort if it is unsorted.
        if (!isSorted(head)) {
            head = this.mergeSort(head);
        }

        if (head != null) { // Check if the list contains any nodes.
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

        // Check if the list is sorted and sort if it is unsorted.
        if (!isSorted(head)) {
            head = this.mergeSort(head);
        }

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
    // C) MERGE SORT: FRONT/BACK SPLIT

    // Reference: ------------------------------------------------------
    // - Geeks for Geeks. (2024, Sept. 19). Merge Sort for Linked Lists.
    //      https://www.geeksforgeeks.org/merge-sort-for-linked-list/
    // -----------------------------------------------------------------

    // C.1. Split the list into two sub-lists — one for the front half and one for the back half.
    // C.2. If the number of elements is odd, put the extra element in the front list.

    public Node frontBackSplit(Node n) {

        // Counters to find the midpoint
        Node index = n;
        Node mid = n;

        // Check for an empty or single-node linked list.
        while (index != null && index.next != null) {

            // Traverse the list to find the midpoint.
            // When the length counter reaches the end of the list, the mid counter will be at the midpoint.
            index = index.next.next;
            if (index != null) {
                mid = mid.next;
            }
        }

        // Splits list and returns the head node of the back list.
        // If the list is odd, the extra node goes in the front list.
        Node midNode = mid.next;
        mid.next = null;
        return midNode;
    }


    // --------------------------------------------------------------------
    // D) MERGE SORT: SORT & MERGE

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
            // Recursively merge the first and return the result
            a.next = merge(a.next, b);
            return a;
        }
        else {
            // Recursively merge the second and return the result
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
        Node b = frontBackSplit(a);

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

    // PRINT LIST FROM NODE -------------------------------------
    public void printLLFromNode(Node head) {
        Node currentNode = head; // Starting at the head, set a node to hold the current value to be printed.
        while (currentNode != null) { // Traverse through the LinkedList.
            System.out.print(currentNode.value + " --> "); // Print the value of the current node.
            currentNode = currentNode.next; // Go to the next node.
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

    // CHECK IF LIST IS SORTED --------------------------------------------
    // Reference: ---------------------------------------------------------
    // - Geeks for Geeks. (2024, August 29).
    //      Check if a linked list is sorted in non-increasing order.
    //      https://www.geeksforgeeks.org/check-linked-list-sorting-order/
    // --------------------------------------------------------------------

    public boolean isSorted(Node n) {

        // Check if the list is empty or a single node
        if (n == null || n.next == null) {
            return true; // Is sorted
        }

        // Compare current node and the next node to check if they are in order.
        if (n.value > n.next.value) {
            return false; // Is not sorted
        }

        // Recursively progress through the list, checking the next pair of nodes
        return isSorted(n.next);
    }
}
