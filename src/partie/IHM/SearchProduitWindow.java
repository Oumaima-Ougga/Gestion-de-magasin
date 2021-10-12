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
import partie.DAO.Produit;

public class SearchProduitWindow {
	 ProduitSearchHandler handler =new ProduitSearchHandler(this);
	Stage window=new Stage();
	VBox root=new VBox();
	HBox  Box= new HBox();
	Scene scene=new Scene(root);
	Label titleLabel=new Label("Recercher un produit");
	Label produitTrouveLabel = new Label ("Produit(s) trouvé(s):");
	Button produitSearchButton= new Button("RECHERCHER");
	TextField produitSearchTextField = new TextField();
	TableColumn<Produit,Long> codeColumn=new TableColumn<>("code");
	TableColumn<Produit,String> designationColumn=new TableColumn<>("designation");
	TableColumn<Produit,Double> prixAchatColumn=new TableColumn<>("prixAchat");
	TableColumn<Produit,Double> prixVenteColumn=new TableColumn<>("prixVente");
	TableColumn<Produit,String> CategorieColumn=new TableColumn<>("categorie");
	TableView<Produit> produitsTableView=new TableView<>();
	ObservableList<Produit> produitsObservableList=FXCollections.observableArrayList();

	private void addColumnsToTableView() {
		produitsTableView.getColumns().addAll(codeColumn,designationColumn,prixAchatColumn,prixVenteColumn,CategorieColumn);	
		produitsTableView.setItems(produitsObservableList);
	}
	private void updateColumns() {
		codeColumn.setCellValueFactory(new PropertyValueFactory("code"));
		codeColumn.setPrefWidth(100);
		designationColumn.setCellValueFactory(new PropertyValueFactory("designation"));
		designationColumn.setPrefWidth(250);
		prixAchatColumn.setCellValueFactory(new PropertyValueFactory("prixAchat"));
		prixAchatColumn.setPrefWidth(150);
		prixVenteColumn.setCellValueFactory(new PropertyValueFactory("prixVente"));
		prixVenteColumn.setPrefWidth(150);
		CategorieColumn.setCellValueFactory(new PropertyValueFactory("categorie"));
		CategorieColumn.setPrefWidth(250);

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
			produitTrouveLabel.getStyleClass().add("LabelForm");
			titleLabel.setMinWidth(window.getWidth());
			produitSearchTextField.setMinWidth(700);
			root.setSpacing(15);
			Box.setSpacing(20);
			
		}
	   private void addNodesToWindow() {
		   Box.getChildren().addAll(produitSearchTextField,produitSearchButton);
			root.getChildren().addAll(titleLabel,Box,produitTrouveLabel,produitsTableView);
	   }
		
	private void initWindow() {
		window.setWidth(1000);
		window.setHeight(650);
		window.setScene(scene);
		window.setTitle(" Rechercher un produit");
		window.getIcons().add(new Image("file:icon.PNG"));
	}
   public SearchProduitWindow() {
	   initWindow();
	   addNodesToWindow();
	   addStylesToNodes();
	   AddEvents();
	   updateColumns();
	   addColumnsToTableView();
	   window.show();
   }
}