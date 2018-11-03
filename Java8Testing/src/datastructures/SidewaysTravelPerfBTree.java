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
                root = root.next;
            }
            root = temp.getLeftNode();// go down to next level
        }      
    }
	
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
