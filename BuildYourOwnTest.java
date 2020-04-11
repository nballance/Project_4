package application;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class BuildYourOwnTest {

	@Test
	public void testPizzaPrice() {
		
		//Small Build Your Own
		ArrayList<String> toppings = new ArrayList<String>();
		toppings.add("Cheese");
		BuildYourOwn b0 = new BuildYourOwn("Build Your Own", "Small", toppings);
		assertEquals(b0.pizzaPrice(), 7);
		toppings.add("Sausage");
		assertEquals(b0.pizzaPrice(), 9);
		toppings.add("Ham");
		assertEquals(b0.pizzaPrice(), 11);
		//6 toppings
		toppings.add("");

		//Medium
		
		//Large
		
		
		//fail("Not yet implemented");
	}

}
