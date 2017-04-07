//给定一个数组和一个值，求解其中数组元素能够凑成这个和的数目的最小值
//解法:还是使用动态规划的思路，i和j分别作为开始和结束的位置坐标
//开始时sum一直加直到符合大于等于s，而后只要其大于等于就不断减去i++上的数，
//那么为什么是从头部开始减呢，因为其要求的字数组还必须是原数组的子数组，故而必然是连续的。
public class Solution {
    public int minSubArrayLen(int s, int[] a) {
  if (a == null || a.length == 0)
    return 0;
  
  int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
  
  while (j < a.length) {
    sum += a[j++];
    
    while (sum >= s) {
      min = Math.min(min, j - i);
      sum -= a[i++];
    }
  }
  
  return min == Integer.MAX_VALUE ? 0 : min;
    }
}
