//给定x,n，求x的n次方
//方法，递归求解pow(x,n/2),这样可以减少运算次数，而后依据n是奇数还是偶数，决定结果是否再乘x。
public class Solution {
    public double myPow(double x, int n) {
        double ans=pows(x,n);
        if(n<0)return 1/ans;
        else return ans;
    }
    public double pows(double x,int n){
        if(n==0)return 1;
        if(x==1)return x;
        if(n==1||n==-1)return x;
        double ans=pows(x,n/2);
        if(n%2==0){
            ans=ans*ans;
        }
        else {
            ans=ans*ans*x;
        }
        return ans;
    }
}
