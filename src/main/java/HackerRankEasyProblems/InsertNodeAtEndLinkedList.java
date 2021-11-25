package HackerRankEasyProblems;

import java.io.IOException;
import java.util.Scanner;

/**
 * https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/problem
 */

public class InsertNodeAtEndLinkedList {

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

        public SinglyLinkedList() {
            this.head = null;
        }


    }

    public static void printSinglyLinkedList(SinglyLinkedListNode node) {
        while (node != null) {
            System.out.println(node.data);

            node = node.next;

            if (node != null) {
                System.out.println(node.data);
            }
        }
    }

    // Complete the insertNodeAtTail function below.

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {

        if(head == null) {
            head = new SinglyLinkedListNode(data);
            head.next = null;

        }
        else {
            head.next = insertNodeAtTail(head.next, data);

        }
        return head;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        SinglyLinkedList llist = new SinglyLinkedList();

        int llistCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < llistCount; i++) {
            int llistItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            llist.head = insertNodeAtTail(llist.head, llistItem);
        }

        printSinglyLinkedList(llist.head);


        scanner.close();
    }
}

