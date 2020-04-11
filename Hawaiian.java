package application;

import java.util.ArrayList;

public class Hawaiian extends Pizza{
	final int PRICE_SMALL = 8;
	final int PRICE_MEDIUM = 10;
	final int PRICE_LARGE = 12;

	/**
	 * Constructs a Hawaiian Pizza
	 * 
	 * @param style, the pizza style as "Hawaiian" 
	 * @param size, the size of the pizza as "Small" "Medium" or "Large"
	 * @param toppings, the list of toppings added to the pizza 
	 */
	public Hawaiian(String style, String size, ArrayList<String> toppings) {
		super(style, size, toppings);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Constructs a Hawaiian Pizza
	 * 
	 * @param style, the pizza style as "Hawaiian" 
	 * @param size, the size of the pizza as "Small" "Medium" or "Large"
	 */
	public Hawaiian(String style, String size) {
		super(style, size);
		// TODO Auto-generated constructor stub
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
