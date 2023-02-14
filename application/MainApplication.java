package application;
import javafx.application.Application;
import javafx.fxml.FXMLLoader; 
import javafx.scene.Parent; 
import javafx.scene.Scene; 
import javafx.stage.Stage;

public class MainApplication extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			// Đọc file fxml và vẽ giao diện.
			Parent root = FXMLLoader.load(getClass().getResource("/fxml/Main.fxml"));
			primaryStage.setTitle("Main Application");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
