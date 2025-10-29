package com.solutions.neetcode.tree.LC297;

import org.w3c.dom.css.Counter;

public class SerializeDeserializeBinaryTreeDFS {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class Codec {
        int counter = 0;

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            counter = 0;
            String str = "";
            if (root == null) return str;
            str = dfs_serialize(root);
            return dfs_serialize(root).substring(0, str.length() - 1);
        }

        private String dfs_serialize(TreeNode node) {
            if (node == null)
                return "-,";
            else return node.val + "," + dfs_serialize(node.left) + dfs_serialize(node.right);
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == "")
                return null;

            String[] arr = data.split(",");
            return dfs_deserialize(arr);
        }

        private TreeNode dfs_deserialize(String[] arr) {
            if (counter == arr.length) return null;
            if (arr[counter].equals("-")) return null;

            TreeNode node = new TreeNode(Integer.parseInt(arr[counter]));
            counter++;
            node.left = dfs_deserialize(arr);

            counter++;
            node.right = dfs_deserialize(arr);

            return node;
        }
    }

}
