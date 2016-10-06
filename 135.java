//给小朋友按照分数分糖，要求对于比左右相邻人分数高的人应该得到更多的唐，
//给予分数，求最少糖
//思路是从左往右便利，如果分数高与左边哪个人则多给一个，否则就给一个
//然后反向便利，如果分数高且糖数少或者等于，则多给一个。
public class Solution {
    public int candy(int[] ratings) {
        int len=ratings.length;
        int[] ans=new int[len];
        ans[0]=1;
        for(int i=1;i<=len-1;i++){
            if(ratings[i]>ratings[i-1])ans[i]=ans[i-1]+1;
            else ans[i]=1;
        }
        for(int i=len-2;i>=0;i--){
            if(ratings[i]>ratings[i+1]&&ans[i]<=ans[i+1])ans[i]=ans[i+1]+1;
        }
        int ret=0;
        for(int i:ans){
            ret=ret+i;
        }
        return ret;
    }
}
