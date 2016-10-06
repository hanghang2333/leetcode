//题意是给定字符串，求出所有回文子字符串，放入到一个链表的链表里，每一个链表为一个合理的回文子字符串分配方案，
//思路是依次轮回，从第一个元素开始，再第一到第二个元素，再第一到第三个，，，在进行每一次大循环时，子循环内为子字符串的依次轮回，每当head=len时，将当前res1假如到res，并且每一次都减去res1的最后一个元素
//每一次在递归循环里都深入一步，向res1中添加一个元素且head前进，当head前进到头后可以将res1内元素进行入res操作，易知在迭代循环后每一轮向回走会删除刚才迭代输入到res1的元素，每一个子循环都类似于深度优先搜索，即到达每一个顶点后保存一下，而后回退上去，继续搜索。
public class Solution {
    List<List<String>> res;;
    ArrayList<String> res1;
    public boolean palind(String str,int l,int r){
            if(l==r) return true;
	        while(l<r){
	            if(str.charAt(l)!=str.charAt(r)) return false;
	            l++;r--;
	        }
	        return true;
    }
    public void diedai(String s,int head){
        if(res1.size()>0&& head>=s.length()){
	                List<String> r=(ArrayList<String>)(res1.clone());
	                res.add(r);
	        }
        for(int i=head;i<s.length();i++){
            if(palind(s,head,i)){
                res1.add(s.substring(head,i+1));
                diedai(s,i+1);
                res1.remove(res1.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s){
        res=new ArrayList<List<String>>();
        res1=new ArrayList<String>();
        diedai(s,0);
        return res;
    }
}
