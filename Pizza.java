package application;

import java.util.ArrayList;

public abstract class Pizza {
	protected String style;
	protected String size;
	protected ArrayList<String> toppings;
	
	
	/**
	 * Constructs a Pizza
	 * 
	 * @param style, the pizza style as "Build your own" "Deluxe" or "Hawaiian"
	 * @param size, the size of the pizza as "Small" "Medium" or "Large"
	 * @param toppings, the list of toppings added to the pizza 
	 */
	public Pizza(String style, String size, ArrayList<String> toppings) {
		this.style = style;
		this.size = size;
		this.toppings = toppings;
	}
	
	/**
	 * Constructs a Pizza
	 * 
	 * @param style, the pizza style as "Build your own" "Deluxe" or "Hawaiian"
	 * @param size, the size of the pizza as "Small" "Medium" or "Large"
	 */
	public Pizza(String style, String size) {
		this.style = style;
		this.size = size;
	}
	
	public abstract int pizzaPrice();
	
	/**
	 * @return String, gives the pizza attributes
	 */
	public String toString() { 
		return size + " " + style + " with " + toppings.toString();
	}
}
