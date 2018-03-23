package Controllers;

import Application.LeagueAssistant;
import Application.Search;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ChampionDetailsController {

    @FXML
    private Label displayName;
    @FXML
    private Label displayPosition;





    public ChampionDetailsController(){

    }

    @FXML
    private void initialize(){

    }

    //public void setSearch(Search userSearch){
        //this.userSearch = userSearch;
    //}

    public void setDisplayName(String displayName){
        this.displayName.setText(displayName);
        this.displayPosition.setText("HOLY FUCK THIS ONLY TOOK A FEW DAYS");
    }

}
