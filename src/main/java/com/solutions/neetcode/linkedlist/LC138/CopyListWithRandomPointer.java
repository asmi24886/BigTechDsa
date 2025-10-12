package com.solutions.neetcode.linkedlist.LC138;

import java.util.HashMap;

public class CopyListWithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    class Solution {
        public Node copyRandomList(Node head) {
            HashMap<Node, Node> map = new HashMap<>();

            //create
            Node node = head;

            while(node != null) {
                Node copy = new Node(node.val);
                map.put(node, copy);
                node = node.next;
            }

            //link
            node = head;

            while(node != null) {
                Node copy = map.get(node);
                if(node.next != null) {
                    copy.next = map.get(node.next);
                }

                if(node.random != null) {
                    copy.random = map.get(node.random);
                }

                node = node.next;
            }

            return map.get(head);
        }
    }
}
