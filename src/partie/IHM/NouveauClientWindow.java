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

public class NouveauClientWindow {
	NouveauClientHandler handler =new NouveauClientHandler(this);
    VBox root= new VBox();
    HBox  ButtonsBox= new HBox();
    Scene scene = new Scene(root);
    Stage window = new Stage();
    Label titleLabel= new Label("Nouveau Client");
    //Label clientCodeLabel = new Label ("Code :");
    Label clientPrenomLabel = new Label ("Prenom :");
    Label clientNomLabel = new Label ("Nom :");
    Label clientTeleLabel = new Label ("Telephone :");
    Label clientEmailLabel = new Label ("E-mail :");
    Label clientAdresseLabel = new Label ("Adresse :");
    //TextField clientCodeTextField = new TextField();
    TextField clientPrenomTextField = new TextField();
    TextField clientNomTextField = new TextField();
    TextField clientTelephoneTextField = new TextField();
    TextField clientEmailTextField = new TextField();
    TextField clientAdresseTextField = new TextField();
    
    
    Button clientAddButton= new Button("AJOUTER");
    Button clientCancelButton= new Button("ANNULER");
    
    private void initWindow() {
    	window.setScene(scene);
    	window.setWidth(800);
    	window.setHeight(600);
    	window.getIcons().add(new Image("file:icon.png"));
    	window.setTitle("Nouveau Client");
    
    }
    
    private void addNodesToWindow() {
    	root.getChildren().add(titleLabel);
    	root.getChildren().addAll(clientPrenomLabel,clientPrenomTextField,clientNomLabel,clientNomTextField,clientTeleLabel,clientTelephoneTextField,clientEmailLabel,clientEmailTextField,clientAdresseLabel,clientAdresseTextField);
    	ButtonsBox.getChildren().addAll(clientAddButton,clientCancelButton);
    	root.getChildren().add(ButtonsBox);   
    }
    
	private void addStylesNodes() {
		scene.getStylesheets().add("css/application.css");
		titleLabel.getStyleClass().add("LabelTitle");
		//Largeur 
		titleLabel.setMaxWidth(window.getWidth());
		clientTeleLabel.getStyleClass().add("LabelForm");
		clientEmailLabel.getStyleClass().add("LabelForm");
		clientAdresseLabel.getStyleClass().add("LabelForm");
		clientPrenomLabel.getStyleClass().add("LabelForm");
		clientNomLabel.getStyleClass().add("LabelForm");
		root.setSpacing(15);
		ButtonsBox.setSpacing(20);
	}
	
	private void AddEvents() {
		   clientCancelButton.setOnAction(event->{
			   window.close();
		   }
		   );
		   clientAddButton.setOnAction(event->{
			   handler.addClick();
				  window.close();
				  new ListeClientWindow();
		   });
	       window.setOnCloseRequest(event->{
	    	   event.consume();
	       });
	}
	
    public NouveauClientWindow() {
	initWindow();
	addStylesNodes();
	addNodesToWindow();
	window.initModality(Modality.APPLICATION_MODAL);
	AddEvents();
	
	window.show();
}


}
