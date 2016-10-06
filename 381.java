//题意的意思是：实现一个能够做到插入，删除和随机取值的数据结构，且上述操作均在O1时间内做好。
//做法是：利用一个list来存储输入的值，利用一个map来实现记下每个值的位置。记下位置的主要目的也就是为了删除操作能够在O1时间内做到。
//这样，输入时将值输入list，将值和位置对输入map，注意这里的map的value是一个set集合。
//删除时先用map的iterator找出位置，而后依次在map和list中删除。需要注意的是，由于map的locs是位置，所以删除元素后也要做更新，list的last元素占领删除的位置，map中相应做好更新。
public class RandomizedCollection {
    ArrayList<Integer> nums;
    HashMap<Integer,HashSet<Integer>>locs;
    java.util.Random rand=new java.util.Random();
    /** Initialize your data structure here. */
    public RandomizedCollection() {
        nums=new ArrayList<Integer>();
        locs=new HashMap<Integer,HashSet<Integer>>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean exist=locs.containsKey(val);
        if(!exist)locs.put(val,new HashSet<Integer>());
        locs.get(val).add(nums.size());
        nums.add(val);
        return (!exist);
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        boolean exist=locs.containsKey(val);
        if(!exist)return false;
        int loc=locs.get(val).iterator().next();
        locs.get(val).remove(loc);
        if(loc<nums.size()-1){
            int lasttone=nums.get(nums.size()-1);
            nums.set(loc,lasttone);
            locs.get(lasttone).remove(nums.size()-1);
            locs.get(lasttone).add(loc);
        }
        nums.remove(nums.size()-1);
        if(locs.get(val).isEmpty())locs.remove(val);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(rand.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */
