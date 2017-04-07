//给定一个数组，为当天袜子的价格。任意天可以任意买入或者卖出，求最大利润
//想法很简单，从第1天开始，比较与之前价格，如果升高了，则把差价加到利润里，因为可以昨天买入今天卖出这样，从头遍历即可
public class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        for(int i=1;i<prices.length;i++)
        {
            if(prices[i]>prices[i-1]){
                profit=profit+prices[i]-prices[i-1];
            }
        }
        return profit;
    }
}
