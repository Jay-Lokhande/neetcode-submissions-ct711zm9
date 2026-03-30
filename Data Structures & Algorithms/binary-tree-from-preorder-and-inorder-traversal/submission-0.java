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
    Map<Integer, Integer> map = new HashMap<>();
    int[] pre;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        pre = preorder;

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        int n = inorder.length;
        return build(0, n - 1, 0, n -1);
    }

    public TreeNode build (int inStart, int inEnd, int preStart, int preEnd) {
        if (inStart > inEnd || preStart > preEnd) return null;

        int val = pre[preStart];
        TreeNode newNode = new TreeNode(val);
        int rootIdx = map.get(val);
        int leftSize = rootIdx - inStart;
        newNode.left = build(inStart, rootIdx - 1, preStart + 1, preStart + leftSize);
        newNode.right = build(rootIdx + 1, inEnd, preStart + leftSize + 1, preEnd);

        return newNode;
    }

}
