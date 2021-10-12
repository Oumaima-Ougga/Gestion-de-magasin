package partie.IHM;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import partie.DAO.Client;

public class ListeClientWindow {
	ListeClientHandler handler = new ListeClientHandler(this);
	Stage window=new Stage();
	VBox root=new VBox();
	Scene scene=new Scene(root);
	Label titleLabel=new Label("Liste des clients");

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

	
        private void addStylesToNodes() {
		scene.getStylesheets().add("css/application.css");
		titleLabel.getStyleClass().add("LabelTitle");
		
		clientsTableView.getStyleClass().add("table-row-cell");
		clientsTableView.setMinHeight(500);
		titleLabel.setMinWidth(window.getWidth());
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

	
	private void initWindow() {
		window.setWidth(1200);
		window.setHeight(650);
		window.setScene(scene);
		window.setTitle("Liste des clients");
		window.getIcons().add(new Image("file:icon.PNG"));
	}
	private void addNodesToPane() {
		root.getChildren().addAll(titleLabel,clientsTableView);
	}
	public ListeClientWindow() {
		
		initWindow();
		addStylesToNodes();
		addNodesToPane();
		updateColumns();
		handler.updateClientsListWindow();
		addColumnsToTableView();
		window.show();
	}
}
