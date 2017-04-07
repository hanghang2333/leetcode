//summary ranges给定一个数组已经拍好序，里面有些元素是连续的，求出这些连续的范围值存放到一个list里。
//就直接遍历数组就行了。
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result=new ArrayList<String>();
        String str="";
        for(int i =0;i<=nums.length-1;i++){
            StringBuffer sb=new StringBuffer();
            /*if(i==nums.length-1){
                sb.append(nums[i]);
                String s=sb.toString();
                result.add(s);
            }*/
            int head=i;
            while(i<=nums.length-2&&nums[i+1]==nums[i]+1){i++;}
            sb.append(nums[head]);
            if(i>head){sb.append("->");sb.append(nums[i]);}
            String s=sb.toString();
                result.add(s);
        }
        return result;
    }
}
