/*************************************************************************
	> File Name: guibingsort.java
	> Author: 
	> Mail: 
	> Created Time: 2016年10月01日 星期六 15时28分56秒
 ************************************************************************/

public class guibingsort
{
    public static void main(String[] args){
        int[] a={2,4,0,12,54,1,90,13};
        gbsort(a,0,7);
        for(int i:a){
            System.out.println(i);
        }
    }
    public static int[] gbsort(int[] a,int low,int high){
        int mid=(low+high)/2;
        if(low<high){
            gbsort(a,low,mid);
            gbsort(a,mid+1,high);
            merge(a,low,high,mid);
        }
        return a;
    }
    public static void merge(int[]a,int low,int high,int mid){
        int[] temp=new int[high-low+1];
        int i=low;
        int j=mid+1;
        int k=0;
        while(i<=mid&&j<=high){
            if(a[i]<a[j]){temp[k++]=a[i++];}
            else{temp[k++]=a[j++];}
        }
        while(i<=mid){temp[k++]=a[i++];}
        while(j<=high){temp[k++]=a[j++];}
        for(int k2=0;k2<high-low+1;k2++){
            a[low+k2]=temp[k2];
        }        

    }
}
