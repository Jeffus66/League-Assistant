package Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import Application.*;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ChampionSearchController {



    public ChampionSearchController(){

    }
    @FXML private TextField champEntry;
    @FXML private TextField positionEntry;
    @FXML private Button searchButton;
    @FXML private Search userSearch;
    @FXML private Stage tempStage;

    private LeagueAssistant leagueAssistant;

    @FXML
    private void handleSearchClick(ActionEvent e){
        String champInput = champEntry.getText().toLowerCase();
        String champPos = positionEntry.getText().toLowerCase();

        Search userSearch = new Search(champInput,champPos);

        this.tempStage = this.leagueAssistant.getPrimaryStage();

        System.out.println(userSearch);

        leagueAssistant.initDetailsLayout(userSearch,tempStage);
    }


    public void setLeagueAssistant(LeagueAssistant leagueAssistant){
        this.leagueAssistant = leagueAssistant;
    }
}
