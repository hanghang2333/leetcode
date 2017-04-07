#!/usr/bin/env python
# coding=utf-8
class Solution(object):
    def findMin(self,nums):
        length = len(nums)
        if length == 0:
            return -1
        if length == 1:
            return nums[0]
        if length == 2:
            return min(nums[0],nums[1]);
        left = 0
        right = length-1
        while left<right-1:
            middle = (left+right)/2
            if nums[middle]<nums[right] and nums[middle]<nums[left]:
                right = middle
            elif nums[middle]>nums[right] and nums[middle]>nums[left]:
                left = middle
            else:
                right = middle
        return min(nums[left],nums[right])

