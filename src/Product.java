package osu.cse2123;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple class for holding product information.
 *
 * @author ChristianBarrett
 * @version 3.14.21
 */

public class Product {

	//6 private variables to be used for the product class instantiated w/ no values
	private String pName;
	private String pCode;
	private int pQuantity;
	private List<Integer> pRatings;
	private int pPrice;
	private String pType;

	/**
	 * Product constructor - creates a default product with no name or type or
	 * inventory code, no ratings, and a price and quantity of 0.
	 * @postcond a product object with no name or type or inventory code, no ratings 
	 *                 and a price and quantity of 0
	 */
	public Product() {
		this.pName = "";
		this.pType = "";
		this.pCode = "";
		this.pRatings = new ArrayList<>();
		this.pPrice = 0;
		this.pQuantity = 0;
	}

	/**
	 * sets the name of the product object
	 *
	 * @param name new name for the product
	 * @postcond product name is now name
	 */
	public void setName(String name) {
		this.pName = name;
	}

	/**
	 * returns the name of the product
	 *
	 * @return the name of the product
	 */
	public String getName() {
		return this.pName;
	}

	/**
	 * sets the type of the product
	 *
	 * @param type the type of the product
	 * @postcond sets the type of the product to type
	 */
	public void setType(String type) {
		this.pType = type;
	}

	/**
	 * returns the type of the product
	 *
	 * @return - the product type
	 */
	public String getType() {

		return this.pType;
	}

	/**
	 * sets the price of the product in cents. A $10 product will have a price
	 * of 1000.
	 *
	 * @param price the price of the product
	 * @postcond price of the product set to price
	 */
	public void setPrice(int price) {
		this.pPrice = price;
	}

	/**
	 * returns the price of the product in cents.
	 *
	 * @return the price of the product in cents
	 */
	public int getPrice() {

		return this.pPrice;
	}

	/**
	 * sets the count of this product in our inventory.
	 *
	 * @param quantity the number of this product in inventory
	 * @postcond quantity of product set to quantity
	 */
	public void setQuantity(int quantity) {
		this.pQuantity = quantity;
	}

	/**
	 * returns the count of this product in our inventory
	 *
	 * @return the number of this product in inventory
	 */
	public int getQuantity() {
		return this.pQuantity;
	}

	/**
	 * sets the inventory code for this product
	 *
	 * @param code the new inventory code for the product
	 * @postcond the inventory code for the product set to code
	 */
	public void setInventoryCode(String code) {
		this.pCode = code;
	}

	/**
	 * returns the inventory code for this product
	 *
	 * @return the inventory code of the product
	 */
	public String getInventoryCode() {
		return this.pCode;
	}

	/**
	 * returns the String representation of this object
	 * (See project write-up for details)
	 *
	 * @return the String representation of this object
	 */
	@Override
	public String toString() {

		String str = "(" + getName()+ ", " + getInventoryCode()+ ", " + getType()+ ", " + getPrice() + ")";


		return str;
	}

	/**
	 * returns true if other equals this, false otherwise.
	 * 
	 * @return true if other has the same value as this, false otherwise
	 */
	@Override
	public boolean equals(Object other) {
		boolean areEqual = false;
		//if given object is the same as the product, return true
		if (other == this) {
			areEqual = true;
		}
		//if given object is a Product instance, check to see if string versions are the same as one another
		else if (other instanceof Product) {
			Product localOther = (Product) other;
			areEqual = this.toString().equals(localOther.toString());
		}
		return areEqual;

	}

	/**
	 * returns an integer value for hashing
	 * (See the project write-up for details)
	 * 
	 * @return an integer value suitable for use in a HashMap or HashSet
	 */
	@Override
	public int hashCode() {
		int code = 0;
		code += this.pName.hashCode();
		code += this.pType.hashCode();
		code += this.pCode.hashCode();
		//code += this.pPrice.hashCode();
		code += this.pPrice;
		
		//code = this.toString().hashCode();
		
//		String prodInfo = this.toString();
//		String[] splitInfo = prodInfo.split(",");
//		int code = 0;
//		//Split String becomes: (Test Product, 123456, DVD, 1000)
//		//get the hash code of each individual string and add them up
//		for (int i = 0; i < splitInfo.length; i++) {
//			System.out.println(splitInfo[i]);
//			code = code + splitInfo[i].hashCode();
//		}
		return code;
	}
	
	public static void main(String[] args) {
		Product pr = new Product();
		pr.setName("Vertigo");
		pr.setInventoryCode("C0000023");
		pr.setType("DVD");
		pr.setPrice(995);
		System.out.println(pr.hashCode());
		Product rr = new Product();
		rr.setName("Vertigo");
		rr.setInventoryCode("C0000023");
		rr.setType("DVD");
		rr.setPrice(995);
		System.out.println(rr.hashCode());
		System.out.println(rr.equals(pr));
	}
}
