module History {
	requires javafx.controls;
	requires javafx.fxml;
	requires json.simple;
	
	opens application to javafx.graphics, javafx.fxml, java.awt;
}
