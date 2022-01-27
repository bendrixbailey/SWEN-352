package coffeemaker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import coffeemaker.exceptions.InventoryException;
import coffeemaker.exceptions.RecipeException;

class InventoryTest {
	
	private Inventory inventory;

	@BeforeEach
	void setUp() throws Exception {
		inventory = new Inventory();
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testInventory() {
		assertNotEquals(null, inventory);
	}

	//Chocolate Tests
	@Test
	void testGetChocolate() {
		assertEquals(15, inventory.getChocolate());
	}

	@Test
	void testSetChocolate() {
		inventory.setChocolate(17);
		assertEquals(17, inventory.getChocolate());
		//set chocolate back to 15
		inventory.setChocolate(15);
	}
	
	@Test
	void testSetChocolateNegative() {
		inventory.setChocolate(-5);
		assertEquals(15, inventory.getChocolate());
	}

	@Test
	void testAddChocolateWorking() {
		try {
			inventory.addChocolate("5");
			assertEquals(20, inventory.getChocolate());
		}catch(InventoryException e) {
			fail("Exception Thrown");
		}
		//reset chocolate to 15
		inventory.setChocolate(15);
	}
	
	@Test
	void testAddChocolateNegativeNumber() {
		assertThrows(RecipeException.class, () -> inventory.addChocolate("-1"), "Units of chocolate must be a positive integer");
	}
	
	@Test
	void testAddChocolateInvalidString() {
		assertThrows(RecipeException.class, () -> inventory.addChocolate("test"), "Units of chocolate must be a positive integer");
	}
	

	//Coffee tests
	@Test
	void testGetCoffee() {
		assertEquals(15, inventory.getCoffee());
	}

	@Test
	void testSetCoffee() {
		inventory.setCoffee(17);
		assertEquals(17, inventory.getCoffee());
		//reset to 15
		inventory.setCoffee(15);
	}
	
	@Test
	void testSetCoffeeNegative() {
		inventory.setCoffee(-5);
		assertEquals(15, inventory.getCoffee());
	}

	@Test
	void testAddCoffeeWorking() {
		try {
			inventory.addCoffee("5");
			assertEquals(20, inventory.getCoffee());
		}catch(InventoryException e) {
			fail("Exception Thrown");
		}
		//reset chocolate to 15
		inventory.setCoffee(15);
	}
	
	@Test
	void testAddCoffeeNegativeNumber() {
		assertThrows(RecipeException.class, () -> inventory.addCoffee("-1"), "Units of coffee must be a positive integer");
	}
	
	@Test
	void testAddCoffeeInvalidString() {
		assertThrows(RecipeException.class, () -> inventory.addCoffee("test"), "Units of coffee must be a positive integer");
	}

	
	//Milk Tests
	@Test
	void testGetMilk() {
		assertEquals(15, inventory.getMilk());
	}

	@Test
	void testSetMilk() {
		inventory.setMilk(17);
		assertEquals(17, inventory.getMilk());
		//reset to 15 milk
		inventory.setMilk(15);
	}
	
	@Test
	void testSetMilkNegative() {
		inventory.setMilk(-5);
		assertEquals(15, inventory.getMilk());
	}

	@Test
	void testAddMilkWorking() {
		try {
			inventory.addMilk("5");
			assertEquals(20, inventory.getMilk());
		}catch(InventoryException e) {
			fail("Exception Thrown");
		}
		//reset chocolate to 15
		inventory.setMilk(15);
	}
	
	@Test
	void testAddMilkNegativeNumber() {
		assertThrows(RecipeException.class, () -> inventory.addMilk("-1"), "Units of milk must be a positive integer");
	}
	
	@Test
	void testAddMilkInvalidString() {
		assertThrows(RecipeException.class, () -> inventory.addMilk("test"), "Units of milk must be a positive integer");
	}

	
	//Sugar Tests
	@Test
	void testGetSugar() {
		fail("Not yet implemented");
	}

	@Test
	void testSetSugar() {
		fail("Not yet implemented");
	}

	@Test
	void testAddSugar() {
		fail("Not yet implemented");
	}

	@Test
	void testEnoughIngredients() {
		fail("Not yet implemented");
	}

	@Test
	void testUseIngredients() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

}
