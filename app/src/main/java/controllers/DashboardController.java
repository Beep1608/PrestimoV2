package controllers;

import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Function;


import javafx.concurrent.Task;
import javafx.scene.layout.Region;
import models.DashboardModel;
import models.DashboardModel.Views;
import views.DashboardView;

public class DashboardController {

    private final DashboardView view;
    private final DashboardModel model;
    private final BuyController buyController;
    private final LoanController loanController;
    private final SaleController saleController;
    private final HashMap<String,Function<?,?>> service = new HashMap<>(); 


    public DashboardController(){
        this.buyController = new BuyController();
        this.model = new DashboardModel();
        this.loanController = new LoanController();
        this.saleController = new SaleController();
        buyController.getView().visibleProperty().bind(model.buyProperty());
        loanController.getView().visibleProperty().bind(model.loanProperty());
        saleController.getView().visibleProperty().bind(model.saleProperty());
        
        service.put("showView", this::showView);

        this.view = new DashboardView(
            buyController.getView(),
            loanController.getView(),
            saleController.getView(),
            service

        );
        
    }
    
    public Region getView(){
        return view.build();
    }



    private Void showView(Object view){
        
        switch (view) {
            case Views.BUY:
                changePropertiesViews(true, false, false);
                break;
            case Views.LOAN:
                changePropertiesViews(false, true, false);
                break;
            case Views.SALE:
                changePropertiesViews(false, false, true);
                break;
            default:
                changePropertiesViews(false, false, false);
                break;
        }

        return null;
    }   

    private void changePropertiesViews(boolean buy, boolean loan, boolean sale){
        try{
            model.buyProperty().set(buy);
            model.loanProperty().set(loan);
            model.saleProperty().set(sale);
        }catch(Exception e){
            System.err.println("Lo sentimos hubo un error : "+ e.getStackTrace());
        }
    
    }
}
