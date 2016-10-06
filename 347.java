//给出数组，求出topk频率的数，采用的map方式
public class Solution {
    public int[] findtopk(int[] nums,int k){
        int[] list=new int[k];
        int max=0;
        int count=0;
        while(k>0){
            int flag=0;
            for(int i=0;i<nums.length;i++){
                if(nums[i]>max){max=nums[i];flag=i;}
            }
            list[count]=flag;
            count=count+1;
            nums[flag]=0;
            k--;
            max=0;
        }
        return list;
    }
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> list=new ArrayList<Integer>();
        int[] res3=new int[k];
        Map<Integer,Integer>map=new HashMap<Integer,Integer>();
        for(int n:nums){
            map.put(n,map.getOrDefault(n,0)+1);
        }
        int size=map.size();
         int[] res1=new int[size];
        int[] res2=new int[size];
        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
        int count=0;
        while (entries.hasNext()) {  
        Map.Entry<Integer, Integer> entry = entries.next();  
        res1[count]=entry.getKey();
        res2[count]=entry.getValue();
        count=count+1;
}
//for(int i=0;i<size;i++){System.out.println(res1[i]+"_"+res2[i]);}
        res3=findtopk(res2,k);
        for(int i=0;i<k;i++){
            list.add(res1[res3[i]]);
        }
    return list;
    }
}
