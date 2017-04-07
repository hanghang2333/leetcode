//题意中给了三个字符串，要求给出第三个字符串是否是由前两个字符串交叉形成的。
//最简单的思路就是递归，依次对三个字符串的首元素进行比对递归，但是发生了时间超时，所以需要用动态规划。由于只有两个字符串，可以画一个数组，横轴是第一个串，竖轴是第二个串，这样，能否从前两个串形成第三个串的问题就变为能否从左上角走到右下角。依次填充矩阵。对于任意一点，向右走表示接下来用s2进行比对，向下走表示接下来用s1比对，对于边缘部分单独处理。其他元素正常输出，需要注意的是，每个位置都依赖与自己左边和上边的元素是真还是假。
public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int len1=s1.length(),len2=s2.length(),len3=s3.length();
        if(len3!=len1+len2)return false;
        if(len1==0)return s2.equals(s3);
        if(len2==0)return s1.equals(s3);
        boolean[][] map=new boolean[len1+1][len2+1];
        for(int i=0;i<=len1;i++)
        for(int j=0;j<=len2;j++){
            if(i==0&&j==0)map[i][j]=true;
            else if(i==0){
                map[i][j]=(s2.charAt(j-1)==s3.charAt(i+j-1))&&map[i][j-1];
            }
            else if(j==0){
                map[i][j]=(s1.charAt(i-1)==s3.charAt(i+j-1))&&map[i-1][j];
            }
            else{
                map[i][j]=(map[i][j-1]&&(s2.charAt(j-1)==s3.charAt(i+j-1)))||(map[i-1][j]&&(s1.charAt(i-1)==s3.charAt(i+j-1)));
            }
        }
       
        return map[len1][len2];
       // System.out.println(len1+""+len2);
    }
}
