//快速排序
public class Solution {

    public static void quick(int[] a){
        if(a.length>0){
            quicksort(a,0,a.length-1);
        }
    }
    public static void quicksort(int[] a,int low,int high){
        if(low<high){
        int medium=getmedium(a,low,high);
        quicksort(a,low,medium-1);
        quicksort(a,medium+1,high);}
    }
    public static int getmedium(int[]a,int low,int high){
        int temp=a[low];
        while(low<high){
            while(low<high&&a[high]>=temp){high--;}
            a[low]=a[high];
            while(low<high&&a[low]<=temp){low++;}
            a[high]=a[low];
        }
        a[low]=temp;
        return low;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int hei=matrix.length;
        int wid=matrix[0].length;
        int num=hei*wid;
        int[] val=new int[num];
        for(int i=0;i<num;i++){
            val[i]=matrix[i/wid][i%wid];
        }
        quick(val);
        return val[k-1];
        
    }

    
}

