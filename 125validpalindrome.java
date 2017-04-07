//给定字符串去掉标点看是否回文
public class Solution {
    public boolean isPalindrome(String s) {
        String ls=s.replaceAll("[\\pP‘'“”`]", "").replaceAll(" ","").toLowerCase();
        int len=ls.length();
        if(len<=1)return true;
        System.out.println(ls);
        for(int i=0;i<len;i++){
            if(ls.charAt(i)!=ls.charAt(len-i-1)){return false;}
        }
        return true;
    }
}
