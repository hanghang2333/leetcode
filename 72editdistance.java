//编辑距离，删除，改变，增加
//思路:动态规划
//对于每一个edit(i,j)有四种可能，前三种是特殊情况，直接给出结果。
//第四种是需要递归的，递归有三种思路，一个是删除一个字符串最右一位，一个是删除第二个字符串最右一位，一个是都删除一位，按照对应的状态。输出这三种思路里最小的
//增加edit数组，使得不重复计算。
public class Solution {
    public int minDistance(String word1, String word2) {
     int len1=word1.length();int len2=word2.length();
     if(len1==0)return len2;if(len2==0)return len1;
     int[][] edit=new int[len1][len2];
     //System.out.println(+":"+j);
     int result=fedit(word1,word2,len1-1,len2-1,edit);
     return result;
    }
    public int max(int x,int y,int z){
        int max=x;if(max>y)max=y;if(max>z)max=z;return max;
    }
    public int fedit(String word1,String word2,int i,int j,int[][]edit){
        //System.out.println(i+":"+j);
        if(i<0&&j<0)return 0;
        if(i<0&&j>=0)return j+1;
        if(i>=0&&j<0)return i+1;
        if(edit[i][j]!=0)return edit[i][j];
        int here=0;
        if(word1.charAt(i)!=word2.charAt(j))here=1;
        int len=max(fedit(word1,word2,i-1,j-1,edit)+here,fedit(word1,word2,i-1,j,edit)+1,fedit(word1,word2,i,j-1,edit)+1);
        edit[i][j]=len;
        //System.out.println(i+":"+j+"len"+len);
        return len;
    }
}
