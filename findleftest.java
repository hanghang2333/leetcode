import java.util.*;
class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
 
public class findleftest {
    public int findBottomLeftValue(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<TreeNode>();
        int res = 0;
        deque.offer(root);
        while(deque.size()>0){
            int size = deque.size();
            res = deque.peek().val;
            while(size>0){
                TreeNode tmp = deque.poll();
                deque.offer(tmp.left);
                deque.offer(tmp.right);
            }
        }
    return res;
    }

}
def fin(root):
    res = 0
    list = []
    list.append(root)
    while(len(list)>0):
        size = len(list)
        tmp = list.pop(0)
        res = tmp.val
        if tmp.left!=None:
            list.append(tmp.left)
        if tmp.right!=None:
            list.append(tmp.right)
        size = size -1
        while size >0:
            tmp = list.pop(0)
            if tmp.left!=None:
                list.append(tmp.left)
            if tmp.right!=None:
                list.append(tmp.right)
    return res