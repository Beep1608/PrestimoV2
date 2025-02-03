package views.buy;

import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;

public class BuyJelwelry implements Builder<Region>{
    private final VBox container = new VBox();

    @Override
    public Region build() {
        return container;
       
    }
    
}