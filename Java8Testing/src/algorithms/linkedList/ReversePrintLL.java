package algorithms.linkedList;

public class ReversePrintLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public String  printRLL(Node n , StringBuffer sb)
	{
		if(n==null)
			return sb.toString();
		sb.insert(0, n.val);
		return printRLL(n.next,sb);
	}

	
	class Node
	{
		int val;
		Node next;
	}
	
}

