package partie.IHM;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class MainWindow extends Application {
	private BorderPane root=new BorderPane();
	private Scene scene=new Scene(root);
	MenuItem nouveauproduitMenuItem = new MenuItem("Nouveau");
	MenuItem ListeproduitMenuItem = new MenuItem("Liste");
	MenuItem ModifierproduitMenuItem = new MenuItem("Modifier");
	MenuItem DeleteproduitMenuItem = new MenuItem("Supprimer");
	MenuItem SearchproduitMenuItem = new MenuItem("Rechercher");
	
	MenuItem nouveauclientMenuItem = new MenuItem("Nouveau");
	MenuItem ListeclientMenuItem = new MenuItem("Liste");
	MenuItem ModifierclientMenuItem = new MenuItem("Modifier");
	MenuItem DeleteclientMenuItem = new MenuItem("Supprimer");
	MenuItem SearchclientMenuItem = new MenuItem("Rechercher");
	
	MenuItem nouveauventeMenuItem = new MenuItem("Nouveau/Modifier");
	MenuItem ListeventeMenuItem = new MenuItem("Liste/Supprimer");
	MenuItem searchDeleteVenteMenuItem = new MenuItem("Rechercher");

	
	MenuItem nouveaupaiementMenuItem = new MenuItem("Nouveau");
	MenuItem ListepaiementMenuItem = new MenuItem("Liste");
	
	private void createMenu() {
		MenuBar menuBar = new MenuBar();
		
		Menu produitMenu = new Menu("Produits");
		Menu clientMenu = new Menu("Clients");
		Menu VenteMenu = new Menu("Ventes");
		Menu paiementMenu = new Menu("Paiements");
	   
		produitMenu.getItems().addAll(nouveauproduitMenuItem,ListeproduitMenuItem,ModifierproduitMenuItem,DeleteproduitMenuItem,SearchproduitMenuItem);
		clientMenu.getItems().addAll(nouveauclientMenuItem,ListeclientMenuItem,ModifierclientMenuItem,DeleteclientMenuItem,SearchclientMenuItem);
		VenteMenu.getItems().addAll(nouveauventeMenuItem,ListeventeMenuItem,searchDeleteVenteMenuItem);
		paiementMenu.getItems().addAll(nouveaupaiementMenuItem,ListepaiementMenuItem);
		
		menuBar.getMenus().addAll(produitMenu,clientMenu,VenteMenu,paiementMenu);
		root.setTop(menuBar);
	}
	
	public void addStylesNodes() {
		scene.getStylesheets().add("css/application.css");
		root.getStyleClass().add("mainWindow");
	}
	
	private void AddEvents() {
		nouveauproduitMenuItem.setOnAction(event->{
			new FormProduitWindow();
		});
		ListeproduitMenuItem.setOnAction(event->{
			new FormListProduitWindow();
		});
		ModifierproduitMenuItem.setOnAction(event->{
			new ModifierProduitWindow();
		});
		DeleteproduitMenuItem.setOnAction(event->{
			new DeleteProduitWindow();
		});
		SearchproduitMenuItem.setOnAction(event->{
			new SearchProduitWindow();
		});
		nouveauclientMenuItem.setOnAction(event->{
			new NouveauClientWindow();
		});
		ListeclientMenuItem.setOnAction(event->{
			new ListeClientWindow();
		});
		ModifierclientMenuItem.setOnAction(event->{
			new ModifierClientWindow();
		});
		DeleteclientMenuItem.setOnAction(event->{
			new DeleteClientWindow();
		});
		SearchclientMenuItem.setOnAction(event->{
			new SearchClientWindow();
		});
		nouveauventeMenuItem.setOnAction(event->{
			new NouvelleVenteWindow();
		});
		ListeventeMenuItem.setOnAction(event->{
			new ListeVenteWindow();
		});
		searchDeleteVenteMenuItem.setOnAction(event->{
			new SearchVenteWindow();
		});
		nouveaupaiementMenuItem.setOnAction(event->{
			new NouveauPaiementWindow();
		});
		ListepaiementMenuItem.setOnAction(event->{
			new ListPaiementWindow();
		});
	
	}

	
	public static void main(String[] args) {
		Application.launch(args);
	}
	
	@Override
	public void start(Stage window) throws Exception{
		createMenu();
		AddEvents();
		addStylesNodes();
		window.setScene(scene);
		window.setWidth(1100);
		window.setHeight(700);
		window.setTitle("Gestion de magasin");
		window.getIcons().add(new Image("file:icon.png"));
		window.show();
	
	}
	
}
