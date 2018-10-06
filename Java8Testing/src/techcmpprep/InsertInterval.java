package techcmpprep;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class InsertInterval
{
    public List<Interval> insert(List<Interval> intervals, Interval newInterval)
    {
        
        Stack<Interval> stk = new Stack<>();
        Collections.sort(intervals, (a,b)->a.start<b.start?1:-1);
        Interval[] arr = new Interval[intervals.size()];
        arr = intervals.toArray(arr);
        for(Interval i : arr)
        {
        	if(stk.isEmpty())
        		stk.push(i);
        	else
        	{
        		Interval curr = stk.peek();
        		if(i.start<=curr.end && i.end>curr.end) // just check the only interval that needs to be merged , NOT ALL
        			stk.pop();
        		//stk.push(new Interva)
        	}
        }
        
        return null;
    }
	

	
	  public class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }
	 

}

