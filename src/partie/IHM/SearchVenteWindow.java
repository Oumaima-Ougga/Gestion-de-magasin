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
import partie.DAO.LigneDeCommande;
import partie.DAO.Produit;

public class SearchVenteWindow {
	SearchVenteHandler handler = new SearchVenteHandler(this);
	Stage window=new Stage();
	VBox root=new VBox();
	HBox  SearchBox= new HBox();
	
	
	Scene scene=new Scene(root);
	Label titleLabel=new Label("Recercher une vente : ");
	Label venteTrouveLabel = new Label ("Ligne(s) de commande trouvé(s):");
	Button produitSearchButton= new Button("RECHERCHER");
	TextField venteSearchTextField = new TextField();


	Label totalLabel=new Label("Total");
	Label totalLabelValue=new Label("0.0");
	HBox totalHbox=new HBox();
	
	
	
	TableColumn<LigneDeCommande,Integer> ProduitColumn=new TableColumn<>("Produit ");
	TableColumn<LigneDeCommande,Integer> qteColumn=new TableColumn<>("qte du produit");
	TableColumn<LigneDeCommande,Integer> totalColumn=new TableColumn<>("Total");
	
	TableView<LigneDeCommande> venteTableView=new TableView<>();
	ObservableList<LigneDeCommande> venteObservableList = FXCollections.observableArrayList();
	
	

	private void addColumnsToTableView() {
		venteTableView.getColumns().addAll(ProduitColumn,qteColumn,totalColumn);
		venteTableView.setItems(venteObservableList);
	}
	private void updateColumns() {
		ProduitColumn.setCellValueFactory(new PropertyValueFactory("produit"));
		ProduitColumn.setPrefWidth(350);
		totalColumn.setCellValueFactory(new PropertyValueFactory("total"));
		totalColumn.setPrefWidth(100);
		qteColumn.setCellValueFactory(new PropertyValueFactory("qte"));
		qteColumn.setPrefWidth(250);

	}
	private void AddEvents() {
		produitSearchButton.setOnAction(event->{
			  handler.searchClick();
		   }
		   );
	}
	   private void addStylesToNodes() {
			scene.getStylesheets().add("css/application.css");
			titleLabel.getStyleClass().add("LabelTitle");
			venteTrouveLabel.getStyleClass().add("LabelForm");
			titleLabel.setMinWidth(window.getWidth());
			venteSearchTextField.setMinWidth(400);
			root.setSpacing(15);
			SearchBox.setSpacing(20);
			
			totalLabel.getStyleClass().add("LabelTotal");
			totalLabelValue.getStyleClass().add("LabelTotal");
			totalHbox.getStyleClass().add("boxTotal");
			totalHbox.setSpacing(20);
		}
	   
	   private void addNodesToWindow() {
		   totalHbox.getChildren().addAll(totalLabel,totalLabelValue);
		   SearchBox.getChildren().addAll(venteSearchTextField,produitSearchButton);
			root.getChildren().addAll(titleLabel,SearchBox,venteTrouveLabel,venteTableView,totalHbox);
	   }
		
	private void initWindow() {
		window.setWidth(700);
		window.setHeight(650);
		window.setScene(scene);
		window.setTitle(" Rechercher une vente ");
		window.getIcons().add(new Image("file:icon.PNG"));
	}
   public SearchVenteWindow() {
	   initWindow();
	   addNodesToWindow();
	   addStylesToNodes();
	   AddEvents();
	   updateColumns();
	   addColumnsToTableView();
	   window.show();
   }

}
