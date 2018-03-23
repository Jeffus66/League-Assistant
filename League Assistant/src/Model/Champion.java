package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Champion {

    private final StringProperty champName = new SimpleStringProperty();


    public final StringProperty champNameProperty(){
        return this.champName;
    }

    public final String getChampName(){
        return this.champNameProperty().get();
    }

    public final void setChampName(final String champName){
        this.champNameProperty().set(champName);
    }


    private final StringProperty position = new SimpleStringProperty();

    public final StringProperty positionProperty(){
        return this.position;
    }

    public final String getPosition(){
        return this.positionProperty().get();
    }

    public final void setPosition(final String position){
        this.positionProperty().set(position);
    }

    public Champion(String name, String position){
        setChampName(name);
        setPosition(position);
    }
}
