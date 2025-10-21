package com.solutions.neetcode.tree.LC110;

public class BalancedBinaryTree {

    class Solution {
        boolean isBalanced = true;
        public boolean isBalanced(TreeNode root) {
            dfs(root);
            return isBalanced;
        }

        int dfs(TreeNode root) {
            if(!isBalanced) {
                return 0;
            }
            if(root == null) return 0;
            int left = dfs(root.left);
            int right = dfs(root.right);

            if(Math.abs(left - right) > 1) {
                isBalanced = false;
            }

            return 1 + Math.max(left, right);
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
