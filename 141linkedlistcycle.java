//给定一个list，求其中是否有环
//思路还是之前的一快一满两个point，注意的是判空条件，以快的为标注，如果其为空或者其next或者next.next为空则直接停止，否则判断是否相等再改变flag
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
       if(head==null||head.next==null)return false;
       ListNode head1=head;
       ListNode head2=head.next;
       boolean flag=false;
       while(head2!=null&&head2.next!=null&&head2.next.next!=null)
       {
           if(head1==head2){return true;}
           head1=head1.next;
           head2=head2.next.next;
       }
       return flag;
    }
}
