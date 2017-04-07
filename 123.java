 /*可以计算出最多k次交易前提下任何的，这里规定k=2；
    我们定义local[i][j]为在到达第i天时最多可进行j次交易并且最后一次交易在最后一天卖出的最大利润，此为局部最优。然后我们定义global[i][j]为在到达第i天
    最多可进行j次交易的最大利润，此为全局最优。它们的递推式为：
    local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)
    global[i][j]=max(local[i][j],global[i-1][j])，
其中局部最优值是比较前一天并少交易一次的全局最优加上大于0的差值，和前一天的局部最优加上差值中取较大值，而全局最优比较局部最优和前一天的全局最优。代码如下：
        */
//这也是分而治之的方法。每次在当前位置按照是否交易分为两个问题，进而有局部最优值和全局最优。
public class Solution {
    public int maxProfit(int[] prices) {
    int len=prices.length;if(len==0||len==1)return 0;
    int[][] local=new int[len][3];
    int[][] global=new int[len][3];
    for(int i=1;i<len;i++){
        int diff=prices[i]-prices[i-1];
        for(int j=1;j<=2;j++){
            local[i][j]=Math.max(global[i-1][j-1]+Math.max(diff,0),local[i-1][j]+diff);
            global[i][j]=Math.max(local[i][j],global[i-1][j]);
        }
    }
    return global[len-1][2];
    }
}
