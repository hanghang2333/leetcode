/*************************************************************************
	> File Name: 42.java
	> Author: 
	> Mail: 
	> Created Time: 2016年10月16日 星期日 17时10分32秒
 ************************************************************************/
import java.util.HashMap.*;
import java.util.*;
public class my
{
    public static void main(String[]args){
        int[] shu={6,4,2,0,3,2,0,3,1,4,5,3,2,7,5,3,0,1,2,1,3,4,6,8,1,3};
        int[] shu1={9,6,8,8,5,6,3};
        System.out.println(trap(shu));
    }
public static int min(int i,int j){return i<j?i:j;}
public static int trap(int[] height) {
      int[] tmp=new int[height.length];
for(int i=0;i<height.length;i++){tmp[i]=height[i];}
int rh=0;int lh=height.length-1;
int head=0;int tail=height.length-1;
while(head<tail){
int mintmp=min(rh,lh);
//if(height[head+1]<=height[head]){tmp[head+1]=0;head++;}
//else{if(height[head+1]<=mintmp){tmp[head+1]}tmp[head]=0;head++;rh=head;}
//if(height[tail-1]<=height[tail]){tmp[tail-1]=0;tail--;}
//else{tmp[tail]=0;tail--;rh=tail;}
while(height[++head]<=mintmp||height[head]<=height[head-1]){tmp[head]=0;}rh=height[head];
while(height[--tail]<=mintmp||height[tail]<=height[tail+1]){tmp[tail]=0;}lh=height[tail];
}
for(int i=0;i<height.length;i++){System.out.println(tmp[i]);}

int counts=1;
int sum=0;
Map<Integer,Integer>maps=new HashMap<Integer,Integer>();
for(int i=0;i<height.length;i++){
    if(tmp[i]!=0)maps.put(counts++,i);
}
System.out.println("counts:"+counts);
for(int k=1;k<=counts-2;k++){
            System.out.println("dd");
//System.out.println("k:"+k);
//System.out.println("map:"+maps.get(2));
            int start=maps.get(k);
int end=maps.get(k+1);
//System.out.println("start:"+start+"end:"+end);
            if(start==end)continue;
            int heights=height[start]>=height[end]?height[end]:height[start];
            int all=(end-start-1)*heights;
            for(int j=start+1;j<end;j++){all=all-(height[j]>heights?heights:height[j]);}sum=sum+all;
        }
        return sum;}
    
}
