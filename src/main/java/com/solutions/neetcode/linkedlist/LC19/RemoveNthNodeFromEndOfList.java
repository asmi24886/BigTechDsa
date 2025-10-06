package com.solutions.neetcode.linkedlist.LC19;

public class RemoveNthNodeFromEndOfList {

    class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {

            int length = 0;
            ListNode node = head;

            while(node != null) {
                length++;
                node = node.next;
            }

            int count = length - n;

            if(count == 0) {
                return head.next;
            }

            node = head;

            while(--count > 0) {
                node = node.next;
            }

            if(node.next.next == null) {
                node.next = null;
            }
            else {
                node.next = node.next.next;
            }
            return head;
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
}
