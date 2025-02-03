package views.dashboard;

import javafx.geometry.Pos;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;
import views.utils.ResourceLoader;

public abstract class ViewDashboard  implements  Builder<Region>   {
     protected final VBox container;

     public ViewDashboard(String styleSheet){
        this.container = new VBox();
        this.container.getStylesheets().add(ResourceLoader.load("/css/dashboard/views/"+styleSheet+".css"));
        this.container.getStyleClass().add("container");
        this.container.setAlignment(Pos.CENTER);
     }

     @Override
    public Region build() {
       return container;
    }
}
