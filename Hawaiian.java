package application;

import java.util.ArrayList;

public class Hawaiian extends Pizza{
	final int PRICE_SMALL = 8;
	final int PRICE_MEDIUM = 10;
	final int PRICE_LARGE = 12;

	public Hawaiian(String style, String size, ArrayList<String> toppings) {
		super(style, size, toppings);
		// TODO Auto-generated constructor stub
	}
	
	public Hawaiian(String style, String size) {
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
