package datastructures;

public class FlattenBTtoLL {
	
private BSTNode prev = null;

public void flatten(BSTNode root) {
    if (root == null)
        return;
    flatten(root.getRightNode());
    flatten(root.getLeftNode());
    root.setRightNode(prev);
    root.setLeftNode(null);
    prev = root;
}

}
