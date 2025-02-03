package views;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.util.Builder;
import views.utils.ResourceLoader;

public class CardsOptionView implements Builder<Region> {
    private final HBox container = new HBox();
    private final double maxWidth = 700;
    private final double maxHeight = 250;
    

    private final Region electronics;
    private final Region whiteGoods;
    private final Region jewelry;
    public CardsOptionView(Region electroncis, Region whiteGoods, Region jewelry ){
        this.electronics = electroncis;
        this.whiteGoods = whiteGoods;
        this.jewelry = jewelry;
        this.container.getChildren().addAll(this.electronics,this.whiteGoods, this.jewelry);
        this.container.setSpacing(5);
        this.container.getStylesheets().add(ResourceLoader.load("/css/dashboard/cards/cards.css"));
        this.container.getStyleClass().add("cards-container");
        this.container.setMaxWidth(maxWidth);
        this.container.setMaxHeight(maxHeight);
        this.container.setPrefHeight(maxHeight);
    }

    @Override
    public Region build() {
        
        return container;
    }
    
}
