package algorithms.linkedList;

public class ReverseKGroupLL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
		ListNode head = new ListNode(arr[0]);
		ListNode lst = head;
		for(int i=1;i<arr.length;i++)
		{
			lst.next = new ListNode(arr[i]);
			lst = lst.next;
		}
		
		ListNode init = null;
		new ReverseKGroupLL().reverseKGroup(head, 2);
	}

	  public ListNode reverseKGroupOld(ListNode head, int k) 
	    {
	        if(head==null || head.next==null || k<1)
	            return head;
	        
	        ListNode init = null;
	        compact(head,init,head,null,head,k,1);
	        return init;
	    }
	  
	  public ListNode reverseKGroup(ListNode head, int k) {
		    //1. test weather we have more then k node left, if less then k node left we just return head 
		    ListNode node = head;
		    int count = 0;
		    while (count < k) { 
		        if(node == null)return head;
		        node = node.next;
		        count++;
		    }
		    // 2.reverse k node at current level 
		       ListNode pre = reverseKGroup(node, k); //pre node point to the the answer of sub-problem 
		        while (count > 0) {  
		            ListNode next = head.next; 
		            head.next = pre; 
		            pre = head; 
		            head = next;
		            count = count - 1;
		        }
		        return pre;
		}
	  
	  
	  
	    public void compact(ListNode pTail, ListNode initH, ListNode currTail, ListNode currHead,ListNode currP, int k, int curr)
	    {
	        if(currP==null)
	            return;
	        currP = currP.next;
	        if(k==curr)
	        {
	            if(initH==null)
	            {
	            	initH = currHead;
	            	currTail = currHead.next;
	            }
	                
	            
	            if(currTail!=null)
	            {
	                pTail.next=currHead;
	                pTail = currTail;
	                currHead.next = null;
	            }
	        }
	        curr = curr==k?1:curr+1;
//	        currHead = currTail;
	        compact(pTail,initH,currTail,currP,currP,k,curr);
	    }
	  
	
	 static class ListNode{
		 int val;
		 ListNode next;
		 ListNode(int val) {this.val = val;}
	 }
	    
}
