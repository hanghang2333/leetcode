//给定一个数字，用这么多块砖摆梯子，求梯子最高长度
//直接求平方根可以得到一个大致范围，但具体值得不出，需要再遍历。
//所幸需要遍历的次数很少
public class Solution {
    public int arrangeCoins(int n) {
        /*
        int sum=0;int count=0;
        while(sum<=n){
            count++;
            sum+=count;
        }
        return count-1;
        */
        long nn=n;
        if(n<=0)return 0;
        if(n==1)return 1;
        long pos=(int)Math.sqrt(2*nn)+1;
        long i=pos;
        for(;i>0;i--){
            if(((i+1)*i)/2<=nn)break;
        }
        return (int)i;
    }
}
