import linked_list.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n------------------   L I S T   O P E R A T I O N S   ------------------");

        // List creation and initialization ----------------------------
        LinkedList ll = new LinkedList();
        ll.append(3);
        ll.append(5);
        ll.append(1);
        ll.append(4);
        ll.append(6);
        ll.append(2);
        ll.append(8);

        System.out.println("\nOriginal linked list:");
        ll.printLL();


        // a) INSERTION TESTS ------------------------------------------
        System.out.println("\nA) NODE INSERTION -----------------------------------------------------");

        // A.1. Test insertion at the beginning of the sorted list
        System.out.println("\nA.1. Insert at the beginning of the sorted list");
        System.out.print("Before: ");
        ll.printLL();
        System.out.print("After: ");
        ll.prepend(9);
        ll.printLL();

        // A.2. Test insertion at the end of the sorted list
        System.out.println("\nA.2. Insert at the end of the sorted list");
        System.out.print("Before: ");
        ll.printLL();
        System.out.print("After: ");
        ll.append(7);
        ll.printLL();

        // A.3. Test insertion at a given location in the sorted list
        int index = 3;
        System.out.println("\nA.3. Insert at a given index (" + index + ") in the sorted list");
        System.out.print("Before: ");
        ll.printLL();
        System.out.print("After: ");
        ll.insertAtIndex(10, index);
        ll.printLL();


        // B) DELETION TESTS -------------------------------------------
        System.out.println("\nB) NODE DELETION -----------------------------------------------------");

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
        System.out.println("\nC) SPLIT LIST --------------------------------------------------------");
        System.out.print("\nOriginal list: ");
        ll.printLL();

        Node temp = ll.head;
        Node frontList = ll.head;
        Node backList = ll.frontBackSplit(temp);
        System.out.print("Front list: ");
        ll.printLLFromNode(frontList);
        System.out.print("Back list: ");
        ll.printLLFromNode(backList);

        // D) MERGE SORT TEST ------------------------------------------

        LinkedList ll2 = new LinkedList();
        ll2.appendUnsorted(3);
        ll2.appendUnsorted(5);
        ll2.appendUnsorted(1);
        ll2.appendUnsorted(4);
        ll2.appendUnsorted(2);

        System.out.println("\nD) MERGE SORT --------------------------------------------------------");
        System.out.println("\nSort an unsorted list using merge sort (split and merge)");
        System.out.print("Before: List sorted = " + ll2.isSorted(ll2.head) + "   |   ");
        ll2.printLL();
        ll2.head = ll2.mergeSort(ll2.head);
        System.out.print("After: List sorted = " + ll2.isSorted(ll2.head) + "   |   ");
        ll2.printLL();

    }

}