package controllers;


import controllers.buy.BuyJewelryController;
import javafx.application.Platform;
import javafx.scene.layout.Region;
import models.BuyModel;
import models.OptionModel.Views;
import views.BuyView;
import views.buy.BuyElectronics;
import views.buy.BuyJewelry;
import views.buy.BuyWhiteGoods;

public class BuyController {

    private final BuyView view;
    private final BuyModel model;
    private final CardsOptionController cards;
    private final BuyJewelryController buyJewelryController;
    public BuyController(){
        this.model =new BuyModel();
        this.buyJewelryController = new BuyJewelryController(this::prev);
        this.cards = new CardsOptionController(model::setCurrentView);
        //TODO: Agregar tabla
        this.view  = new BuyView(cards.getView(), new Region()/*Table */,
        new BuyElectronics().build(), 
        new BuyWhiteGoods().build(), 
        buyJewelryController.getView(),
        model );
        
    
    }
    
    private Void nihao(){
        System.out.println("Nihao");
        return null;
    }
    private Void prev(){
        model.setCurrentView(Views.PARENT);
        return null;
    }

   
    public Region getView(){
        return view.build();
    }
}

