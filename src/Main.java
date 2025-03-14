import linked_list.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n-----------   L I N K E D   L I S T   O P E R A T I O N S   -----------");

        // List creation and initialization ----------------------------
        LinkedList ll = new LinkedList();
        ll.append(3);
        ll.append(1);
        ll.append(5);
        ll.append(4);
        ll.append(2);
        System.out.println("\nOriginal linked list:");
        ll.printLL();


        // a) INSERTION TESTS ------------------------------------------
        System.out.println("\nA) NODE INSERTION -----------------------------------------------");

        // A.1. Test insertion at the beginning of the sorted list
        System.out.println("\nA.1. Insert at the beginning of the sorted list");
        System.out.print("Before: ");
        ll.printLL();
        System.out.print("After: ");
        ll.prepend(11);
        ll.printLL();

        // A.2. Test insertion at the end of the sorted list
        System.out.println("\nA.2. Insert at the end of the sorted list");
        System.out.print("Before: ");
        ll.printLL();
        System.out.print("After: ");
        ll.append(101);
        ll.printLL();

        // A.3. Test insertion at a given location in the sorted list
        int index = 3;
        System.out.println("\nA.31. Insert at a given index (" + index + ") in the sorted list");
        System.out.print("Before: ");
        ll.printLL();
        System.out.print("After: ");
        ll.insertAtIndex(666, index);
        ll.printLL();


        // B) DELETION TESTS -------------------------------------------
        System.out.println("\nB) NODE DELETION -----------------------------------------------");

        // B.1. Test deletion of the first node from the sorted list
        System.out.println("\nB.1. Delete the first node (head) from the sorted list");
        System.out.print("Before: ");
        ll.printLL();
        System.out.print("After: ");
        ll.deleteHead();
        ll.printLL();

        // B.2. Test deletion of the last node from the sorted list
        System.out.println("\nB.2. Delete the last node (tail) from the sorted list");
        System.out.print("Before: ");
        ll.printLL();
        System.out.print("After: ");
        ll.deleteTail();
        ll.printLL();

        // B.3. Test deletion at a given index from the sorted list
        index = 1;
        System.out.println("\nB.3. Delete the node at a given index (" + index + ") in the sorted list");
        System.out.print("Before: ");
        ll.printLL();
        System.out.print("After: ");
        ll.deleteAtIndex(index);
        ll.printLL();

        // C) SPLIT TEST -----------------------------------------------
        ll.split();
        //System.out.println(ll.split().value);

        // D) MERGE SORT TEST ------------------------------------------
        // TODO: Test merge sort on the list
//        System.out.println("Before:");
//        ll.printLL();
//        System.out.println("After:");
//        ll.mergeSort(ll.head);
//        ll.printLL();

    }

}