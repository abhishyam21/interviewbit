package arrays;

import java.util.*;

/**
 * Created by Rachana Rao on 8/20/2016.
 */
public class MergeIntervals {
    public static void main(String[] args) {
        ArrayList<Interval> intervals = getInterVels();
        MergeIntervals mergeIntervals = new MergeIntervals();
        Interval newInterval = new Interval(4,9);
        ArrayList<Interval> resList = mergeIntervals.insert(intervals,newInterval);
        for(Interval interval : resList){
            System.out.println(interval.toString());
        }
    }

    private ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        newInterval.start = Math.min(newInterval.start,newInterval.end);
        newInterval.end = Math.max(newInterval.start,newInterval.end);
        intervals.add(newInterval);
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start != o2.start)
                    return o1.start-o2.start;
                else
                    return o1.end-o2.end;
            }
        });
        ArrayList<Interval> result = new ArrayList<>();
        Interval pre = intervals.get(0);
        for(int i=0; i<intervals.size(); i++){
            Interval curr = intervals.get(i);
            if(curr.start>pre.end){
                result.add(pre);
                pre = curr;
            }else{
                pre = new Interval(pre.start, Math.max(pre.end, curr.end));
            }
        }
        result.add(pre);
        return result;
    }

    private static ArrayList<Interval> getInterVels() {
        ArrayList<Interval> list = new ArrayList<>();
        list.add(new Interval(1, 2));
        list.add(new Interval(3, 5));
        list.add(new Interval(6, 7));
        list.add(new Interval(8, 10));
        list.add(new Interval(12, 16));
        return list;
    }
}

   class Interval {
      int start;
      int end;
      Interval() { start = 0; end = 0; }
      Interval(int s, int e) { start = s; end = e; }

       @Override
       public String toString() {
           return "["+this.start+","+this.end+"]";
       }
   }