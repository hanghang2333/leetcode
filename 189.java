//是一个对数组进行旋转的方式
//选择了采用翻转的方法，对于k词旋转，直接从结果出发
//比之前一次一次进行旋转得到的效率要高
public class Solution {
    public void rotate(int[] nums, int k) {
         int n=nums.length;
         k=k%n;
         reverse(nums,0,n-1);
         reverse(nums,0,k-1);
         reverse(nums,k,n-1);
    }
    public void reverse(int[] a,int start,int end){
        while(start<end){
           int temp=a[start];
            a[start]=a[end];
            a[end]=temp;
            start++;
            end--;
        }
    }
}
