package application;

import java.util.ArrayList;

public class BuildYourOwn extends Pizza{

	final int MAX_NUM_TOPPINGS = 6;
	final int MIN_NUM_TOPPINGS = 1;
	
	public BuildYourOwn(String style, String size, ArrayList<String> toppings) {
		super(style, size, toppings);
		// TODO Auto-generated constructor stub
	}
	
	public BuildYourOwn(String style, String size) {
		super(style, size);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int pizzaPrice() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	public String toString() {
		return "";
	}
	
}
