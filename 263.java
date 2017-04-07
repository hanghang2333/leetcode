//给定一个数，如果它的最大因数只有2,3,5，则为丑陋数，
//方法:如果可以被2整除则整除2，能被3整除则整除3，如果最大因数只有它们三个，则最
//后应该为1.
public class Solution {
    public boolean isUgly(int num) {
        if(num==1)return true;
        if(num<=0)return false;
        while(num%2==0){
            num=num/2;
        }
        while(num%3==0){
            num=num/3;
        }
        while(num%5==0){
            num=num/5;
        }
        if(num==1)return true;
        return false;
        
    }
}
