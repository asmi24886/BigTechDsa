package com.solutions.neetcode.tree.LC124;

public class MaximumPathSum {

    /
      Definition for a binary tree node.
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
     /
    class Solution {
        int maxPathRoot = Integer.MIN_VALUE;

        public int maxPathSum(TreeNode root) {
            maxPathSumDfs(root);
            return maxPathRoot;
        }

        public int maxPathSumDfs(TreeNode root) {
            if(root == null) return 0;

            int maxPathLeft = Math.max(0, maxPathSumDfs(root.left));
            int maxPathRight = Math.max(0, maxPathSumDfs(root.right));

            int maxSumLeftRight = Math.max(maxPathLeft, maxPathRight);
            int maxPathWithCurrentRoot = maxPathLeft + maxPathRight + root.val;

            maxPathRoot = Math.max(maxPathWithCurrentRoot, maxPathRoot);

            return maxSumLeftRight + root.val;
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
