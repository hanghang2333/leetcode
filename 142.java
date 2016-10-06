//查看链表里是否有环，采用的方法是两个点移动，
//即slow和fast。根据相遇点位置和初始点到环起始点距离关系计算可得出
//到达相遇点后只需head和fast移动即可。
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
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null)return null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                while(head!=fast){
                    head=head.next;
                    fast=fast.next;
                }
                return head;
            }
        }
        return null;
    }
}