/*************************************************************************
	> File Name: VerifyPre331.java
	> Author:lihang 
	> Mail:1092978787@qq.com 
	> Created Time: 2017年04月06日 星期四 16时56分08秒
 ************************************************************************/

public class VerifyPre331
{
    public boolean isValidSerialization(String preorder){
    //判断是否是合法的
    //首先长度要合法，需要是pow(2,n)-1个。长度不对的肯定不行
    //其次就是任何节点的父节点不能够是#。一个节点的父节点坐标是(n-1)/2
    if(preorder.equals(""))return true;
    String[] array = preorder.split(",");
    int len = array.length;
    if(len%2==0)return false;
    int count =0;
    for(int i=1;i<len;i++){
        if(array[i].equals("#")){
            count++;
        }
        if(array[(i-1)/2].equals("#"))
            return false;
    }
    return true;
    }
    public static boolean hefalen(int len){
        //判断len是否合法
        int tmp = 1;
        int count =2;
        if(len==1)return true;
        boolean flag = false;
        while(tmp<len){
            count = count*2;
            tmp=count-1;
            if(tmp==len)flag=true;
        }
        return flag;
    }
    public boolean isVaild(String preorder){
        String[] nodes = preorder.split(",");
        int diff = 1;
        for(String node :nodes){
            if(--diff<0)return false;
            if(!node.equals("#"))diff=diff+2;
        }
        return diff==0;
    }
}
