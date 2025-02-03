package views;


import javafx.scene.layout.Region;
import views.dashboard.ViewDashboard;

public class LoanView extends ViewDashboard {

    public LoanView(Region cards, Region table){
       super("loan");
       this.container.getChildren().addAll(cards, table);
    }

}
