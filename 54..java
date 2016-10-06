//给定矩阵，求输出的螺旋数组，用的方法比较粗暴，就是一圈一圈向里走。
public class Solution {
    public void diedai(int[] sum,int count,int[][] matrix,int h1,int h2,int p1,int p2,int all){
        if(count>=all)return;
        for(int i=h1;i<h2;i++){
            sum[count++]=matrix[p1][i];
        }if(count>=all)return;
        for(int i=p1;i<p2;i++){
            sum[count++]=matrix[i][h2];
        }if(count>=all)return;
        for(int i=h2;i>h1;i--){
            sum[count++]=matrix[p2][i];if(count>=all)return;
        }
        for(int i=p2;i>p1;i--){
            sum[count++]=matrix[i][h1]; if(count>=all)return;
        }
         //if(sum[all-1]!=-999)return;
         if((h1+1)<=(h2-1)&&(p1+1)<=(p2-1)){
         diedai(sum,count,matrix,h1+1,h2-1,p1+1,p2-1,all);}
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list=new ArrayList<Integer>();
        if(matrix==null)return list;
        int p=matrix.length;
        if(p==0)return list;
        int h=matrix[0].length;
        int h1=0,h2=h-1,p1=0,p2=p-1;
        int[]sum=new int[h*p];
        int count=0;
        if(p==1&&h==1)sum[0]=(matrix[0][0]);
        else diedai(sum,count,matrix,h1,h2,p1,p2,h*p);
        if(p==h&&p%2==1){sum[p*h-1]=matrix[p/2][h/2];}
        for(int i:sum){
            list.add(i);
        }
        return list;
    }
}