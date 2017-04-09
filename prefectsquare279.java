import java.util.*;
public class prefectsquare279 {
    public static  int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int min = Integer.MAX_VALUE;
            int j =1;
            while(i-j*j>=0){
                min=Math.min(min,dp[n-j*j]+1);
                j++;
            }
            dp[i]=min;

        }
        return dp[n];
    }
    public static int[] count(int num){
        //根据这个树求出其最大开方数和余数
        int[] result = new int[2];
        int tmp = (int)Math.ceil(Math.pow(num,0.5));
        if(tmp*tmp==num){result[0]=tmp;result[1]=0;}
        else{int tmpnum = num-(tmp-1)*(tmp-1);
        result[0]=tmp-1;result[1]=tmpnum;}
        System.out.println("d");
        System.out.println(result[0]);
        System.out.println(result[1]);
        return result;    
    }
    public static void main(String[] args){
        int num = 12;
       System.out.println(numSquares(num));
    }
}
