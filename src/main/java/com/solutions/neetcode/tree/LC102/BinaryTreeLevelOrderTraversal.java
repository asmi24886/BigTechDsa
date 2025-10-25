package com.solutions.neetcode.tree.LC102;

import com.sun.source.tree.Tree;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
    class Solution {

        public List<List<Integer>> levelOrder(TreeNode root) {
            return levelOrder_q(root);
        }

        List<List<Integer>> levelOrder_q(TreeNode root) {
            List<List<Integer>> result  = new ArrayList<>();

            if(root == null) return result;

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while(!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> list =  new ArrayList<>();

                for(int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    list.add(node.val);
                    if(node.left != null) queue.add(node.left);
                    if(node.right != null)  queue.add(node.right);
                }

                result.add(list);
            }

            return result;
        }

        public List<List<Integer>> levelOrder_2stack(TreeNode root) {
            List<List<Integer>> result =  new ArrayList<>();
            Stack<TreeNode> stack1 = new Stack<TreeNode>();
            Stack<TreeNode> stack2 = new Stack<TreeNode>();

            if(root == null) return result;

            stack2.push(root);

            while(!stack2.isEmpty()) {

                while(!stack2.isEmpty()) {
                    stack1.push(stack2.pop());
                }

                List<Integer> list = new ArrayList<>();
                while(!stack1.isEmpty()) {
                    TreeNode node = stack1.pop();
                    list.add(node.val);
                    if(node.left != null) stack2.add(node.left);
                    if(node.right != null) stack2.add(node.right);
                }

                if(!list.isEmpty()) {
                    result.add(list);
                }
            }

            return result;
        }
        
        class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;

             TreeNode() {
             }

             TreeNode(int val) {
                 this.val = val;
             }

             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
        }
    }
}
