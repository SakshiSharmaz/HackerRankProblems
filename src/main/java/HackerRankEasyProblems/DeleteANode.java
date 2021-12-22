package HackerRankEasyProblems;

/**
 * https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list/problem
 */

public class DeleteANode {
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

        public void insertNode(int nodeData) {
            SinglyLinkedListNode node = new SinglyLinkedListNode(nodeData);

            if (this.head == null) {
                this.head = node;
            } else {
                this.tail.next = node;
            }

            this.tail = node;
        }
    }

    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position) {

        if (position ==0){
            return llist.next;
        }

      return   deleteNode(llist, position, 0);
    }

    public static SinglyLinkedListNode deleteNode(SinglyLinkedListNode llist, int position, int currPos) {

        if(position-1 == currPos){

            llist.next = llist.next.next;


        }else {
            deleteNode(llist.next, position, currPos + 1);
        }
        return llist;

    }


}
