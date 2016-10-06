//求两个已排序数组的中位数。
//采用的是merge两个数组，而后求中的办法。
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] newsum=new int[nums1.length+nums2.length];
        int r=0,f=0;
        int i=0;
        for(i=0;i<nums1.length+nums2.length&&f<nums1.length&&r<nums2.length;i++){
            if(nums1[f]<=nums2[r])newsum[i]=nums1[f++];
            else if(nums1[f]>nums2[r])newsum[i]=nums2[r++];
        }
        if(f==nums1.length){
        for(;i<nums1.length+nums2.length;i++){
          newsum[i]=nums2[r++];  
        }}
        else  if(r==nums2.length){
        for(;i<nums1.length+nums2.length;i++){
          newsum[i]=nums1[f++];  
        }}
        if(newsum.length%2==1){return (double)newsum[newsum.length/2];}
        if(newsum.length%2==0){return (double)((newsum[newsum.length/2-1]+newsum[newsum.length/2])/2.0);}
        return 0; 
    }
}