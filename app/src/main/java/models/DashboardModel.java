package models;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

public class DashboardModel {
    private final SimpleBooleanProperty buyProperty = new SimpleBooleanProperty();
    private final SimpleBooleanProperty loanProperty = new SimpleBooleanProperty();
    private final SimpleBooleanProperty saleProperty = new SimpleBooleanProperty();
    

    public DashboardModel(){
        buyProperty.set(true);
        loanProperty.set(false);
        saleProperty.set(false);
    }

    public BooleanProperty buyProperty(){

        return buyProperty;
    }

    public BooleanProperty loanProperty(){

        return loanProperty;
    }
    
    public BooleanProperty saleProperty(){

        return saleProperty;
    }


  
    
    
}
