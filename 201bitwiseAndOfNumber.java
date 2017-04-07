//给定一个数字的范围，将这个范围的所有数字的二进制表示与运算，求结果
//首先当m为0时为0，给定了范围则一定是有奇数和偶数，所以最后一位一定是0.此时将范围缩小一倍，即将head和tail都右移一位，如果二者还不相等，说明此时范围还没有到达1，所以还是有奇数偶数，所以最后一位还是0.如此，记录下来一共右移了多少为，最后将m=n的m的结果与右移次数相乘，即为结果。
public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        if(m==0)return 0;
        int step=1;
        while(m!=n){
            m=m>>1;
            n=n>>1;
            step=step<<1;
        }
        return m*step;
        
    }
}
