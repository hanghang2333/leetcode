//要求给定一个数字字符串，查看其中有无类似于additive即第三个数等于前两个数之和的这种可能性，有则为additive number
//解决方法很暴力，因为前两个数需要确定，所以便枚举前两个数，而后针对枚举结果查看是否合适。
//题目中要求去除03这种前缀0的数，故而做了些检查
public class test {
    public static boolean isAdditiveNumber(String num) {
        for (int i=0;i<num.length();i++){
          for (int j=i+1;j<num.length()-1;j++){
            String first=num.substring(0,i+1);
            String second=num.substring(i+1,j+1);
            if(vaild(num,first,second)){return true;}
          }
        }
        return false;
    }
    public static boolean vaild(String num,String first,String second){
        System.out.println(num);
        System.out.println(first);
        System.out.println(second);
        if(first.charAt(0)=='0'&&first.length()!=1)return false;
        if(second.charAt(0)=='0'&&second.length()!=1)return false;
        Long firstnum=Long.parseLong(first);
        Long secondnum=Long.parseLong(second);
        int index=first.length()+second.length();
        for(;index<num.length();){
            String subnum=num.substring(index,num.length());
            if(subnum.charAt(0)=='0'&&subnum.length()!=1)return false;
            System.out.println("subnum"+subnum);
            boolean flag=false;
            for(int i=1;i<=subnum.length();i++){
                if(Long.parseLong(subnum.substring(0,i))==firstnum+secondnum){
                    flag=true;
                    System.out.println("dcdvdv");
                    firstnum=secondnum;
                    secondnum=Long.parseLong(subnum.substring(0,i));
                    index=index+i;
                    break;//退出此次循环
                }
            }
            if(flag==false){
                return false;
            }
            else {
                flag=false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        String s="1023";
        System.out.println(isAdditiveNumber(s));
    }
}
