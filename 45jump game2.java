//题意是给定一个数组，每个元素值为当你位于这个位置时可以走的最大步长，求解的是求出从头开始到达结尾最少的步数。
//解决:按照分而治之的思路，从结尾开始考虑，从后向前数，如果存在某一个点的步长恰好等于此点位置和尾巴的距离，那么一步就可以从这里走到。当然这个点必须要遍历到头部才能保证找到的这个点是全局最优的。而后问题可缩小为更小的问题。
public class Solution {
    int count=0;
    public int jump(int[] nums) {
        int tail=nums.length-1;
        diedai(nums,tail);
        return count;
    }
    public void diedai(int[]nums,int tail){
        if(tail==0)return;
        int tailbak=tail;
        int flag=tail;
        int pathlen=0;
        while(tailbak>0){
            tailbak--;
            pathlen+=1;
            if(nums[tailbak]>=pathlen){
                flag=tailbak;
            }
        }
        count++;
        diedai(nums,flag);
    }
}
