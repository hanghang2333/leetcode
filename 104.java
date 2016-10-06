//求给的二叉树的深度
//利用了一个迭代，当前树深度等于子树最大深度加1.当前分为左子树和右子树。
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        int leftdepth=maxDepth(root.left)+1;
        int rightdepth=maxDepth(root.right)+1;
        return leftdepth>rightdepth?leftdepth:rightdepth;
    }
}