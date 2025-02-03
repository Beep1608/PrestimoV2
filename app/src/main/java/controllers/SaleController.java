package controllers;

import javafx.scene.layout.Region;
import views.BuyView;
import views.SaleView;

public class SaleController {
    private final SaleView view;
    private final CardsOptionController cards;
    public SaleController(){
        this.cards = new CardsOptionController(this::nihao,this::nihao,this::nihao);
        //TODO: Agregar tabla
        this.view  = new SaleView(cards.getView(), new Region());
    }
    private Void nihao(){
        System.out.println("Nihao");
        return null;
    }
    public Region getView(){
        return view.build();
    }
}
