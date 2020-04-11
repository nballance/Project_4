package application;

import java.util.ArrayList;

public class Deluxe extends Pizza {
	final int PRICE_SMALL = 14;
	final int PRICE_MEDIUM = 16;
	final int PRICE_LARGE = 18;
	
	/**
	 * Constructs a Deluxe Pizza
	 * 
	 * @param style, the pizza style as "Deluxe" 
	 * @param size, the size of the pizza as "Small" "Medium" or "Large"
	 * @param toppings, the list of toppings added to the pizza 
	 */
	public Deluxe(String style, String size, ArrayList<String> toppings) {
		super(style, size, toppings);
	}
	
	/**
	 * Constructs a Deluxe Pizza
	 * 
	 * @param style, the pizza style as "Deluxe" 
	 * @param size, the size of the pizza as "Small" "Medium" or "Large"
	 */
	public Deluxe(String style, String size) {
		super(style, size);
	}

	/**
	 * Gets the price of this pizza
	 * 
	 * @return int, the price of the pizza
	 */
	@Override
	public int pizzaPrice() {
		if(this.size.equals("Small")) {
			return PRICE_SMALL;
		}else if(this.size.equals("Medium")) {
			return PRICE_MEDIUM;
		}else if(this.size.equals("Large")) {
			return PRICE_LARGE;
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
