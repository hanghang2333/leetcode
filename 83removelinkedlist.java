//给定一个排好序的list，去除重复元素
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)return null;
        if(head.next==null)return head;
        ListNode temp=head;
        while(head!=null){
            int val=head.val;
            while(head.next!=null&&head.next.val==val){
                head.next=head.next.next;
            }
            head=head.next;
        }
        return temp;
    }
}
