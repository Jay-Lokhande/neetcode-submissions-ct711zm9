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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // preorder(list, root);
        // return list;.
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                list.add(cur.val);
                stack.push(cur.right);
                cur = cur.left;
            }

            cur = stack.pop();



        }

        return list;
    }

    public void preorder(List<Integer> list, TreeNode root) {
        if (root == null) return;
        list.add(root.val);
        preorder(list, root.left);
        preorder(list, root.right);
    }
}