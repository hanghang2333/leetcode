//给定一个挨个存储在数组的大数，求加1的结果
//遍历
public class Solution {
    public int[] plusOne(int[] digits) {
        int length=digits.length;
        int flag=0;
        for(int i=length-1;i>=0;i--){
            if(i==length-1)
            {digits[i]+=1;}
            if(digits[i]>=10){
                if(i!=0){
                    digits[i-1]+=1;
                    digits[i]-=10;
                }
                if(i==0){flag=1;}
            }
        }
        if(flag==1){
            int[] res=new int[length+1];
            res[0]=1;
            res[1]=digits[0]-10;
            for(int i=1;i<length;i++){
                res[i+1]=digits[i];
            }
            return res;
        }
        else{
           int[] res=new int[length];
            for(int i=0;i<length;i++){
                res[i]=digits[i];
            }
            return res;
        }
    }
}
