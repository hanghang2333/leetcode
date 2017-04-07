//题意是给定一个链表，要将其中元素变换下位置这种。
//方法，直接将元素值先存储到一个list里，再遍历链表这样来改变。

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        ListNode headbak=head;
        List<Integer> list=new ArrayList<Integer>();
        while(headbak!=null){
            list.add(headbak.val);
            headbak=headbak.next;
        }
        int n=list.size()-1;
        for(int i=0;i<list.size();i++){
            if(i%2==0){head.val=list.get(i/2);}
            else{head.val=list.get(n-i/2);}
            head=head.next;
        }
    }
}
