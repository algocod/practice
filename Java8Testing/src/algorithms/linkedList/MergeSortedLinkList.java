package algorithms.linkedList;
/*
 * [1,2,4]
   [1,3,4]
   [1,1,2,3,4,4]
 */
public class MergeSortedLinkList {

	public static void main(String[] args) {

	}
	
	   public ListNode mergeTwoLists(ListNode l1, ListNode l2)
	    {
	        ListNode res = new ListNode(0);
	        ListNode dummy = res;
	        
	        while(l1!=null && l2!=null)
	        {
	            if(l1.val<l2.val)
	            {
	                res.next = l1;
	                l1 = l1.next;
	            }
	            else
	            {
	                res.next = l2;
	                l2= l2.next;
	            }
	            if(res.next!=null)
	                res = res.next;
	        }
	        
	        ListNode rem = l1!=null?l1:l2!=null?l2:null;
	        res.next = rem;
/*
 * No need to iterate through the rest of the remaining nodes, just point to its starter.
	        while(rem!=null)
	        {
	            res.next = rem;
	            rem = rem.next;
	            res = res.next;
	        }
*/	        
	        return dummy.next;
	    }
// TODO do it in recursive sytle , just for the sake of concept as iterative is much faster.
	   static class ListNode
	   {
		   int val;
		   ListNode next;
		   ListNode(int x) { val = x; }
	   }

}
