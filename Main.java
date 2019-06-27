package cs143;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
	
	
	public static void main(String[] args) {

		long totalMiliseconds = 0;
	int count = 10000;
	
		
		InputStream res = Main.class.getResourceAsStream("/files/NameList.csv");
		ArrayList<Employee> unsorted = loadEmployee(res, count);
		
		BinarySearchTree<String, Employee> sortedTree = new BinarySearchTree<>();
		
		for(int i = 0; i < unsorted.size(); i++)
		{
			sortedTree.insert(unsorted.get(i).getID(), unsorted.get(i));
		}
		
		
		Collections.shuffle(unsorted);
		BinarySearchTree<String, Employee> unsortedTree = new BinarySearchTree<>();
		for(int i = 0; i < unsorted.size(); i++)
		{
			unsortedTree.insert(unsorted.get(i).getID(), unsorted.get(i));
		}

		

	

		unsortedTree.printTree(); 
		Random rand = new Random();
		Instant start = Instant.now();
		long totalNanoSeconds = 0;
		for(int x = 0; x<100; x++)
		{int num = rand.nextInt(count);
		
			unsortedTree.find(String.format("%010d", num));
		}
		Instant end = Instant.now();
		totalNanoSeconds = Duration.between(start, end).toNanos();
		System.out.println("Unsorted Time for Find: "+ totalNanoSeconds);
		
		 start = Instant.now();
		totalNanoSeconds = 0;
		for(int x = 0; x<100; x++)
		{int num = rand.nextInt(count);
		
			sortedTree.find(String.format("%010d", num));
		}
		 end = Instant.now();
		totalNanoSeconds = Duration.between(start, end).toNanos();
		System.out.println("Sorted Time for Find: "+ totalNanoSeconds);
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
