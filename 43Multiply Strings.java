//给定两个String表示的整数，求乘积
//解决:先定义一个长度为二者之和的数组，从低位往前乘，可以从例子里看到的是:
//假定每个string首位坐标为0，则第i个数和第j个数相乘的结果的坐标为p1=i+j,p2=i+j+1;如此，可以两层循环来求解，每两个元素的乘积放入到相应的位置即可。
//最后在结果输出时在处理首位为0等情况
public class Solution {
    public String multiply(String num1, String num2) {
        int m=num1.length(),n=num2.length();
        int[] res=new int[m+n];
        for(int i=m-1;i>=0;i--)
        for(int j=n-1;j>=0;j--){
            int mul=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
            int p1=i+j;int p2=i+j+1;
            int sum=res[p2]+mul;
            res[p1]+=sum/10;
            res[p2]=sum%10;
        }
        String sres="";
        boolean first=true;
        for(int i:res){
            if(i==0&&first==true){}
            else {sres+=i+"";first=false;}
        }
        if(sres=="")sres="0";
        return sres;
    }
    
}
