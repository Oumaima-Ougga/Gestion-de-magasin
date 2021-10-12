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
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import partie.DAO.*;


public class ListPaiementWindow {
	ListPaiementHandler handler =new ListPaiementHandler(this);
	VBox root= new VBox();    
	Scene scene = new Scene(root);
	Stage window = new Stage();
	Label titleLabel= new Label("Liste Paiement :");
	
	
	TableColumn<Paiement,Long> codeColumn=new TableColumn<>("Code de paiement");
	TableColumn<Paiement,Date> dateColumn=new TableColumn<>("date");
	TableColumn<Paiement,Long> codeVenteColumn=new TableColumn<>("code Vente");
	TableColumn<Paiement,Long> numChequeColumn=new TableColumn<>("numCheque");
	TableColumn<Paiement,String> typeColumn=new TableColumn<>("type");
	TableColumn<Paiement,Double> prixApayeColumn=new TableColumn<>("Prix à payer");
	TableColumn<Paiement,Double> prixPayeColumn=new TableColumn<>("Prix payé");
	TableColumn<Paiement,Double> prixRestantColumn=new TableColumn<>("Prix restant");
	
	TableView<Paiement> paiementsTableView=new TableView<>();
	ObservableList<Paiement> paiementsObservableList=FXCollections.observableArrayList();
	
	Button paiementDeleteButton= new Button("SUPPRIMER");
	TextField paiementDeleteTextField = new TextField();
	Label paiementDeleteLabel = new Label(" Enter le code de paiement à supprimer : ");
	
	
	
	private void addColumnsToTableView() {
		paiementsTableView.getColumns().addAll(codeColumn,dateColumn,codeVenteColumn,numChequeColumn,typeColumn,prixApayeColumn,prixPayeColumn,prixRestantColumn);
		paiementsTableView.setItems(paiementsObservableList);
	
	}
	
	private void updateColumns() {
		codeColumn.setCellValueFactory(new PropertyValueFactory("code"));
		codeColumn.setPrefWidth(100);
		dateColumn.setCellValueFactory(new PropertyValueFactory("date"));
		dateColumn.setPrefWidth(150);
		codeVenteColumn.setCellValueFactory(new PropertyValueFactory("vente"));
		codeVenteColumn.setPrefWidth(100);
		numChequeColumn.setCellValueFactory(new PropertyValueFactory("numCheque"));
		numChequeColumn.setPrefWidth(200);
		typeColumn.setCellValueFactory(new PropertyValueFactory("type"));
		typeColumn.setPrefWidth(150);
		prixApayeColumn.setCellValueFactory(new PropertyValueFactory("totalApayer"));
		prixApayeColumn.setPrefWidth(200);
		prixPayeColumn.setCellValueFactory(new PropertyValueFactory("totalPayé"));
		prixPayeColumn.setPrefWidth(200);
		prixRestantColumn.setCellValueFactory(new PropertyValueFactory("TotalRestant"));
		prixRestantColumn.setPrefWidth(200);
		}
	private void addNodesToWindow() {
		
		root.getChildren().addAll(titleLabel,paiementsTableView,paiementDeleteLabel,paiementDeleteTextField,paiementDeleteButton);
    }
	
	 private void addStylesNodes() {
			scene.getStylesheets().add("css/application.css");
			titleLabel.getStyleClass().add("LabelTitle");
			titleLabel.setMaxWidth(window.getWidth());
			paiementDeleteLabel.getStyleClass().add("LabelForm");
			paiementsTableView.getStyleClass().add("table-row-cell");
			root.setSpacing(15);
			
		}
	 private void AddEvents() {
		
		paiementDeleteButton.setOnAction(event->{
				handler.deleteClick();
			});
	 }
	 
	private void initWindow() {
    	window.setScene(scene);
    	window.setWidth(1300);
    	window.setHeight(650);
    	window.getIcons().add(new Image("file:icon.png"));
    	window.setTitle("Liste des paiements");
    
    }
	 public ListPaiementWindow() {
			initWindow();
			addStylesNodes();
			addNodesToWindow();
			updateColumns();
			handler.updatePaiementsListWindow();
			addColumnsToTableView();
			window.initModality(Modality.APPLICATION_MODAL);
			AddEvents();
			window.show();
		}
}
