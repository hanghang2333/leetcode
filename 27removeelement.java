//给定一个数组和一个值，移除数组里所有这个值，不使用其他空间，数组里数的位置可以改变。
//解决:剩余长度可以由遍历得出
//改变数组元素的方法，从头遍历，对于每一个应该去除的位置，停下来进入一个由后往前得出非移除元素，将该值设置为此值即可。
public class Solution {
    public int removeElement(int[] nums, int val){
        int i=0;
        if(nums.length==0)return 0;
        for(int j=0;j<nums.length;j++){
            if(nums[j]==val)i++;
        }
        int flag=nums.length-1;
        for(int k=0;k<nums.length;k++){
            if(nums[k]==val){
                while(flag-1>=0&&nums[flag]==val){flag--;}
                nums[k]=nums[flag];if(flag>0){flag--;}
                System.out.println("flag"+flag);
            }
        }
                System.out.println(nums.length-i);
        return nums.length-i;
    }
}
