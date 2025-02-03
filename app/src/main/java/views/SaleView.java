package views;


import javafx.scene.layout.Region;
import views.dashboard.ViewDashboard;

public class SaleView extends ViewDashboard {

    public SaleView(Region cards, Region table){
        super("sale");
        this.container.getChildren().addAll(cards, table);
    }


}
