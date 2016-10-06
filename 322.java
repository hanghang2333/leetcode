//给定硬币面额，和钱数，求最少硬币数目。
public class Solution {
    public static void swap(int[] coins,int i,int j){
        int tmp=coins[i];
        coins[i]=coins[j];
        coins[j]=tmp;
    }
    public static void sort(int[] coins){
        qsort(coins,0,coins.length-1);
    }
    public static void qsort(int[] coins,int head,int tail){
        if(tail<=head)return;
        int mid=partition(coins,head,tail);
        qsort(coins,head,mid-1);
        qsort(coins,mid+1,tail);
    }
    public static int partition(int[]coins,int head,int tail){
        //int mid=head;
       // if(head<=tail)return;
        int i=head;
        int j=tail+1;
       int tmp=coins[head];
        while(true){
            while(coins[++i]>tmp)if(i==tail)break;
            while(coins[--j]<tmp)if(j==head)break;
            if(i>=j)break;
            swap(coins,i,j);
        }
        swap(coins,head,j);
        return j;
    }
    int count=0;
    int flag=-1;
    public void diedai(int[] coins,int left){
        int flag1=0;
        if(left==0){flag=0;return;}
        for(int i=0;i<coins.length&&flag1==0;i++){
            if(coins[i]<=left){
                flag1=1;
                left=left-coins[i];
                count++;
                diedai(coins,left);
            }
        }
    }
    int minCount = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
		count(amount, coins.length - 1, coins, 0);
		return minCount == Integer.MAX_VALUE ? -1 : minCount;
	}

	void count(int amount, int index, int[] coins, int count) {
		if(amount % coins[index] == 0) {
			int newCount = count + amount / coins[index];
			if(newCount < minCount)
				minCount = newCount;
		}
		
		if(index == 0)
			return;
			
		for (int i = amount / coins[index]; i >= 0; i--) {
			int newAmount = amount - i * coins[index];
			int newCount = count + i;
			
			int nextCoin = coins[index-1];
			if(newCount + (newAmount + nextCoin -1) / nextCoin >= minCount)
				break;
			
			count(newAmount, index - 1, coins, newCount);
		}
	}
}