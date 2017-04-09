import java.util.*;
public class combina77 {
    public List<List<Integer>> combine(int n, int k) {
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i]=i+1;
        }
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backtrack(nums,k,list,result);
        return result;
    }
    public static void backtrack(int[] nums,int k,List<Integer> list,List<List<Integer>> result){
        if(list.size()==k){
            result.add(list);
        }
        else{
            int tmpindex = 0;
            if(list.size()!=0)tmpindex=list.get(list.size()-1);
            for(int i=tmpindex;i<nums.length;i++){
                list.add(nums[i]);
                List<Integer> listtmp = new ArrayList<Integer>();
                listtmp.addAll(list);
                backtrack(nums,k,listtmp,result);
                list.remove(list.size()-1);
            }
        }
    }
}