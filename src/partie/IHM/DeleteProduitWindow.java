package partie.IHM;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DeleteProduitWindow {
	ProduitDeleteHandler handler =new ProduitDeleteHandler(this);
	Stage window=new Stage();
	VBox root=new VBox();
	Scene scene=new Scene(root);
	Label titleLabel=new Label("Supprimer un produit");
	Button produitDeleteButton= new Button("SUPPRIMER");
	TextField produitDeleteTextField = new TextField();
	Label produitDeleteLabel = new Label(" Enter le code du produit à supprimer : ");
	
	 private void addStylesToNodes() {
			scene.getStylesheets().add("css/application.css");
			titleLabel.getStyleClass().add("LabelTitle");
			produitDeleteLabel.getStyleClass().add("LabelForm");
			titleLabel.setMinWidth(window.getWidth());
			produitDeleteTextField.setMinWidth(700);
			root.setSpacing(15);
			
		}
	 private void addNodesToWindow() {
			root.getChildren().addAll(titleLabel,produitDeleteLabel,produitDeleteTextField,produitDeleteButton);
	   }
	 private void addEvents() {
		 produitDeleteButton.setOnAction(event->{
			   //DAO
			  handler.deleteClick();
			  window.close();
		   });
	 }
	private void initWindow() {
		window.setWidth(1000);
		window.setHeight(650);
		window.setScene(scene);
		window.setTitle("Supprimer un produit");
		window.getIcons().add(new Image("file:icon.PNG"));
	}
	public DeleteProduitWindow() {
		   initWindow();
		   addNodesToWindow();
		   addStylesToNodes();
		   addEvents();
		   window.show();
	   }

}
