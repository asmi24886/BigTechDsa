package com.solutions.neetcode.linkedlist.LC23;

public class MergeKSortedLists {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {

            if(lists.length == 1)
                return lists[0];

            ListNode head1= lists[0];


            for(int i = 1; i < lists.length; i++) {
                head1 = mergeSortedList(head1, lists[i]);
            }

            return head1;
        }

        public ListNode mergeSortedList(ListNode head1, ListNode head2) {

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
    
     public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
}
