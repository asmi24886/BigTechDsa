package com.solutions.neetcode.tree.LC100;

public class SameTree {
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p == null && q == null) return true;
            if(p == null || q == null) return false;

            if(p.val != q.val) return false;

            boolean leftCompare = isSameTree(p.left, q.left);
            boolean rightCompare = isSameTree(p.right, q.right);

            if(leftCompare && rightCompare) return true;
            return false;
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
