//给定一个数字n，多长度为n的数组串，从左向右隔一个删除，然后从
//右向左，如此，到只剩一个为止
//思路是只记录最左边的这个值，当最后一个时它也就是需要返回的值
//它会更新的情况,1.从左向右遍历时 2.剩余个数长度为奇数时。二者有可能会同时发生但也只更新一次，更新步长即为现在的step大小，step大小每轮增加一倍。
public class Solution {
    public int lastRemaining(int n) {
        boolean left=true;
        int remaining=n;
        int head=1;
        int step=1;
        while(remaining>1){
            if(left==true||remaining%2==1){
                head=head+step;
            }
            remaining=remaining/2;
            step=step*2;
            left=!left;
        }
        return head;
    }
}
