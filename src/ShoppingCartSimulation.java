package osu.cse2123;
/**
 * A simple program that implements an interactive shopping cart.
 *
 * @author ChristianBarrett
 * @version 3.16.2021
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ShoppingCartSimulation {
	
	/**
	 * Loads a List of Product objects from a file (format given in the
	 * project write-up).  You should assume that the file is correctly
	 * formatted.
	 * 
	 * @param fname name of properly formatted product file to load data from
	 * @precond fname is a properly formatted file as given in the assignment
	 * @return List of Product objects as read from the file
	 */
	public static List<Product> loadProductsFromFile(String fname) throws FileNotFoundException {
		ArrayList<Product> prod = new ArrayList<Product>();
		//read the file with a scanner
		Scanner f = new Scanner(new File(fname));
		int j = 0;
		while (f.hasNext()) {
			//read the file line by line, putting each line into a product object
			String str = f.nextLine();
			String[] pVals = str.split(",");
			prod.add(new Product());
			prod.get(j).setName(pVals[0]);
			prod.get(j).setInventoryCode(pVals[1]);
			prod.get(j).setPrice(Integer.parseInt(pVals[2]));
			prod.get(j).setType(pVals[3]);
			//adding certain items to the current product in the array list

			j++;

		}
		f.close();
		return prod;
	}
	
	
	/**
	 * Prints the choices for the user to choose from to the screen
	 * (See the project write-up for details)
	 * 
	 * @param prods List of Product objects to display for purchase
	 */
	public static void displayChoices(List<Product> prods) {
		int j = 0;
		for (int i = 0; i < prods.size(); i++) {
			j = i+1; 
			//System.out.println( j + " " + prods.get(i).getName() + " " + (double)prods.get(i).getPrice() / 100);
			System.out.printf("%-5s %-34s %5.2f%n", 
					j, prods.get(i).getName(), (double)(prods.get(i).getPrice() / 100.00));
			
		}
    	
	}
	
	/**
	 * Prints the current contents of the shopping cart
	 * (See the project write-up for details)
	 * 
	 * @param cart a Map of (Product,Integer) where the key is the product
	 *         in the cart and the value is the quantity of that product
	 *         in the cart.
	 */
	public static void displayCart(Map<Product, Integer> cart) {
		double sumTotalCost = 0;
		//for loop that iterates through the cart Map
		for (Map.Entry<Product,Integer> entry : cart.entrySet()) {
			double totalCost = ((double)entry.getKey().getPrice() * (double)entry.getValue()) / 100.00;
			double adjPrice = (double)entry.getKey().getPrice() / 100.00;
			System.out.printf("%-38s %2d x %5.2f %9.2f%n", 
					 entry.getKey().getName(), entry.getValue(), adjPrice, totalCost);
			sumTotalCost += totalCost;
		}
		System.out.printf("Total cost: %10.2f%n", sumTotalCost);
	}
	
	/**
	 * Simple method to get user input for the name of the file
	 * 
	 * @return file String - name of file
	 */
	public static String getFileName(Scanner s) {
		System.out.print("Enter an input file: ");
		String file = s.nextLine();
		return file;
	}
	/**
	 * Comprehensive method that contains a loop asking the user for choices to add to cart until they select 0
	 * 
	 * @return prodMap Map<Product, Integer>, the map with all of their choices.
	 */
	public static Map<Product, Integer> choicesLoop (int cartItem, List<Product> prods, Scanner s) {
		Map<Product, Integer> prodMap = new HashMap<>();
		int quantity = 0;
		while (cartItem != 0) {
			System.out.print("Enter a quantity: ");
			quantity = Integer.parseInt(s.nextLine());
			prodMap.put(prods.get(cartItem-1), quantity);
			System.out.println();
			//get user input for a quantity and add it to the cart as the value
			
			System.out.print("Your cart contains: ");
			System.out.println();
			displayCart(prodMap);
			
			System.out.println();
			System.out.print("Hit ENTER to continue");
			s.nextLine();
			
			
			displayChoices(prods);
			System.out.println();
			System.out.print("Enter something to add to the cart (0 to quit): ");
			cartItem = Integer.parseInt(s.nextLine());
			//display the choices and get user input for the next item (key) they want to put in their cart
		}
		return prodMap;
	}
	
	public static void main(String[] args) throws FileNotFoundException {
		Scanner s = new Scanner(System.in);
		List<Product> prods = loadProductsFromFile(getFileName(s));
		//load file into a list of products
		
		
		displayChoices(prods);
		System.out.println();
		//display the choices available to the user
		
		System.out.print("Enter something to add to the cart (0 to quit): ");
		int cartItem = Integer.parseInt(s.nextLine()); 
		//I talked with you (Phe) about this issue but you got it solved. Thanks for your help and all your encouraging comments!
		//ask the user for an item to put into cart
		
		Map<Product, Integer> prodMap = choicesLoop(cartItem, prods, s);
		//run the loop that continues asking for choices and will return a map with all product choices and quantities
		
		System.out.println();
		System.out.println("Your final purchases: ");
		displayCart(prodMap);
		//takes the product map (cart) returned above and displays it
    	
		s.close();
	}

}
