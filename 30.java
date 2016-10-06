/×题意是在字符串s里寻找到包含这字符串数组所有元素（无关顺序）且之间没有其他元素的子字符串的起始index。方法是将数组所有元素入map，而后以start为起始，以wordlen为步长，依次查看s中元素在map中，在则入curmap并记录个数，不在则start前移相应距离重新开始。
主要的思路是设置一个windowLen，来不断能够前移查看。
×/
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res=new ArrayList<Integer>();
        if(words.length==0||s.length()==0||words==null)return res;
        int len=words.length;
        List<Integer> num=new ArrayList<Integer>();
        int sLen=s.length();
        int wordLen=words[0].length();
        int windowLen=len*wordLen;
        HashMap<String,Integer> wordmap=new HashMap<String,Integer>();
        for(String word: words){
            wordmap.put(word,wordmap.getOrDefault(word,0)+1);
        }
        for(int i=0;i<wordLen;i++){
            HashMap<String,Integer> curmap=new HashMap<String,Integer>();
            for(int j=i, count=0,start=i;j+wordLen<=sLen;j=j+wordLen){
                if(start+windowLen>sLen)break;
                String word=s.substring(j,j+wordLen);
                if(!wordmap.containsKey(word)){
                    start=j+wordLen;
                    curmap.clear();
                    count=0;
                }
                else{
                    if(j-start==windowLen){
                        String removeword=s.substring(start,start+wordLen);
                        int val=curmap.get(removeword);
                        if(val==1)curmap.remove(removeword);
                        else{
                            curmap.put(removeword,val-1);
                        }
                        if(val-1>=wordmap.get(removeword))count--;
                        start=start+wordLen;
                    }
                    curmap.put(word,curmap.getOrDefault(word,0)+1);
                    if(curmap.get(word)>wordmap.get(word))count++;
                    if(start+windowLen==j+wordLen&&count==0){
                        res.add(start);
                    }
                }
            }
        }
        
return res;
    }
}
