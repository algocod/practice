package algorithms.linkedList;

import java.util.LinkedList;

import datastructures.BSTNode;

public class ReverseLinkedList 
{   
	public static void main(String args[])
	{
		LinkedList<Integer> l = new LinkedList<>();
		
	}
	
	public ListNode reverseList(ListNode head) 
    {
        // the super reduced line of code below
		//return head!=null?head.next!=null?helperReverse(null,head,head.next):head:head;
        if(head==null || head.next==null)
            return head;
         
        ListNode prev = null;
        return helperReverse(prev,head,head.next);
    }
    
	/**
	 * Simple recursive way to reverse a linked list.
	 * @param prev
	 * @param curr
	 * @param nxt
	 * @return
	 */
    public ListNode helperReverse(ListNode prev , ListNode curr, ListNode nxt)
    {
        curr.next = prev;
        return nxt!=null?helperReverse(curr,nxt,nxt.next):curr;
        
    }
    
	/**
	 * Below is an iterative way of reversing linked list that looks complex and hard to understand. 
	 * Above is the recursive way that is much easier to understand.
	 * @param head
	 * @return
	 */
	public BSTNode reverseList(BSTNode head) 
		{
		    if(head==null || head.next==null)
		        return head;
		    BSTNode p1 =  head;
		    BSTNode p2 = head.next;
		    BSTNode temp, temp2 = null;
		    //temp = p1.next;
		    p1.next = null;
		    while(p2!=null)
		    {
		        temp2 = p2;
		        p2 = p2.next;
		        temp2.next = p1;
		        p1= temp2;
		    }
		    return p2;
		}
	
	static class ListNode
	{
		ListNode next;
		int val;
		ListNode(int x) { val = x; }
	}
	

}
