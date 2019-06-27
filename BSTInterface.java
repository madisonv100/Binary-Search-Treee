package cs143;

import java.util.ArrayList;

public interface BSTInterface <Key extends Comparable<Key>, Value> {

	
	/**
	*   @brief clear all elements from the tree.
	*
	*   @return void
	*/
	void clear();

	
	/**
	*   @brief insert the Value using the Key
	*   If the Key is already in the tree it returns false.
	*   @param  Key of the item to insert.
	*   @param  Value the item to insert.
	*   @return return true if the Value was inserted
	*/
	boolean insert(Key key, Value value);
	


	/**
	*   @brief  Get the current number of items in the tree.
	*  
	*
	*   @return int the current number of items in the tree.
	*/
	int size() ;


	/**
	*   @brief  Return true if this key is found in the tree
	*  Returns null if the Key is not found
	*  
	*   @return True if this key is in the tree 
	*/
	boolean cotains(Key key);
	
	
	/**
	*   @brief  Return true if this tree has no Values
	*  
	*   @return True if the tree has no values 
	*/
	boolean isEmpty();
	
	/**
	*   @brief  Return the at stored at the key
	*  Returns null if the Key is not found
	*  
	*   @return Value store at this key in the tree 
	*/
	Value find(Key key) ;
	
	/**
	*  @brief  Return the at stored at the key
	*  Returns null if the Key is not found
	*  
	*  @return Value removed from the tree
	*/
	Value remove(Key key) ;
	
	/**
	*  @brief  prints an inorder list 
	*  Prints the list is empty if it is empty
	*  @return Value removed from the tree
	*/
	void printTree();
	
	
	/**
	*  @brief  Return an inorder list of the  values in the tree
	*  
	*  @return an inorder list of the  values in the tree
	*/
	ArrayList<Value> inorderValues();
	
	
	/**
	*  @brief  Return an preOrder list of the  values in the tree
	*  
	*  @return an preOrder list of the  values in the tree
	*/
	ArrayList<Value> preorderValues();
	
	/**
	*  @brief  Return an postOrder list of the  values in the tree
	*  
	*  @return an postOrder list of the  values in the tree
	*/
	ArrayList<Value> postOrderValues();
	
	
	
	
}
