package algorithms.linkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import algorithms.linkedList.MergeSortedLinkList.ListNode;

public class MergeTwoIntervalLists {

	public static void main(String[] args) {
		int[][] arr = {{1,5},{10,14},{16,18}};
		int[][] arr2 = {{2,6},{8,10},{11,20}};
		
		ListNode first = new ListNode(new Interval(0,0));
		ListNode dummy = first;
		for(int[] a : arr)
		{
			first.next = new ListNode(new Interval(a[0],a[1]));
			first = first.next;
		}
		
		ListNode second = new ListNode(new Interval(0,0));
		ListNode dummy2 = second;
		for(int[] a : arr2)
		{
			second.next = new ListNode(new Interval(a[0],a[1]));
			second = second.next;
		}
		
		ListNode lst = dummy.next;
		ListNode lst2 = dummy2.next;
		
		List<Interval> ans = new ArrayList<>();
		
		PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b) -> a.val.start > b.val.start?1:-1);
		pq.offer(lst);
		pq.offer(lst2);
		
		ListNode last = pq.poll();
		pq.offer(last.next);
		while(!pq.isEmpty())
		{
			ListNode curr = pq.poll();
			if(last.val.end < curr.val.start)
			{
				ans.add(last.val);
				last = curr;
				if(curr.next!=null)
					pq.offer(curr.next);
				
			}
			else if (last.val.end >= curr.val.start && (curr.val.end >= last.val.end))
			{
				Interval merge = new Interval(last.val.start, curr.val.end);
				last.val = merge;
				if(curr.next!=null)
					pq.offer(curr.next);
			}
		}
		
		ans.add(last.val);
		
	}

	static class ListNode
	   {
		   Interval val;
		   ListNode next;
		   ListNode(Interval x) { val = x; }
	   }
	
	static class Interval
	{
		int start;
		int end;
		
		Interval(int x, int y) {start=x; end=y;}
	}
	
}
