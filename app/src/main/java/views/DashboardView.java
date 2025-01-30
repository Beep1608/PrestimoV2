package views;

import core.ResourceLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Builder;
import views.dashboard.Option;
import views.dashboard.SideBar;
import views.dashboard.TopBar;
import views.utils.Responsive;

public class DashboardView implements Builder<Region> {

    private final Region buyView ;
    private final Region loanView ;
    private final Region saleView ;


    public DashboardView(Region buyView, Region loanView, Region saleView ){
        this.buyView = buyView;
        this.loanView = loanView;
        this.saleView = saleView;
    }

    private Node mainContainer(){
        HBox container = new HBox(
            createSideBar(),
            createContentContainer()
        );
        container.getStylesheets().add(ResourceLoader.load("/css/dashboard/dashboard.css"));
        container.getStyleClass().add("container");
        container.setPadding(new Insets(10,10,10,10));

        return container;
    }

    private Node createSideBar(){

        VBox container =(VBox) new SideBar(
            new Option("Compra", "shopping-cart.png","shopping-cart-h.png").createOption(),
           new Option("Prestamo", "loan.png","loan-h.png").createOption(),
           new Option("Venta", "price-tag.png","price-tag-h.png").createOption()
        ).createSideBar();
   
        return container;
    }
    
    private Node createContentContainer(){
       VBox innerContentContainer =  new VBox(
            new TopBar().createTopBar(),
            createContent()
        );
        Responsive.bindingToParentWidth(innerContentContainer, 1);
        HBox contentContainer = new HBox(innerContentContainer); 
        contentContainer.setHgrow(contentContainer, Priority.ALWAYS);

        contentContainer.getStyleClass().add("content");
        contentContainer.setPadding(new Insets(0, 0, 0, 15));

        return contentContainer;
    }

    private Node createContent(){
        StackPane container = new StackPane();
        Responsive.bindingToParent(container, 1, 1);
        container.getChildren().addAll(buyView,loanView,saleView);



        return container;
    }

  

    @Override
    public Region build() {
       
        return (Region) mainContainer();
    }
    
}
