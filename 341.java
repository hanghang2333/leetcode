//题意是实现一个能够处理嵌套的list的list，需要做到hasnext和next的返回能够压平原先的嵌套。
//做法：将原list压入堆栈，而后依次输出，在hasnext中检查，如果堆栈为空则返回false。
//然后peek出栈内元素，检查是数字还是list，若为数字则true，否则将list内数字压入堆栈。并且判断list是否输出完了，完了则pop出去。
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private Stack<ListIterator<NestedInteger>> lists;
    public NestedIterator(List<NestedInteger> nestedList) {
        lists=new Stack<>();
        lists.push(nestedList.listIterator());
    }
    @Override
    public Integer next() {
        hasNext();
        return lists.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while(!lists.empty()){
            if(!lists.peek().hasNext()){
                lists.pop();
            }
            else{
                NestedInteger x=lists.peek().next();
                if(x.isInteger()){
                    return lists.peek().previous()==x;
                }
                lists.push(x.getList().listIterator());
            }
        } return false;   
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
//下面这种解决办法是同样的思路，更好理解
class NestedIterator {
public:
    NestedIterator(vector<NestedInteger> &nestedList) {
        for (int i = nestedList.size() - 1; i >= 0; --i) {
            s.push(nestedList[i]);
        }
    }

    int next() {
        NestedInteger t = s.top(); s.pop();
        return t.getInteger();
    }

    bool hasNext() {
        while (!s.empty()) {
            NestedInteger t = s.top(); 
            if (t.isInteger()) return true;
            s.pop();
            for (int i = t.getList().size() - 1; i >= 0; --i) {
                s.push(t.getList()[i]);
            }
        }
        return false;
    }

private:
    stack<NestedInteger> s;
};
