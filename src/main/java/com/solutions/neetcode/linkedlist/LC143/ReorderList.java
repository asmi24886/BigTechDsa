package com.solutions.neetcode.linkedlist.LC143;

import java.util.Deque;
import java.util.LinkedList;

public class ReorderList {

    class Solution {

        public void reorderList(ListNode head) {
            dfs(head.next, head);
        }

        public ListNode dfs(ListNode cur, ListNode head) {
            if(cur == null)
                return head;

            head = dfs(cur.next, head);

            if(head == null)
                return null;

            if(head == cur || head.next == cur) {
                cur.next = null;
                return null;
            }

            ListNode temp = head.next;
            head.next = cur;
            cur.next = temp;

            return temp;
        }

        public void deqSolution (ListNode head) {

            if(head.next == null)
                return;

            Deque<ListNode> deq = new LinkedList<>();

            ListNode start = head;
            while(start != null) {
                deq.offer(start);
                start = start.next;
            }

            ListNode node = null;
            while(!deq.isEmpty()) {
                ListNode temp = deq.removeFirst();

                if(node == null) node = temp;
                else {
                    node.next = temp;
                    node = node.next;
                }

                node.next  = null;

                if(deq.isEmpty()) {
                    return;
                }

                temp = deq.removeLast();
                node.next = temp;
                node = node.next;
                node.next = null;
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
}
