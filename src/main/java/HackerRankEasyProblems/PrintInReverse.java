package HackerRankEasyProblems;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem
 */

class SinglyLinkedListNode {
    public int data;
    public SinglyLinkedListNode next;

    public SinglyLinkedListNode(int nodeData) {
        this.data = nodeData;
        this.next = null;
    }
}

class SinglyLinkedList {
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


public class PrintInReverse {

    public static void reversePrint(SinglyLinkedListNode llist) {

        if (llist == null)
            return;

        if (llist.next != null) {
            reversePrint(llist.next);
        }
        System.out.println(llist.data);
    }

    static SinglyLinkedListNode revHead;


    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {

        if (head == null) {
            head = new SinglyLinkedListNode(data);
            head.next = null;

        } else {
            head.next = insertNodeAtTail(head.next, data);

        }
        return head;

    }


    public static SinglyLinkedListNode reverse(SinglyLinkedListNode llist) {
        if (llist == null)
            return null;

        reverseMap(llist);

        return revHead;
    }

    public static void reverseMap(SinglyLinkedListNode llist) {
        if (llist.next == null) {
            revHead = new SinglyLinkedListNode(llist.data);
        } else {
            reverseMap(llist.next);
            insertNodeAtTail(revHead, llist.data);

        }
    }

    //Reverse version 2 (Iterative )A better way
    public static SinglyLinkedListNode reverseV2(SinglyLinkedListNode llist) {
        if (llist == null || llist.next == null)
            return llist;

        SinglyLinkedListNode curr, next, prev;
        curr = llist;
        prev = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;

    }

    //Reverse version3 (Recursive way )
    public static SinglyLinkedListNode reverseV3(SinglyLinkedListNode llist) {

        if (llist == null || llist.next == null) return llist;
        SinglyLinkedListNode revNode = reverseV3(llist.next);
        llist.next.next = llist;
        llist.next = null;
        return revNode;

    }

    /**
     * https://www.hackerrank.com/challenges/compare-two-linked-lists/problem
     *
     * @param head1
     * @param head2
     * @return
     */
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        if (head1 == null && head2 == null) return true;

        if (head1 == null || head2 == null)
            return false;


        if (head1.data == head2.data) {
            return compareLists(head1.next, head2.next);
        } else return false;


    }

    /**
     * https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem?h_r=next-challenge&h_v=zen
     *
     * @param head1
     * @param head2
     * @return
     */
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        SinglyLinkedListNode tempNode = new SinglyLinkedListNode(0);
        SinglyLinkedListNode currentNode = tempNode;

        while (head1 != null && head2 != null) {

            if (head1.data < head2.data) {
                currentNode.next = head1;
                head1 = head1.next;
            } else {
                currentNode.next = head2;
                head2 = head2.next;
            }


            currentNode = currentNode.next;

        }

        if (head1 == null) {
            currentNode.next = head2;
        }
        if (head2 == null)
            currentNode.next = head1;


        return tempNode.next;

    }

    /**
     * https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail/problem
     *
     * @param llist
     * @param positionFromTail
     * @return
     */

    static int finalValue = -1;

    public static int getNode(SinglyLinkedListNode llist, int positionFromTail) {
        // Write your code here
        if (llist == null)
            return -1;
        finalValue = -1;
        return getNodeDef(llist, positionFromTail);

    }


    public static int getNodeDef(SinglyLinkedListNode llist, int positionFromTail) {

        if (llist.next == null) {
            if (positionFromTail == 0) {
                finalValue = llist.data;
                return finalValue;
            } else return 0;
        } else if (finalValue != -1) {
            return finalValue;
        } else {
            int pos = getNodeDef(llist.next, positionFromTail);

            if (finalValue != -1) return finalValue;

            if (pos + 1 == positionFromTail) {
                finalValue = llist.data;
                return finalValue;
            } else return pos + 1;
        }

    }

    //Perfect version iterates through only once
    public static int getNodeV2(SinglyLinkedListNode llist, int positionFromTail) {
        int index = 0;
        SinglyLinkedListNode current = llist;
        SinglyLinkedListNode result = llist;
        while (current != null) {
            current = current.next;
            if (index++ > positionFromTail) {
                result = result.next;
            }
        }

        return result.data;

    }

    /**
     * https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/problem
     *
     * @param llist
     * @return
     */

    public static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode llist) {
        // Write your code here

        if (llist == null) return null;
        if (llist.next == null) return llist;
        SinglyLinkedListNode current = llist;
        SinglyLinkedListNode next = current.next;

        while (current != null) {
            if (next != null && current.data == next.data) {
                current.next = current.next.next;
                next = current.next;
            } else if (next != null) {
                current = current.next;
                next = next.next;
            } else current = null;
        }
        return llist;
    }


    public static void printList(SinglyLinkedListNode node) throws IOException {
        while (node != null) {
            System.out.printf("%d ", node.data);

            node = node.next;


        }
        System.out.println();
    }

    /**
     * https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem
     * Floyd's cycle finding algorithm
     *
     * @param head
     * @return
     */
    static boolean hasCycle(SinglyLinkedListNode head) {

        if (head == null) return false;
        if (head.next == null) return false;


        SinglyLinkedListNode slow = head.next, fast = head.next.next;
        while (head != null) {

            if (fast == null || fast.next == null || slow == null)
                return false;

            if (fast == slow)
                return true;

            slow = slow.next;
            fast = fast.next.next;
            head = head.next;

        }
        return false;

    }

    /**
     * https://www.hackerrank.com/challenges/find-the-merge-point-of-two-joined-linked-lists/problem
     *
     * @param head1
     * @param head2
     * @return
     */


    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        if (head1 == null) return 0;
        if (head2 == null) return 0;

        SinglyLinkedListNode h1 = head1, h2 = head2;
        int count1 = 0, count2 = 0;
        while (h1 != null && h2 != null) {

            count1++;
            count2++;
            h1 = h1.next;
            h2 = h2.next;

        }
        while (h1 != null) {
            h1 = h1.next;
            count1++;
        }
        while (h2 != null) {
            h2 = h2.next;
            count2++;
        }

        int d = Math.abs(count1 - count2);
        SinglyLinkedListNode bigList, smallList;

        if (count1 > count2) {
            bigList = head1;
            smallList = head2;
        } else {
            bigList = head2;
            smallList = head1;
        }


        while (d > 0) {
            bigList = bigList.next;
            d--;
        }

        while (bigList != null && smallList != null) {

            if (bigList == smallList) return bigList.data;

            bigList = bigList.next;
            smallList = smallList.next;


        }
        return 0;
    }

}
