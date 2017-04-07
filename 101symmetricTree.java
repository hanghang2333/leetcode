//给定一颗二叉树看是否对称
//直接递归遍历即可
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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        boolean flag=true;
        flag=loop(root.left,root.right);
        return flag;
    }
    public boolean loop(TreeNode Left,TreeNode Right){
        if(Left==null&&Right==null)return true;
        else if(Left==null||Right==null)return false;
        if(Left.val!=Right.val)return false;
        else{
            return loop(Left.left,Right.right)&&loop(Left.right,Right.left);
        }
    }
}
