//题意是求解给的目录路径里文件的最长字符串长度是多少
//采用的是：先split，而后根据\t的个数来判断高度，由于给的路径字符串的特点，所以可以
//从左向右依次遍历，将指定深度的长度存储到map里。
//若为文件，则直接比较是否是现存最长的。
//注意\t是转义字符，算作一个字符。
public class Solution {
    public int lengthLongestPath(String input) {
        Map<Integer,Integer> map=new HashMap<Integer,Integer>();
        map.put(0,0);
        int result=0;
        for(String s:input.split("\n")){
            int level=s.lastIndexOf("\t")+1;
            int len=s.substring(level).length();
            if(s.contains(".")){
                result=Math.max(result,map.get(level)+len);
            }
            else{
                map.put(level+1,map.get(level)+len+1);
            }
        }
        return result;
    }
}