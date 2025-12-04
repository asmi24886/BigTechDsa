package com.solutions.neetcode.tree.LC98;

public class ValidateBinarySearchTree {
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
        public boolean isValidBST(TreeNode root) {
            return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
        }

        boolean dfs(TreeNode root, long minVal, long maxVal) {
            if (root == null)
                return true;

            if (minVal >= root.val || root.val >= maxVal)
                return false;

            boolean left = dfs(root.left, minVal, Math.min(root.val, maxVal));
            boolean right = dfs(root.right, Math.max(minVal, root.val), maxVal);

            return left && right;

        }

        class TreeNode {
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
