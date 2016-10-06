//给一个数组，有的元素出现三次，但只有一个出现一次，求这个的index。
//思路是：整数都是二进制存储的，考虑位运算，首先定义一个int[]32的数组，每一位当做一个二进制，对原数组所有元素都进行与操作，可以出现三次的那些在最后进行%3操作后会归为0，只有出现一次的会留下。这里也可以直接用一个int来记录。
//java位运算不太熟悉，贴上c代码
class Solution {  
public:  
    int singleNumber(int A[], int n) {  
        int bitnum[32]={0};  
        int res=0;  
        for(int i=0; i<32; i++){  
            for(int j=0; j<n; j++){  
                bitnum[i]+=(A[j]>>i)&1;  
            }  
            res|=(bitnum[i]%3)<<i;  
        }  
        return res;  
    }  
};  
