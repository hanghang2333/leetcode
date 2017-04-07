//给定一个数组和一个值，求该值在数组出现的首个位置和最后位置。直接两头遍历即可。
public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result={-1,-1};
        int start=0,end=nums.length-1;
        boolean st=false,en=false;
        while(start<=end){
            if(nums[start]==target&&st==false){result[0]=start;st=true;}
            else if(st==false) start++;
            if(nums[end]==target&&en==false){result[1]=end;en=true;}
            else if(en==false)end--;
            if(en==true&&st==true)break;
        }
        return result;
    }
}
