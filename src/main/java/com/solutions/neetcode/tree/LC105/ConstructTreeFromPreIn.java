package com.solutions.neetcode.tree.LC105;

import java.util.Arrays;
import java.util.List;

public class ConstructTreeFromPreIn {

    public static void main(String[] args) {
        int [] pre = {3,2,1,4};
        int [] in = {1,2,3,4};
        TreeNode treeNode = new Solution().buildTree(pre, in);
        traverse(treeNode);
    }

    public static void traverse(TreeNode treeNode) {
        if(treeNode == null) return;
        traverse(treeNode.left);
        System.out.println(treeNode.val);
        traverse(treeNode.right);
    }

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
    static class Solution {
        List<Integer> preorder;
        List<Integer> inorder;
        public TreeNode buildTree(int[] pre, int[] in) {
            preorder = Arrays.stream(pre).boxed().toList();
            inorder = Arrays.stream(in).boxed().toList();
            return solve(0, preorder.size()-1, 0, preorder.size()-1);
        }

        //2,3,4 and 4,3,2
        public TreeNode solve(int pre_idx_start, int pre_idx_end, int in_idx_start, int in_idx_end) {
            //System.out.println(List.of(pre_idx_start, pre_idx_end, in_idx_start, in_idx_end));
            if(pre_idx_start > pre_idx_end)
                return null;
            int curr_root = preorder.get(pre_idx_start);
            int idx_of_curr_root_inorder = inorder.indexOf(curr_root);

            TreeNode node = new TreeNode();
            node.val = curr_root;

            if(idx_of_curr_root_inorder > in_idx_start) {
                node.left = solve(
                        pre_idx_start+1,
                        pre_idx_start + idx_of_curr_root_inorder - in_idx_start,
                        in_idx_start,
                        idx_of_curr_root_inorder - 1
                        );
            }

            if(idx_of_curr_root_inorder < in_idx_end) {
                node.right = solve(
                        pre_idx_start + idx_of_curr_root_inorder - in_idx_start + 1,
                        pre_idx_end,
                        idx_of_curr_root_inorder + 1,
                        in_idx_end
                );
            }

            return node;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    }
}
