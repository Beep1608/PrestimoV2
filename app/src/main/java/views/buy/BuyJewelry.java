package views.buy;

import javafx.scene.Node;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;
import models.buy.BuyJewelryModel;

public class BuyJewelry implements Builder<Region>{
    private final VBox container = new VBox();
    private final BuyJewelryModel model;
    public BuyJewelry(){
        this.model = new BuyJewelryModel();
    }
    @Override
    public Region build() {
        container.getChildren().addAll(createCaratageOptions());
        return container;
       
    }
private Node createCaratageOptions(){
        ComboBox<String> options = new ComboBox<>();
        options.getItems().addAll("8k","10k","12k","14k","16k","18k","20k","22k","24k");
        options.setMinWidth(100);
        options.setMaxWidth(200);
        options.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                model.caratage_node().set(true);
                switch(newValue){
                    case "8k":
                    model.caratage().set(8);
                    System.out.println( model.caratage().get());
                    break;
                    case "10k":
                    model.caratage().set(10);
                    System.out.println( model.caratage().get());
                    break;
                    case "12k":
                    model.caratage().set(12);
                    System.out.println( model.caratage().get());
                    break;
                    case "14k":
                    model.caratage().set(14);
                    System.out.println( model.caratage().get());
                    break;
                    case "16k":
                    model.caratage().set(16);
                    System.out.println( model.caratage().get());
                    break;
                    case "18k":
                    model.caratage().set(18);
                    System.out.println( model.caratage().get());
                    break;
                    case "20k":
                    model.caratage().set(20);
                    System.out.println( model.caratage().get());
                    break;
                    case "22k":
                    model.caratage().set(22);
                    System.out.println( model.caratage().get());
                    break;
                    case "24k":
                    model.caratage().set(24);
                    System.out.println( model.caratage().get());
                    break;
                    default:
                    model.caratage().set(0);
                    break;
                    
                }
            }
        });
        return options;
    }



    
}