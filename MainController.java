package application;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MainController {
	@FXML private TextArea result;
	
	@FXML private ComboBox<String> pizzaType;
	@FXML private ComboBox<String> size;
	
	@FXML private Button addToppings;
	@FXML private Button removeToppings;
	@FXML private Button addToOrder;
	@FXML private Button checkout;
	@FXML private Button clearSelection;
	
	@FXML private ListView<String> chooseToppings;
	@FXML private ListView<String> selectedToppings;
	
	@FXML private ImageView images;
	
	@FXML private Slider music;
	
	public ObservableList<Pizza> myOrder;
	final int MAX_TOPPINGS = 6;
	final int DELUXE_TOPPINGS = 5;
	final int HAWAIIAN_TOPPINGS = 2;
	
	
	/**
	 * Called when pizza is added to the order.
	 * Resets selections and selectedToppings list
	 */
	public void resetData() {
		selectedToppings.getItems().clear();
		pizzaType.getSelectionModel().selectFirst();
		size.getSelectionModel().select(1);	
		chooseToppings.getSelectionModel().clearSelection();
	}
	
	public void initialize() {
		myOrder = FXCollections.observableArrayList();
//		myOrder = new ArrayList<Pizza>();
		
		//Configure pizzaType ComboBox
		pizzaType.getItems().addAll(
				"Build your own",
				"Deluxe",
				"Hawaiian"
				
		);
		
		pizzaType.getSelectionModel().selectFirst();
		pizzaType.getSelectionModel().selectedItemProperty().addListener( (Observable, oldValue, newValue) -> 
				pizzaTypeChangeAction()
				);
		
		//Configure size ComboBox
		size.getItems().addAll(
				"Small",
				"Medium",
				"Large"
		);
		size.getSelectionModel().select(1);	
		
		//Configure toppings ListView
		chooseToppings.getItems().addAll("Cheese", "Beef", "Sausage", "Pepperoni","Chicken", "Ham", "Onion", "Green Pepper", "Mushroom", "Pineapple");
		chooseToppings.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		//Configure toppingsSelected ListView
		selectedToppings.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		displayImage();
		
	}
	
	public void displayImage() {
		File file;
		if(pizzaType.getValue().equals("Build your own")) {
			 file = new File("Resource_Images/Build_your_own.png");	
		}else if(pizzaType.getValue().equals("Deluxe")) {
			 file = new File("Resource_Images/Deluxe.png");	
		}else {
			//This will be Hawaiian
			 file = new File("Resource_Images/Hawaiian.png");
		}
		
		Image image = new Image(file.toURI().toString());
		//Image img = new Image(getClass().getResourceAsStream("Resource_Images/Build_your_own.png"));
		images.setImage(image);
	}
	
	/**
	 * If the pizzaType combobox value is changed the method is called 
	 * to check if toppings are changed or not
	 */
	public void pizzaTypeChangeAction() {
		//case 1: Build your own
		if(pizzaType.getValue().toString().equals("Build your own")) {
			displayImage();
		}
		//case 2: Deluxe
		else if(pizzaType.getValue().toString().equals("Deluxe")) {
			displayImage();
			selectedToppings.getItems().clear();
			selectedToppings.getItems().add("Sausage");
			selectedToppings.getItems().add("Pepperoni");
			selectedToppings.getItems().add("Green Pepper");
			selectedToppings.getItems().add("Onion");
			selectedToppings.getItems().add("Mushroom");
		}
		//case 3: Hawaiian
		else if(pizzaType.getValue().toString().equals("Hawaiian")) {
			displayImage();
			selectedToppings.getItems().clear();
			selectedToppings.getItems().add("Ham"); 
			selectedToppings.getItems().add("Pineapple"); 
		}
	}
	
	/**
	 * When this method is called, the scene will change 
	 * to the checkout menu
	 * @throws IOException 
	 */
	public void changeSceneCheckoutButton(ActionEvent event) throws IOException {
		//Parent checkoutParent = FXMLLoader.load(getClass().getResource("Second.fxml"));
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Second.fxml"));
		Parent checkoutParent = loader.load();
		
		Scene checkoutScene = new Scene(checkoutParent);
		
		SecondController controller = loader.getController();
		controller.initData(myOrder);
		
		//Line gets stage info
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(checkoutScene);
		window.show();
	}
	
	
	/**
	 * Method to check if a given pizza is valid
	 * @return true if the pizza is valid
	 */
	public boolean validPizzaSelection() {
		if(pizzaType.getValue().contentEquals("Build your own")) {
			if(selectedToppings.getItems().size() < 1) {
				return false;
			}
		}
		
//		if(pizzaType.getValue().contentEquals("--")) {
//			return false;
//		}
//		if(size.getValue().contentEquals("--")) {
//			return false;
//		}
		return true;
	}
	
	/**
	 * This method is called when adding or removing toppings
	 * to set the combo box correctly. If "Deluxe" or "Hawaiian" 
	 * pizzas have subbed/removed toppings they are assumed
	 * to be "Build your own"
	 */
	public void setComboBox() {
		if(selectedToppings.getItems().size() == DELUXE_TOPPINGS) {
			if(selectedToppings.getItems().contains("Sausage")&
			selectedToppings.getItems().contains("Pepperoni")&
			selectedToppings.getItems().contains("Green Pepper")&
			selectedToppings.getItems().contains("Onion")&
			selectedToppings.getItems().contains("Mushroom")) {
				pizzaType.getSelectionModel().select("Deluxe");
				return;		
			}
		}else if(selectedToppings.getItems().size() == HAWAIIAN_TOPPINGS) {
			if(selectedToppings.getItems().contains("Ham") & selectedToppings.getItems().contains("Pineapple")) {
				pizzaType.getSelectionModel().select("Hawaiian");
				return;
			}
		}
		
		pizzaType.getSelectionModel().select("Build your own");
	}
	
	/**
	 * When this method is called, the selected pizza type and size 
	 * will be added to the order. If invalid, error message displayed.
	 * @param event, Add to Order button is selected
	 */
	public void addToOrderButton(ActionEvent event) {
		result.setText("Add to Order button selected.");
		if(validPizzaSelection()) {
			Pizza myPizza = null;
		
			ArrayList<String> toppings = new ArrayList<String>(selectedToppings.getItems());
		
			String selectedType = pizzaType.getValue().toString();
			if(selectedType.equals("Deluxe")) {
				myPizza = new Deluxe("Deluxe", size.getValue().toString(), toppings);
				
			}else if(selectedType.equals("Hawaiian")) {
				myPizza = new Hawaiian("Hawaiian", size.getValue().toString(), toppings);

			}else if(selectedType.equals("Build your own")) {
				myPizza = new BuildYourOwn("Build your own", size.getValue().toString(), toppings);
			}
			result.setText(myPizza.toString());
			myOrder.add(myPizza);
			resetData();
		}else {
			result.setText("Need to select at least 1 topping for Build your own.");			
		}
	}
	
	/**
	 * When this method is called, the selected toppings in the chooseToppings listView
	 * will be added to the pizza
	 * @param event, Add Toppings button is selected
	 */
	public void addToppingsButton(ActionEvent event) {

		result.setText("Add Toppings Button clicked.");
		ObservableList<String> selected = chooseToppings.getSelectionModel().getSelectedItems();

        for(String s : selected){
        	if(selectedToppings.getItems().size() < MAX_TOPPINGS) {
        		if(!selectedToppings.getItems().contains(s)) {
                    selectedToppings.getItems().add(s);
            	}else {
            		result.setText("Duplicate item " + s);
            	}	
        	}else {
        		result.setText("Max toppings of 6 reached");
        		break;
        	}	
        }
        //Reset pizzaType ComboBox
        setComboBox();
	}
	
	/**
	 * When this method is called, the selected toppings in the selectedToppings listView 
	 * will be removed from the pizza
	 * @param event, Remove Toppings button is selected
	 */
	public void removeToppingsButton(ActionEvent event) {
		result.setText("Remove Toppings Button clicked.");
		ObservableList<String> selected = selectedToppings.getSelectionModel().getSelectedItems();
		
		
		//TODO removing multiple on selection only removes half for some reason.
        for(String s : selected){
        	selectedToppings.getItems().remove(s);
        }
	}
	
	/**
	 * When this method is called, all the toppings in selectedToppings listView
	 * will be removed from the pizza
	 * @param event, Clear Selection button is selected
	 */
	public void clearSelectionButton(ActionEvent event) {
		result.setText("Clear Toppings Button clicked.");
		selectedToppings.getItems().clear();
	}
	
	/**
	 * When called it will set the pizza order to the passed 
	 * value from SecondController
	 * @param order pizza list from SecondController
	 */
	public void initData(ObservableList<Pizza> order){
		System.out.println("initData for MainController.");
		if(order == null) {
			System.out.println("No pizzas selected.");
			return;
		}
		System.out.println("option 2 initData");
		myOrder = order;
//		for(Pizza s : order) {
//			myOrder = order;
//		}
	}
	
}
