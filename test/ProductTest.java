package osu.cse2123;

/**
 * Test cases for the Product class
 * 
 * @name Jeremy Morris
 * @version 20201007
 * 
 */
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ProductTest {
	
	static Product[] test;
	
	@BeforeAll
	static void initialize() {
		test = new Product[6];
		test[0] = new Product();
		test[0].setName("Test Product");
		test[0].setInventoryCode("123456");
		test[0].setType("DVD");
		test[0].setPrice(1000);
		test[1] = new Product();
		test[1].setName("Another Test Product");
		test[1].setInventoryCode("123456");
		test[1].setType("DVD");
		test[1].setPrice(1000);
		test[2] = new Product();
		test[2].setName("Test Product");
		test[2].setInventoryCode("987654");
		test[2].setType("DVD");
		test[2].setPrice(1000);
		test[3] = new Product();
		test[3].setName("Test Product");
		test[3].setInventoryCode("123456");
		test[3].setType("DVD");
		test[3].setPrice(3000);
		test[4] = new Product();
		test[4].setName("Test Product");
		test[4].setInventoryCode("123456");
		test[4].setType("Book");
		test[4].setPrice(1000);
		test[5] = new Product();
		test[5].setName("Test Product");
		test[5].setInventoryCode("123456");
		test[5].setType("DVD");
		test[5].setPrice(1000);

	}
	
	@Test
	void testToString() {
		assertEquals("(Test Product, 123456, DVD, 1000)",test[0].toString());
	}
	
	@Test
	void testToStringDifferentName() {
		assertEquals("(Another Test Product, 123456, DVD, 1000)",test[1].toString());
	}
	
	@Test
	void testToStringDifferentICode() {
		assertEquals("(Test Product, 987654, DVD, 1000)",test[2].toString());
	}
	
	@Test
	void testToStringDifferentType() {
		assertEquals("(Test Product, 123456, Book, 1000)",test[4].toString());
	}

	@Test
	void testToStringDifferentPrice() {
		assertEquals("(Test Product, 123456, DVD, 3000)",test[3].toString());
	}


	@Test
	void testName() {
		assertEquals("Test Product", test[0].getName());
	}
	
	@Test
	void testInventoryCode() {
		assertEquals("123456",test[0].getInventoryCode());
	}
	
	@Test
	void testPrice() {
		assertEquals(1000,test[0].getPrice());
	}
	
	@Test
	void testEqualsSame() {
		assertEquals(test[0],test[5]);
	}

	@Test
	void testNotEqualsName() {
		assertNotEquals(test[0],test[1]);
	}
	
	@Test
	void testNotEqualsICode() {
		assertNotEquals(test[0],test[2]);
	}
	
	@Test
	void testNotEqualsPrice() {
		assertNotEquals(test[0],test[3]);
	}
	
	@Test
	void testNotEqualsType() {
		assertNotEquals(test[0],test[4]);
	}
	
	@Test
	void testNotEqualsVsString() {
		assertNotEquals(test[0],"Test Product");
	}

	
	@Test
	void testHashCodeSameValue() {
		assertEquals(test[0].hashCode(),test[5].hashCode());
	}
	
	@Test
	void testHashCodeAtLeastOneDifferent() {
		int i = 1;
		boolean same = true;
		while (i < test.length-1 && same) {
			same = test[0].hashCode() == test[i].hashCode();
		}
		assertTrue(!same);
	}
}
