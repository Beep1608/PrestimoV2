package views;


import javafx.beans.property.StringProperty;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import models.BuyModel;
import views.dashboard.ViewDashboard;


public class BuyView extends ViewDashboard {
   private TableView<BuyModel> salesTable;

    public BuyView(Region cards, Region table , Region electronics, Region whiteGoods, Region jelwelry, BuyModel model, StringProperty searchText) {
        super("buy",electronics,whiteGoods,jelwelry,model);
        this.container.getChildren().addAll(cards, table);
        
    }
    

 

    
}
