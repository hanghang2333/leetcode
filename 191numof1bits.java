//题意是给定一个数，求其中二进制中１的个数
//需要注意的是虽然输入的int,但是实际的输入则可能会大于int.因为输入的是unsigned值而我们处理的是signed的值，所以注意这里使用的是n!=0,而非n>0.因为输入的unsigned值在这里会被转化为负数值来进行计算。所以这里:使用位计算似乎可以使得在右移时不损失数据原始值，即输入的值不会因为超过界限而被去除。
   public class Solution {

        public int hammingWeight(int n) {
	int ones = 0;
    	while(n!=0) {
    		ones = ones + (n & 1);
    		n = n>>>1;
    	}
    	return ones;
        }
    }
