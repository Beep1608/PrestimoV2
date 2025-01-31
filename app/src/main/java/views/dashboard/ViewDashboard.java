package views.dashboard;

import core.ResourceLoader;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public abstract class ViewDashboard  implements  Builder<Region>   {
     private final VBox container;

     public ViewDashboard(String styleSheet){
        this.container = new VBox();
        this.container.getStylesheets().add(ResourceLoader.load("/css/dashboard/views/"+styleSheet+".css"));
        this.container.getStyleClass().add("container");
     }

     @Override
    public Region build() {
       return container;
    }
}
