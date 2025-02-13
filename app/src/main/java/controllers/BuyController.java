package controllers;

import controllers.buy.BuyJewelryController;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.layout.Region;
import models.BuyModel;
import views.BuyView;
import views.buy.BuyElectronics;
import views.buy.BuyJewelry;
import views.buy.BuyWhiteGoods;

public class BuyController {

    private final BuyView view;
    private final BuyModel model;
    private final CardsOptionController cards;
    private final BuyJewelryController buyJewelryController;
    private final StringProperty searchText = new SimpleStringProperty("");
    public BuyController(){
        this.model =new BuyModel();
        this.buyJewelryController = new BuyJewelryController();
        this.cards = new CardsOptionController(model::setCurrentView);
        //TODO: Agregar tabla
        this.view  = new BuyView(cards.getView(), new Region()/*Table */,
        new BuyElectronics().build(), 
        new BuyWhiteGoods().build(), 
        buyJewelryController.getView(),
        model,
        searchText);
        
    
    }
    
    private Void nihao(){
        System.out.println("Nihao");
        return null;
    }

   
    public Region getView(){
        return view.build();
    }
}

