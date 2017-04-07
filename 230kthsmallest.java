//给定二叉搜索树，查找其中第k个小元素
//中序遍历，这里采用对左边树节点计数的方式遍历。
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
    public int kthSmallest(TreeNode root, int k) {
        if(root==null)return -1;
        int leftcount=countNums(root.left);
        if(leftcount+1==k)return root.val;
        else if(leftcount+1<k){return kthSmallest(root.right,k-leftcount-1);}
        else {return kthSmallest(root.left,k);}
    }
    public int countNums(TreeNode tree){
        if(tree==null)return 0;
        return 1+countNums(tree.left)+countNums(tree.right);
    }
}
