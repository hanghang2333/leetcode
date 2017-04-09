import java.util.*;
public class containsduplicat3e220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(t<0)return false;
        boolean flag=false;
        Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        Set<Integer> set = new HashSet<Integer>();
        for(int i=0;i<nums.length;i++){
            List<Integer> list = map.getOrDefault(nums[i],new ArrayList<Integer>());
            list.add(i);
            map.put(nums[i],list);
            set.add(nums[i]);
        }
        for(int i:nums){
            List<Integer> list = map.get(i);
            int distance = nums.length;
            if(list.size()!=1){
                for(int j=0;j<list.size()-1;j++){
                distance = Math.min(Math.abs(list.get(j+1)-list.get(j)),distance);
            }
            if(distance<=k){flag = true;break;}
            }
        }
        if(flag == true)return flag;
        breakFor:for(int i:nums){
            List<Integer> list = new ArrayList<Integer>();
            for(int tmp:set){
                if(Math.abs((long)(tmp-i))<=t&&tmp!=i){
                List<Integer> listt = map.get(tmp);
                if(listt.size()>=1){
                    for(int tmpindex :listt)list.add(tmpindex);
                }
            }}
            int distance = nums.length;
            List<Integer> listi = map.get(i);
            for(int ii:listi){
                 for(int j=0;j<list.size();j++){
                distance = Math.min(Math.abs(ii-list.get(j)),distance);
                if(distance<=k){flag = true;break breakFor;}
            }
            }
        }
        return flag;

    }
    public boolean containsDuplicate(int[] nums) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i:nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        boolean flag = false;
        for(int i:map.keySet()){
            if(map.get(i)>1)flag=true;
        }
        return flag;
    }
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        boolean flag=false;
        Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
        for(int i=0;i<nums.length;i++){
            List<Integer> list = map.getOrDefault(nums[i],new ArrayList<Integer>());
            list.add(i);
            map.put(nums[i],list);
        }
        for(int i:nums){
            List<Integer> list = map.get(i);
            int distance = nums.length;
            if(list.size()!=1){
                for(int j=0;j<list.size()-1;j++){
                distance = Math.min(list.get(j+1)-list.get(j),distance);
            }
            if(distance<=k){flag = true;break;}
            }
        }
        return flag;
    }
}