package com.solutions.neetcode.tree.LC572;

public class SubTreeOfAnotherTree {

    class Solution {
        public boolean isSubtree(TreeNode root, TreeNode subRoot) {
            if(root == null && subRoot == null) return false;
            if(root == null || subRoot == null) return false;

            boolean areNodesEqual = isEqual(root, subRoot);;
            if(areNodesEqual) return true;

            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }

        boolean isEqual(TreeNode p, TreeNode q) {
            if(p == null && q == null) return true;

            if(p == null || q == null) return false;

            if(p.val != q.val) return false;

            return isEqual(p.left, q.left) && isEqual(p.right, q.right);
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
