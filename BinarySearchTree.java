package cs143;

import java.util.ArrayList;

public class BinarySearchTree <Key extends Comparable<Key>, Value> implements BSTInterface<Key, Value>  {
	int nodeCount = 0;
	 @SuppressWarnings("unused")
	private class Node 
	{
		
		public Node(Key key, Value data, Node rightChild, Node leftChild) {
			super();
			
			this.data = data;
			this.key = key;
			this.rightChild = rightChild;
			this.leftChild = leftChild;
		}

		 public Key key;
		 
		 public Value data;
		
		 public Node rightChild;
		
		 public Node leftChild;
	}
   private Node root;
   private void printTree(Node current) 
	{
		//add code here
	 if (current != null)
	 {
		printTree(current.leftChild);
		System.out.println(current.data);
		printTree(current.rightChild);
		 
	 }
	
	   
	   
	}
	@Override
	public void printTree() {
		 printTree(root);
		
	}
	 
	@Override
	public Value find(Key key) {
		// TODO Auto-generated method stub
		if (root == null)
		{
			return null;
		}
		Node current = root;
	while(current != null)
	{
		if (current.key.compareTo(key) == 0)
		{
			return current.data;
		}
		else if(current.key.compareTo(key) > 0)
		{
			
			current = current.leftChild;
			
		}
		else 
		{
			current = current.rightChild;
			
		}
	}
	return null;
	}
	
	public Node findParent(Key childKey)
	{
		if (root == null)
		{
			return null;
		}
		Node current = root;
		while(current != null)
		{
		
			if(current.key.compareTo(childKey)>0)
			{
				if(current.leftChild.key.equals(childKey))
				{
					return current;
				}
				else
				{
				current = current.leftChild;
				}
				
			}
			else 
			{
				if(current.rightChild.key.equals(childKey))
				{
					return current;
				}
				else
				{
				current = current.rightChild;
				}
			}
		}
		return null;
		}
		
	public Value getParentValue(Key key)
	{
		Node parent = findParent(key);
		return parent.data;
		
	}
	
	

	
	@Override
	public void clear() {
		root = null;
		nodeCount = 0;
		
		
	}

	@Override
	public boolean insert(Key key, Value value) {
		// TODO Auto-generated method stub
		if (root == null)
		{
			root = new Node(key, value, null, null);
			nodeCount++;
			return true;
		}
		Node current = root;
	while(current != null)
	{
		if (current.key.compareTo(key) == 0)
		{
			return false;
		}
		else if(current.key.compareTo(key)>0)
		{
			if (current.leftChild != null)
			{
				current = current.leftChild;
				
			}
			else
			{
				current.leftChild = new Node(key, value, null, null);
				nodeCount++;
				return true;
			}
		}
		else 
		{
			if (current.rightChild != null)
			{
				current = current.rightChild;
				
			}
			else
			{
				current.rightChild = new Node(key, value, null, null);
				nodeCount++;
				return true;
			}
		}
	}
	//unreachable 
return false;
	}

	public boolean isEmpty()
	{
		if(nodeCount > 0)
		{
			return false;
		}
		else
		{
		return true;
		}
	}
	@Override
	public int size() {

		return nodeCount;
	}

	@Override
	public boolean cotains(Key key) {
		if(find(key) == null)
		{
			return false;
		}
		else
		{
		return true;
		}
	}

@Override	
	public Value remove(Key key) {
		boolean atRight = false;
		boolean atLeft = false;
		boolean rootDelete = false;
		Node parent =  null;
		if(size()==0)
		{
		 return null;
		}
		if(root.key.compareTo(key) == 0) {
			if(size() ==1 )
			{
				Value value = root.data;
				clear();
				nodeCount--;
				return value;
				
			}
			rootDelete = true;
		} 
		else
		{
		 parent = findParent(key);
		if(parent.leftChild.key.compareTo(key)== 0)
		{
			
			atLeft = true;
		}
		else
		{
			atRight = true;
		}
		}
		 if(( rootDelete ||parent.leftChild.leftChild !=null && parent.rightChild.rightChild != null))
		{   
			
			Node min = getMin(); 
			Value minData = min.data;
			Key minKey = min.key;
			Node minParent = findParent(min.key);
			
			if(min.rightChild != null)
			{
				minParent.leftChild = minParent.leftChild.rightChild;
				Value value = root.data;
				root.data = minData;
				root.key = minKey;
				nodeCount--;
                return value;
			}
			else
			{
				minParent.leftChild = null;
				Value value = root.data;
				root.data = minData;
				root.key = minKey;	
				nodeCount--;
				 return value;
			}
		}
		else if(parent.leftChild.leftChild != null)
		{
			if(atLeft)
			{
			Value value = parent.leftChild.data;
			
			parent.leftChild = parent.leftChild.leftChild;
			nodeCount--;
			return value;
			}
			else
			{
				Value value = parent.rightChild.data;
				parent.rightChild = parent.rightChild.leftChild;
				nodeCount--;
				return value;
			}
		}
		 //1 child at the right
		else
		{
			if(atLeft)
			{
				Value value = parent.leftChild.data;
				parent.leftChild = parent.leftChild.rightChild;
				nodeCount--;
				return value;
			}
			else
			{
				Value value = parent.rightChild.data;
				parent.rightChild = parent.rightChild.rightChild;
				nodeCount--;
				return value;
			}
		}
		
	
	}
	
	public Node getMin()
	{
		Node current = root;
		current = current.rightChild;
		while(current.leftChild != null)
		{
			current = current.leftChild;
		}
		return current;
	}
	
	public Value getMinValue()
	{
		Node min = getMin();
		return min.data;
		
	}
	


	private void inOrderValues(Node current, ArrayList<Value> values)
	{
		if (current != null)
		{
			inOrderValues(current.leftChild, values);
			values.add(current.data);
			inOrderValues(current.rightChild, values);
			
			
		}
	}
	@Override
	public ArrayList<Value> inorderValues() {
		ArrayList<Value> in = new ArrayList<>();
		inOrderValues(root, in);
		return in;
	}  
	
	private void preOrderValues(Node current, ArrayList<Value> values)
	{
		if (current != null)
		{
			values.add(current.data);
			preOrderValues(current.rightChild, values);
			preOrderValues(current.leftChild, values);
			
		}
	}
	@Override
	public ArrayList<Value> preorderValues() {
		ArrayList<Value> pre = new ArrayList<>();
		preOrderValues(root, pre);
		return pre;
	
	}
	
	  private void postOrderValues(Node current, ArrayList<Value> values) 
		{
			//add code here
		 if (current != null)
		 {
			 postOrderValues(current.leftChild,values);
			//System.out.println(current.data);
			postOrderValues(current.rightChild, values);
			values.add(current.data);
			
			 
		 }
		
		   
		   
		}
	@Override
	public ArrayList<Value> postOrderValues() {
		ArrayList<Value> post = new ArrayList<>();
		postOrderValues(root, post);
		return post;
	}

	

}
