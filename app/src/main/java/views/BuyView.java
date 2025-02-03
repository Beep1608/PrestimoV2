package views;


import javafx.scene.layout.Region;
import views.dashboard.ViewDashboard;


public class BuyView extends ViewDashboard {
    
    public BuyView(Region cards, Region table){
        super("buy");
        this.container.getChildren().addAll(cards, table);
        
    }

 

    
}
