import java.util.*;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }
public class pathsum113 {
       public List<List<Integer>> pathSum(TreeNode root, int sum) {
       List<List<Integer>> result = new ArrayList<List<Integer>>();
       List<Integer> list = new ArrayList<Integer>();
       if(root==null)return result;
       TreeNode prehead = new TreeNode(0);
       prehead.left = root;
       backtrack(prehead,sum,0,list,result);
       if (result.size()==0){List<Integer> n =  new List<Integer>();return n;}
       return result;
    }
    public static void backtrack(TreeNode root,int sum,int cur,List<Integer>list,List<List<Integer>>result){
        if(cur==sum){
            if(list.size()>0){
            result.add(list);return;}
        }
        if(root.left!=null){
            //list.add(root.left.val);
            int curtmp = cur+root.left.val;
            List<Integer> listtmp = new ArrayList<Integer>();
            listtmp.addAll(list);
            listtmp.add(root.left.val);
            backtrack(root.left,sum,curtmp,listtmp,result);
            
        }
        if(root.right!=null){
            //list.add(root.right.val);
            int curtmp = cur+root.right.val;
            List<Integer> listtmp = new ArrayList<Integer>();
            listtmp.addAll(list);
            listtmp.add(root.right.val);
            backtrack(root.right,sum,curtmp,listtmp,result);
        }
    }
}