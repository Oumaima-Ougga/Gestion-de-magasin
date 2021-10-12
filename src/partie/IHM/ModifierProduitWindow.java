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

public class ModifierProduitWindow {
	ProduitModifierHandler handler =new ProduitModifierHandler(this);
	Stage window=new Stage();
	VBox root=new VBox();
	HBox  ButtonsBox= new HBox();
	Scene scene=new Scene(root);
	Label titleLabel=new Label("Modifier un produit");
	 Label produitCodeLabel = new Label ("Code :");
	 TextField produitCodeTextField = new TextField();
	 Label produitDesignationLabel = new Label ("Designation :");
	    Label produitPrixAchatLabel = new Label ("Prix d'achat :");
	    Label produitPrixVenteLabel = new Label ("Prix de vente :");
	    Label produitCatégorieLabel = new Label ("Categorie :");
	    TextField produitDesignationTextField = new TextField();
	    TextField produitPrixAchatTextField = new TextField();
	    TextField produitPrixVenteTextField = new TextField();
	    TextField produitCategorieTextField = new TextField();  
    Button produitModifierButton= new Button("MODIFIER");
    Button produitCancelButton= new Button("ANNULER");
	
    private void addNodesToWindow() {
    	
    	root.getChildren().add(titleLabel);
    	root.getChildren().addAll(produitCodeLabel,produitCodeTextField,produitDesignationLabel,produitDesignationTextField,produitPrixAchatLabel,produitPrixAchatTextField,produitPrixVenteLabel,produitPrixVenteTextField,produitCatégorieLabel,produitCategorieTextField);
    	ButtonsBox.getChildren().addAll(produitModifierButton,produitCancelButton);
    	root.getChildren().add(ButtonsBox);   
    }
    
	 private void addStylesToNodes() {
			scene.getStylesheets().add("css/application.css");
			titleLabel.getStyleClass().add("LabelTitle");
			scene.getStylesheets().add("css/application.css");
			titleLabel.getStyleClass().add("LabelTitle");
			//Largeur 
			titleLabel.setMaxWidth(window.getWidth());
			produitDesignationLabel.getStyleClass().add("LabelForm");
			produitPrixAchatLabel.getStyleClass().add("LabelForm");
			produitPrixVenteLabel.getStyleClass().add("LabelForm");
			produitCatégorieLabel.getStyleClass().add("LabelForm");
			produitCodeLabel.getStyleClass().add("LabelForm");
			root.setSpacing(15);
			ButtonsBox.setSpacing(20);
		}

		private void AddEvents() {
			   produitCancelButton.setOnAction(event->{
				   window.close();
			   }
			   );
			   produitModifierButton.setOnAction(event->{
				  handler.updateClick();
				  new FormListProduitWindow();
				  window.close();
			   });
		       window.setOnCloseRequest(event->{
		    	   event.consume();
		       });
		}
	private void initWindow() {
		window.setWidth(1000);
		window.setHeight(650);
		window.setScene(scene);
		window.setTitle("Modifier un produit");
		window.getIcons().add(new Image("file:icon.PNG"));
	}
	public ModifierProduitWindow() {
		initWindow();
		addStylesToNodes();
		addNodesToWindow();
		window.initModality(Modality.APPLICATION_MODAL);
		AddEvents();
		
		window.show();
	   }
}
