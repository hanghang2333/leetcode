//给定一个数组，求吗袜子最佳时机，只能买一次
//遍历，每次取最小值，和当前值与最小值的差值
public class Solution {
    public int maxProfit(int[] prices) {
      if (prices.length==0) return 0;
        int res = 0;
        int minp = prices[0];
        for (int i = 0; i < prices.length; ++i) {
            minp = Math.min(minp, prices[i]);
            res = Math.max(res, prices[i] - minp);
        }
        return res;   
    }
}
