package controllers;

import javafx.scene.layout.Region;
import views.LoanView;

public class LoanController {
    private final LoanView view;
    public LoanController(){
        this.view = new LoanView();
    }

    public Region getView(){
        return view.build();
    }
}
