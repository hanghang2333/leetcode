//给定了一组pair时间序列对，又给了一个pair，把它merge到原序列里面，要求重叠的时间要over覆盖。
//解决的办法是依次走。
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public int max(int a,int b){
        return a>b?a:b;
    }
    public int min(int a,int b){
        return a<b?a:b;
    }
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        int i=0;
        List<Interval> list=new ArrayList<Interval>();
                if(intervals==null||newInterval==null)return list;
        while(i<intervals.size()&&intervals.get(i).end<newInterval.start){
            list.add(intervals.get(i));
            i++;
        }
        while(i<intervals.size()&&intervals.get(i).start<=newInterval.end){
            newInterval=new Interval(
                min(intervals.get(i).start,newInterval.start),
                max(intervals.get(i).end,newInterval.end)
                );
            i++;
        }
        list.add(newInterval);
        while(i<intervals.size()){
            list.add(intervals.get(i++));
        }
        return list;
    }
}
