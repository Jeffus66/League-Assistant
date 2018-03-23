package Application;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Search {

    private final StringProperty champName;
    private final StringProperty champPosition;


    public Search(String champName, String champPositon){

        this.champName = new SimpleStringProperty(champName);
        this.champPosition = new SimpleStringProperty(champPositon);

    }

    public String getChampName() {
        return champName.get();
    }

    public void setChampName(String champName) {
        this.champName.set(champName);
    }

    public StringProperty champNamePropertyProperty() {
        return champName;
    }

    public String getChampPosition() {
        return champPosition.get();
    }

    public void setChampPosition(String champPosition) {
        this.champPosition.set(champPosition);
    }

    public StringProperty champPositionPropertyProperty() {
        return champPosition;
    }
}
