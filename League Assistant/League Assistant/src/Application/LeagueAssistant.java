package Application;

import Controllers.ChampionDetailsController;
import Controllers.ChampionSearchController;
import Scrapers.Opgg;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;
import java.io.IOException;

public class LeagueAssistant extends Application {

    //Create references
    private Stage primaryStage;
    private BorderPane rootLayout;
    //private Opgg opScraper;

    //Default Constructor
    public LeagueAssistant(){
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Font.loadFont(getClass().getResourceAsStream("friz-quadrata.ttf"),12);
        System.setProperty("prism.lcdtext", "false");

        //Setting reference to stage and setting window title
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("League Assistant ALPHA");

        //Testing data gathering
        //this.opScraper = new Opgg();
        //opScraper.connect("sona","bottom");
        //opScraper.getOverviewData(25);


        //Draw the login screen
        initRootLayout();
    }

    /**
     * Initializes the root layout and displays opening scene.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader searchPaneLoader = new FXMLLoader(getClass().getResource("/FXML/champion_search.fxml"));

            //Set root to the loaded FXML file
            rootLayout =  searchPaneLoader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);

            //Create a controller object to set the application reference
            ChampionSearchController csc = searchPaneLoader.getController();
            csc.setLeagueAssistant(this);

            //Set the scene to the newly created scene from the root which contains the FXML file
            primaryStage.setScene(scene);

            scene.getStylesheets().add(LeagueAssistant.class.getResource("LeagueStyle.css").toExternalForm());

            //Show the stage and display the application
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes the details scene after searching for a champion and position
     */
    public void initDetailsLayout(Search userSearch, Stage stage){
        //searches.add(userSearch);
        try {
            //opScraper = new Opgg();

            //Setting stage reference again
            this.primaryStage = stage;

            // Load root layout from fxml file.
            FXMLLoader detailsPaneLoader = new FXMLLoader(getClass().getResource("/FXML/champion_details.fxml"));

            //Set root to the loaded FXML file
            rootLayout =  detailsPaneLoader.load();

            /*Create a controller object from the details controller and use it to set the champion name label on the
               details screen using the reference from the search controller
               THERE ARE GOING TO BE A TON OF STATEMENTS LIKE THIS*/
            ChampionDetailsController cdc = detailsPaneLoader.getController();
            cdc.setDisplayName(userSearch);

            cdc.setRecommendedSpells();
            //opScraper was passed in at one point

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);

            //Set the scene to the newly created scene from the root which contains the FXML file
            primaryStage.setScene(scene);

            scene.getStylesheets().add(LeagueAssistant.class.getResource("LeagueStyle.css").toExternalForm());

            //Show the stage and display the application
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
}




