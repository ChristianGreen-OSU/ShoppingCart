package osu.cse2123;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

class ShoppingCartSimTest {
	
	

	private static String runMain(String input) {
		 // Set System.in and System.out to our test values
     // Create a stream to hold the output
     ByteArrayOutputStream baos = new ByteArrayOutputStream();
     PrintStream ps = new PrintStream(baos);
     // IMPORTANT: Save the old System.out!
     PrintStream old = System.out;
     // Tell Java to use your special stream
     System.setOut(ps);

     InputStream oldInput = System.in;
     InputStream newInput = new ByteArrayInputStream(input.getBytes());
     System.setIn(newInput);


     // Run the actual project here, output will go into baos, input will
     // come from newInput.
     // This is implemented in the child class inherited from ProjectTest
     // for flexibility.
   
     	try {
			ShoppingCartSimulation.main(new String[0]);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     

     // Put System.out and System.in back to what they were.
     // IMPORTANT - make sure to flush System.out so it all gets written
     // to the ByteArray
     System.out.flush();
     System.setOut(old);
     System.setIn(oldInput);

     // Return our output as a String instead of as a ByteArray
     return baos.toString();
	}
	
	private static String runChoice(String input) {
		 // Set System.in and System.out to our test values
    // Create a stream to hold the output
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    PrintStream ps = new PrintStream(baos);
    // IMPORTANT: Save the old System.out!
    PrintStream old = System.out;
    // Tell Java to use your special stream
    System.setOut(ps);

    InputStream oldInput = System.in;
    InputStream newInput = new ByteArrayInputStream(input.getBytes());
    System.setIn(newInput);


    // Run the actual project here, output will go into baos, input will
    // come from newInput.
    // This is implemented in the child class inherited from ProjectTest
    // for flexibility.
  
    	try {
			List<Product> prods = ShoppingCartSimulation.loadProductsFromFile(input);
			ShoppingCartSimulation.displayChoices(prods);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    

    // Put System.out and System.in back to what they were.
    // IMPORTANT - make sure to flush System.out so it all gets written
    // to the ByteArray
    System.out.flush();
    System.setOut(old);
    System.setIn(oldInput);

    // Return our output as a String instead of as a ByteArray
    return baos.toString();
	}
	
	private static String runCart(String input) {
		 // Set System.in and System.out to our test values
   // Create a stream to hold the output
   ByteArrayOutputStream baos = new ByteArrayOutputStream();
   PrintStream ps = new PrintStream(baos);
   // IMPORTANT: Save the old System.out!
   PrintStream old = System.out;
   // Tell Java to use your special stream
   System.setOut(ps);

   InputStream oldInput = System.in;
   InputStream newInput = new ByteArrayInputStream(input.getBytes());
   System.setIn(newInput);


   // Run the actual project here, output will go into baos, input will
   // come from newInput.
   // This is implemented in the child class inherited from ProjectTest
   // for flexibility.
 
   	try {
			List<Product> prods = ShoppingCartSimulation.loadProductsFromFile(input);
			Map<Product,Integer> map = new HashMap<>();
			map.put(prods.get(0), 3);
			map.put(prods.get(1), 2);
			ShoppingCartSimulation.displayCart(map);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
   

   // Put System.out and System.in back to what they were.
   // IMPORTANT - make sure to flush System.out so it all gets written
   // to the ByteArray
   System.out.flush();
   System.setOut(old);
   System.setIn(oldInput);

   // Return our output as a String instead of as a ByteArray
   return baos.toString();
	}
	
	public static String loadFromFile(String fname) {
		String result ="";
		try {
			Scanner input = new Scanner(new File(fname));
			while (input.hasNext()) {
				result = result+input.nextLine();
				result += System.lineSeparator();
			}
			input.close();
		}
		catch(FileNotFoundException e) {
			System.out.println("ERROR - cannot find file "+fname);
		}
		return result;
	}


	@Test
	void testMainTranscript() throws FileNotFoundException {
		String keys = "input.txt\n1\n3\n\n2\n10\n\n5\n1\n\n0\n\n";
		String testRun = runMain(keys);
		String truth = loadFromFile("output_transcript.txt");
		assertEquals(truth,testRun,"full program transcript"); 
	}
	
	@Test
	void testLoadProductsFromFile() throws FileNotFoundException {
		List<Product> test = ShoppingCartSimulation.loadProductsFromFile("input.txt");
		assertEquals(6,test.size(),"size of product list test");
		assertEquals("The Shawshank Redemption",test.get(0).getName(),"front product name test");
		assertEquals("A Game of Thrones",test.get(test.size()-1).getName(),"final product name test");
	}
	
	@Test
	void testOutputChoice() throws FileNotFoundException {
		String keys = "input.txt";
		String testRun = runChoice(keys);
		String truth = loadFromFile("output_choice.txt");
		assertEquals(truth,testRun,"choice menu output");
	}
	
	@Test
	void testOutputCart() throws FileNotFoundException {
		String keys = "input.txt";
		String testRun = runCart(keys);
		String truth = loadFromFile("output_cart.txt");
		assertEquals(truth,testRun,"cart output");
	}


}
