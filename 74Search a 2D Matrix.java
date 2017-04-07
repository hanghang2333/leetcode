//给定一个已经排好序的矩阵，求其中是否包含某个元素
//先比较每一行的头，再依次比较
public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix==null)return false;
        int row=matrix.length;
        int col=matrix[0].length;
        for(int i=0;i<row;i++){
            if(matrix[i][0]==target)return true;
            else{if(i!=row-1){
                if(matrix[i][0]<target&&target<matrix[i+1][0]){
                    for(int j=0;j<col;j++){
                        if(matrix[i][j]==target)return true;
                    }
                }
              }
              else{
                  for(int j=0;j<col;j++){
                        if(matrix[i][j]==target)return true;
                    }
              }
            }
        }return false;
    }
}
