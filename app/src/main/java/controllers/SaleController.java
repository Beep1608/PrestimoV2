package controllers;

import javafx.scene.layout.Region;
import views.SaleView;

public class SaleController {
    private final SaleView view;
    public SaleController(){
        this.view = new SaleView();
    }
    public Region getView(){
        return view.build();
    }
}
