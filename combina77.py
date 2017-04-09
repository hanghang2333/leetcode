#!/usr/bin/env python
# coding=utf-8
def backtrack(nums,k,list,result):
    if len(list)==k:
        result.add(list)
    else:
        tmpindex = 0
        if len(list)!=0:
            tmpindex=list[len(list)-1]
            for i in range(tmpindex,len(nums)):
                list.append(nums[i])
                listtmp = [n for n in list]
                backtrack(nums,k,list,result)
                list=list[0:-1]
def combine(self,n,k):
    nums = [i+1 for i in range(n)]
    list = []
    result = []
    backtrack(nums,k,list,result)
    return result
