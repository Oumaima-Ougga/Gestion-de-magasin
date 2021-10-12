package partie.IHM;


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
import partie.DAO.Produit;

public class FormListProduitWindow {
    ProduitsListHandler handler =new ProduitsListHandler(this);
	Stage window=new Stage();
	VBox root=new VBox();
	Scene scene=new Scene(root);
	Label titleLabel=new Label("Liste des produits");
	HBox totalHbox=new HBox();
	Label totalLabel=new Label("Total");
	Label totalLabelValue=new Label("0.0");
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

	
        private void addStylesToNodes() {
		scene.getStylesheets().add("css/application.css");
		titleLabel.getStyleClass().add("LabelTitle");
		totalLabel.getStyleClass().add("LabelTotal");
		totalLabelValue.getStyleClass().add("LabelTotal");
		totalHbox.getStyleClass().add("boxTotal");
		produitsTableView.getStyleClass().add("table-row-cell");
		produitsTableView.setMinHeight(500);
		titleLabel.setMinWidth(window.getWidth());
		totalHbox.setSpacing(15);
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
		CategorieColumn.setPrefWidth(200);

	}
	
	private void initWindow() {
		window.setWidth(900);
		window.setHeight(650);
		window.setScene(scene);
		window.setTitle("Liste des produits");
		window.getIcons().add(new Image("file:icon.PNG"));
	}
	private void addNodesToPane() {
		totalHbox.getChildren().addAll(totalLabel,totalLabelValue);
		root.getChildren().addAll(titleLabel,produitsTableView,totalHbox);
	}
	public FormListProduitWindow() {
		initWindow();
		addStylesToNodes();
		addNodesToPane();
		updateColumns();
		handler.updateProduitsListWindow();
		handler.updateTotal();
		addColumnsToTableView();
		window.show();
	}
}  
