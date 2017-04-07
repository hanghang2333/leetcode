/*************************************************************************
	> File Name: Continuos.java
	> Author:lihang 
	> Mail:1092978787@qq.com 
	> Created Time: 2017年03月05日 星期日 13时13分51秒
 ************************************************************************/

public class Continuos
{
    public static boolean Solution(int[] nums,int k){
 int length=nums.length;
        if(length<=1)return false;
                if(k==0){
                    for(int i=0;i<length-1;i++){
            int sum=nums[i];
            for(int j=i+1;j<length;j++){
                sum=sum+nums[j];
                if(sum==0)return true;
            }
        }
                }
                else{
        for(int i=0;i<length-1;i++){
            int sum=nums[i];
            for(int j=i+1;j<length;j++){
                sum=sum+nums[j];
                if(sum%k==0)return true;
            }
        }}
        return false;
    }
    }
    public static void main(String[] args){
        int[] nums={23,2,6,4,7};
        int k=6;
        System.out.println(Solution(nums,k));
    }
}
