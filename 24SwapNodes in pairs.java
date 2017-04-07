//给定一个list，每两个交换一下值
//直接交换值即可，不变动list
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode swapPairs(ListNode head) {
    ListNode headbak=head;
    int count=0;
     while(head!=null){
         if(count%2==0){
         ListNode temp=head.next;
         if(temp!=null){
         int tmp=temp.val;
         temp.val=head.val;
         head.val=tmp;}}
         count++;
         head=head.next;
     }
     return headbak;
    }
}
