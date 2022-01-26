package coffeemaker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import coffeemaker.exceptions.RecipeException;

class RecipeTest {
	
	private Recipe recipe;

	@BeforeEach
	void setUp() throws Exception {
		recipe = new Recipe();
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	
	// Chocolate tests

	@Test
	void testGetAmtChocolate() {
		assertEquals(0, recipe.getAmtChocolate());
	}

	@Test
	void testSetAmtChocolate() {
		try {
			recipe.setAmtChocolate("10");
		} catch (RecipeException e) {
			fail("Exception thrown");
		}
		assertEquals(10, recipe.getAmtChocolate());
	}
	
	@Test
	void testSetAmtChocolateZero() {
		try {
			recipe.setAmtChocolate("10");
			recipe.setAmtChocolate("0");
		} catch (RecipeException e) {
			fail("Exception thrown");
		}
		assertEquals(0, recipe.getAmtChocolate());
	}
	
	@Test
	void testSetAmtChocolateNegativeException() {
		assertThrows(RecipeException.class, () -> recipe.setAmtChocolate("-1"), "Units of chocolate must be a positive integer");
	}
	
	@Test
	void testSetAmtChocolateInvalidNumberException() {
		assertThrows(RecipeException.class, () -> recipe.setAmtChocolate("abc"), "Units of chocolate must be a positive integer");
	}

	
	// Coffee tests
	
	@Test
	void testGetAmtCoffee() {
		assertEquals(0, recipe.getAmtCoffee());
	}
	
	@Test
	void testSetAmtCoffee() {
		try {
			recipe.setAmtCoffee("10");
		} catch (RecipeException e) {
			fail("Exception thrown");
		}
		assertEquals(10, recipe.getAmtCoffee());
	}
	
	@Test
	void testSetAmtCoffeeZero() {
		try {
			recipe.setAmtCoffee("10");
			recipe.setAmtCoffee("0");
		} catch (RecipeException e) {
			fail("Exception thrown");
		}
		assertEquals(0, recipe.getAmtCoffee());
	}
	
	@Test
	void testSetAmtCoffeeNegativeException() {
		assertThrows(RecipeException.class, () -> recipe.setAmtCoffee("-1"), "Units of coffee must be a positive integer");
	}
	
	@Test
	void testSetAmtCoffeeInvalidNumberException() {
		assertThrows(RecipeException.class, () -> recipe.setAmtCoffee("abc"), "Units of coffee must be a positive integer");
	}
	
	
	// Milk tests
	
	@Test
	void testGetAmtMilk() {
		assertEquals(0, recipe.getAmtMilk());
	}
	
	@Test
	void testSetAmtMilk() {
		try {
			recipe.setAmtMilk("10");
		} catch (RecipeException e) {
			fail("Exception thrown");
		}
		assertEquals(10, recipe.getAmtMilk());
	}
	
	@Test
	void testSetAmtMilkZero() {
		try {
			recipe.setAmtMilk("10");
			recipe.setAmtMilk("0");
		} catch (RecipeException e) {
			fail("Exception thrown");
		}
		assertEquals(0, recipe.getAmtMilk());
	}
	
	@Test
	void testSetAmtMilkNegativeException() {
		assertThrows(RecipeException.class, () -> recipe.setAmtMilk("-1"), "Units of milk must be a positive integer");
	}
	
	@Test
	void testSetAmtMilkInvalidNumberException() {
		assertThrows(RecipeException.class, () -> recipe.setAmtMilk("abc"), "Units of milk must be a positive integer");
	}
	
	
	// Sugar tests
	
	@Test
	void testGetAmtSugar() {
		assertEquals(0, recipe.getAmtSugar());
	}
	
	@Test
	void testSetAmtSugar() {
		try {
			recipe.setAmtSugar("10");
		} catch (RecipeException e) {
			fail("Exception thrown");
		}
		assertEquals(10, recipe.getAmtSugar());
	}
	
	@Test
	void testSetAmtSugarZero() {
		try {
			recipe.setAmtSugar("10");
			recipe.setAmtSugar("0");
		} catch (RecipeException e) {
			fail("Exception thrown");
		}
		assertEquals(0, recipe.getAmtSugar());
	}
	
	@Test
	void testSetAmtSugarNegativeException() {
		assertThrows(RecipeException.class, () -> recipe.setAmtSugar("-1"), "Units of sugar must be a positive integer");
	}
	
	@Test
	void testSetAmtSugarInvalidNumberException() {
		assertThrows(RecipeException.class, () -> recipe.setAmtSugar("abc"), "Units of sugar must be a positive integer");
	}
	
	
	// Name tests
	
	@Test
	void testGetName() {
		assertNull(recipe.getName());
	}
	
	@Test
	void testSetName() {
		recipe.setName("abc");
		assertEquals("abc", recipe.getName());
	}
	
	@Test
	void testSetNameNull() {
		recipe.setName("abc");
		recipe.setName(null);
		assertEquals("abc", recipe.getName());
	}
	
	
	// Price tests
	
	@Test
	void testGetAmtPrice() {
		assertEquals(0, recipe.getPrice());
	}
	
	@Test
	void testSetAmtPrice() {
		try {
			recipe.setPrice("10");
		} catch (RecipeException e) {
			fail("Exception thrown");
		}
		assertEquals(10, recipe.getPrice());
	}
	
	@Test
	void testSetAmtPriceZero() {
		try {
			recipe.setPrice("10");
			recipe.setPrice("0");
		} catch (RecipeException e) {
			fail("Exception thrown");
		}
		assertEquals(0, recipe.getPrice());
	}
	
	@Test
	void testSetAmtPriceNegativeException() {
		assertThrows(RecipeException.class, () -> recipe.setPrice("-1"), "Price must be a positive integer");
	}
	
	@Test
	void testSetAmtPriceInvalidNumberException() {
		assertThrows(RecipeException.class, () -> recipe.setPrice("abc"), "Price must be a positive integer");
	}
	
	
	// Other tests
	
	@Test
	void testToString() {
		recipe.setName("abc");
		assertEquals("abc", recipe.toString());
	}
	
	@Test
	void testHashCodeNullName() {
		assertEquals(31, recipe.hashCode());
	}
	
	@Test
	void testHashCode() {
		recipe.setName("abc");
		assertEquals(96385, recipe.hashCode());
	}
	
	@Test
	void testEqualsSameObject() {
		assertTrue(recipe.equals(recipe));
	}
	
	@Test
	void testNotEqualsNull() {
		assertFalse(recipe.equals(null));
	}
	
	@Test
	void testNotEqualsDifferentType() {
		assertFalse(recipe.equals("abc"));
	}
	
	@Test
	void testNotEqualsDifferentName() {
		Recipe other = new Recipe();
		other.setName("abc");
		recipe.setName("xyz");
		assertFalse(recipe.equals(other));
	}
	
	@Test
	void testNotEqualsNullName() {
		Recipe other = new Recipe();
		other.setName("abc");
		assertFalse(recipe.equals(other));
	}
	
	@Test
	void testEqualsBothNullNames() {
		Recipe other = new Recipe();
		assertTrue(recipe.equals(other));
	}
	
	@Test
	void testEqualsSameName() {
		Recipe other = new Recipe();
		other.setName("abc");
		recipe.setName("abc");
		assertTrue(recipe.equals(other));
	}

}
