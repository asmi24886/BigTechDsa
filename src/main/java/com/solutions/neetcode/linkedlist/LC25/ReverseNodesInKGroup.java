package com.solutions.neetcode.linkedlist.LC25;

// Difficult due to 4 pointer tracking
public class ReverseNodesInKGroup {
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

    // WE TRACK 4 pointer
        // previous group head that became the previous tail
        // current head that will become the current tail
        // the tail that will become the new head -> needs to be attached with old group head
        // the next head in group that will start the next iteration
    class Solution {
        public ListNode reverseKGroup_without_dummy(ListNode head, int k) {

            ListNode tail = head;
            ListNode reversedHead = null;
            ListNode parent = null;

            while(tail != null) {

                int count = 1;

                ListNode oldHead = tail;

                //Increase tail
                while(count != k) {
                    if(tail.next == null) {
                        if(parent != null) parent.next = oldHead;
                        return (reversedHead == null? head : reversedHead);
                    }

                    tail = tail.next;
                    count++;
                }

                ListNode nextHead = tail.next;
                ListNode newHead = reverse_with_tail(oldHead, nextHead);
                if(reversedHead == null) reversedHead = newHead;


                tail = nextHead;

                if(parent != null) {
                    parent.next = newHead;
                }

                //skip parent to the latest end of the last group
                parent = oldHead;
                oldHead.next = null;
            }

            return (reversedHead == null? head : reversedHead);
        }

        public ListNode reverseKGroup_dummy(ListNode head, int k) {

            ListNode dummy = new ListNode(0, head);

            ListNode oldGroupHead = dummy;

            while(true) {
                ListNode tail = oldGroupHead;

                for(int i =0; i < k; i++) {
                    tail = tail.next;

                    if(tail == null) {
                        return dummy.next;
                    }
                }

                ListNode currentGroupHead = oldGroupHead.next;
                ListNode currentGroupTail = tail.next; //imp
                ListNode reversedCurrentGroupHead = reverse_with_tail(currentGroupHead, currentGroupTail);

                oldGroupHead.next = reversedCurrentGroupHead;
                oldGroupHead = currentGroupHead;
            }
        }

        public ListNode reverseKGroup_recursive(ListNode head, int k) {

            ListNode current = head;
            for(int i = 0; i < k; i++) {
                if(current == null) return head;
                current = current.next;
            }

            ListNode parent = null;
            current = head;

            for(int i = 0; i < k; i++) {
                ListNode next = current.next;
                current.next = parent;
                parent = current;
                current = next;
            }

            head.next = reverseKGroup_recursive(current, k); //current has the latest NEXT value
            return parent;
        }

        //Normal reverse would usually assign null to the head and then reverse it
        //Reverse with tail attaches the next head (that will go to be a tail)
        ListNode reverse_with_tail(ListNode head, ListNode end) {

            ListNode parent = end;
            ListNode node = head;
            while(node != end) {
                ListNode next = node.next;
                node.next = parent;
                parent = node;
                node = next;
            }

            return parent;
        }
        
         class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }
    }
}
