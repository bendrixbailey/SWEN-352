package coffeemaker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import coffeemaker.exceptions.InventoryException;

class InventoryTest {
	
	private Inventory inventory;
	private Recipe testRecipe;

	@BeforeEach
	void setUp() throws Exception {
		inventory = new Inventory();
		testRecipe = new Recipe();
		testRecipe.setAmtChocolate("5");
		testRecipe.setAmtMilk("5");
		testRecipe.setAmtSugar("5");
		testRecipe.setAmtCoffee("5");
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
	void testSetChocolateZero() {
		inventory.setChocolate(0);
		assertEquals(0, inventory.getChocolate());
		inventory.setChocolate(15);
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
	void testAddChocolateZero() {
		try {
			inventory.addChocolate("0");
			assertEquals(15, inventory.getChocolate());
		}catch(InventoryException e) {
			fail("Exception Thrown");
		}
	}
	
	@Test
	void testAddChocolateNegativeNumber() {
		assertThrows(InventoryException.class, () -> inventory.addChocolate("-1"), "Units of chocolate must be a positive integer");
	}
	
	@Test
	void testAddChocolateNull() {
		assertThrows(InventoryException.class, () -> inventory.addChocolate(null), "Units of chocolate must be a positive integer");
	}
	
	@Test
	void testAddChocolateInvalidString() {
		assertThrows(InventoryException.class, () -> inventory.addChocolate("test"), "Units of chocolate must be a positive integer");
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
	void testSetCoffeeZero() {
		inventory.setCoffee(0);
		assertEquals(0, inventory.getCoffee());
		inventory.setCoffee(15);
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
	void testAddCoffeeZero() {
		try {
			inventory.addCoffee("0");
			assertEquals(15, inventory.getCoffee());
		}catch(InventoryException e) {
			fail("Exception Thrown");
		}
	}
	
	@Test
	void testAddCoffeeNegativeNumber() {
		assertThrows(InventoryException.class, () -> inventory.addCoffee("-1"), "Units of coffee must be a positive integer");
	}
	
	@Test
	void testAddCoffeeNull() {
		assertThrows(InventoryException.class, () -> inventory.addCoffee(null), "Units of coffee must be a positive integer");
	}
	
	@Test
	void testAddCoffeeInvalidString() {
		assertThrows(InventoryException.class, () -> inventory.addCoffee("test"), "Units of coffee must be a positive integer");
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
	void testSetMilkZero() {
		inventory.setMilk(0);
		assertEquals(0, inventory.getMilk());
		inventory.setMilk(15);
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
	void testAddMilkZero() {
		try {
			inventory.addMilk("0");
			assertEquals(15, inventory.getMilk());
		}catch(InventoryException e) {
			fail("Exception Thrown");
		}
	}
	
	@Test
	void testAddMilkNegativeNumber() {
		assertThrows(InventoryException.class, () -> inventory.addMilk("-1"), "Units of milk must be a positive integer");
	}
	
	@Test
	void testAddMilkNull() {
		assertThrows(InventoryException.class, () -> inventory.addMilk(null), "Units of milk must be a positive integer");
	}
	
	@Test
	void testAddMilkInvalidString() {
		assertThrows(InventoryException.class, () -> inventory.addMilk("test"), "Units of milk must be a positive integer");
	}

	
	//Sugar Tests
	@Test
	void testGetSugar() {
		assertEquals(15, inventory.getSugar());
	}

	@Test
	void testSetSugar() {
		inventory.setSugar(17);
		assertEquals(17, inventory.getSugar());
		//reset sugar
		inventory.setSugar(15);
	}
	
	
	@Test
	void testSetSugarNegative() {
		inventory.setSugar(-5);
		assertEquals(15, inventory.getSugar());
	}
	
	@Test
	void testSetSugarZero() {
		inventory.setSugar(0);
		assertEquals(0, inventory.getSugar());
		inventory.setSugar(15);
	}

	@Test
	void testAddSugarWorking() {
		try {
			inventory.addSugar("5");
			assertEquals(20, inventory.getSugar());
		}catch(InventoryException e) {
			fail("Exception Thrown");
		}
		//reset chocolate to 15
		inventory.setSugar(15); 
	} 
	
	@Test
	void testAddSugarZero() {
		try {
			inventory.addSugar("0");
			assertEquals(15, inventory.getSugar());
		}catch(InventoryException e) {
			fail("Exception Thrown");
		}
	}
	
	@Test
	void testAddSugarNegativeNumber() {
		assertThrows(InventoryException.class, () -> inventory.addSugar("-1"), "Units of sugar must be a positive integer");
	}
	
	@Test
	void testAddSugarNull() {
		assertThrows(InventoryException.class, () -> inventory.addSugar(null), "Units of sugar must be a positive integer");
	}
	
	@Test
	void testAddSugarInvalidString() {
		assertThrows(InventoryException.class, () -> inventory.addSugar("test"), "Units of sugar must be a positive integer");
	}

	
	//Ingredient testing
	@Test
	void testEnoughIngredients() {
		assertEquals(true, inventory.enoughIngredients(testRecipe));
	}
	
	@Test
	void testNotEnoughIngredientsChocolate() {
		inventory.setChocolate(3);
		assertEquals(false, inventory.enoughIngredients(testRecipe));
		inventory.setChocolate(15);
	}
	
	@Test
	void testNotEnoughIngredientsCoffee() {
		inventory.setCoffee(3);
		assertEquals(false, inventory.enoughIngredients(testRecipe));
		inventory.setCoffee(15);
	}
	
	@Test
	void testNotEnoughIngredientsMilk() {
		inventory.setMilk(3);
		assertEquals(false, inventory.enoughIngredients(testRecipe));
		inventory.setMilk(15);
	}
	
	@Test
	void testNotEnoughIngredientsSugar() {
		inventory.setSugar(3);
		assertEquals(false, inventory.enoughIngredients(testRecipe));
		inventory.setSugar(15);
	}
	
	@Test
	void testNotEnoughIngredientsAll() {
		inventory.setChocolate(3);
		inventory.setCoffee(3);
		inventory.setMilk(3);
		inventory.setSugar(3);
		assertEquals(false, inventory.enoughIngredients(testRecipe));
		inventory.setChocolate(15);
		inventory.setCoffee(15);
		inventory.setMilk(15);
		inventory.setSugar(15);
	}
	
	@Test
	void testEnoughIngredientsEmptyRecipe() {
		Recipe testRecipe = new Recipe();
		assertEquals(true, inventory.enoughIngredients(testRecipe));
	}
	
	
	
	//ingredient use testing

	@Test
	void testUseIngredientsEnough() {
		assertEquals(true, inventory.useIngredients(testRecipe));
		assertEquals(10, inventory.getChocolate());
		assertEquals(10, inventory.getCoffee());
		assertEquals(10, inventory.getMilk());
		assertEquals(10, inventory.getSugar()); 
	}
	
	@Test
	void testUseIngredientsNotEnoughCoffee() {
		inventory.setCoffee(3);
		inventory.setChocolate(15);
		inventory.setMilk(15);
		inventory.setSugar(15);
		assertEquals(false, inventory.useIngredients(testRecipe));
		assertEquals(15, inventory.getChocolate());	//make sure amounts havent changed if recipe isnt used
		assertEquals(3, inventory.getCoffee());
		assertEquals(15, inventory.getMilk());
		assertEquals(15, inventory.getSugar());
		inventory.setCoffee(15);
	}
	
	@Test
	void testUseIngredientsNotEnoughChocolate() {
		inventory.setChocolate(3);
		inventory.setCoffee(15);
		inventory.setMilk(15);
		inventory.setSugar(15);
		assertEquals(false, inventory.useIngredients(testRecipe));
		assertEquals(3, inventory.getChocolate());	//make sure amounts havent changed if recipe isnt used
		assertEquals(15, inventory.getCoffee());
		assertEquals(15, inventory.getMilk());
		assertEquals(15, inventory.getSugar());
		inventory.setChocolate(15);
	}
	
	@Test
	void testUseIngredientsNotEnoughMilk() {
		inventory.setChocolate(15);
		inventory.setCoffee(15);
		inventory.setMilk(3);
		inventory.setSugar(15);
		assertEquals(false, inventory.useIngredients(testRecipe));
		assertEquals(15, inventory.getChocolate());	//make sure amounts havent changed if recipe isnt used
		assertEquals(15, inventory.getCoffee());
		assertEquals(3, inventory.getMilk());
		assertEquals(15, inventory.getSugar());
		inventory.setMilk(15);
	}
	
	@Test
	void testUseIngredientsNotEnoughSugar() {
		inventory.setChocolate(15);
		inventory.setCoffee(15);
		inventory.setMilk(15);
		inventory.setSugar(3);
		assertEquals(false, inventory.useIngredients(testRecipe));
		assertEquals(15, inventory.getChocolate());	//make sure amounts havent changed if recipe isnt used
		assertEquals(15, inventory.getCoffee());
		assertEquals(15, inventory.getMilk());
		assertEquals(3, inventory.getSugar());
		inventory.setSugar(15);
	}
	
	@Test
	void testUseIngredientsNotEnoughAnything() {
		inventory.setChocolate(3);
		inventory.setCoffee(3);
		inventory.setMilk(3);
		inventory.setSugar(3);
		assertEquals(false, inventory.useIngredients(testRecipe));
		assertEquals(3, inventory.getChocolate());
		assertEquals(3, inventory.getCoffee());
		assertEquals(3, inventory.getMilk());
		assertEquals(3, inventory.getSugar());
		//reset back to normal amt of ingredients
		inventory.setChocolate(15);
		inventory.setCoffee(15);
		inventory.setMilk(15);
		inventory.setSugar(15);
	}
	

	@Test
	void testToString() {
		StringBuffer testBuf = new StringBuffer();
		testBuf.append("Coffee: ");
		testBuf.append(15);
		testBuf.append("\n");
		testBuf.append("Milk: ");
		testBuf.append(15);
		testBuf.append("\n");
		testBuf.append("Sugar: ");
		testBuf.append(15);
		testBuf.append("\n");
		testBuf.append("Chocolate: ");
		testBuf.append(15);
		testBuf.append("\n");
		assertEquals(testBuf.toString(), inventory.toString());
	}

}
