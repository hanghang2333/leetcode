public class reversepair493 {
    public int reversePairs(int[] nums) {
        //Given an array nums, we call (i, j) an important reverse pair if 
        //i < j and nums[i] > 2*nums[j].
        //Input: [1,3,2,3,1]  Output: 2
        //Input: [2,4,3,5,1]  Output: 3
        int len = nums.length;
        int count = 0;
        for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                if(nums[i]-nums[j]>nums[j])count++;
            }
        }
        return count;
    }
}