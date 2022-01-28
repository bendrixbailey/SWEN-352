package coffeemaker;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RecipeBookTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	//Getting a recipe
	
	@Test
	void testGetRecipes() {
		RecipeBook recipeBook = new RecipeBook();
		assertEquals(4,recipeBook.getRecipes().length);
	}
	
	//Adding a recipe

	@Test
	void testAddRecipe() {
		RecipeBook recipeBook = new RecipeBook();
		Recipe r = new Recipe();
		r.setName("Test");
		assertTrue(recipeBook.addRecipe(r));
	}
	
	@Test
	void testAddRecipeExisting() {
		RecipeBook recipeBook = new RecipeBook();
		Recipe r = new Recipe();
		r.setName("Test");
		recipeBook.addRecipe(r);
		assertFalse(recipeBook.addRecipe(r));
	}
	
	@Test
	void testAddRecipeMoreThanFour() {
		RecipeBook recipeBook = new RecipeBook();
		Recipe r = new Recipe();
		r.setName("1");
		recipeBook.addRecipe(r);
		r.setName("2");
		recipeBook.addRecipe(r);
		r.setName("3");
		recipeBook.addRecipe(r);
		r.setName("4");
		recipeBook.addRecipe(r);
		r.setName("5");
		assertFalse(recipeBook.addRecipe(r));
	}

	//Deleting a recipe
	
	@Test
	void testDeleteRecipe() {
		RecipeBook recipeBook = new RecipeBook();
		Recipe r = new Recipe();
		r.setName("Test");
		recipeBook.addRecipe(r);
		assertEquals(r.getName(), recipeBook.deleteRecipe(0));
	}
	
	@Test
	void testDeleteRecipeEmpty() {
		RecipeBook recipeBook = new RecipeBook();
		assertNull(recipeBook.deleteRecipe(0));
	}
	
	@Test
	void testDeleteRecipeNegative() {
		RecipeBook recipeBook = new RecipeBook();
		try {
			assertNull(recipeBook.deleteRecipe(-1));
		}catch(Exception e) {
			fail("Exception Thrown");
		}
	}
	
	@Test
	void testDeleteRecipeGreaterThanArray() {
		RecipeBook recipeBook = new RecipeBook();
		try {
			assertNull(recipeBook.deleteRecipe(10));
		}catch(Exception e) {
			fail("Exception Thrown");
		}
	}

	//Editing a recipe
	
	@Test
	void testEditRecipe() {
		RecipeBook recipeBook = new RecipeBook();
		Recipe r = new Recipe();
		r.setName("Test");
		try {
			r.setAmtChocolate("4");
			recipeBook.addRecipe(r);
			r.setAmtChocolate("14");
			assertEquals(r.getName(), recipeBook.editRecipe(0, r));
		}catch(Exception e) {
			fail("Exception Thrown");
		}
	}
	
	@Test
	void testEditRecipeNonExisting() {
		RecipeBook recipeBook = new RecipeBook();
		Recipe r = new Recipe();
		r.setName("Test");
		try {
			r.setAmtChocolate("4");
			recipeBook.addRecipe(r);
			r.setAmtChocolate("14");
			assertNull(recipeBook.editRecipe(2, r));
		}catch(Exception e) {
			fail("Exception Thrown");
		}
	}
	
	@Test
	void testEditRecipeNegativePlace() {
		RecipeBook recipeBook = new RecipeBook();
		Recipe r = new Recipe();
		r.setName("Test");
		try {
			r.setAmtChocolate("4");
			recipeBook.addRecipe(r);
			r.setAmtChocolate("14");
			assertNull(recipeBook.editRecipe(-1, r));
		}catch(Exception e) {
			fail("Exception Thrown");
		}
	}
	
	@Test
	void testEditRecipeGreaterThanArray() {
		RecipeBook recipeBook = new RecipeBook();
		Recipe r = new Recipe();
		r.setName("Test");
		try {
			r.setAmtChocolate("4");
			recipeBook.addRecipe(r);
			r.setAmtChocolate("14");
			assertNull(recipeBook.editRecipe(20, r));
		}catch(Exception e) {
			fail("Exception Thrown");
		}
	}

}
