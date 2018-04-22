package datastructures;

public class BinarySearchTree {

	public static BSTNode mainRoot = null;
	
	public static void main(String[] args) {

		Integer[] arr = {10,1,4,40,50};
				
		addToTree(mainRoot, arr, 0);
		System.out.println("Finished");
		mainRoot.toString(mainRoot);
	}
	
	public static void addToTree(BSTNode rt, Integer[] arr, int offset)
	{

		if(offset>=arr.length)
			return;
		if(rt==null)
		{
			mainRoot = new BSTNode(arr[offset]);
			addToTree(mainRoot, arr, offset+1);
		}
			
		
		if(rt!=null && rt.isGreaterthanRoot(arr[offset]) && rt.getRightNode()==null)
		{
			rt.setRightNode(new BSTNode(arr[offset]));
			addToTree(mainRoot, arr, offset+1);
		}
		else if (rt!=null && rt.isGreaterthanRoot(arr[offset]) && rt.getRightNode()!=null)
		{
			addToTree(rt.getRightNode(),arr,offset);
		}
		else if (rt!=null && !rt.isGreaterthanRoot(arr[offset]) && rt.getLeftNode()==null)
		{
			rt.setLeftNode(new BSTNode(arr[offset]));
			addToTree(mainRoot, arr, offset+1);
		}
		else if(rt!=null && !rt.isGreaterthanRoot(arr[offset]) && rt.getLeftNode()!=null)
		{
			addToTree(rt.getLeftNode(),arr, offset);
		}
	
		if(rt!=null)
			rt.toString();
		
	}

}
