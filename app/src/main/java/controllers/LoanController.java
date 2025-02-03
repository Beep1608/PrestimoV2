package controllers;

import javafx.scene.layout.Region;
import views.BuyView;
import views.LoanView;

public class LoanController {
    private final LoanView view;
    private final CardsOptionController cards;
    public LoanController(){
        this.cards = new CardsOptionController(this::nihao,this::nihao,this::nihao);
        //TODO: Agregar tabla
        this.view  = new LoanView(cards.getView(), new Region());
    }

    private Void nihao(){
        System.out.println("Nihao");
        return null;
    }
    public Region getView(){
        return view.build();
    }
}
