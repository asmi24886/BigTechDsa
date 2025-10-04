package com.solutions.neetcode.linkedlist.LC21;

public class MergeTwoSortedLists {

    class Solution {
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
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
