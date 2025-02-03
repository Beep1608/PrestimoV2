package views.dashboard;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringPropertyBase;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import views.utils.ResourceLoader;
import views.utils.Responsive;

public class TopBar {
    private final double height = 60;
    private final HBox container;
    private final SimpleStringProperty currentView  = new SimpleStringProperty();
    public TopBar(){
        this.container = new HBox();
        container.getStylesheets().add(ResourceLoader.load("/css/dashboard/topbar.css"));
    }

    public Node createTopBar(){
       container.getStyleClass().add("container");
       container.setPrefHeight(height);
       
      
       HBox searchBar =(HBox) new SearchBar().createSearchBar();
       container.getChildren().addAll(createTitleContainer(),searchBar);
       container.setHgrow(searchBar, Priority.ALWAYS);

       //container.setSpacing(200);
       
        return container;
    }

    private Node createTitleContainer(){
        Text title = new Text();
        title.textProperty().bind(currentView);
        title.setFont(new Font("Roboto", 25));
        title.setFill(Color.rgb(72, 76, 82));
        HBox container = new HBox(title);
        container.setPrefHeight(height);
        Responsive.bindingToParentWidth(container, 0.15);
        container.getStyleClass().add("title-container");
        container.setAlignment(Pos.CENTER);
        return container;
    }

    public StringPropertyBase currentView(){
        return currentView;
    }
    
}
