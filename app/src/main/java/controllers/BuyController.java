package controllers;

import javafx.scene.layout.Region;
import views.BuyView;

public class BuyController {

    private final BuyView view;
    private final CardsOptionController cards;
    public BuyController(){
        this.cards = new CardsOptionController(this::nihao,this::nihao,this::nihao);
        //TODO: Agregar tabla
        this.view  = new BuyView(cards.getView(), new Region());
    
    }
    
    private Void nihao(){
        System.out.println("Nihao");
        return null;
    }
    public Region getView(){
        return view.build();
    }
}

