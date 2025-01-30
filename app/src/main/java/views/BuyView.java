package views;

import core.ResourceLoader;
import javafx.scene.Node;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;
import views.utils.Responsive;

public class BuyView implements Builder<Region> {
    private final VBox container;
    
    public BuyView(){
        this.container =  new VBox();
        this.container.getStylesheets().add(ResourceLoader.load("/css/buy/buy.css"));
    }

    @Override
    public Region build() {
        
        return (Region)createMainContainer();
    }

    private Node createMainContainer(){

    
       container.getStyleClass().add("container");

    
        
        return container;
    }

    
}
