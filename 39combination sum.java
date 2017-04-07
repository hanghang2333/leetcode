//题意给定一个数组和一个目标，以数组元素为元素组成list使得和等于目标，数组可以重复取。
//思路其实就是遍历，不过这里需要注意的是回溯的方法。在递归函数里我们对数组里每一个元素开始遍历，之前已经对数组排过序，并且每次递归都传入一个入口位置值，表明递归里从数组中是从该位置之后开始遍历的。
//这里的回溯是通过迭代后将tmp里的最后一个元素删除来做到的。
//还需要注意的是我们传入了一个临时的list，由于其回溯中会被多次使用，所以我们在将之增加到结果中时需要新建一个list.
//自己对于动态规划方法不熟悉，经常会想不到回溯的办法，在这里，回溯就是递归到底后进行的向上传播，即删除最后一个元素。这一步是必须有的。否则会导致tmp不能狗正确反映结果，因为多次递归的结果会叠加到tmp上。当走出递归后就意味着这一次向下走已经到头了，需要回溯了，所以删除最后一个元素。至于判断是否符合条件，应该放在最开始充当递归基。
public class Solution {
    List<List<Integer>> list=new ArrayList();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        //List<Integer> tmp=new ArrayList<Integer>();
       diedai(target,candidates,new ArrayList<>(),0);
       return list;
    }
    public void diedai(int target,int []candidates,ArrayList<Integer>tmp,int start){
        if(target<0)return;
        else if(target==0)list.add(new ArrayList<>(tmp));
        for(int i=start;i<candidates.length;i++){
            tmp.add(candidates[i]);
            diedai(target-candidates[i],candidates,tmp,i);
            tmp.remove(tmp.size()-1);
        }
    }
}
