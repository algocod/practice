package datastructures;

import java.util.Stack;

/**
 * Find the lowest common ancestor in a binary tree which is NOT a SEARCH tree. 
 * Basic solution of extra O(n) space and log(n) times includes going to each node and storing the elements on the way in a stack
 * Compare the two stacks and get answer
 * 
 *  Another smooth method is to just check if the two elements are there in the tree or not.
 *  
 * @author hemant
 *
 */


public class LowestCommonAncestor {

		/**
		 * This method below just checks where are the elements present
		 * @param root
		 * @param p
		 * @param q
		 * @return
		 */
	   public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        
	        if(root==null)
	            return null;
	        
	        if(root==p || root==q)
	            return root;
	        
	        TreeNode left = lowestCommonAncestor(root.left,p,q);
	        TreeNode right = lowestCommonAncestor(root.right,p,q);
	        // if the elements are present in the left and right subtree of the root then that root itself is the answer
	        if(left!=null && right !=null)
	            return root;
	        // if elements are in neither of the subtree then return null
	        if(left==null && right==null)
	            return null;
	        // the above checks leave only two possibilities, either left is null or right is null, in which case the elements must be below each other
	        // one can simply return whichever was found first means check left is null and then move on.
	        return left!=null?left:right;
	        
	    }
	
	
	/** 
	 * Basic method of stack comparison
	 * @param root
	 * @param p
	 * @param q
	 * @return
	 */
    public TreeNode lowestCommonAncestorStk(TreeNode root, TreeNode p, TreeNode q) {
        
        Stack<TreeNode> stkp=null, stkq = null;
        stkp= getStack(root,p,stkp);
        stkq = getStack(root,q,stkq);
        
        TreeNode matching = null;
        while(!stkp.isEmpty() && !stkq.isEmpty() && stkp.peek().val==stkq.peek().val)
        {
            matching = stkp.pop();
            stkq.pop();
        }
        
        return matching;
    }
    
    public Stack<TreeNode> getStack(TreeNode root, TreeNode input, Stack<TreeNode> stk)
    {
        if(root==null)
            return stk;
        if(root.val==input.val)
        {
            stk = new Stack<TreeNode>();
            stk.push(input);
            return stk;
        }
        
        stk = getStack(root.left,input,stk);
        if(stk==null)
            stk = getStack(root.right,input,stk);
        
        if(stk!=null)
            stk.push(root);
        
        return stk;
    }

	
}
