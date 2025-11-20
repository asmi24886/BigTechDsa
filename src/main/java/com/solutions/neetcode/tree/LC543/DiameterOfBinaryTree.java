package com.solutions.neetcode.tree.LC543;

public class DiameterOfBinaryTree {

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
        public int diameterOfBinaryTree2(TreeNode root) {

            if(root == null) return 0;

            int dm_left = diameterOfBinaryTree2(root.left);
            int dm_right = diameterOfBinaryTree2(root.right);

            int maxDiamaterOfChildren = Math.max(dm_left, dm_right);

            return Math.max(
                    maxDiamaterOfChildren,
                    depth(root.left) + depth(root.right)
            );
        }

        private int depth(TreeNode root) {

            if(root == null) return 0;

            return 1 + Math.max(
                    depth(root.left),
                    depth(root.right)
            );
        }

        / with variable /


        int maxD = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            findMaxD(root);
            return maxD;
        }

        private int findMaxD(TreeNode root) {
            if(root == null) return 0;

            int left = findMaxD(root.left);
            int right = findMaxD(root.right);

            maxD = Math.max(maxD, left + right);

            return 1 + Math.max(left, right);
        }


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
