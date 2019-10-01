package algorithms;

public class ReversePairsBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = {1,3,2,3,1};
		new ReversePairsBST().reversePairs(input);
	}

	public int reversePairs(int[] nums) {
	    int res = 0;
	    Node root = null;
	    	
	    for (int ele : nums) {
	    	// Searching before adding is key to the rule where i >j so for higher indices, search if anything is greater than the 2*num value
	    	// and then add it.
	    	// So it saves the time for twice iteration .
	        res += search(root, 2L * ele + 1);
	        root = insert(root, ele);
	    }
	    
	    return res;
	}
	private int search(Node root, long val) {
	    if (root == null) {
	    	return 0;
	    } else if (val == root.val) {
	    	return root.cnt;
	    } else if (val < root.val) {
	    	return root.cnt + search(root.left, val);
	    } else {
	    	return search(root.right, val);
	    }
	}

	private Node insert(Node root, int val) {
	    if (root == null) {
	        root = new Node(val);
	    } else if (val == root.val) {
	        root.cnt++;
	    } else if (val < root.val) {
	        root.left = insert(root.left, val);
	    } else {
	        root.cnt++;
	        root.right = insert(root.right, val);
	    }
	    
	    return root;
	}
	
	
	class Node {
	    int val, cnt;
	    Node left, right;
	        
	    Node(int val) {
	        this.val = val;
	        this.cnt = 1;
	    }
	}
}
