package datastructures;
import java.util.*;

class BSTIterator {

    // Possibly maintain two stacks, one for the next and other for prev
	// On every next call, pop out the next and put it in prev and for every prev call, pop out the prev and put it back in next.
    public Stack<TreeNode> stk = new Stack<>();
    public TreeNode prev = null;
    public LinkedList<TreeNode> prevKElements = new LinkedList<>();
    public BSTIterator(TreeNode root) {
        
        //nextHelper(root);
        nextStkHelper(root);
    }
    
    /** @return the next smallest number */
    public int next() {
        
        TreeNode tmp = stk.pop();
        nextStkHelper(tmp.right); // Get the next set of elements into the stack.
        // Add the current next to the prev variable to get the last previous element.
        prev = tmp;
        prevKElements.add(tmp);
        return tmp.val;
        
    }
    
    public TreeNode prev()
    {
        return prev; // the next function has to be called before the prev function else prev will be null.
    }
    
    public TreeNode prevKth(int k)
    {
        while(k>0)
        {
        	prevKElements.pop();
        	k--;
        }
        
        return prevKElements.element();
    }
    
    public void nextStkHelper(TreeNode root)
    {
        while(root!=null)
        {
            stk.push(root);
            root = root.left;
        }
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        
        //return !q.isEmpty();
        return !stk.isEmpty();
    }
}

