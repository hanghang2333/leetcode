//给定一个数组从0到n缺失一个，求这个
//先排序，后遍历
public class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums[0]!=0)return 0;
        int flag=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]+1){
                flag=i;
            }
        }
        if(flag==0)flag=nums.length;
        return flag;
    }
}
