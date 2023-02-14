package application;

import java.net.*; 
import java.util.ResourceBundle;

import history.data.SearchDynasties;
import history.data.SearchEvent;
import history.data.SearchFestival;
import history.data.SearchKing;
import history.data.SearchLocate;
import javafx.event.ActionEvent;
import javafx.fxml.*; 
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainController implements Initializable {
	
	SearchDynasties searchDynasties = new SearchDynasties();
	SearchKing searchKing = new SearchKing();
	SearchLocate searchLocate = new SearchLocate();
	SearchFestival searchFestival = new SearchFestival();
	SearchEvent searchEvent = new SearchEvent();
	
	
	@FXML
	private Pane searchPane;
	@FXML
	private VBox searchVBox;
	@FXML
	private TitledPane searchTitledPane;
	@FXML
	private TextArea searchTextArea;
	@FXML
	private TextArea textHello;
	@FXML
	private Button searchButton;
	@FXML
	private RadioButton searchItem1;
	@FXML
	private RadioButton searchItem2;
	@FXML
	private RadioButton searchItem3;
	@FXML
	private RadioButton searchItem4;
	@FXML
	private RadioButton searchItem5;
	
	private int item = 0;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	public void result (ActionEvent event)
	{
		
		if (item == 1) 
		{
			searchDynasties.input(searchTextArea.getText()); 
			String s = searchDynasties.print(searchTextArea.getText());
			textHello.setText(s); 
				
		}
		if (item == 2) //done
		{
			searchKing.input(searchTextArea.getText()); 
			String s = searchKing.print(searchTextArea.getText());
			textHello.setText(s); 
				
		}
		if (item == 3) 
		{
			searchLocate.input(searchTextArea.getText()); 
			String s = searchLocate.print(searchTextArea.getText());
			textHello.setText(s); 
				
		}
		if (item == 4)
		{
			searchFestival.input(searchTextArea.getText()); //nap du lieu 
			String s = searchFestival.print(searchTextArea.getText()); //lay van ban nguoi dung nhap vao
			textHello.setText(s); 
				
		}
		if (item == 5)
		{
			searchEvent.input(searchTextArea.getText()); //nap du lieu 
			String s = searchEvent.print(searchTextArea.getText()); //lay van ban nguoi dung nhap vao
			textHello.setText(s); 
				
		}
		
	}
	
	public int item1(ActionEvent event)
	{
		if(item == 0)
		{
			textHello.setText("Đã chọn Triều đại lịch sử");
			item = 1;
		}
		else if(item == 1)
		{
			textHello.setText(" ");
			item = 0;
		}
		return item;
	}
	public int item2(ActionEvent event)
	{
		if(item == 0)
		{
			textHello.setText("Đã chọn Nhân vật lịch sử");
			item = 2;
		}
		else if(item == 2)
		{
			textHello.setText(" ");
			item = 0;
		}
		return item;
	}
	public int item3(ActionEvent event)
	{
		if(item == 0)
		{
			textHello.setText("Đã chọn Di tích lịch sử");
			item = 3;
		}
		else if(item == 3)
		{
			textHello.setText(" ");
			item = 0;
		}
		return item;
	}
	public int item4(ActionEvent event)
	{
		if(item == 0)
		{
			textHello.setText("Đã chọn Lễ hội văn hóa");
			item = 4;
		}
		else if(item == 4)
		{
			textHello.setText(" ");
			item = 0;
		}
		return item;
		
	}
	public int item5(ActionEvent event)
	{
		if(item == 0)
		{
			textHello.setText("Đã chọn Sự kiện lịch sử");
			item = 5;
		}
		else if(item == 5)
		{
			textHello.setText(" ");
			item = 0;
		}
		return item;
	}
	
}