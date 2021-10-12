package partie.IHM;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import partie.DAO.Client;

public class SearchClientWindow {
	 SearchClientHandler handler =new SearchClientHandler(this);
	Stage window=new Stage();
	VBox root=new VBox();
	HBox  Box= new HBox();
	Scene scene=new Scene(root);
	Label titleLabel=new Label("Recercher un client");
	 Label clientTrouveLabel = new Label ("Client(s) trouvé(s):");
	 Label clientSearchLabel = new Label ("Entre le code du client :");
	Button clientSearchButton= new Button("RECHERCHER");
	TextField clientSearchTextField = new TextField();
	TableColumn<Client,Long> codeColumn=new TableColumn<>("code");
	TableColumn<Client,String> PrenomColumn=new TableColumn<>("Prenom");
	TableColumn<Client,String> NomColumn=new TableColumn<>("Nom");
	TableColumn<Client,Long> TelephoneColumn=new TableColumn<>("Telephone");
	TableColumn<Client,String> EmailColumn=new TableColumn<>("E-mail");
	TableColumn<Client,String> AdresseColumn=new TableColumn<>("Adresse");
	TableView<Client> clientsTableView=new TableView<>();
	ObservableList<Client> clientsObservableList=FXCollections.observableArrayList();
	
	private void addColumnsToTableView() {
		clientsTableView.getColumns().addAll(codeColumn,PrenomColumn,NomColumn,TelephoneColumn,EmailColumn,AdresseColumn);
		clientsTableView.setItems(clientsObservableList);
	}
	private void updateColumns() {
		codeColumn.setCellValueFactory(new PropertyValueFactory("code"));
		codeColumn.setPrefWidth(100);
		PrenomColumn.setCellValueFactory(new PropertyValueFactory("prenom"));
		PrenomColumn.setPrefWidth(250);
		NomColumn.setCellValueFactory(new PropertyValueFactory("nom"));
		NomColumn.setPrefWidth(250);
		TelephoneColumn.setCellValueFactory(new PropertyValueFactory("telephone"));
		TelephoneColumn.setPrefWidth(150);
		EmailColumn.setCellValueFactory(new PropertyValueFactory("email"));
		EmailColumn.setPrefWidth(150);
		AdresseColumn.setCellValueFactory(new PropertyValueFactory("adresse"));
		AdresseColumn.setPrefWidth(250);

	}
	private void addStylesToNodes() {
		scene.getStylesheets().add("css/application.css");
		titleLabel.getStyleClass().add("LabelTitle");
		clientTrouveLabel.getStyleClass().add("LabelForm");
		clientSearchLabel.getStyleClass().add("LabelForm");
		titleLabel.setMinWidth(window.getWidth());
		clientSearchTextField.setMinWidth(700);
		root.setSpacing(15);
		Box.setSpacing(20);
		
	}
	 private void addNodesToWindow() {
		   Box.getChildren().addAll(clientSearchTextField,clientSearchButton);
			root.getChildren().addAll(titleLabel,clientSearchLabel,Box,clientTrouveLabel,clientsTableView);
	   }
	 private void AddEvents() {
			clientSearchButton.setOnAction(event->{
				   handler.searchClick();
			   }
			   );
		}
		
	private void initWindow() {
		window.setWidth(1200);
		window.setHeight(650);
		window.setScene(scene);
		window.setTitle(" Rechercher un(e) client(e)");
		window.getIcons().add(new Image("file:icon.PNG"));
	}
 public SearchClientWindow() {
	   initWindow();
	   addNodesToWindow();
	   AddEvents();
	   addStylesToNodes();
	   updateColumns();
	   addColumnsToTableView();
	   window.show();
 }

}
