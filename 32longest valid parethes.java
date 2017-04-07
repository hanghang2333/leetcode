//题意是给定一个左括号和右括号组成的序列，求解其中最长的合法的括号序列长度
//需要考虑的情况非常多，不过最主要的当然就是用栈来存储。当碰到(时将其存入栈中,当碰到)时，
//如果此时栈不为空，则栈中取出一个元素，并且此时计算目前为止最大长度，当然此时也要分栈是否为空两种情况，
//当非空时直接去栈顶元素和当然位置的差即可。若为空，则可知需要用当前位置减去之前记录的断点，断点初始值为-1，
//也就是说如果从来没碰到断点就这样计算。在正常中，当碰到右括号而此时栈已经为空时，记录下此时的位置，这个位置即可充当断点。
public class Solution {
    public int longestValidParentheses(String s) {
        if(s.equals("")||s==null)return 0;
        Stack<Integer> stack=new Stack();
        char[] str=s.toCharArray();
        int head=-1;
        int max=0;
        for(int i=0;i<str.length;i++){
            if(str[i]==('('))
             {stack.push(i);}
           else{
                if(!stack.empty()){
                    stack.pop();
                    if(!stack.empty()){max=Math.max(max,i-stack.peek());}
                    else{max=Math.max(max,i-head);}
                   }
                else {
                    head=i;
                }
            }
        }
return max;
    }
}
