package datastructures;

import java.util.Stack;

/**
 * The LL or DLL transformation of a BST is actually a traversal of all its nodes and its mostly In-Order that is L N R .
 * This can also be done with extra space where all in order visited nodes can be stored in a stack or queue and then iterated over to connect to each other .
 * @author hemant
 *
 */
public class FlattenBTtoLL {
	
private BSTNode prev = null;
private BSTNode oneUp = null;
public Stack<Node> stk = new Stack<>();
public void flatten(BSTNode root) {
    if (root == null)
        return;
    flatten(root.getRightNode());
    flatten(root.getLeftNode());
    root.setRightNode(prev);
    root.setLeftNode(null);
    prev = root;
}

/*
 * This method is NOT in order , rather its POST ORDER.
 */
public void flattenToDoubleLL(BSTNode root) {
    if (root == null)
        return;
    flattenToDoubleLL(root.getRightNode());
    if(root.getLeftNode()!=null)
    	oneUp = root.getLeftNode();
    flattenToDoubleLL(root.getLeftNode());
    root.setRightNode(prev);
    root.setLeftNode(oneUp);
    prev = root;
}

/*
 * The below is a better solution to understand, key is using the temp variable to point as well, like the Prev pointer in below
 * This is a In Order Traversal of a tree , it can be done in place like below or addding the nodes in a stack and then chaining them later.
 * 
public Node treeToDoublyList(Node root) 
{
    Node dummy = new Node(0,null,null);
    prev = dummy;
    flattenToDoubleLL(root);   
    prev.right = dummy.right;
    dummy.right.left = prev;
    return dummy.right; // dummy.right to point to the right head.
}
public void flattenToDoubleLL(Node root) {
if (root == null)
    return;
flattenToDoubleLL(root.left);
prev.right = root;// this is the key piece
root.left = prev;
prev = root;
flattenToDoubleLL(root.right);
}
 */

public Node iterStack(Node root)
{
    addToStack(root);
    Node prev = null;
    Node last = null;
    prev = stk.pop();   
    last = prev;
    while(!stk.isEmpty())
    {
        Node temp = stk.pop();
        temp.right = prev;
        prev.left = temp;
        prev = temp;
    }
    
    last.right = prev;
    prev.left = last;
    
    return prev;
}

public void addToStack(Node root)
{
    if(root== null)
        return;
    
    addToStack(root.left);
    stk.push(root);
    addToStack(root.right);
}

static class Node
{
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
}

}
