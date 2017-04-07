/*************************************************************************
	> File Name: 59SpiralMatrix.java
	> Author:lihang 
	> Mail:1092978787@qq.com 
	> Created Time: 2017年03月05日 星期日 12时06分26秒
 ************************************************************************/
public class SpiralMatrix59
{
    public static int[][] generateMatrix(int n){
        int[][] result=new int[n][n];
        //对于n有(n+1)/2个圈需要循环，每一圈需要循环的个数为:2*n+2*(n-2)=4*n-4个位置,当本圈内为列时需要循环个数为4×k-4.特殊情况k=1时是1个。需要循环的圈的序列为n,n-2,
        int k=n;
        int num=1;
        while(k>0){//当前圈列数为k
            if(k==1){
                result[n/2][n/2]=num;
            }
            //对于每一圈除非k=1分为4分来组织元素位置，每一份内有元素k-1个
            int incount = 0;
            while(incount<4*k-4){
            int dangqaianfen = incount/(k-1);
            int dangqaianfennei = incount%(k-1);
            if(dangqaianfen==0){
                int hang=(n-k)/2;
                int lie =(n-k)/2+dangqaianfennei;
                result[hang][lie]=num;
            }
            if(dangqaianfen==1){
                int hang=(n-k)/2+dangqaianfennei;
                int lie = n-(n-k)/2-1;
                result[hang][lie]=num;
            }
            if(dangqaianfen==2){
                int hang=n-(n-k)/2-1;
                int lie = n-(n-k)/2-dangqaianfennei-1;
                result[hang][lie]=num;
            }
            if(dangqaianfen==3){
                int hang = n-dangqaianfennei-1-(n-k)/2;
                int lie = (n-k)/2;
                result[hang][lie]=num;
            }
            num++;
            incount++;
        }
        k=k-2;}
        return result;
    }
    public static void main(String[] args){
        int n=4;
        int[][] res=generateMatrix(n);
        for(int i =0;i<n;i++){
            for (int j=0;j<n;j++){
                System.out.println(res[i][j]);
            }
        }
    }
}
