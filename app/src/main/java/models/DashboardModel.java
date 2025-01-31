package models;

import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ObservableBooleanValue;

public class DashboardModel {
    private final SimpleBooleanProperty buyProperty = new SimpleBooleanProperty();
    private final SimpleBooleanProperty loanProperty = new SimpleBooleanProperty();
    private final SimpleBooleanProperty saleProperty = new SimpleBooleanProperty();
    private final SimpleBooleanProperty viewMetalSales= new SimpleBooleanProperty();

    public DashboardModel(){
        buyProperty.set(false);
        loanProperty.set(false);
        saleProperty.set(false);
        viewMetalSales.set(false);
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

    public ObservableBooleanValue getSaleMetalProperty(){
        return this.viewMetalSales;
    }

    public void setSaleMetalProperty(boolean value){
        this.viewMetalSales.set(value);
    }
  
   public static enum Views{
        BUY,
        LOAN,
        SALE
    }
    
}
