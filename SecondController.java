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
	@FXML
	private Button goBack;
	@FXML
	private Button placeOrder;
	@FXML
	private Button clearOrder;
	@FXML
	private Button removeSelectedPizza;

	@FXML
	private TextArea textTotal;
	@FXML
	private ListView<String> orderedPizza;
	@FXML
	private ListView<String> pizzaPrices;

	ObservableList<Pizza> pizzaList;
	boolean isCleared = false;
	int total = 0;

	/**
	 * Makes the view go back to the pizza selection window
	 * 
	 * @param event when the "Go Back" Button is selected
	 * @throws IOException
	 */
	public void changeSceneCheckoutButton(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Main.fxml"));
		Parent checkoutParent = loader.load();

		Scene checkoutScene = new Scene(checkoutParent);

		MainController controller = loader.getController();
		controller.initData(getPizzaList());

		// Line gets stage info
		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(checkoutScene);
		window.show();
	}

	/**
	 * Initialize the data which is passed from the first window
	 * 
	 * @param order, the list of Pizza objects passed into the new window
	 */
	public void initData(ObservableList<Pizza> order) {
		placeOrder.setDisable(false);

		pizzaList = order;
		if (order == null) {
			return;
		}

		if (order.size() == 0) {
			placeOrder.setDisable(true);
		}

		for (Pizza s : order) {
			orderedPizza.getItems().add(s.toString());
			pizzaPrices.getItems().add("$" + s.pizzaPrice());
			total += s.pizzaPrice();
		}

		textTotal.setText("Total: $" + total);
	}

	/**
	 * Method to get the list of Pizza Objects
	 * 
	 * @return pizzaList, the Pizza Object list
	 */
	ObservableList<Pizza> getPizzaList() {
		if (!isCleared) {
			return pizzaList;
		} else {
			return null;
		}
	}

	/**
	 * Clears the list of Pizza Objects
	 * 
	 * @param event, when the "Clear Order" Button is selected
	 */
	public void clearOrderButton(ActionEvent event) {
		orderedPizza.getItems().clear();
		pizzaPrices.getItems().clear();
		textTotal.clear();
		textTotal.setText("Total: $0");
		isCleared = true;
		placeOrder.setDisable(true);
	}

	public void getTotal() {

		ObservableList<String> orderedPizza = pizzaPrices.getItems();
		int total = 0;
		for (String s : orderedPizza) {
			String sub = s.substring(1);
			int val = Integer.parseInt(sub);
			total += val;
		}

		textTotal.setText("Total: $" + total);
	}

	/**
	 * Removes the selected Pizza when selecting in the orderedPizza ListView
	 * 
	 * @param event, when the "Remove Selected Pizza" Button is clicked
	 */
	public void removeSelectedPizzaButton(ActionEvent event) {

		if (orderedPizza.getSelectionModel().getSelectedItems().size() == 0) {
			return;
		}
		int index = orderedPizza.getSelectionModel().getSelectedIndex();

		orderedPizza.getItems().remove(index);
		if (orderedPizza.getItems().size() == 0) {
			placeOrder.setDisable(true);
		}

		pizzaPrices.getItems().remove(index);

		pizzaList.remove(index);
		getTotal();

	}

	/**
	 * Exists the program when the order is selected, no implementation of payment
	 * method
	 * 
	 * @param event, when the "Place Order" Button is selected
	 */
	public void placeOrderButton(ActionEvent event) {
		System.exit(0);
	}
}
