package com.solutions.neetcode.linkedlist.LC21;

import com.solutions.neetcode.linkedlist.LC23.MergeKSortedLists;

public class MergeTwoSortedLists {

    class Solution {
        //old unoptimized approach
        public ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {

            if(listNode1 == null)
                return listNode2;
            else if(listNode2 == null)
                return listNode1;

            ListNode finalListHead = null;
            ListNode start = null;

            while(listNode1 != null && listNode2 != null) {

                ListNode node;
                if(listNode1.val < listNode2.val) {
                    node = listNode1;
                    listNode1 = listNode1.next;
                }
                else {
                    node = listNode2;
                    listNode2 = listNode2.next;
                }
                node.next = null;

                if(finalListHead == null) {
                    finalListHead = node;
                    start = finalListHead;
                }
                else {
                    finalListHead.next = node;
                    finalListHead = finalListHead.next;
                }

            }

            if(listNode1 == null) {
                finalListHead.next = listNode2;
            }
            else {
                finalListHead.next = listNode1;
            }

            return start;
        }

        //My approach
        public ListNode mergeSortedList_myversion(ListNode head1, ListNode head2) {

            if(head1 == null)
                return head2;

            if(head2 == null)
                return head1;

            ListNode node1 = head1;
            ListNode node2 = head2;

            ListNode parent = null;

            while(true) {

                if(node2.val <= node1.val) {
                    ListNode temp = node2;
                    node2 = node2.next;

                    if(parent != null) {
                        parent.next = temp;
                    }
                    else head1 = temp;

                    temp.next = node1;
                    parent = temp;
                }
                else {
                    parent = node1;
                    node1 = node1.next;
                }

                if(node1 == null) {
                    parent.next = node2; //attach remaining nodes
                    return head1;
                }
                else if(node2 == null) {
                    return head1;
                }
            }
        }
    }

    //Recursive
    public ListNode mergeSortedList_rec(ListNode head1, ListNode head2) {

        /

                1,5,7
                2,3,4,9

                1_-> 2| -> 3|-> 4| -> 5_ -> 7_ -> (9|)

                -> is the recursion call and sticthing to next
                _ from list1
                | from list 2
                () one of the list was non null while the other was null so stitched in full

         /
        if(head1 == null) return head2;
        if(head2 == null) return head1;

        if(head1.val <= head2.val) {
            head1.next = mergeSortedList_rec(head1.next, head2);
            return head1;
        }

        head2.next = mergeSortedList_rec(head1, head2.next);
        return head2;
    }

    //Use current pointer to append either list1 or list2
    public ListNode mergeSortedList_classic(ListNode head1, ListNode head2) {
        /
             1 3
             2 4
         /

        if(head1 == null) return head2;
        if(head2 == null) return head1;

        ListNode current = null;

        if(head1.val <= head2.val) {
            current = head1;
            head1 = head1.next;
        }
        else {
            current = head2;
            head2 = head2.next;
        }

        ListNode mergedList = current;

        while(head1 != null && head2 != null) {
            if(head1.val <= head2.val) {
                current.next = head1;
                head1 = head1.next;
            }
            else {
                current.next = head2;
                head2 = head2.next;
            }

            current = current.next;
        }

        current.next = head1 == null? head2 : head1;

        return mergedList;
    }

    //list1 head always has lower value
    public ListNode mergeSortedList_swapping(ListNode head1, ListNode head2) {
        /
                1| 3
                2| 4

                ----------
                1 2| 4
                3|
                ----------
                1 2 3|
                4|
                ---- null found in list 1----
                1 2 3 4|
                null

                break while loop
         /
        if(head1 == null) return head2;
        if(head2 == null) return head1;

        if(head1.val > head2.val) {
            ListNode temp = head1;
            head1= head2;
            head2 = temp;
        }

        ListNode mergedList = head1;

        while(head1 != null && head2 != null) {

            while(head1.next != null && head1.next.val <= head2.val) {
                head1 = head1.next;
            }

            ListNode temp = head1.next;
            head1.next = head2;
            head2 = temp;


            head1 = head1.next;
        }

        return mergedList;
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
