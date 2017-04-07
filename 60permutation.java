//给定一个数字n和k，求n个数字组成的序列里第k个元素是什么
//经过排列组合可以得到，是有规律的，第1个元素以(n-1)!的长度变化，第2个元素以(n-2)!的长度变化，如此，可以提前将n!的各次阶乘计算出来，并且将数存储在list里，用过后一定记得删除掉。
//这里将数看做符号比较好理解为什么用过后要删除
public class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> nums=new ArrayList<Integer>();
        int[] fac=new int[n+1];
        fac[0]=1;
        for(int i=1;i<=n;i++){
            fac[i]=fac[i-1]*i;
            nums.add(i);
        }
        int tmp=n,count=n;
        k=k-1;
        StringBuilder sb=new StringBuilder();
        while(count>=1){
            int i=k/fac[tmp-1];
            sb.append(nums.get(i));
            tmp=tmp-1;k=k%fac[tmp];count--;nums.remove(i);
        }
        String res=sb.toString();
        return res;
    }
}
