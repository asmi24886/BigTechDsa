package com.solutions.neetcode.linkedlist.LC206;

public class ReverseLinkedList {

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
        public ListNode reverseList(ListNode head) {

            ListNode cur = head;
            ListNode parent = null;
            ListNode next;

            while(cur != null) {
                  next = cur.next;
                  cur.next = parent;
                  parent = cur;

                  cur = next;
            }
            return parent;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
