package views;


import javafx.scene.layout.Region;
import models.LoanModel;
import views.dashboard.ViewDashboard;

public class LoanView extends ViewDashboard {

    public LoanView(Region cards, Region table, Region electronics, Region whiteGoods, Region jelwelry, LoanModel model){
       super("loan",electronics,whiteGoods,jelwelry,model);
       this.container.getChildren().addAll(cards, table);
    }

}
