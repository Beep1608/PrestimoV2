package views;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.util.Builder;
import views.utils.ResourceLoader;
import views.utils.Responsive;

public class CardOptionView implements Builder<Region> {
    private final VBox container;
    private final String resource;
    private final String description;
    private final String title;
    public CardOptionView(double width, double height, String resource, String title,String description){

        this.container = new VBox();
        //this.container.getStylesheets().add(ResourceLoader.load("/css/dashboard/cards/card.css"));
        this.container.getStyleClass().add("card");
        this.container.setPrefWidth(width);
        this.container.setPrefHeight(height);
        this.resource = resource;
        this.description = description;
        this.title = title;
        Responsive.bindingToParentWidth(this.container, 0.3333);
        createCard();
    }

    @Override
    public Region build() {
        container.setAlignment(Pos.CENTER);
        
        return container;
    }


    private void createCard(){

        container.getChildren().addAll(createIcon(),createDescription());
        
    }


    private Node createIcon(){
        ImageView icon = ResourceLoader.makeIcon(resource, 64);
        VBox contianer = new VBox();
        contianer.getChildren().add(icon);
        contianer.setAlignment(Pos.CENTER);
        contianer.getStyleClass().add("icon-container");
        Responsive.bindingToParent(contianer, 0.5);
        
        return contianer;
    }
    private Node createDescription(){
        VBox contianer = new VBox();
        Label title = new Label(this.title);
        title.setFont(new Font("Roboto",15));
        title.getStyleClass().add("title");
        Label description = new Label(this.description);
        description.setFont(new Font("Roboto",10));
        description.getStyleClass().add("description");
        description.setWrapText(true);
        contianer.getChildren().addAll(title,description);
        contianer.getStyleClass().add("description-container");
        contianer.setSpacing(15);
        Responsive.bindingToParent(contianer, 0.5);
        return contianer;
    }
    
}