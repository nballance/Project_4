package application;

import java.util.ArrayList;

public class BuildYourOwn extends Pizza{

	final int MAX_NUM_TOPPINGS = 6;
	final int MIN_NUM_TOPPINGS = 1;
	
	final int PRICE_PER_TOPPING = 2;
	
	final int PRICE_SMALL = 5;
	final int PRICE_MEDIUM = 7;
	final int PRICE_LARGE = 9;
	
	/**
	 * Constructs a Build Your Own Pizza
	 * 
	 * @param style, the pizza style as "Build Your Own" 
	 * @param size, the size of the pizza as "Small" "Medium" or "Large"
	 * @param toppings, the list of toppings added to the pizza 
	 */
	public BuildYourOwn(String style, String size, ArrayList<String> toppings) {
		super(style, size, toppings);
	}
	
	/**
	 * Constructs a Build Your Own Pizza
	 * 
	 * @param style, the pizza style as "Build Your Own" 
	 * @param size, the size of the pizza as "Small" "Medium" or "Large"
	 */
	public BuildYourOwn(String style, String size) {
		super(style, size);
	}

	/**
	 * Gets the price of this pizza
	 * 
	 * @return int, the price of the pizza
	 */
	@Override
	public int pizzaPrice() {
		int total;
		int numToppings = toppings.size();
		
		if(this.size.equals("Small")) {
			total = numToppings * PRICE_PER_TOPPING;
			total += PRICE_SMALL;
			return total;
			
		}else if(this.size.equals("Medium")) {
			total = numToppings * PRICE_PER_TOPPING;
			total += PRICE_MEDIUM;
			return total;
			
		}else if(this.size.equals("Large")) {
			total = numToppings * PRICE_PER_TOPPING;
			total += PRICE_LARGE;
			return total;
		}
		//Error otherwise
		return -1;
	}
	
    /**
     * {@inheritDoc}
     */
	@Override
	public String toString() {
		return super.toString();
	}
	
}
