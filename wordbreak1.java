/*************************************************************************
	> File Name: wordbreak1.java
	> Author:lihang 
	> Mail:1092978787@qq.com 
	> Created Time: 2017年04月07日 星期五 09时10分28秒
 ************************************************************************/
import java.util.*;
public class wordbreak1
{   public static void main(String[] args){
    String s="catsanddog";
   // String s ="bb";
    List<String> wordDict = new ArrayList<String>();
    wordDict.add("cat");
    wordDict.add("sand");
    wordDict.add("dog");
    wordDict.add("and");
    wordDict.add("cats");
    wordDict.add("b");
    List<String> res = wordBreak(s,wordDict);
    System.out.println("re");
    for(String i:res){
        System.out.println(i);
    }
}
    public static List<String> wordBreak(String s,List<String> wordDict){
    StringBuffer list = new StringBuffer();
    List<String> result = new ArrayList<String>();
    wordbreak(s,wordDict,list,result);
    return result;
}
    public static void  wordbreak(String s,List<String> wordDict,StringBuffer list,List<String> result){
        int len = wordDict.size();
    if(s.equals("")){
        result.add(list.toString().trim());
    }
    else{
        for(int j =0;j<len;j++){
            String i = wordDict.get(j);
            String ss = have(s,i);
            if(!(ss.equals("-"))){
                list.append(i);
                list.append(" ");
                List<String> wordDictt = new ArrayList<String>();
                //wordDictt.addAll(wordDict);
                wordDictt = wordDict.subList(j,wordDict.size());
                //wordDictt.remove(i);
                //StringBuffer listt = new StringBuffer(list.toString());
                //String sst = new StringBuffer(ss).toString();
                System.out.println(list);
                wordbreak(ss,wordDictt,list,result);
                list.delete(list.length()-i.length()-1,list.length()); 
            }
        }
    }
}
    public static String have(String s1,String s2){
        if(s1.equals(""))return "-";
        //返回s1中是否包含有s2的全部字符
        //如果有则返回已经去掉s2的s1，没有则返回“-”
        char[] cs2 = s2.toCharArray();
        int len = s2.length();
        int count =0;
        StringBuffer sb1=new StringBuffer(s1);
        for(char i:cs2){
            String ii = String.valueOf(i);
            int tmp = sb1.indexOf(ii);
            if(tmp==-1)break;
            else{
                count++;
                sb1.replace(tmp,tmp+1,""); 
            }
        }
        if(count == len){
            //完成了删除
            return sb1.toString();
        }
        else{
            return "-";
        }
    }
}
