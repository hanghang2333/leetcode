#!/usr/bin/env python
# coding=utf-8
class ListNode(object):
    def __init__(self,x):
        self.val = x
        self.next = None
class Solution(object):
    def deleteDuplicates(self.head):
        if head == None:
            return head
        prehead = ListNode(12345)
        prehead.next = head
        pre = prehead
        current = head
        while current!=None:
            while current.next!=None and current.val == current.next.val:
                current=current.next
            if pre.next == current:
                pre = pre.next
            else:
                pre.next = current.next
            current = current.next
        return prehead.next
