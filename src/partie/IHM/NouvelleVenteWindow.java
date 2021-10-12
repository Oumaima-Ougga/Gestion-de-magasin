package partie.IHM;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import partie.DAO.Client;
import partie.DAO.LigneDeCommande;
import partie.DAO.Produit;

public class NouvelleVenteWindow {
	AjouterClickHandler handler = new AjouterClickHandler(this);
	 VBox root= new VBox();
	 HBox hBox = new HBox();
	 VBox addVbox = new VBox();
	 VBox TabVbox = new VBox();   
	 Scene scene = new Scene(root);
     Stage window = new Stage();
     
	    HBox  ButtonsBox= new HBox();
	    HBox LCommandeBox = new HBox();
	    Label titleLabel= new Label("Ajouter ou Modifier Vente : ");
	    Label venteCodeLabel = new Label ("Code de vente :");
	    TextField venteCodeTextField = new TextField();
	    Label venteDateLabel = new Label ("Date :");
	    Label venteLCLabel = new Label ("ligne(s) de commande :");
	    Label venteCodeClientLabel = new Label ("Code du client :");
	    TextField venteCodeClientTextField = new TextField();
	    DatePicker venteDateDatePicker = new DatePicker();
	    TextField venteLCTextField = new TextField();
	    Button AjouterButton= new Button("AJOUTER");
	    Button SupprimerButton= new Button("SUPPRIMER");
	    Button venteAddButton= new Button("AJOUTER");
	    Button venteUpdateButton= new Button("MODIFIER");
	    Button venteListeButton= new Button("LISTE");
	    Button venteCancelButton= new Button("ANNULER");
	    
	   
			Label codeProduitLabel = new Label ("code:");
		    TextField codeProduitTextField = new TextField();
			Label qteProduitLabel = new Label ("qte:");
		    TextField qteProduitTextField = new TextField();
		    
		    TableColumn<LigneDeCommande,String> produitColumn=new TableColumn<>("Produit");
			TableColumn<LigneDeCommande,Integer> qteColumn=new TableColumn<>("qte du produit");
			TableColumn<LigneDeCommande,Double> totalColumn=new TableColumn<>("Total");
			TableView<LigneDeCommande> LCmdTableView=new TableView<>();
			ObservableList<LigneDeCommande> lcObservableList=FXCollections.observableArrayList();
	    
			TableColumn<Client,Long> codeColumn=new TableColumn<>("code");
			TableColumn<Client,String> PrenomColumn=new TableColumn<>("Prenom");
			TableColumn<Client,String> NomColumn=new TableColumn<>("Nom");
			TableColumn<Client,Long> TelephoneColumn=new TableColumn<>("Telephone");
			TableColumn<Client,String> EmailColumn=new TableColumn<>("E-mail");
			TableColumn<Client,String> AdresseColumn=new TableColumn<>("Adresse");
			TableView<Client> clientsTableView=new TableView<>();
			ObservableList<Client> clientsObservableList=FXCollections.observableArrayList();
			
			TableColumn<Produit,Long> codePColumn=new TableColumn<>("code");
			TableColumn<Produit,String> designationColumn=new TableColumn<>("designation");
			TableColumn<Produit,Double> prixAchatColumn=new TableColumn<>("prixAchat");
			TableColumn<Produit,Double> prixVenteColumn=new TableColumn<>("prixVente");
			TableColumn<Produit,String> CategorieColumn=new TableColumn<>("categorie");
			TableView<Produit> produitsTableView=new TableView<>();
			ObservableList<Produit> produitsObservableList=FXCollections.observableArrayList();

			private void addColumnsToTableView() {
				LCmdTableView.getColumns().addAll(produitColumn,qteColumn,totalColumn);
				LCmdTableView.setItems(lcObservableList);
				
				clientsTableView.getColumns().addAll(codeColumn,PrenomColumn,NomColumn,TelephoneColumn,EmailColumn,AdresseColumn);	
				clientsTableView.setItems(clientsObservableList);
			
				produitsTableView.getColumns().addAll(codePColumn,designationColumn,prixAchatColumn,prixVenteColumn,CategorieColumn);	
				produitsTableView.setItems(produitsObservableList);
			}
		private void updateColumns() {
				produitColumn.setCellValueFactory(new PropertyValueFactory("produit"));
				produitColumn.setPrefWidth(350);
				qteColumn.setCellValueFactory(new PropertyValueFactory("qte"));
				qteColumn.setPrefWidth(100);
				totalColumn.setCellValueFactory(new PropertyValueFactory("total"));
				totalColumn.setPrefWidth(100);
				codeColumn.setCellValueFactory(new PropertyValueFactory("code"));
				codeColumn.setPrefWidth(100);
				PrenomColumn.setCellValueFactory(new PropertyValueFactory("prenom"));
				PrenomColumn.setPrefWidth(150);
				NomColumn.setCellValueFactory(new PropertyValueFactory("nom"));
				NomColumn.setPrefWidth(150);
				TelephoneColumn.setCellValueFactory(new PropertyValueFactory("telephone"));
				TelephoneColumn.setPrefWidth(150);
				EmailColumn.setCellValueFactory(new PropertyValueFactory("email"));
				EmailColumn.setPrefWidth(150);
				AdresseColumn.setCellValueFactory(new PropertyValueFactory("adresse"));
				AdresseColumn.setPrefWidth(250);
				codePColumn.setCellValueFactory(new PropertyValueFactory("code"));
				codePColumn.setPrefWidth(100);
				designationColumn.setCellValueFactory(new PropertyValueFactory("designation"));
				designationColumn.setPrefWidth(150);
				prixAchatColumn.setCellValueFactory(new PropertyValueFactory("prixAchat"));
				prixAchatColumn.setPrefWidth(150);
				prixVenteColumn.setCellValueFactory(new PropertyValueFactory("prixVente"));
				prixVenteColumn.setPrefWidth(150);
				CategorieColumn.setCellValueFactory(new PropertyValueFactory("categorie"));
				CategorieColumn.setPrefWidth(150);	
			}
	    private void addNodesToWindow() { 
	    	root.getChildren().add(titleLabel);
	    	ButtonsBox.getChildren().addAll(venteAddButton,venteUpdateButton,venteListeButton,venteCancelButton);
	    	root.getChildren().add(ButtonsBox); 
	    	LCommandeBox.getChildren().addAll(codeProduitLabel,codeProduitTextField,qteProduitLabel,qteProduitTextField,AjouterButton,SupprimerButton);
	    	addVbox.getChildren().addAll(venteCodeLabel, venteCodeTextField,venteCodeClientLabel,venteCodeClientTextField,venteDateLabel,venteDateDatePicker,venteLCLabel,LCommandeBox,LCmdTableView);
	    	TabVbox.getChildren().addAll(clientsTableView,produitsTableView);
	    	hBox.getChildren().addAll(addVbox,TabVbox);	
	    	root.getChildren().add(hBox);
	    }

	    private void addStylesNodes() {
			scene.getStylesheets().add("css/application.css");
			titleLabel.getStyleClass().add("LabelTitle");
			titleLabel.setMaxWidth(window.getWidth());
			venteLCTextField.setMinWidth(300);
			venteDateLabel.getStyleClass().add("LabelForm");
			venteCodeLabel.getStyleClass().add("LabelForm");
			venteLCLabel.getStyleClass().add("LabelForm");
			venteCodeClientLabel.getStyleClass().add("LabelForm");
			codeProduitLabel.getStyleClass().add("LabelForm");
			qteProduitLabel.getStyleClass().add("LabelForm");
			venteCodeClientTextField.setMinWidth(window.getMinWidth());
			LCommandeBox.setMinWidth(window.getMinWidth());
			root.setSpacing(15);
			LCommandeBox.setSpacing(20);
			ButtonsBox.setSpacing(20);
			addVbox.setSpacing(15);
			TabVbox.setSpacing(20);
			hBox.setSpacing(20);
			
		}
	   
	    private void AddEvents() {
	    	 venteCancelButton.setOnAction(event->{
				   window.close();
			   }
			   );
	    	 AjouterButton.setOnAction(event->{
	    		handler.ajouterLcClick();
	    	 });
	    	 SupprimerButton.setOnAction(event->{
	    		 
	    	 });
			   venteAddButton.setOnAction(event->{
				 handler.ajouterVente();
			   });
			   venteUpdateButton.setOnAction(event->{
				   handler.modifierVente();
			   });
			   venteListeButton.setOnAction(event->{
				   new ListeVenteWindow();
			   });
		      window.setOnCloseRequest(event->{
		    	   event.consume();
		       });
		      produitsTableView.setOnMouseClicked((event) -> {
					if(event.getButton().equals(MouseButton.PRIMARY)){
					 handler.mouseClickProduit();
					}
					});
		      SupprimerButton.setOnAction(event->{
		    	 handler.supprimerLcClick(); 
		      });
		      clientsTableView.setOnMouseClicked((event) -> {
					if(event.getButton().equals(MouseButton.PRIMARY)) {
			   		 handler.mouseClickClient();
					}
					});
		     
	    }
	private void initWindow() {
    	window.setScene(scene);
    	window.setWidth(1500);
    	window.setHeight(800);
    	window.getIcons().add(new Image("file:icon.png"));
    	window.setTitle("Nouvelle vente");
    
    }
	 public NouvelleVenteWindow() {
			initWindow();
			addStylesNodes();
			addNodesToWindow();
			updateColumns();
			handler.updateClientsListWindow();
			handler.updateProduitsListWindow();
			window.initModality(Modality.APPLICATION_MODAL);
			addColumnsToTableView();
			AddEvents();
			window.show();
		}

}
