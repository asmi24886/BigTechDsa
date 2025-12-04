package com.solutions.neetcode.tree.LC1448;

public class GoodNodesInBinaryTree {
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
        public int goodNodes(TreeNode root) {
            return dfs(root, root.val);
        }

        int dfs(TreeNode root, int maxVal) {
            if (root == null)
                return 0;
            int maxUntilNow = Math.max(maxVal, root.val);
            int childrenGoodNodeCount = dfs(root.left, maxUntilNow) + dfs(root.right, maxUntilNow);
            if (root.val < maxVal)
                return childrenGoodNodeCount;
            return 1 + childrenGoodNodeCount;
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
