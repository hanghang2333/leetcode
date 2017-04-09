import java.util.*;
public class longestcon128 {
    public static void main(String[] args){
        //int[] nums = {100, 4, 200,201,202,203,204, 1, 3, 2};
        int[] nums = {1,0,2,3,4,100};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
       Set<Integer> set = new HashSet<Integer>();
       int len1 = nums.length;
       for(int i=0;i<len1;i++)set.add(nums[i]);
       int[] uf = new int[set.size()];//存储去重过后的nums数组
       int count = 0;
       for(int i:set){
           uf[count] = i;
           count++;
       }
       int len = uf.length; if(len==1)return 1;
       Map<Integer,Integer> map = new HashMap<Integer,Integer>();
       for(int i=0;i<len;i++)map.put(uf[i],i);
       int[] uff = new int[len];
       for(int i=0;i<len;i++)uff[i]=i;
       for(int i=0;i<len;i++){
           int now = uf[i];
           int index1 = map.getOrDefault(now-1,-1);
           if(index1!=-1){
               insert(uff,i,index1);
           }
       }
       int res = 0;
       for(int i=0;i<len;i++){
           res = Math.max(res,Math.abs(uf[find(uff,i)]-uf[i]));
       }
       return res+1;
}
    public static void insert(int[] uf,int i,int j){
        //向unionfind里插入关系
        int tmpi = i;
        int tmpj = j;
        while(uf[i]!=i)i=uf[i];
        while(uf[j]!=j)j=uf[j];
        uf[i]=j;//现在所有点的上级都应该是j
        //插入关系的同时也更新自己路径上的
        while(uf[tmpi]!=j){
            int tmpii=tmpi;
            tmpi = uf[tmpi];
            uf[tmpii] =j;
        }
        while(uf[tmpj]!=j){
            int tmpjj=tmpj;
            tmpj = uf[tmpj];
            uf[tmpjj] =j;
        }
    }
    public static int find(int[] uf,int k){
        while(uf[k]!=k)k=uf[k];
        return k;
    }

}