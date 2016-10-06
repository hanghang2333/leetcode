//给定一个dna字符串，找出其中十个为长度的出现不只一次的子串
//采用了两个set，将每十个都add到set1，当不是第一次add时会返回false，此时set将其add入即可。
public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> set=new HashSet<String>();
        Set<String>reset=new HashSet<String>();
        int len=s.length();
        for(int i=0;(i+10)<=len;i++){
            String substr=s.substring(i,i+10);
            if(!set.add(substr))reset.add(substr);
        }
        List<String> list=new ArrayList(reset);
        return list;
    }
}
