package views.dashboard;

import javafx.geometry.Pos;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;
import models.OptionModel;
import models.OptionModel.Views;
import views.utils.ResourceLoader;

public abstract class ViewDashboard  implements  Builder<Region>   {
     protected final VBox container;
     private final Region electroncis;
     private final Region whiteGoods;
     private final Region jelwelry;
     private final OptionModel model;
     private final Region cards;
     private final Region table;

     public ViewDashboard(String styleSheet,Region cards, Region table ,Region electronics, Region whiteGoods, Region jelwelry, OptionModel model){
        this.container = new VBox();
        this.container.getStylesheets().add(ResourceLoader.load("/css/dashboard/views/"+styleSheet+".css"));
        this.container.getStyleClass().add("container");
        this.container.setAlignment(Pos.CENTER);
        this.electroncis = electronics;
        this.whiteGoods = whiteGoods;
        this.jelwelry = jelwelry;
        this.cards = cards;
        this.table = table;
        this.model = model;
        this.model.currentViewProperty().addListener((obs, oldView, newView) -> switchRightView(getViewByType(newView)));
     }

     @Override
    public Region build() {
       return container;
    }


         /**
     * Cambia la vista activa en el contenedor de contenido.
     *
     * @param activeView La nueva vista activa.
     */
    protected void switchRightView(Region activeView) {
        if(activeView == null){
            container.getChildren().setAll(cards,table);
        
        }else{
            container.getChildren().setAll(activeView);
        }
    }

    /**
     * Obtiene la vista correspondiente a un tipo específico.
     *
     * @param view Tipo de vista a obtener.
     * @return La vista correspondiente al tipo indicado.
     */
    protected Region getViewByType(Views view) {
        return switch (view) {
            case ELECTRONICS -> electroncis;
            case WHITEGOODS -> whiteGoods;
            case JELWERY -> jelwelry;
            case PARENT -> null;
        };
    }

    /**
     * Cambia la vista activa en el modelo del dashboard.
     *
     * @param view La vista a mostrar.
     */
    protected void showView(Views view) {
        model.setCurrentView(view);
    }


}
