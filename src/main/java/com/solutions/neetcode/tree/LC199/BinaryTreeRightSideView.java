package com.solutions.neetcode.tree.LC199;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

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
        public List<Integer> rightSideView(TreeNode root) {

            Queue<TreeNode> queue = new LinkedList<>();
            List<Integer> result = new LinkedList<>();
            if(root == null) return result;

            queue.add(root);

            while(!queue.isEmpty()) {
                int size = queue.size();
                TreeNode firstRight = null;
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if(firstRight == null) firstRight = node;
                    if(node.right != null) queue.offer(node.right);
                    if(node.left != null) queue.offer(node.left);
                }

                result.add(firstRight.val);
            }
            return result;
        }
        
        public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode() {}
          TreeNode(int val) { this.val = val; }
          TreeNode(int val, TreeNode left, TreeNode right) {
              this.val = val;
              this.left = left;
              this.right = right;
          }
      }
    }
}
