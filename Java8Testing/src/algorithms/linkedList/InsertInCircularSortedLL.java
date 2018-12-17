package algorithms.linkedList;

import java.util.ArrayList;

public class InsertInCircularSortedLL {

	public static void main(String[] args) {
		// sorted input
		int[] arr = {2,3,6,8,21,99};
		ArrayList<Integer> ast = new ArrayList<>();
        ast.add(0, 20);
        ast.add(1, 21);
        ast.add(0, 22);
		Node head = new Node();
		Node tail = head;
		head.val = 1;
		for(Integer a : arr)
		{
			Node p = new Node();
			p.val = a;
			tail.next = p;
			tail = p;
		}
		// make it circular
		tail.next = head;
		int getNode = 6;
		int addNode = -1; // add 9 , 4 , 100 ,-1
		Node p = getNode(head, getNode);
		Node toA = addToLL(p, addNode); 
		Node temp = toA.next;
		Node gt = new Node();
		gt.val = addNode;
		toA.next = gt;
		gt.next = temp;
	}

	public static Node getNode(Node head, int i)
	{
		if(head.val ==i)
			return head;
		return getNode(head.next,i);
		
	}
	
	public static Node addToLL(Node n, int i)
	{
		if(n==null)
			return null;
		if(n.val>n.next.val && i<n.val && i<n.next.val)
			return n;
		if(i<n.val)
			return addToLL(n.next, i);
		if(i >n.val && i<n.next.val)
			return n;
		if(i>n.val && n.val > n.next.val)
			return n;
		
				
		return addToLL(n.next, i);
		
	}
	
	static class Node 
	{
		Integer val = 0;
		Node next = null;
	}
	
}
