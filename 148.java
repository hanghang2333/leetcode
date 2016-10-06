//单链表排序，采用的方法是：
//先利用遍历（两个指针，一快一慢）来将链表分为两个，而后递归此操作，并且对递归结果进行merge，最后返回正确的结果。
//和归并排序相似
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode merge(ListNode h1,ListNode h2){
        if(h1==null)return h2;
        if(h2==null)return h1;
        if(h1.val<=h2.val){
            h1.next=merge(h1.next,h2);
            return h1;
        }
        if(h1.val>h2.val){
            h2.next=merge(h2.next,h1);
            return h2;
        }
        return h1;
    }
    public ListNode sortList(ListNode head) {
        if(head==null){
            return head;
        }
        if(head.next==null){
            return head;
        }
        ListNode pre=head;
        ListNode p1=head;
        ListNode p2=head;
        while(p2!=null&&p2.next!=null){
            pre=p1;
            p1=p1.next;
            p2=p2.next.next;
        }
       pre.next=null;
       ListNode h1=sortList(head);
       ListNode h2=sortList(p1);
       return merge(h1,h2);
    }
    
}
