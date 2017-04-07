/*************************************************************************
	> File Name: deleteduplicates.java
	> Author:lihang 
	> Mail:1092978787@qq.com 
	> Created Time: 2017年04月06日 星期四 20时30分31秒
 ************************************************************************/
class ListNode{
    int val;
    ListNode next;
}
public class deleteduplicates
{
    public ListNode deleteduplicate(ListNode head){
        ListNode prehead = new ListNode();
        prehead.next = head;
        int cur = head.val;
        ListNode current = prehead;
        while(head.next!=null){
            int count = 0;
            ListNode tmp = new ListNode();
            while(head.val == cur){count++;tmp = head;head = head.next;}
            if(count == 1){current.next=tmp;current = tmp;}
            cur = head.val;
        }
        return prehead.next;
    }
}
