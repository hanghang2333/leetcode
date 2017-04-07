//给定有序数组，求解出对应的二叉搜索树
//思路很简单，使用数组截取函数copyOfRange。
//按照搜索二叉树的规则，即左子树元素小于根，右子树大于根的原则，直接选择中点元素进行递归即可。
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
    public TreeNode sortedArrayToBST(int[] nums) {
        int len=nums.length;
        if(nums.length==0)return null;
        int index=(len-1)/2;
        TreeNode root=new TreeNode(nums[index]);
        root.left=sortedArrayToBST(Arrays.copyOfRange(nums,0,index));
        root.right=sortedArrayToBST(Arrays.copyOfRange(nums,index+1,len));
        return root;
    }
}
