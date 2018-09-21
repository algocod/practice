package algorithms.firstlevel;

import java.util.LinkedList;

import datastructures.BSTNode;

public class ReverseLinkedList 
{   
	public static void main(args[])
	{
		LinkedList<Integer> l = new LinkedList<>();
		
	}
	
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

}
