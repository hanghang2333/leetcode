//给定字符串数组，求其中两两合并后是回文的坐标的列表。
//对于每一个字符串，开头和结尾处如有连续几个是回文的，则如果数组里有以该字符串剩余部分翻转为内容的字符串，则该字符串可以和原先字符串形成回文字符串。所以对每一个字符串都遍历字母内容，找寻其中是否还有子回文串，并且将整个字符串放入ｍａｐ中以使得在整个数组字符串中找寻以某字符串内容的坐标很快速。
public class Solution {
    public boolean ispalin(String res){
        int len=res.length();if(len==1)return true;
        char[] chares=res.toCharArray();
        for(int i=0;i<len;i++){
            if(chares[i]!=chares[len-1-i])
            return false;
        }
        return true;
    }
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        if(words.length<=1||words==null)return list;
        Map<String,Integer> map=new HashMap<String,Integer>();
        for(int i=0;i<words.length;i++)map.put(words[i],i);
        for(int i=0;i<words.length;i++){
            for(int j=0;j<=words[i].length();j++){
                String str1=words[i].substring(0,j);
                String str2=words[i].substring(j);
                if(ispalin(str1)){
                    String str2rev=new StringBuilder(str2).reverse().toString();
                    if(map.containsKey(str2rev)&&map.get(str2rev)!=i){
                        List<Integer> temp=new ArrayList<Integer>();
                        temp.add(map.get(str2rev));temp.add(i);
                        list.add(temp);
                    }
                }
                if(ispalin(str2)){
                   String str1rev=new StringBuilder(str1).reverse().toString();
                   if(map.containsKey(str1rev)&&map.get(str1rev)!=i&&str2.length()!=0){
                       List<Integer> temp=new ArrayList<Integer>();
                        temp.add(i);temp.add(map.get(str1rev));
                        list.add(temp);
                   }
                }
            }
        }return list;
    }
}
