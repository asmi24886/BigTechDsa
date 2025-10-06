package com.solutions.neetcode.linkedlist.LC143;

import com.sun.source.tree.ParenthesizedTree;

import java.util.Deque;
import java.util.LinkedList;

public class ReorderList {

    class Solution {

        public void reorderList(ListNode head) {
            fsp(head);
        }

        public void fsp(ListNode head) {
            ListNode sp = head;
            ListNode fp = head.next;

            while(fp != null && fp.next != null && fp.next.next != null) {
                fp = fp.next.next;
                sp = sp.next;
            }

            ListNode firstHalf = head;
            ListNode secondHalf = sp.next;

            // cut the node
            sp.next = null;

            secondHalf = reverseList(secondHalf);
            mergeList(firstHalf, secondHalf);
        }

        private ListNode reverseList(ListNode node) {

            ListNode parent = null;
            while(node != null) {
                ListNode next = node.next;
                node.next = parent;
                parent = node;
                node = next;
            }
            return parent;
        }

        //v v imp - in place merging
        private void mergeList(ListNode list1Head, ListNode list2Head) {

            while(list1Head != null && list2Head != null) {
                ListNode temp1 = list1Head.next;
                ListNode temp2 = list2Head.next;

                list1Head.next = list2Head;

                //nothing more to construct
                if(temp1 == null)
                    return;

                list2Head.next = temp1;

                list1Head = temp1;
                list2Head = temp2;

            }
        }


        private void printList(ListNode node) {
            System.out.print("[");
            while(node != null) {
                System.out.print(node.val + ",");
                node = node.next;
            }
            System.out.print("]");
        }

        /********************************************************************************************************/
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
