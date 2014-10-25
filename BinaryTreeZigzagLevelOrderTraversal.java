import java.util.*;
import java.util.Stack; 

public class BinaryTreeZigzagLevelOrderTraversal {

	class TreeNode {
 	    int val;
 	   TreeNode left;
 	   TreeNode right;
 	   TreeNode(int x) { val = x; }
 	}

	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root != null){
            return null;
        }
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.add(root);
        Queue<Stack<TreeNode>> queue = new LinkedList<Stack<TreeNode>>();
        queue.add(stack);
        int level = 0;
        while(!queue.isEmpty()){
        	stack = queue.poll();
        	List<Integer> list = new ArrayList<Integer>();
        	Stack<TreeNode> newStack = new Stack<TreeNode>();
        	while(!stack.isEmpty()){
        		TreeNode p = stack.pop();
        		if(p != null){
	        		list.add(p.val);
	        		TreeNode lnode = p.left;
	        		TreeNode rnode = p.right;
	 				if(level % 2 == 0){
						if(lnode != null)
							newStack.push(lnode);
						if(rnode != null)
							newStack.push(rnode);
	        		}else{
	        			if(rnode != null)
							newStack.push(rnode);
						if(lnode != null)
							newStack.push(lnode);
	        		}
        		}
        	}
        	result.add(list);
        	if(!newStack.isEmpty()){
        		queue.add(newStack);
        	}
        	level = level + 1;
        }
    	return result;
    }



}
