//给定一个二叉树，中序遍历
//迭代即可，左不为空则向左走，右边同理，将root纳入list即可
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
     List<Integer> list=new ArrayList<Integer>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null)return list;
       diedai(root);
       return list;
    }
    public void diedai(TreeNode root){
       if(root.left!=null){diedai(root.left);}
       list.add(root.val);
       if(root.right!=null){diedai(root.right);}
    }
}
