public class searchinsert35 {
    public int searchInsert(int[] nums, int target) {
        int left = -1;int len = nums.length;
        while(left+1<len){
            int middle=(left+len)/2;
            if(nums[middle]<target)left=middle;
            else len=middle;
        }
        return len-1;
    }

}