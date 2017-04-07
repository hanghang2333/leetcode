/*************************************************************************
	> File Name: finmin2.java
	> Author:lihang 
	> Mail:1092978787@qq.com 
	> Created Time: 2017年04月07日 星期五 08时03分31秒
 ************************************************************************/

public class finmin2
{
    public int findMin(int[]num){
        int len = num.length;
        if(len==0)return 0;
        if(len==1)return num[0];
        if(len == 2)return Math.min(num[0],num[1]);
        int left = 0,right=len-1;
        while(left<right){
            int middle = (left+right)/2
                if(num[j]<num[mid]){
                    left = middle;
                }
                else if(num[mid]<num[j]){
                    right = middle;
                }
                else{
                    if(num[i]==num[middle]){
                        left++;
                        right--;
                    }
                    else{
                        j = mid;
                    }
                }
            return Math.min(num[left],num[right]);
        }
    }
}
