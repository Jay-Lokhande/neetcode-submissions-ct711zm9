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
    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;
        return valid(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }


    public boolean valid(TreeNode root, int max, int min) {
        if (root == null) return true;
        if (root.val >= max || root.val <= min) return false;

        return valid(root.left, root.val, min) && valid(root.right, max, root.val);
    }
}
