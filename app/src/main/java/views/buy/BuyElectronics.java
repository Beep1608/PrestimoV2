package views.buy;

import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;
import views.utils.ResourceLoader;
import views.utils.Responsive;

public class BuyElectronics implements Builder<Region>{
    private final VBox container = new VBox();

    /**TODO: Interfaz de compra de electronicos */
    @Override
    public Region build() {
        container.getStylesheets().add(ResourceLoader.load("/css/buy/electronics.css"));
        container.getStyleClass().add("view");
        Responsive.bindingToParent(container, 1);
        return container;
       
    }
    
}