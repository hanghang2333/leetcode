//给定链表，去除其中值为对应值的
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null)return null;
        if(head.next==null&&head.val==val)return null;
        ListNode temp1=head;
        ListNode temp2=head;
        while(temp1.val==val&&temp1.next!=null){
            temp1=temp1.next;
        }
        while(head!=null){
            while(head.next!=null&&head.next.val==val){
                head.next=head.next.next;
            }
            //if(head.next!=null&&head.next.val==val){
              //  head.next=head.next.next;}
            head=head.next;
        }
        if(temp1!=null&&temp1.val!=val)
        return temp1;
        return null;
    }
}
