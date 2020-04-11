package application;

/**
 * A JUnit test class for the PizzaPrice method in BuildYourOwn
 * 
 * @author Nathan Ballance, Weihong Chen
 */

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
        
        //price for 2 toppings
        toppings.add("Sausage");
        assertEquals(b0.pizzaPrice(), 9);
        
        //price of the pizza with up till 6 toppings
        toppings.add("Ham");
        assertEquals(b0.pizzaPrice(), 11);
        toppings.add("Beef");
        assertEquals(b0.pizzaPrice(), 13);
        toppings.add("Onion");
        assertEquals(b0.pizzaPrice(), 15);
        toppings.add("Mushroom");
        assertEquals(b0.pizzaPrice(), 17);
        

        //Medium Build Your Own 
        ArrayList<String> toppings2 = new ArrayList<String>();
        BuildYourOwn b1 = new BuildYourOwn("Build Your Own", "Medium", toppings2);
        toppings2.add("Cheese");
        assertEquals(b1.pizzaPrice(), 9);
        
        //price for 2 toppings
        toppings2.add("Sausage");
        assertEquals(b1.pizzaPrice(), 11);
        
        //price of the pizza with up till 6 toppings
        toppings2.add("Ham");
        assertEquals(b1.pizzaPrice(), 13);
        toppings2.add("Beef");
        assertEquals(b1.pizzaPrice(), 15);
        toppings2.add("Onion");
        assertEquals(b1.pizzaPrice(), 17);
        toppings2.add("Mushroom");
        assertEquals(b1.pizzaPrice(), 19);

        
        
        //Large Build Your Own
        ArrayList<String> toppings3 = new ArrayList<String>();
        BuildYourOwn b2 = new BuildYourOwn("Build Your Own", "Large", toppings3);
        
        toppings3.add("Cheese");
        assertEquals(b2.pizzaPrice(), 11);
        
        //price for 2 toppings
        toppings3.add("Sausage");
        assertEquals(b2.pizzaPrice(), 13);
        
        //price of the pizza with up till 6 toppings
        toppings3.add("Ham");
        assertEquals(b2.pizzaPrice(), 15);
        toppings3.add("Beef");
        assertEquals(b2.pizzaPrice(), 17);
        toppings3.add("Onion");
        assertEquals(b2.pizzaPrice(), 19);
        toppings3.add("Mushroom");
        assertEquals(b2.pizzaPrice(), 21);
        
	}

}
