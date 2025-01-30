package controllers;

import javafx.scene.layout.Region;
import views.BuyView;

public class BuyController {

    private final BuyView view;

    public BuyController(){
        this.view  = new BuyView();
    }
    
    public Region getView(){
        return view.build();
    }
}

