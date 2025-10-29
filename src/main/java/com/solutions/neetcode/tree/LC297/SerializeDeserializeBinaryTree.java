package com.solutions.neetcode.tree.LC297;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTree {

      class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "";

            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node == null) {
                    sb.append("null,");
                    continue;
                }
                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }

            // Remove trailing comma
            sb.setLength(sb.length() - 1);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty()) return null;

            String[] values = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(values[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            int i = 1;
            while (!queue.isEmpty() && i < values.length) {
                TreeNode parent = queue.poll();

                // Left child
                if (!values[i].equals("null")) {
                    TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                    parent.left = left;
                    queue.offer(left);
                }
                i++;

                // Right child
                if (i < values.length && !values[i].equals("null")) {
                    TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                    parent.right = right;
                    queue.offer(right);
                }
                i++;
            }

            return root;
        }
    }

}
