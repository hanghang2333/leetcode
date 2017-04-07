//题意就是给定一个矩阵，求其中增长路径的最大值
//解决方法是对于每一个cell都进行dfs
//最重要的是将中间结果缓存，降低复杂度
//方法是传入一个cache矩阵，将每一轮计算结果都缓存下。
public class Solution {
    public static final int[][] dirs={{-1,0},{1,0},{0,-1},{0,1}}; 
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length==0)return 0;
        int m=matrix.length;int n=matrix[0].length;
        int [][]cache=new int[m][n];
        int max=1;
        for(int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                int len=dfs(matrix,i,j,cache);
                max=Math.max(max,len);
            }
        }
        return max;
    }
    public int dfs(int[][]mat,int x,int y,int[][]cache){
        if(cache[x][y]!=0)return cache[x][y];
        int max=1;
        for(int[] dir:dirs){
            int xx=x+dir[0];int yy=y+dir[1];
            if(xx<0||yy<0||xx>=mat.length||yy>=mat[0].length||mat[xx][yy]<=mat[x][y])continue;
            int len=dfs(mat,xx,yy,cache)+1;
            max=Math.max(max,len);
        }
        cache[x][y]=max;
        return max;
    }
}
