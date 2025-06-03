package com.solutions.neetcode.tree.LC889;

import java.util.Arrays;
import java.util.List;

public class ConstructTreeFromPrePost {
    static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
    }

    public static void main(String[] args) {
        int [] pre = {1,2,4,5,3,6,7};
        int [] post = {4,5,2,6,7,3,1};
        TreeNode treeNode = new Solution().constructFromPrePost(pre, post);
        traverse(treeNode, "root");
    }

    public static void traverse(TreeNode treeNode, String dir) {
        if(treeNode == null) return;
        System.out.println(dir + " ->" + treeNode.val);
        traverse(treeNode.left, "left");
        traverse(treeNode.right, "right");
    }

    static class Solution {
        List<Integer> preorder;
        List<Integer> postorder;

        public TreeNode constructFromPrePost(int[] pre, int[] post) {
            preorder = Arrays.stream(pre).boxed().toList();
            postorder = Arrays.stream(post).boxed().toList();
            return solve(0, preorder.size()-1, 0, postorder.size()-1);
        }

        public TreeNode solve(int pre_idx_start, int pre_idx_end, int post_idx_start, int post_idx_end) {
            int curr_root = preorder.get(pre_idx_start);

            TreeNode node = new TreeNode();
            node.val = curr_root;

            if(pre_idx_start == pre_idx_end) return  node;

            int idx_curr_root_postorder = post_idx_end;
            int idx_left_tree_root_preorder = pre_idx_start+1;
            int idx_left_tree_root_postorder = postorder.indexOf(preorder.get(idx_left_tree_root_preorder));

            if(idx_left_tree_root_postorder - post_idx_start >= 0) { //atleast 1 element in left subtree
                node.left = solve(
                        idx_left_tree_root_preorder,
                        idx_left_tree_root_preorder + (idx_left_tree_root_postorder - post_idx_start),
                        post_idx_start,
                        idx_left_tree_root_postorder
                );
            }

            if(idx_curr_root_postorder - idx_left_tree_root_postorder > 1) {
                node.right = solve(
                        idx_left_tree_root_preorder + (idx_left_tree_root_postorder - post_idx_start) + 1,
                        pre_idx_end,
                        idx_left_tree_root_postorder+1,
                        post_idx_end - 1
                );
            }

            return node;
        }
    }
}
