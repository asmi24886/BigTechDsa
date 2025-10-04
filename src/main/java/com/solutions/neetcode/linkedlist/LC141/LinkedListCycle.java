package com.solutions.neetcode.linkedlist.LC141;

public class LinkedListCycle {

    public class Solution {
        public boolean hasCycle(ListNode head) {
            if(head == null)
                return false;

            ListNode sp = head;
            ListNode fp = head;

            while(fp != null) {
                sp = sp.next;
                fp = fp.next;

                if(fp == null) break;

                fp = fp.next;

                if(fp == sp)
                    return true;
            }
            return false;
        }
    }

      class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
}
