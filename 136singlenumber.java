//给定一个数组，里面所有元素出现两次只有一个是一次，
//解决:先排序，而后针对长度小于3的单独处理，对于单独元素在首尾的也单独处理。其他的循环查看其前后是否有相同的。
public class Solution {
    public int singleNumber(int[] nums) {
     Arrays.sort(nums);
     int len=nums.length;if(len==1)return nums[0];
     int flag=0;int count=0;
     if(nums[0]!=nums[1]){count=nums[0];return count;}
     if(nums[len-1]!=nums[len-2]){count=nums[len-1];return count;}
     for(int i=1;i<=nums.length-2;i++){
         if(nums[i]==nums[i-1])continue;
         else if(nums[i]==nums[i+1])continue;
         else {flag=i;break;}
     }
     count=nums[flag];return count;
    }
}
