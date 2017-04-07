//题目是给定一个数字数组，求解其中最大和值的子数组。即一个字数组要求其和很大，是
//最大的。
//解决:首先这个子数组一定的最大和的，所以不论向右还是向左只要扩展都会导致
//和变小，所以从左向右遍历，在第i个位置，求解前i个元素最大连续子串的和。
//即:dp[i]的意思是:包含自己在内，能够向前扩展的连续的子数组里最大的和。
//得到这个数组后，可以想到:要求的子数组是和最大的，且其一定是包含至少一个元素的，以结尾元素来看，这个最大子数组就是其前面所有能够扩展的最长的和最大的子数组，所以其和是dp数组里最大值。
public class Solution {
    public int maxSubArray(int[] nums) {
        int len=nums.length;
        int sum=0;
        int[] dp=new int[len];
        dp[0]=nums[0];
        int max=dp[0];
        for(int i=1;i<len;i++){
            dp[i]=nums[i]+(dp[i-1]>0?dp[i-1]:0);
            max=Math.max(max,dp[i]);
        }
        return max;
    
    }
}
