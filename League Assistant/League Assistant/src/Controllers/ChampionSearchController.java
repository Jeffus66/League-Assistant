package Controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import Application.*;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;



public class ChampionSearchController {



    public ChampionSearchController(){

    }

    //Create JavaFX objects that are bound to the corresponding FXML file
    @FXML private TextField champEntry;
    @FXML private TextField positionEntry;
    @FXML private Button searchButton;



    //Create a search and stage object to contain passed in references
    //@FXML private Search userSearch;
    @FXML private Stage tempStage;

    //Not sure if I need @FXML here. Purpose is the same as above
    private LeagueAssistant leagueAssistant;


    @FXML
    private void initialize(){
        positionEntry.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                if(event.getCode().equals(KeyCode.ENTER) && (positionEntry.getText().length() > 0)){
                    switchView();
                }
            }
        });
    }
    //Method handles switching views when the search button is pressed
    @FXML
    private void handleSearchClick(ActionEvent e){
        if(!(champEntry.getText().length() == 0)) {
            switchView();
        }
    }

    private void switchView(){
        //Storing the entered champ and position as a regular sting
        String champInput = champEntry.getText().toLowerCase();
        String champPos = positionEntry.getText().toLowerCase();



        //Creating new search object to hold the champ name and position. Pass it to the main app using the reference stored in this.leagueAssistant
        Search userSearch = new Search(champInput,champPos);

        //Setting the controller stage reference to the main app stage
        this.tempStage = this.leagueAssistant.getPrimaryStage();

        //using the app object to draw the details view. Pass in userSearch to give the method the ability to send the object reference to the next controller
        leagueAssistant.initDetailsLayout(userSearch,tempStage);
    }

    //This method sets the local leagueAssistant object to the mainApps object
    public void setLeagueAssistant(LeagueAssistant leagueAssistant){
        this.leagueAssistant = leagueAssistant;
    }
}
