package views.buy;

import java.util.HashMap;
import java.util.function.Supplier;


import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SkinBase;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;
import models.buy.BuyJewelryModel;
import views.utils.ResourceLoader;
import views.utils.Responsive;

public class BuyJewelry implements Builder<Region>{
    private final VBox container = new VBox();
    private final BuyJewelryModel model;
    private final HashMap<String, Supplier<Void>> services;
    public BuyJewelry(BuyJewelryModel model,HashMap<String, Supplier<Void>> services){
        this.model = model;
        this.services = services;
        this.container.getStylesheets().add(ResourceLoader.load("/css/buy/jewelry.css"));
    }
    @Override
    public Region build() {
        container.getChildren().addAll(createMainContainer() );
        Responsive.bindingToParent(container, 1);
        
        return container;
       
    }

    private Node createMainContainer(){
        HBox container = new HBox(createMainLeftContainer(), createMainRightContainer());

        return container;
    }

   
    private Node createMainRightContainer(){
        // TODO: Implementar vista para las imagenes
        VBox container = new VBox();
        Responsive.bindingToParentWidth(container, 0.5);
        container.getStyleClass().add("main-right");
        return container;
    }

    private Node createMainLeftContainer(){
        VBox container = new VBox(createMetalsOptions(), createWeightContainer());
        Responsive.bindingToParentWidth(container, 0.5);
        container.setPadding(new Insets(100, 15, 0, 40));
        container.getStyleClass().add("main-left");
        container.setSpacing(50);

        return container;
    }

    private Node createOptionsContainer(){
        HBox container = new HBox(createMetalsOptions());
        container.setAlignment(Pos.CENTER);
        container.setSpacing(600);
        return container;
    }

    private Node createMetalsOptions(){
        ComboBox<String> options = new ComboBox<>();
        options.getStyleClass().add("combo-box");
       options.setPromptText("Metal");
        
        options.getItems().addAll("Oro","Plata");
        options.setMinWidth(500);
        options.setMaxWidth(500);
        options.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                model.metal_node().set(false);
                switch(newValue){
                    case "Oro":
                    model.metal().set("Oro");
                    
                    break;
                    case "Plata":
                    model.metal().set("Plata");
                   
                    break;
                    default:
                    model.metal().set("nada");
                    break;
                    
                }
            }
        });
        
        return options;
    }

    private Node createCaratageOptions(){
        ComboBox<String> options = new ComboBox<>();
        options.getStyleClass().add("combo-box");
       options.setPromptText("Kilataje");
        options.getItems().addAll("8k","10k","12k","14k","16k","18k","20k","22k","24k");
        options.setMinWidth(200);
        options.setMaxWidth(300);
        options.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                model.caratage_node().set(false);
                switch(newValue){
                    case "8k":
                    model.caratage().set(8);
                    break;
                    case "10k":
                    model.caratage().set(10);
                    break;
                    case "12k":
                    model.caratage().set(12);
                    break;
                    case "14k":
                    model.caratage().set(14);
                    break;
                    case "16k":
                    model.caratage().set(16);
                    break;
                    case "18k":
                    model.caratage().set(18);
                    break;
                    case "20k":
                    model.caratage().set(20);
                    break;
                    case "22k":
                    model.caratage().set(22);
                    break;
                    case "24k":
                    model.caratage().set(24);
                    break;
                    default:
                    model.caratage().set(0);
                    break;
                    
                }
            }
        });
        options.disableProperty().bind(model.metal_node());
        return options;
    }

    private Node createWeightContainer(){
        VBox container = new VBox(createWeightField_CaratageContainer(),createContianerWeightButtons(),createCalculateButtonContainer());
        Responsive.bindingToParentWidth(container, 1);
        container.setSpacing(10);

        return container;
    }

    private Node createWeightField_CaratageContainer(){
        HBox container = new HBox(createWeightField(), createCaratageOptions());
        container.setSpacing(50);

        return container;
    }

    private Node createWeightField(){
        TextField field = new TextField();
        field.getStyleClass().add("weight-field");
        field.setMinWidth(250);
        field.setMaxWidth(250);
        field.setMinHeight(30);
        field.disableProperty().bind(model.weight_field_node());
        return field;
    }
    private Node createContianerWeightButtons(){
        HBox container = new HBox(createButtonAutomatic(),createButtonManual());
        container.setSpacing(20);
        return container;
    }

    private Node createButtonManual(){
        Button button = new Button("Ingresar peso manual");
        button.setMinWidth(100);
        button.setMinHeight(30);
        button.getStyleClass().add("button-weight");
        button.setOnMouseClicked(evt ->{
            model.weight_field_node().set(false);
        });
        return button;
    }
     private Node createButtonAutomatic(){
        Button button = new Button("Obtener peso automático");
        button.setMinWidth(100);
        button.setMinHeight(30);
        button.getStyleClass().add("button-weight");
        button.setOnMouseClicked(evt ->{
            model.weight_field_node().set(false);
        });
        return button;
    }
    private Node createButtonImages(){
        Button button = new Button("Tomar fotos");

        return button;
    }

    private Node createCalculateButtonContainer(){
        VBox container = new VBox(createCalculateButton());
        container.setPrefHeight(100);
        container.setAlignment(Pos.BOTTOM_LEFT);
        return container;
    }

    private Node createCalculateButton(){
        Button button = new Button("Calcular compra");
        button.setMinWidth(100);
        button.setMinHeight(30);
        button.getStyleClass().add("button-calculate");
       
        return button;
    }



    
}