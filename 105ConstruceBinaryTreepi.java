//给定二叉树的中序和前序恢复
//数组截取copyOfRange。
//递归
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        TreeNode root=loop(preorder,inorder);
        return root;
    }
    public TreeNode loop(int[] pre,int[]in){
        if(pre.length==0)return null;
        if(pre.length==1){TreeNode tree=new TreeNode(pre[0]);return tree;}
        int root=0;
        for(int i=0;i<in.length;i++){
            if(in[i]==pre[0]){root=i;break;}
        }
        int[] preleft=Arrays.copyOfRange(pre,1,root+1);
        int[] preright=Arrays.copyOfRange(pre,root+1,pre.length);
        int[] inleft=Arrays.copyOfRange(in,0,root);
        int[] inright=Arrays.copyOfRange(in,root+1,in.length);
        TreeNode tree=new TreeNode(pre[0]);
        tree.left=loop(preleft,inleft);
        tree.right=loop(preright,inright);
        return tree;
    }
}
