package datastructures;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SerializeAndDeSerBTree {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        StringBuffer sb = new StringBuffer();
        ser(root,sb);
        return sb.toString();
    }
    // Pre-order serialization is important to figure out the node before the leaves.
    public void ser(TreeNode root, StringBuffer sb)
    {
        if(root==null)
        {
            sb.append("null,");
            return;
        }
        
        sb.append(root.val).append(",");
        ser(root.left,sb);
        ser(root.right,sb);
        
        return;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data==null || data.length()<1)
            return null;
            
        String[] input = data.split(",");
        List<String> inputList = new LinkedList<String>(Arrays.asList(input));
        return deser(inputList);
    }
    
    public TreeNode deser(List<String> input)
    {
    	// the below piece of code is key , which defines when to return while parsing the string inputs.
    	
        if(input.get(0).equals("null"))
        {
            input.remove(0);
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(input.get(0)));
        input.remove(0);
        root.left = deser(input);
        root.right = deser(input);
        
        return root;
    }

	public class TreeNode
	{
	 int val;
	 TreeNode left;
	 TreeNode right;
	 TreeNode(int x) { val = x; }
	}	
	
}
