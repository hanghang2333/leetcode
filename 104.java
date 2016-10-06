//����Ķ����������
//������һ����������ǰ����ȵ������������ȼ�1.��ǰ��Ϊ����������������
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