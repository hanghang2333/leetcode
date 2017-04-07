//给定一个矩阵，给定左上角和右下角，求区块内和
//直接遍历计算即可。
public class NumMatrix {
    int[][] matrix;
    public NumMatrix(int[][] matrix1) {
       matrix=matrix1;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum=0;
        for(int i=row1;i<=row2;i++){
            for(int j=col1;j<=col2;j++){
                sum=sum+matrix[i][j];
            }
        }return sum;
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
