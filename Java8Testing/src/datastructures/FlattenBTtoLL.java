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



}
