package controllers;

import controllers.buy.BuyJewelryController;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.layout.Region;
import models.BuyModel;
import views.BuyView;
import views.buy.BuyElectronics;
import views.buy.BuyWhiteGoods;

public class BuyController {

    private final BuyView view;
    private final BuyModel model;
    private final CardsOptionController cards;
    private final BuyJewelryController buyJewelryController;
    private final ObservableList<BuyModel> items = FXCollections.observableArrayList(); 

    public BuyController(StringProperty searchText){
        this.model =new BuyModel();
        this.buyJewelryController = new BuyJewelryController();
        this.cards = new CardsOptionController(model::setCurrentView);
        
        this.view  = new BuyView(
            cards.getView(),
            new BuyElectronics().build(), 
            new BuyWhiteGoods().build(), 
            buyJewelryController.getView(),
            model,
            searchText,
            items
            );

        loadData();
        
    
    }
    
    private Void nihao(){
        System.out.println("Nihao");
        return null;
    }

   
    public Region getView(){
        return view.build();
    }

    /**
     * Carga los datos de la tabla de compras de metales en la lista observable.
     * Los datos se obtienen mediante el método getBuyData() del modelo.
     */
    private void loadData() {
        items.setAll(model.getBuyData()); // Método que obtiene datos de BD o servicio
    }

}

