package com.solutions.neetcode.linkedlist.LC2;

public class AddTwoNumbers {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

            ListNode result = null;
            ListNode head = null;

            for(int carry = 0; l1 != null || l2 != null || carry == 1;) {

                int v1 = l1 == null ? 0 : l1.val;
                int v2 = l2 == null ? 0 : l2.val;

                int sum = v1+v2+carry;


                if(sum >= 10) {
                    carry = 1;
                    sum = sum % 10;
                }
                else {
                    carry = 0;
                }

                if(result == null) {
                    result = new ListNode(sum);
                    head = result;
                }
                else {
                    result.next = new ListNode(sum);
                    result = result.next;
                }

                if(l1 != null) {
                    l1=l1.next;
                }

                if(l2 !=null) {
                    l2=l2.next;
                }

            }

            return head;
        }
    }
}
