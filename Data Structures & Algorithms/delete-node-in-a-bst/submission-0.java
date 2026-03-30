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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode curr = root;
        TreeNode parent = null;

        while (curr != null && curr.val != key) {
            parent = curr;
            if (curr.val < key) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }

        if (curr == null) return root;

        if (curr.left == null || curr.right == null) {
            TreeNode child = (curr.left != null) ? curr.left : curr.right;

            if (parent == null) return child;

            if (parent.left == curr) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        } else {
            TreeNode par = null;
            TreeNode delNode = curr;

            curr = curr.right;
            while (curr.left != null) {
                par = curr;
                curr = curr.left;
            }

            if (par != null) {
                par.left = curr.right;
                curr.right = delNode.right;
            }

            curr.left = delNode.left;
            if (parent == null) return curr;

            if (parent.left == delNode) {
                parent.left = curr;
            } else {
                parent.right = curr;
            }
        }

        return root;
    }
}