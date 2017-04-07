//给定一个树的中序遍历和后序遍历，恢复出来这个树
//解决:画个例子就可以看到，后续遍历的最后一个元素为root，而此值恰好将元素可以分为两部分，一部分在左子树，一部分在右子树。以此root的值为边界，可以获得当然根节点，可以从中序遍历和后序遍历里分别提取出属于左子树和右子树的中序遍历和后序遍历。
//写的过程需要用到数组截取，这里用的是copyOfRange方法来快速获取中序遍历的左部分和右部分。
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
           TreeNode head=diedai(inorder,postorder);
           return head;
        
    }
    public TreeNode diedai(int[] inorder,int[]postorder){
        int plen=postorder.length;
        if(plen==0)return null;
        //int root=Arrays.binarySearch(inorder,postorder[plen-1]);
        int root=0;
        for(int i=0;i<plen;i++){
            if(inorder[i]==postorder[plen-1]){root=i;break;}
        }
        int[] leftin=Arrays.copyOfRange(inorder,0,root);
        int[] rightin=Arrays.copyOfRange(inorder,root+1,plen);
        int[] leftpo=Arrays.copyOfRange(postorder,0,root);
        int[] rightpo=Arrays.copyOfRange(postorder,root,plen-1);
        TreeNode head=new TreeNode(postorder[plen-1]);
       // head.val=postorder[plen-1];
        head.left=diedai(leftin,leftpo);
        head.right=diedai(rightin,rightpo);
        return head;
    }
}
