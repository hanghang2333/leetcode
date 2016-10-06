//给定一个list，需要将list内值小于给定数的元素放置在大于等于的前面，
//且元素表的初始顺序不可变化。
//使用的方法：先计数有几个小于的。
//而后遍历，小于的不管，大于等于的进行里循环，即从当前元素遍历，碰到大于x的就和当前外循环正比较的元素置换，小于则将该小值和外循环元素进行置换。
//之所以大于的也置换，是为了保持原顺序不变。
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void swap(ListNode l1,ListNode l2){
        int temp=l1.val;
        l1.val=l2.val;
        l2.val=temp;
    }
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null)return head;
        ListNode temp=head;
        ListNode temp1=head;
        int count=0;
        while(head!=null){
            if(head.val<x)count++;
            head=head.next;
        }
        int counttemp=0;
        int flag=0;
        while(temp!=null&&counttemp<count){
            ListNode n1=temp;
            //if(temp.val<x){}
            if(temp.val>=x){
                while(n1!=null){
                    n1=n1.next;
                    if(n1.val>=x){swap(n1,temp);}
                    if(n1.val<x){swap(n1,temp);break;}
                }
            }
            if(flag==0){temp1.val=temp.val;flag=1;}
            temp=temp.next;counttemp++;
        }
        return temp1;
    }
}
