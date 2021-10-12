package partie.IHM;

import java.util.Date;

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
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import partie.DAO.LigneDeCommande;

import partie.DAO.Vente;

public class ListeVenteWindow {
	ListHandlerVente handler =new ListHandlerVente(this);
	VBox root= new VBox();    
	Scene scene = new Scene(root);
	Stage window = new Stage();
	HBox HboxVente = new HBox();
	HBox totalHbox=new HBox();
	VBox TabVente =new VBox();
	Label titleLabel= new Label("Liste Vente :");
	
	
	TableColumn<Vente,Long> codeColumn=new TableColumn<>("Code de vente");
	TableColumn<Vente,Date> dateColumn=new TableColumn<>("date");
	TableColumn<Vente,Long> codeClientColumn=new TableColumn<>("codeClient");
	TableView<Vente> ventesTableView=new TableView<>();
	
	TableColumn<LigneDeCommande,String> produitColumn=new TableColumn<>("Produit");
	TableColumn<LigneDeCommande,Integer> qteColumn=new TableColumn<>("qte du produit");
	TableColumn<LigneDeCommande,Double> totalColumn=new TableColumn<>("Total");
	TableView<LigneDeCommande> venteTableView=new TableView<>();
	
	ObservableList<Vente> ventesObservableList=FXCollections.observableArrayList();
	ObservableList<LigneDeCommande> lcObservableList=FXCollections.observableArrayList();
	
	Label totalLabel=new Label("Total");
	Label totalLabelValue=new Label("0.0");
	
	Button venteDeleteButton= new Button("SUPPRIMER");
	TextField venteDeleteTextField = new TextField();
	Label venteDeleteLabel = new Label(" Enter le code de vente à supprimer : ");
	
	
	
	private void addColumnsToTableView() {
		ventesTableView.getColumns().addAll(codeColumn,dateColumn,codeClientColumn);
		venteTableView.getColumns().addAll(produitColumn,qteColumn,totalColumn);
		ventesTableView.setItems(ventesObservableList);
		venteTableView.setItems(lcObservableList);
	}
	
	private void updateColumns() {
		codeColumn.setCellValueFactory(new PropertyValueFactory("code"));
		codeColumn.setPrefWidth(200);
		dateColumn.setCellValueFactory(new PropertyValueFactory("date"));
		dateColumn.setPrefWidth(200);
		codeClientColumn.setCellValueFactory(new PropertyValueFactory("client"));
		codeClientColumn.setPrefWidth(200);
		
		produitColumn.setCellValueFactory(new PropertyValueFactory("produit"));
		produitColumn.setPrefWidth(350);
	
		qteColumn.setCellValueFactory(new PropertyValueFactory("qte"));
		qteColumn.setPrefWidth(100);
		totalColumn.setCellValueFactory(new PropertyValueFactory("total"));
		totalColumn.setPrefWidth(100);
		}
	private void addNodesToWindow() {
		totalHbox.getChildren().addAll(totalLabel,totalLabelValue);
		TabVente.getChildren().addAll(venteTableView,totalHbox,venteDeleteLabel,venteDeleteTextField,venteDeleteButton);
		HboxVente.getChildren().addAll(ventesTableView,TabVente);
		root.getChildren().addAll(titleLabel,HboxVente);
    }
	
	 private void addStylesNodes() {
			scene.getStylesheets().add("css/application.css");
			titleLabel.getStyleClass().add("LabelTitle");
			totalLabel.getStyleClass().add("LabelTotal");
			totalLabelValue.getStyleClass().add("LabelTotal");
			totalHbox.getStyleClass().add("boxTotal");
			totalHbox.setSpacing(20);
			titleLabel.setMaxWidth(window.getWidth());
			venteDeleteLabel.getStyleClass().add("LabelForm");
			ventesTableView.getStyleClass().add("table-row-cell");
			HboxVente.setMinHeight(window.getMinHeight());
			HboxVente.setMinWidth(window.getMinWidth());
			HboxVente.setSpacing(30);
		}
	 private void AddEvents() {
		 ventesTableView.setOnMouseClicked((event) -> {
				if(event.getButton().equals(MouseButton.PRIMARY)){
			//	 System.out.println("faite");
				 handler.mouseClick();
				}
				});
		 venteDeleteButton.setOnAction(event->{
				handler.deleteClick();
			});
	 }
	 
	private void initWindow() {
    	window.setScene(scene);
    	window.setWidth(1200);
    	window.setHeight(650);
    	window.getIcons().add(new Image("file:icon.png"));
    	window.setTitle("Liste des ventes");
    
    }
	 public ListeVenteWindow() {
			initWindow();
			addStylesNodes();
			addNodesToWindow();
			updateColumns();
			handler.updateVentesListWindow();
			addColumnsToTableView();
			window.initModality(Modality.APPLICATION_MODAL);
			AddEvents();
			window.show();
		}

}
