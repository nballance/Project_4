package application;
	
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.control.Button;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/application/Main.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Pizza Builder");
			
			
			StackPane layout = new StackPane();
			Button button = new Button();
			button.setText("Checkout");
			layout.getChildren().add(button);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
			Stage secondaryStage = new Stage();
			
			//Upon selection of "Place Order"
			
			button.setOnAction(new EventHandler<ActionEvent>(){
				public void handle(ActionEvent event) {
					
					Scene scene2 = new Scene(layout, 300,250);
					secondaryStage.setScene(scene2);
					scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
					secondaryStage.initModality(Modality.WINDOW_MODAL);;
					secondaryStage.setTitle("Checkout Order");
					secondaryStage.show();
				}
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
