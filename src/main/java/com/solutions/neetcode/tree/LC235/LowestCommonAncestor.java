package com.solutions.neetcode.tree.LC235;

public class LowestCommonAncestor {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

            //An infered logic - A common ancestor should be the one which branch out a left descendant and a right descendant
            // If both left/right are not less or greater than current node then it means either its distributed to left and right
            // or one of the node is equal to the root
            //Tricky!!

            if(root == null || p == null || q == null)
                return null;
            //Make q always the greater of the two
            //Could have also been done with Math.max
            if(p.val > q.val) {
                TreeNode temp = p;
                p = q;
                q = temp;
            }

            if(p.val > root.val) {
                return lowestCommonAncestor(root.right, p, q);
            }
            else if(q.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            }
            return root;
        }

        /********************************************************************************************************/
        public TreeNode lowestCommonAncestor_suboptimal(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null || p == null || q == null) return null;

            if( p.val > q.val) {
                TreeNode temp = p;
                p = q;
                q = temp;
            }

            if(
                    (root.val == p.val && search(q.val > root.val ? root.right:root.left, q))
            ) return root;

            if(
                    (root.val == q.val &&  search(p.val < root.val ? root.left: root.right, p) )
            ) return root;

            if(p.val < root.val && q.val > root.val) {

                boolean found  = search(root.left, p) && search(root.right, q);
                if(!found) return null;
                return root;
            }

            if(q.val < root.val) {
                return lowestCommonAncestor(root.left, p, q);
            }
            else {
                return lowestCommonAncestor(root.right, p, q);
            }

        }

        public boolean search(TreeNode node, TreeNode searchNode) {
            if(node == null) return false;
            if(node.val == searchNode.val) return true;

            return search(node.left, searchNode) || search(node.right, searchNode);
        }

        public class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
      }
    }
}
