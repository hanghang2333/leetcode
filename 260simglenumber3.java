//给定一个数组，有俩只出现一次，找出这两个
//求解过程先异火，而后对此结果二进制为1的地方表明那两个数在该位上不一样，为0的部分表明两个数在该为一样，而后筛选一下即可。这里的方法比较粗陋，大致是去结果最高位的二进制与其他的与，其他在该位也是1的为一类，不是的为一类。如此即可。
public class Solution {
    public int[] singleNumber(int[] nums) {
        int res=0;
        for(int i=0;i<nums.length;i++){
            res=res^nums[i];
        }
        int res1=0,res2=0;
        for(int i=0;i<nums.length;i++){
            if((res&nums[i])<=res>>1){
                res1=res1^nums[i];
            }
            else{
                res2=res2^nums[i];
            }
        }
        int[] result=new int[2];
        result[0]=res1;
        result[1]=res2;
        return result;
    }
}
