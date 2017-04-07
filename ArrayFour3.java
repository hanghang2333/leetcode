/*************************************************************************
	> File Name: ArrayFour3.java
	> Author:lihang 
	> Mail:1092978787@qq.com 
	> Created Time: 2017年03月06日 星期一 14时51分17秒
 ************************************************************************/
import java.util.*;
public class ArrayFour3
{
    public static void main(String[] args){
        int[] A = {12,1,1,13,1,13,1,1,12};
        HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] sums = new int[A.length];
        int tmp=0;
        for(int i = 0;i<A.length;i++){
            tmp=tmp+A[i];
            sums[i]=tmp;
            map.put(tmp,i);
        }
        for(int pos1=1;pos1<A.length;pos1++){
            int sum=sums[pos1]-A[pos1];//sum为数组和
            if(map.containsKey(sum+sums[pos1])){
                int pos2=map.get(sum+sums[pos1]+1);
                if(pos2 <A.length && map.containsKey(sum+sums[pos2])){
                    int pos3=map.get(sum+sums[pos2]+1);
                    if(pos3< A.length &&sums[A.length-1]-sums[pos3] == sum){
                        System.out.println("True"+pos1+"-"+pos2+"_"+pos3);return;
                    }
                }
            }
        }
    System.out.println("False");
    }
}
