package HackerRankEasyProblems;


public class InsertNodeAtSpecificPosition {


    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    static class SinglyLinkedList {
        public SinglyLinkedListNode head;
        public SinglyLinkedListNode tail;

        public SinglyLinkedList() {
            this.head = null;
            this.tail = null;
        }


    }


    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position) {

        if (position == 0) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(data);
            node.next = llist;
            return node;
        } else

            return insertNodeAtPosition(llist, data, position, 0);

    }

    public static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode llist, int data, int position, int currentPos) {

        if (currentPos == position -1 ) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(data);
            node.next = llist.next;
            llist.next = node;

        } else {
            insertNodeAtPosition(llist.next, data, position, currentPos + 1);
        }
        return llist;
    }

}
