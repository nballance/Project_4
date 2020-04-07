package application;

import java.io.IOException;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class SecondController {
	@FXML private Button goBack;
	@FXML private Button placeOrder;
	@FXML private Button clearOrder;

	@FXML private TextArea textTotal;
	@FXML private ListView<String> orderedPizza;
	@FXML private ListView<String> pizzaPrices;
	
	ObservableList<Pizza> pizzaList;
	boolean isCleared = false;
	int total = 0;
	
	public void changeSceneCheckoutButton(ActionEvent event) throws IOException {
		//Parent checkoutParent = FXMLLoader.load(getClass().getResource("Main.fxml"));
		//Scene checkoutScene = new Scene(checkoutParent);
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Main.fxml"));
		Parent checkoutParent = loader.load();
		
		Scene checkoutScene = new Scene(checkoutParent);
		
		MainController controller = loader.getController();
		controller.initData(getPizzaList());
		
		//Line gets stage info
		Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
		window.setScene(checkoutScene);
		window.show();
	}
	
	public void initData(ObservableList<Pizza> order){
		pizzaList = order;
		System.out.println("did we get here");
		if(order == null) {
			System.out.println("option 1");
			System.out.println("Buy some pizza before you checkout.");
			return;
		}
		System.out.println("option 2");
		
		for(Pizza s : order) {
			System.out.println("We added " + s.toString());
			orderedPizza.getItems().add(s.toString());
			pizzaPrices.getItems().add("$" + s.pizzaPrice());
			total += s.pizzaPrice();
		}
		
		textTotal.setText("Total: $" + total);
	}
	
	ObservableList<Pizza> getPizzaList(){
		if(!isCleared) {
			return pizzaList;
		}else {
			return null;
		}
	}

	
	public void clearOrderButton(ActionEvent event) {
		orderedPizza.getItems().clear();
		pizzaPrices.getItems().clear();
		textTotal.clear();
		textTotal.setText("Total: $0");
		isCleared = true;
	}
}
