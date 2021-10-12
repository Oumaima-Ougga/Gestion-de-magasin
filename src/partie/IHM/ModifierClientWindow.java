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

public class ModifierClientWindow {
	ModifierClientHandler handler = new ModifierClientHandler(this);
	Stage window=new Stage();
	VBox root=new VBox();
	HBox  ButtonsBox= new HBox();
	Scene scene=new Scene(root);
	Label titleLabel=new Label("Modifier un client");
	 Label clientCodeLabel = new Label ("Code :");
    Label clientPrenomLabel = new Label ("Prenom :");
    Label clientNomLabel = new Label ("Nom :");
    Label clientTeleLabel = new Label ("Telephone :");
    Label clientEmailLabel = new Label ("E-mail :");
    Label clientAdresseLabel = new Label ("Adresse :");
    TextField clientCodeTextField = new TextField();
    TextField clientPrenomTextField = new TextField();
    TextField clientNomTextField = new TextField();
    TextField clientTelephoneTextField = new TextField();
    TextField clientEmailTextField = new TextField();
    TextField clientAdresseTextField = new TextField();
    
    
    Button clientModifierButton= new Button("MODIFIER");
    Button clientCancelButton= new Button("ANNULER");

    private void addNodesToWindow() {
    	root.getChildren().add(titleLabel);
    	root.getChildren().addAll(clientCodeLabel,clientCodeTextField,clientPrenomLabel,clientPrenomTextField,clientNomLabel,clientNomTextField,clientTeleLabel,clientTelephoneTextField,clientEmailLabel,clientEmailTextField,clientAdresseLabel,clientAdresseTextField);
    	ButtonsBox.getChildren().addAll(clientModifierButton,clientCancelButton);
    	root.getChildren().add(ButtonsBox);   
    }
    private void addStylesToNodes() {
		scene.getStylesheets().add("css/application.css");
		titleLabel.getStyleClass().add("LabelTitle");
		//Largeur 
		titleLabel.setMaxWidth(window.getWidth());
		clientTeleLabel.getStyleClass().add("LabelForm");
		clientEmailLabel.getStyleClass().add("LabelForm");
		clientAdresseLabel.getStyleClass().add("LabelForm");
		clientPrenomLabel.getStyleClass().add("LabelForm");
		clientNomLabel.getStyleClass().add("LabelForm");
		clientCodeLabel.getStyleClass().add("LabelForm");
		root.setSpacing(15);
		ButtonsBox.setSpacing(20);
	}
	private void initWindow() {
		window.setWidth(1000);
		window.setHeight(650);
		window.setScene(scene);
		window.setTitle("Modifier un client");
		window.getIcons().add(new Image("file:icon.PNG"));
	}
	private void AddEvents() {
		   clientCancelButton.setOnAction(event->{
			   window.close();
		   }
		   );
		   clientModifierButton.setOnAction(event->{
						  handler.updateClick();
						  new ListeClientWindow();
						  window.close();
					   
		   });
	       window.setOnCloseRequest(event->{
	    	   event.consume();
	       });
	}
	public ModifierClientWindow() {
		initWindow();
		addStylesToNodes();
		addNodesToWindow();
		window.initModality(Modality.APPLICATION_MODAL);
		AddEvents();
		
		window.show();
	   }
}
