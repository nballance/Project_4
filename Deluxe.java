package application;

import java.util.ArrayList;

public class Deluxe extends Pizza {
	final int PRICE_SMALL = 14;
	final int PRICE_MEDIUM = 16;
	final int PRICE_LARGE = 18;
	
	public Deluxe(String style, String size, ArrayList<String> toppings) {
		super(style, size, toppings);
		// TODO Auto-generated constructor stub
	}
	
	public Deluxe(String style, String size) {
		super(style, size);
		// TODO Auto-generated constructor stub
	}

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
	
	@Override
	public String toString() {
		return super.toString();
		//+ "costs $" + pizzaPrice();
	}

}
