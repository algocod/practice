package datastructures;

public class FlattenBTtoLL {
	
private BSTNode prev = null;
private BSTNode oneUp = null;
public void flatten(BSTNode root) {
    if (root == null)
        return;
    flatten(root.getRightNode());
    flatten(root.getLeftNode());
    root.setRightNode(prev);
    root.setLeftNode(null);
    prev = root;
}

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
 * 
 * 
public Node treeToDoublyList(Node root) 
{
    Node dummy = new Node(0,null,null);
    prev = dummy;
    flattenToDoubleLL(root);   
    prev.right = dummy.right;
    dummy.right.left = prev;
    return dummy;
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
}
