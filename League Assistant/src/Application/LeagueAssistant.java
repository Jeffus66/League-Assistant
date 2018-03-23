package Application;

import Controllers.ChampionDetailsController;
import Controllers.ChampionSearchController;
import Model.Champion;
import Scrapers.opgg;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class LeagueAssistant extends Application {


    private Stage primaryStage;
    private BorderPane rootLayout;
    private String name;
    private String position;

    private ObservableList<Search> searches = FXCollections.observableArrayList();


    public LeagueAssistant(){

    }

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("League Assistant ALPHA");

        initRootLayout();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader searchPaneLoader = new FXMLLoader(getClass().getResource("/FXML/champion_search.fxml"));
            rootLayout =  searchPaneLoader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);

            ChampionSearchController csc = searchPaneLoader.getController();
            csc.setLeagueAssistant(this);


            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void initDetailsLayout(Search userSearch, Stage stage){
        //load details fxml here

        searches.add(userSearch);
        try {

            this.primaryStage = stage;

            // Load root layout from fxml file.
            FXMLLoader detailsPaneLoader = new FXMLLoader(getClass().getResource("/FXML/champion_details.fxml"));

            rootLayout =  detailsPaneLoader.load();


            //Get controller and pass the search BUT cant load the file due to errors on initialize
            ChampionDetailsController cdc = detailsPaneLoader.getController();
            cdc.setDisplayName(userSearch.getChampName());

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);

            this.primaryStage.setScene(scene);
           this.primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Returns the main stage.
     *
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    public ObservableList<Search> getSearches() {
        return searches;
    }
}




