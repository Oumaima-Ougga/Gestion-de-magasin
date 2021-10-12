package partie.IHM;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FormProduitWindow {
     ProduitAddHandler handler =new ProduitAddHandler(this);
    VBox root= new VBox();
    HBox  ButtonsBox= new HBox();
    Scene scene = new Scene(root);
    Stage window = new Stage();
    Label titleLabel= new Label("Nouveau Produit");
    //Label produitCodeLabel = new Label ("Code :");
	//TextField produitCodeTextField = new TextField();
    Label produitDesignationLabel = new Label ("Designation :");
    Label produitPrixAchatLabel = new Label ("Prix d'achat :");
    Label produitPrixVenteLabel = new Label ("Prix de vente :");
    Label produitCatégorieLabel = new Label ("Categorie :");
    TextField produitDesignationTextField = new TextField();
    TextField produitPrixAchatTextField = new TextField();
    TextField produitPrixVenteTextField = new TextField();
    TextField produitCategorieTextField = new TextField();
    
    Button produitAddButton= new Button("AJOUTER");
    Button produitCancelButton= new Button("ANNULER");
    
    private void initWindow() {
    	window.setScene(scene);
    	window.setWidth(800);
    	window.setHeight(600);
    	window.getIcons().add(new Image("file:icon.png"));
    	window.setTitle("Nouveau Produit");
    
    }
    
    private void addNodesToWindow() {
   
    	root.getChildren().add(titleLabel);
    	root.getChildren().addAll(produitDesignationLabel,produitDesignationTextField,produitPrixAchatLabel,produitPrixAchatTextField,produitPrixVenteLabel,produitPrixVenteTextField,produitCatégorieLabel,produitCategorieTextField);
    	ButtonsBox.getChildren().addAll(produitAddButton,produitCancelButton);
    	root.getChildren().add(ButtonsBox);   
    }
    
	private void addStylesNodes() {
		scene.getStylesheets().add("css/application.css");
		titleLabel.getStyleClass().add("LabelTitle");
		titleLabel.setMaxWidth(window.getWidth());
	//	produitCodeLabel.getStyleClass().add("LabelForm");
		produitDesignationLabel.getStyleClass().add("LabelForm");
		produitPrixAchatLabel.getStyleClass().add("LabelForm");
		produitPrixVenteLabel.getStyleClass().add("LabelForm");
		produitCatégorieLabel.getStyleClass().add("LabelForm");
		root.setSpacing(15);
		ButtonsBox.setSpacing(20);
	}
	
	private void AddEvents() {
		   produitCancelButton.setOnAction(event->{
			   window.close();
		   }
		   );
		   produitAddButton.setOnAction(event->{
			  handler.addClick();
			  window.close();
		   });
	       window.setOnCloseRequest(event->{
	    	   event.consume();
	       });
	}
	
    public FormProduitWindow() {
	initWindow();
	addStylesNodes();
	addNodesToWindow();
	window.initModality(Modality.APPLICATION_MODAL);
	AddEvents();
	
	window.show();
}

}
