/*************************************************************************
	> File Name: findmin1.java
	> Author:lihang 
	> Mail:1092978787@qq.com 
	> Created Time: 2017年04月06日 星期四 21时39分59秒
 ************************************************************************/

public class findmin1
{
    public int findMin(int[] nums){
        //二分查找,当当前元素比两头的都小时，则最小值在左侧，否则在右侧
        int len = nums.length;
        if(len == 0)return -1;
        if(len ==1) return nums[0];
        int left = 0;
        int right = len-1;
        while(left!=right){
            int middle = (left+right)/2;
            if(middle<nums[right]&&middle<nums[left]){
                right = middle;
            }
            else{
                left = middle;
            }
        }
        return left;
    }
}
