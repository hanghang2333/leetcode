//�鿴�������Ƿ��л������õķ������������ƶ���
//��slow��fast������������λ�úͳ�ʼ�㵽����ʼ������ϵ����ɵó�
//�����������ֻ��head��fast�ƶ����ɡ�
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