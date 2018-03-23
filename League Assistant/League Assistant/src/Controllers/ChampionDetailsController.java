package Controllers;

import Application.Search;
import Scrapers.Opgg;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.apache.commons.lang3.StringUtils;
import java.io.IOException;

public class ChampionDetailsController {

    //Create JavaFX objects that are bound to the corresponding FXML file
    @FXML
    private Label displayName;
    @FXML
    private Label displayPosition;
    @FXML
    private ImageView summonerSpellOne;
    @FXML
    private ImageView summonerSpellTwo;
    @FXML
    private Label summonerPickOne;
    @FXML
    private Label summonerPickTwo;

    private Opgg opScraper;
    StringUtils stringUtils;

    public ChampionDetailsController() throws IOException {
        this.opScraper = new Opgg();

    }

    @FXML
    private void initialize() {

    }
    //TO DO - look at a way to make the connect call only happen once.
    // Otherwise this will be slow as fuck. Could try setting user search on scene creation and not having to pass it into each method.
    public void setDisplayName(Search userSearch) {
        Search tempSearch = userSearch;

        tempSearch = userSearch;

        this.displayName.setText(StringUtils.capitalize(tempSearch.getChampName()));
        this.displayPosition.setText(StringUtils.capitalize(tempSearch.getChampPosition()));
    }

    public void setRecommendedSpells() throws IOException {
        int i = 0;
        String url = "";

            opScraper.connect(this.displayName.getText(),this.displayPosition.getText());
            url = opScraper.getOverviewImages(0);
            Image spellImage = new Image(url);
            this.summonerSpellOne.setImage(spellImage);

            url = opScraper.getOverviewImages(1);
            spellImage = new Image(url);
            this.summonerSpellTwo.setImage(spellImage);


    }

    public void setWinRate(Opgg opgg) throws IOException{


    }
}