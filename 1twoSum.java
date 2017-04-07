//给定一个数组和一个target，求数组中的两个元素位置使得和为其
public class Solution {
    public int[] twoSum(int[] nums, int target) {
       int len=nums.length;
       int[] result=new int[2];
       for(int i=0;i<len;i++){
           int tar=target-nums[i];
           for(int j=i+1;j<len;j++){
               if(nums[j]==tar){result[0]=i;result[1]=j;break;}
           }
       }
       return result;
    }
    public int[] twoSum2(int[] nums,int target){
      int len = nums.length;
      int[] result = new int[2];
      for (int i = 0;i<len;i++){
        int tar=target=nums[i];
        for (int j=0;j<len;j++){
          if(nums[j]==tar){result[0]=i;result[1]=j;break;}
        }
      }
    }
}
