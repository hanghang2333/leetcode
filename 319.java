//给定灯泡数目n，初始状态为off，而后从1到n，找出能够整除的位置灯泡按下开关，最后求最后开着的等的数目。
//解决：对于不能整除的数来说，一定是操作了偶数次，结果还是off，只有能够整除的才会操作奇数次变为on
//小于n的所有完全平方数，为sqrt(n)个。
public class Solution {
    public int bulbSwitch(int n) {
        int sum=0;
        sum=(int)Math.sqrt(n);
        return sum;
    }
}
