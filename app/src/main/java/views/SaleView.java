package views;


import javafx.scene.layout.Region;
import models.SaleModel;
import views.dashboard.ViewDashboard;

public class SaleView extends ViewDashboard {

    public SaleView(Region cards, Region table, Region electronics, Region whiteGoods, Region jelwelry, SaleModel model){
        super("sale",electronics,whiteGoods,jelwelry,model);
        this.container.getChildren().addAll(cards, table);
    }


}
