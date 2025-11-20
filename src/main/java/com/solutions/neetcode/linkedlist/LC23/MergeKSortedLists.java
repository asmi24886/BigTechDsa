package com.solutions.neetcode.linkedlist.LC23;

public class MergeKSortedLists {
    /
      Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
     /
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {

            if(lists == null || lists.length == 0)
                return null;

            if(lists.length == 1)
                return lists[0];

           return mergeSortedList(lists, 0, lists.length - 1);
        }

        public ListNode mergeSortedList(ListNode[] lists, int lo, int hi) {

            if(lo == hi) {
                return lists[lo];
            }

            int mid = lo + (hi - lo)/2;
            ListNode leftMerged = mergeSortedList(lists, lo, mid);
            ListNode rightMerged = mergeSortedList(lists, mid+1, hi);

            return merge2SortedLists(leftMerged, rightMerged);

        }

        public ListNode merge2SortedLists(ListNode head1, ListNode head2) {
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


            ListNode mergedHead = current;

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

            current.next = head1 == null? head2: head1;

            return mergedHead;
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
