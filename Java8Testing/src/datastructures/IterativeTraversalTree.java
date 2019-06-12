package datastructures;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class IterativeTraversalTree {

	class TreeNode
	{
		TreeNode left;
		TreeNode right;
		int val;
		TreeNode(int x) {val =x;}
	}
	
	public static void main(String[] args) {

	    Deque<Integer> test = new ArrayDeque<>();
	    test.push(1);
	    test.push(2);
	    test.push(3);
	    test.push(4);
	    
	    System.out.println(test.pop());
		
	}

	/*
	 * Dequeue is being used which is a double ended queue and the pop mimics the Stack behavior, hence not to be confused by below solution where queue 
	 * is mentioned but stack named variable is being used. 
	 */
	public List<Integer> preorderTraversal(TreeNode root) {
	    List<Integer> result = new ArrayList<>();
	    Deque<TreeNode> stack = new ArrayDeque<>();
	    //Queue<TreeNode> q = new ArrayDqueue<>();
	    TreeNode p = root;
	    while(!stack.isEmpty() || p != null) {
	        if(p != null) {
	            stack.push(p);
	            result.add(p.val);  // Add before going to children
	            p = p.left;
	        } else {
	            TreeNode node = stack.pop();
	            p = node.right;   
	        }
	    }
	    return result;
	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
	    LinkedList<Integer> result = new LinkedList<>();
	    Deque<TreeNode> stack = new ArrayDeque<>();
	    TreeNode p = root;
	    while(!stack.isEmpty() || p != null) {
	        if(p != null) {
	            stack.push(p);
	            result.addFirst(p.val);  // Reverse the process of preorder
	            p = p.right;             // Reverse the process of preorder
	        } else {
	            TreeNode node = stack.pop();
	            p = node.left;           // Reverse the process of preorder
	        }
	    }
	    return result;
	}
	
	public List<Integer> inorderTraversal(TreeNode root) {
	    List<Integer> result = new ArrayList<>();
	    Deque<TreeNode> stack = new ArrayDeque<>();
	    TreeNode p = root;
	    while(!stack.isEmpty() || p != null) {
	        if(p != null) {
	            stack.push(p);
	            p = p.left;
	        } else {
	            TreeNode node = stack.pop();
	            result.add(node.val);  // Add after all left children
	            p = node.right;   
	        }
	    }
	    return result;
	}
	
	
}
