package com.solutions.neetcode.tree.LC105;

import java.util.HashMap;

public class ConstructTreeFromPreIn {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    class Solution {
        int [] pre;
        int [] in;
        int pre_index = 0;
        HashMap<Integer, Integer> map  = new HashMap<>();
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            pre = preorder;
            in = inorder;

            for(int i =0; i < in.length; i++) {
                map.put(in[i], i);
            }
            return buildTreeHelper(0, in.length - 1);
        }

        // 12, 9, 8, 10, 11, 18, 17, 16, 19
        // 8, 9, 10, 11, 12, 16, 17, 18, 19
        public TreeNode buildTreeHelper(
                int in_start, int in_end
        ) {
            if(in_start > in_end) return null;
            TreeNode root = new TreeNode(pre[pre_index++]);
            if(in_start == in_end) return root;

            int inorder_index = map.get(root.val);

            root.left = buildTreeHelper(in_start, inorder_index - 1);
            root.right = buildTreeHelper(inorder_index + 1, in_end);

            return root;

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
