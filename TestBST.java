package cs143;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.junit.Test;



public class TestBST {

	/*
	 * @Test public void testSizeOnEMptyTree() {
	 * 
	 * BinarySearchTree<String, Employee> tree = new BinarySearchTree<>();
	 * 
	 * assertTrue("The Tree is empty but is empty returns false", tree.isEmpty());
	 * 
	 * 
	 * 
	 * }
	 */
	
	@Test
	public void insertOne()
	{
		BinarySearchTree<String, Employee> tree = new BinarySearchTree<>();
		
		InputStream res = Main.class.getResourceAsStream("/files/NameList.csv");
		ArrayList<Employee> unsorted = loadEmployee(res, 100);
		tree.insert(unsorted.get(0).getID(), unsorted.get(0));
		assertEquals(1, tree.size());
	}
	@Test
	public void insertRightChild()
	{
		BinarySearchTree<String, Employee> tree = new BinarySearchTree<>();
		
		InputStream res = Main.class.getResourceAsStream("/files/NameList.csv");
		ArrayList<Employee> unsorted = loadEmployee(res, 100);
		tree.insert(unsorted.get(0).getID(), unsorted.get(0));
		tree.insert(unsorted.get(1).getID(), unsorted.get(1));
        
		assertEquals(unsorted.get(1).getID(), tree.inorderValues().get(1).getID());	
		
	}
	
	@Test
	public void insertRightRightChild()
	{
		BinarySearchTree<String, Employee> tree = new BinarySearchTree<>();
		
		InputStream res = Main.class.getResourceAsStream("/files/NameList.csv");
		ArrayList<Employee> unsorted = loadEmployee(res, 100);
		tree.insert(unsorted.get(0).getID(), unsorted.get(0));
		tree.insert(unsorted.get(1).getID(), unsorted.get(1));
		tree.insert(unsorted.get(2).getID(), unsorted.get(2));

        
		assertEquals(unsorted.get(2).getID(), tree.inorderValues().get(2).getID());	
		
	}
	
	@Test
	public void insertLeftChild()
	{
		BinarySearchTree<String, Employee> tree = new BinarySearchTree<>();
		
		InputStream res = Main.class.getResourceAsStream("/files/NameList.csv");
		ArrayList<Employee> unsorted = loadEmployee(res, 100);
		tree.insert(unsorted.get(2).getID(), unsorted.get(2));
		tree.insert(unsorted.get(0).getID(), unsorted.get(0));
	
		
		System.out.println( tree.inorderValues().get(0).getID());
		assertEquals(unsorted.get(0).getID(), tree.inorderValues().get(0).getID());	
	}
	
	@Test
	public void insertLeftLeftChild()
	{
		BinarySearchTree<String, Employee> tree = new BinarySearchTree<>();
		
		InputStream res = Main.class.getResourceAsStream("/files/NameList.csv");
		ArrayList<Employee> unsorted = loadEmployee(res, 100);
		tree.insert(unsorted.get(5).getID(), unsorted.get(5));
		tree.insert(unsorted.get(2).getID(), unsorted.get(2));
		tree.insert(unsorted.get(1).getID(), unsorted.get(1));

	
		
		System.out.println( tree.inorderValues().get(0).getID());
		assertEquals(unsorted.get(1).getID(), tree.inorderValues().get(0).getID());	
	}	
	
//check	
	@Test
	public void insertAlreadyExist()
	{
		BinarySearchTree<String, Employee> tree = new BinarySearchTree<>();
		
		InputStream res = Main.class.getResourceAsStream("/files/NameList.csv");
		ArrayList<Employee> unsorted = loadEmployee(res, 100);
		tree.insert(unsorted.get(5).getLevel(), unsorted.get(5));
		assertFalse(tree.insert(unsorted.get(5).getLevel(), unsorted.get(5)));
		
		
	}	
	

@Test 
public void findKeyNormal()
{
	BinarySearchTree<String, Employee> tree = new BinarySearchTree<>();
	
	InputStream res = Main.class.getResourceAsStream("/files/NameList.csv");
	ArrayList<Employee> unsorted = loadEmployee(res, 100);
	tree.insert(unsorted.get(5).getID(), unsorted.get(5));
	tree.insert(unsorted.get(4).getID(), unsorted.get(4));
	tree.insert(unsorted.get(3).getID(), unsorted.get(3));
	tree.insert(unsorted.get(7).getID(), unsorted.get(7));

	tree.printTree(); 
	assertEquals(unsorted.get(3), tree.find(unsorted.get(3).getID()));

}
@Test 
public void findKeyNormalNumbers()
{
	BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
	Integer find = 6;
	


	tree.insert(8, 8);
	tree.insert(5, 5);
	tree.insert(4, 4);
	tree.insert(6,6);
	tree.insert(7, 7);
	tree.insert(11, 11);
	
	

	tree.printTree(); 
	assertEquals(find, tree.find(find));

}

@Test 
public void containsTrue()
{
	BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
	Integer find = 6;
	


	tree.insert(8, 8);
	tree.insert(5, 5);
	tree.insert(4, 4);
	tree.insert(6,6);
	tree.insert(7, 7);
	tree.insert(11, 11);
	
	

	tree.printTree(); 
	assertEquals(true, tree.cotains(find));

}
@Test 
public void containsFalse()
{
	BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
	Integer find = 2;
	


	tree.insert(8, 8);
	tree.insert(5, 5);
	tree.insert(4, 4);
	tree.insert(6,6);
	tree.insert(7, 7);
	tree.insert(11, 11);
	
	

	tree.printTree(); 
	assertEquals(false, tree.cotains(find));

}

@Test 
public void findKeyDNE()
{
	BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
	Integer find = 12;
	


	tree.insert(8, 8);
	tree.insert(5, 5);
	tree.insert(4, 4);
	tree.insert(6,6);
	tree.insert(7, 7);
	tree.insert(11, 11);
	
	

	tree.printTree(); 
	assertEquals(null, tree.find(find));

}
@Test 
public void insertDuplicate()
{
	BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
	Integer find = 8;
	


	tree.insert(8, 8);
	tree.insert(5, 5);
	tree.insert(4, 4);
	tree.insert(6,6);
	tree.insert(7, 7);
	tree.insert(11, 11);
	
	

	tree.printTree(); 
	assertEquals(false, tree.insert(find, find));

}
@Test 
public void size()
{
	BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
	Integer find = 6;
	


	tree.insert(8, 8);
	tree.insert(5, 5);
	tree.insert(4, 4);
	tree.insert(6,6);
	tree.insert(7, 7);
	tree.insert(11, 11);
	
	assertEquals(6, tree.size());

}

@Test 
public void findParent()
{
	BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
	Integer find = 6;
	


	tree.insert(8, 8);
	tree.insert(5, 5);
	tree.insert(4, 4);
	tree.insert(6,6);
	tree.insert(7, 7);
	tree.insert(11, 11);
	
	assertEquals(5, tree.getParentValue(find), .001);

}


@Test 
public void findKeyInEmptyTree()
{
	BinarySearchTree<String, Employee> tree = new BinarySearchTree<>();
	
	InputStream res = Main.class.getResourceAsStream("/files/NameList.csv");
	ArrayList<Employee> unsorted = loadEmployee(res, 100);
	

	assertTrue( null== tree.find(unsorted.get(3).getID()));

} 

@Test 
public void clear()
{
	BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
	Integer find = 8;
	


	tree.insert(8, 8);
	tree.insert(5, 5);
	tree.insert(4, 4);
	tree.insert(6,6);
	tree.insert(7, 7);
	tree.insert(11, 11);
	
	

	tree.clear();
	assertEquals(null, tree.find(8));

}

@Test 
public void isEmptyTrue()
{
	BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
	

	tree.insert(8, 8);
	tree.insert(5, 5);
	tree.insert(4, 4);
	tree.insert(6,6);
	tree.insert(7, 7);
	tree.insert(11, 11);
	


	assertEquals(false, tree.isEmpty());

}
@Test 
public void getMax()
{
	BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
	

	tree.insert(8, 8);
	tree.insert(5, 5);
	tree.insert(4, 4);
	tree.insert(6,6);
	tree.insert(7, 7);
	tree.insert(11, 11);
	tree.insert(9, 9);
	


	assertEquals(9, tree.getMinValue(), .001);

}

@Test 
public void remove()
{
	BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
	

	tree.insert(8, 8);
	tree.insert(5, 5);
	tree.insert(4, 4);
	tree.insert(6,6);
	tree.insert(7, 7);
	tree.insert(11, 11);
	tree.insert(9, 9);
	


//	assertEquals(5, tree.remove(5), .001);
//	assertEquals(null, tree.find(5));
//	assertEquals(11, tree.remove(11), .001);
//	assertEquals(null, tree.find(11));
//	assertEquals(9, tree.remove(9), .001);
//	assertEquals(null, tree.find(9));
	
//	assertEquals(8, tree.remove(8), .001);
//	assertEquals(null, tree.find(8));
//	assertEquals(6, tree.size());
//	assertEquals(5, tree.remove(5), .001);
	assertEquals(6, tree.remove(6), .001);	
	assertEquals(8, tree.remove(8), .001);
	assertEquals(11, tree.remove(11), .001);
	
}
@Test 
public void isEmptyFalse()
{
	BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
	
	


	assertEquals(true, tree.isEmpty());

}
public static ArrayList<Employee> loadEmployee(InputStream res, int size)
{
	 BufferedReader reader = new BufferedReader(new InputStreamReader(res));
	
	
	 ArrayList<Employee> employees = new  ArrayList<Employee>();
    ArrayList<String> lines = new  ArrayList<String>();
	try {
	
		String line;
	
		while ((line = reader.readLine()) != null) 
		{
			lines.add(line);				
		}	

	} catch (IOException e) {

		e.printStackTrace();

	} finally {

		try {

			if (reader != null)
				reader.close();

		} catch (IOException ex) {
		

		}
		int count = 0;
		for (int i = 0; i < size; i++) {
			
			String field[] = lines.get(count++).split(","); 
			
			 
			employees.add(new Employee(field[0], field[1], field[2], String.format("%010d", i), field[3]));
			count = count % lines.size();
			
		}

	}

	return employees;
}




}