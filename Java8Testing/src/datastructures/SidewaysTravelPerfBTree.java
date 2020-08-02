package datastructures;
/**
 * 
 * Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
Example:

Given the following perfect binary tree,

     1
   /  \
  2    3
 / \  / \
4  5  6  7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \  / \
4->5->6->7 -> NULL
 * 
 * 
 */
import java.util.ArrayDeque;
import java.util.Queue;

public class SidewaysTravelPerfBTree {

	public static void main(String[] args) {

	}
	/**
	 * THis is like a double for loop running through each row and then columns within the row 
	 * @param root
	 */
	public static void connectLevels(BSTNode root) {     
        if (root == null) return;  
        while (root != null) {
        	BSTNode temp = root;
            if (root.getLeftNode() == null) break;//since it is a perfect binary tree
            while (root != null) {//concat in level start from root.left.
                root.getLeftNode().next = root.getRightNode();
                // Below is the key, as its a perfect binary tree the above left points to right but when its Right's turn, it points to the left node 
                // of the parents Next node. This sidways travel is continued in the while loop before moving down. 
                if (root.next != null) 
                    root.getRightNode().next = root.next.getLeftNode();
                root = root.next; // Moving to the columns to the right. 
            }
            root = temp.getLeftNode();// go down to next level like traversing the rows of a 2d matrix.
        }      
    }
	/*
	 * Below is the third way of doing in addition to top and below
	 * Keep a track of the elements at each level and keep connecting to them while recursing
	 * Height of the tree to used to keep track of the elements to be pointed to at each level and this will work for all trees
	 * The above solution works only for perfect binary trees. 
	    public void connect(TreeLinkNode root) {
        if(root==null)
            return ;
        
        ArrayList<Stack<TreeLinkNode>> ast = new ArrayList<>();
        connHelper(ast,root,1);
        
    }
    
    public void connHelper(ArrayList<Stack<TreeLinkNode>> ast,TreeLinkNode tln, int height)
    {
        if(tln==null)
            return;
        if(ast.size()<height)
            ast.add(new Stack<TreeLinkNode>());
        
        
        TreeLinkNode n = null;
        if(ast.get(height-1).size()!=0)
            n = ast.get(height-1).pop();
        
        tln.next = n;
        ast.get(height-1).push(tln);
        
        connHelper(ast,tln.right,height+1);
        connHelper(ast,tln.left,height+1);
        
    }
	 
	 
	 */
	
	
	/**
	 * The lengthy way of chaining nodes side by side using a Queue to store same level nodes.
	 * This can also be achieved by storing null and then checking while adding left and right nodes , not to include nulls.
	 * @param root
	 */
	public void connectSideViaQ(BSTNode root) {
        if(root==null)
            return ;
        
        Queue<BSTNode> stk = new ArrayDeque<>();
        stk.add(root);
        BSTNode nextE = null;
        while(!stk.isEmpty())
        {
            Queue<BSTNode> temp = new ArrayDeque<>();
            while(!stk.isEmpty())
            {
            	BSTNode node = stk.poll();
                System.out.println(node.getValue());
                if(node.getLeftNode()!=null)
                {
                    System.out.println(node.getLeftNode().getValue());
                        temp.add(node.getLeftNode());
                }
                    
                if(node.getRightNode()!=null)
                {
                        temp.add(node.getRightNode());
                }
                nextE = stk.peek()!=null?stk.peek():null;
                node.next = nextE;
            }
            stk = temp;
            nextE=null;
        }
    }

}
