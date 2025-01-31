package views.dashboard;


import core.ResourceLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import views.utils.Responsive;

public class SideBar {
    private final VBox container = new VBox();
    private final double width = 0.15;
    private final double height = 1;
    public SideBar(Node ...childrens){
        for (Node node : childrens) {
            container.getChildren().add(node);
        }
        container.getStylesheets().add(ResourceLoader.load("/css/dashboard/sidebar.css"));
        container.getStyleClass().add("container");
    }

    public Node createSideBar(){
        Responsive.bindingToParent(container, width, height);
             container.setPadding(new Insets(10, 10, 10, 10));
        container.setSpacing(10);
        return container;
    }
    
}
