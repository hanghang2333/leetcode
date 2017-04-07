//给定一个尼波兰表达式的数组，求结果
//直接遍历，数字入栈，运算符读出来pop出两个数字即可。运算结果再次入栈
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> stack=new Stack<String>();
        for(int i=0;i<tokens.length;i++){
            if((!tokens[i].equals("+"))&&(!tokens[i].equals("-"))&&(!tokens[i].equals("*"))&&(!tokens[i].equals("/"))){
                stack.push(tokens[i]);
                System.out.println(tokens[i]);
            }
            else{double ress=0;
                int num1=(int)Double.parseDouble(stack.pop());
                int num2=(int)Double.parseDouble(stack.pop());
                if(tokens[i].equals("+")){ress=num1+num2;}
                else if(tokens[i].equals("-")){ress=num2-num1;}
                else if(tokens[i].equals("/")){ress=num2/num1;}
                else if(tokens[i].equals("*")){ress=num1*num2;}
                stack.push(String.valueOf(ress));
            }
        }
        int res=(int)(int)Double.parseDouble(stack.pop());
        return res;
        
    }
}
