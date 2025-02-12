package views;


import javafx.scene.layout.Region;
import models.BuyModel;
import views.dashboard.ViewDashboard;


public class BuyView extends ViewDashboard {
   
    public BuyView(Region cards, Region table , Region electronics, Region whiteGoods, Region jelwelry, BuyModel model){
        super("buy",cards,table,electronics,whiteGoods,jelwelry,model);
        this.container.getChildren().addAll(cards, table);
        
    }
    

 

    
}
