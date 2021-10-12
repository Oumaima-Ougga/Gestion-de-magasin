package partie.IHM;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeleteClientWindow {
	DeleteClientHandler handler = new DeleteClientHandler(this);
	Stage window=new Stage();
	VBox root=new VBox();
	Scene scene=new Scene(root);
	Label titleLabel=new Label("Supprimer un client");
	Button clientDeleteButton= new Button("SUPPRIMER");
	TextField clientDeleteTextField = new TextField();
	Label clientDeleteLabel = new Label(" Enter le code du client à supprimer : ");
	
	 private void addStylesToNodes() {
			scene.getStylesheets().add("css/application.css");
			titleLabel.getStyleClass().add("LabelTitle");
			clientDeleteLabel.getStyleClass().add("LabelForm");
			titleLabel.setMinWidth(window.getWidth());
			clientDeleteTextField.setMinWidth(700);
			root.setSpacing(15);
			
		}
	 private void addNodesToWindow() {
			root.getChildren().addAll(titleLabel,clientDeleteLabel,clientDeleteTextField,clientDeleteButton);
	   }
	 private void addEvents() {
		 clientDeleteButton.setOnAction(event->{
			  handler.deleteClick();
			  window.close();
		   });
	 }
		private void initWindow() {
			window.setWidth(1000);
			window.setHeight(650);
			window.setScene(scene);
			window.setTitle("Supprimer un client");
			window.getIcons().add(new Image("file:icon.PNG"));
		}
		public DeleteClientWindow() {
			   initWindow();
			   addNodesToWindow();
			   addStylesToNodes();
			   addEvents();
			   window.show();
		   }

}
