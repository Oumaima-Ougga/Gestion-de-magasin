package partie.IHM;

import java.util.Date;

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
import partie.DAO.LigneDeCommande;
import partie.DAO.Vente;

public class NouveauPaiementWindow {
	NouveauPaiementHandler handler =new NouveauPaiementHandler(this);
	VBox root= new VBox();    
	Scene scene = new Scene(root);
	Stage window = new Stage();
	Label titleLabel= new Label("Nouveau Paiement :");
	HBox hbox = new HBox();
	VBox TableBox = new VBox();
	VBox AddBox = new VBox();
	HBox totalHbox=new HBox();
	
	Button paiementAddButton= new Button("AJOUTER");
	Button paiementUpdateButton= new Button("MODIFIER");
	Button paiementListeButton= new Button("LISTE");
	Button paiementCancelButton= new Button("ANNULER");
	HBox  ButtonsBox= new HBox();
	
	TableColumn<Vente,Long> codeColumn=new TableColumn<>("Code de vente");
	TableColumn<Vente,Date> dateColumn=new TableColumn<>("date");
	TableColumn<Vente,Long> codeClientColumn=new TableColumn<>("codeClient");
	TableView<Vente> ventesTableView=new TableView<>();
	ObservableList<Vente> ventesObservableList=FXCollections.observableArrayList();

	TableColumn<LigneDeCommande,String> produitColumn=new TableColumn<>("Produit");
	TableColumn<LigneDeCommande,Integer> qteColumn=new TableColumn<>("qte du produit");
	TableColumn<LigneDeCommande,Double> totalColumn=new TableColumn<>("Total");
	TableView<LigneDeCommande> LCTableView=new TableView<>();
	ObservableList<LigneDeCommande> lcObservableList=FXCollections.observableArrayList();

	Label totalLabel=new Label("Total");
	Label totalLabelValue=new Label("0.0");
	
	Label paiementCodeLabel = new Label ("Code de paiement :");
	TextField paiementCodeTextField = new TextField();
	Label paiementVenteCodeLabel = new Label ("Code de vente :");
	TextField paiementVenteCodeTextField = new TextField();
	Label numChequeLabel = new Label ("Num de cheque :");
	TextField numChequeTextField = new TextField();
	Label dateLabel = new Label ("Date de paiement :");
	DatePicker paiementDateDatePicker = new DatePicker();
	Label typeLabel = new Label ("Type paiement :");
	TextField TypeTextField = new TextField();
	Label TotalApayéLabel = new Label ("Total à payer :");
	TextField TotalApayéTextField = new TextField();
	Label TotalPayéLabel = new Label ("Total payé :");
	TextField TotalPayéTextField = new TextField();
	
	
	private void addColumnsToTableView() {
		ventesTableView.getColumns().addAll(codeColumn,dateColumn,codeClientColumn);
		LCTableView.getColumns().addAll(produitColumn,qteColumn,totalColumn);
		ventesTableView.setItems(ventesObservableList);
		LCTableView.setItems(lcObservableList);
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
		ButtonsBox.getChildren().addAll(paiementAddButton,paiementUpdateButton,paiementListeButton,paiementCancelButton);
		totalHbox.getChildren().addAll(totalLabel,totalLabelValue);
		TableBox.getChildren().addAll(ventesTableView,LCTableView,totalHbox);
		AddBox.getChildren().addAll(paiementCodeLabel,paiementCodeTextField,paiementVenteCodeLabel,paiementVenteCodeTextField,numChequeLabel,numChequeTextField,dateLabel,paiementDateDatePicker,typeLabel,TypeTextField,TotalApayéLabel,TotalApayéTextField,TotalPayéLabel,TotalPayéTextField);
		hbox.getChildren().addAll(AddBox,TableBox);
		root.getChildren().addAll(titleLabel,ButtonsBox,hbox);
    }
	 private void addStylesNodes() {
			scene.getStylesheets().add("css/application.css");
			titleLabel.getStyleClass().add("LabelTitle");
			totalLabel.getStyleClass().add("LabelTotal");
			totalLabelValue.getStyleClass().add("LabelTotal");
			totalHbox.getStyleClass().add("boxTotal");
			
			paiementCodeLabel.getStyleClass().add("LabelForm");
			paiementVenteCodeLabel.getStyleClass().add("LabelForm");
			numChequeLabel.getStyleClass().add("LabelForm");
			dateLabel.getStyleClass().add("LabelForm");
			typeLabel.getStyleClass().add("LabelForm");
			TotalApayéLabel.getStyleClass().add("LabelForm");
			TotalPayéLabel.getStyleClass().add("LabelForm");
			totalHbox.setSpacing(20);
			titleLabel.setMaxWidth(window.getWidth());
		
			ventesTableView.getStyleClass().add("table-row-cell");
			AddBox.setSpacing(15);
			AddBox.setMinWidth(600);
			TableBox.setSpacing(15);
			hbox.setSpacing(15);
			root.setSpacing(15);
			ButtonsBox.setSpacing(15);
			
		}
	 private void AddEvents() {
		 ventesTableView.setOnMouseClicked((event) -> {
				if(event.getButton().equals(MouseButton.PRIMARY)){
				 handler.mouseClick();
				}
				});
		 paiementAddButton.setOnAction(event->{
			 handler.ajouterPaiement();
		   });
		   paiementUpdateButton.setOnAction(event->{
			 handler.modifierPaiement();
		   });
		   paiementListeButton.setOnAction(event->{
			   new ListPaiementWindow();
		   });
	      window.setOnCloseRequest(event->{
	    	   event.consume();
	       });
	      paiementCancelButton.setOnAction(event->{
			   window.close();
		   }
		   );
	      totalLabelValue.setOnMouseClicked(event->{
	    	  if(event.getButton().equals(MouseButton.PRIMARY)){
					 handler.mouseClickTotal();
					}
	      });
	 }
	 private void initWindow() {
	    	window.setScene(scene);
	    	window.setWidth(1200);
	    	window.setHeight(650);
	    	window.getIcons().add(new Image("file:icon.png"));
	    	window.setTitle("Nouveau Paiement");
	    
	    }
	 public NouveauPaiementWindow() {
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
