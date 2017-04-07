//给定一个字符串，求其中第一个单独的元素
//直接遍历
public class Solution {
    public int firstUniqChar(String s) {
        char[] ss=s.toCharArray();
        int index=-1;
        for(int i=0;i<ss.length;i++){
            char temp=ss[i];index=i;
            for(int j=0;j<ss.length;j++){
                if(i!=j&&ss[j]==ss[i]){index=-1;break;}
            }
            if(index!=-1){break;}
        }
        return index;
    }
}
