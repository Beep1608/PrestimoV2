package controllers;

import javafx.scene.layout.Region;
import models.SaleModel;
import views.BuyView;
import views.SaleView;
import views.sale.SaleElectronics;
import views.sale.SaleJelwelry;
import views.sale.SaleWhiteGoods;

public class SaleController {
    private final SaleView view;
    private final CardsOptionController cards;
    private final SaleModel model;
    public SaleController(){
        this.model = new SaleModel();
        this.cards = new CardsOptionController(model::setCurrentView);
        //TODO: Agregar tabla
        this.view  = new SaleView(cards.getView(), new Region()/*Table */,
        new SaleElectronics().build(), new SaleWhiteGoods().build(), new SaleJelwelry().build(), model);
    }
    private Void nihao(){
        System.out.println("Nihao");
        return null;
    }
    public Region getView(){
        return view.build();
    }
}
