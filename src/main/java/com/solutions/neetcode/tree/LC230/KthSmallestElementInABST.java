package com.solutions.neetcode.tree.LC230;

public class KthSmallestElementInABST {

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
        int result = -1;
        int count = 0;
        public int kthSmallest(TreeNode root, int k) {
            dfs(root, k);
            return result;
        }

        public void dfs(TreeNode node, int k) {
            if(node == null)
                return;

            if(result != -1)
                return;

            dfs(node.left, k);

            count++;

            if(count == k) {
                result = node.val;
                return;
            }

            dfs(node.right, k);
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
