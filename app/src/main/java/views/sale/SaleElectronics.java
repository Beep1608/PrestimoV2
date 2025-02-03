package views.sale;

import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class SaleElectronics implements Builder<Region>{
    private final VBox container = new VBox();

    @Override
    public Region build() {
        return container;
       
    }
    
}
    