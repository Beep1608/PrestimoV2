package controllers;

import javafx.scene.layout.Region;
import models.LoanModel;
import views.BuyView;
import views.LoanView;
import views.loan.LoanElectronics;
import views.loan.LoanJelwelry;
import views.loan.LoanWhiteGoods;

public class LoanController {
    private final LoanView view;
    private final CardsOptionController cards;
    private final LoanModel model;
    public LoanController(){
        this.model= new LoanModel();
        this.cards = new CardsOptionController(model::setCurrentView);
        
        //TODO: Agregar tabla
        this.view  = new LoanView(cards.getView(), new Region()/*Table */,
        new LoanElectronics().build(), new LoanWhiteGoods().build(), new LoanJelwelry().build(),model);
    }

    private Void nihao(){
        System.out.println("Nihao");
        return null;
    }
    public Region getView(){
        return view.build();
    }
}
