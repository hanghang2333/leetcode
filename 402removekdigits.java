//给定一个字符串形式的数字，要求从里面移除k个数字，使得结果是最小的
//方法是分而治之，即每次移除一个，具体方法是从头开始数，有某个数大于紧接其后的值后就删除这个数，递归即可。
public class Solution {
    public String removeKdigits(String num, int k) {
        char[] s=num.toCharArray();
        int len=s.length;
        List<Character> list=new ArrayList<Character>();
        for(int i=0;i<s.length;i++)list.add(s[i]);
        for(char i :list){System.out.println(i);}
        StringBuffer sb=new StringBuffer();
        diedai(list,len,k);
        boolean head=true;
        for(char i:list){if(i!='0'){sb.append(i);head=false;}
            else if(!head){sb.append(i);}
        }
        String res=sb.toString();
        if(res.equals(""))res+="0";
        return res;
    }
    public void diedai(List<Character> list,int len,int k){
        if(k==0)return;
        int index=0;
        for(int i=0;i<len;i++){
            if(i==len-1){index=i;break;}
            else if(list.get(i)>list.get(i+1)){
                index=i;
                break;
            }
        }
        k=k-1;
        list.remove(index);
        len=len-1;
        diedai(list,len,k);
    }
}
