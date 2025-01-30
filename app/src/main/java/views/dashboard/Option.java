package views.dashboard;

import core.ResourceLoader;
import javafx.animation.FillTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class Option {

    private final Text text;
    private final ImageView icon;
    private final Font font = new Font("Roboto",15);
    private final double widthContainerText = 100;
    private final double widthContainerIcon = 50;
    private final double height = 50;
    private final double width = 200;
    private final HBox container =new HBox();
    private final String resource;
    private final String selectedResource;
    public Option(String text, String resource, String selectedResource){
        this.text = new Text(text);
        this.resource =resource;
        this.selectedResource = selectedResource;
        this.icon = makeIcon(this.resource);
        this.container.getStylesheets().add(ResourceLoader.load("/css/dashboard/option.css"));
    }

    private ImageView makeIcon(String resource){
         Image image = new Image(ResourceLoader.load("/images/dashboard/"+resource), 
        24, 
        24,
         true, 
         true);
         return new ImageView(image);
    }
    public Node createOption(){
        text.setFont(font);
        HBox containerText = new HBox(text);
        containerText.setPrefWidth(widthContainerText); 
        containerText.setPrefHeight(height);
        containerText.setAlignment(Pos.CENTER_LEFT);

        HBox containerIcon = new HBox(icon);
        containerIcon.setPrefWidth(widthContainerIcon);
        containerIcon.setPrefHeight(height);
        containerIcon.setAlignment(Pos.CENTER);
        
    


        HBox innerContainer = new HBox(containerIcon,containerText);
        container.setOnMouseEntered(event ->{
           
            containerIcon.getChildren().clear();
            containerIcon.getChildren().add(makeIcon(selectedResource));
            text.setFill(Color.WHITE);
        });
        container.setOnMouseExited(event -> {
            containerIcon.getChildren().clear();
            containerIcon.getChildren().add(makeIcon(resource));
            text.setFill(Color.BLACK);
        });
      container.getStyleClass().add("container");
       this.container.getChildren().clear();
       this.container.getChildren().add(innerContainer);
       container.setPrefWidth(width);
        return container;

    }

    

    
}
