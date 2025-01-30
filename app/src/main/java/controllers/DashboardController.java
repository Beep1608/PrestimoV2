package controllers;

import javafx.concurrent.Task;
import javafx.scene.layout.Region;
import models.DashboardModel;
import views.DashboardView;

public class DashboardController {

    private final DashboardView view;
    private final DashboardModel model;
    private final BuyController buyController;
    private final LoanController loanController;
    private final SaleController saleController;


    public DashboardController(){
        this.buyController = new BuyController();
        this.model = new DashboardModel();
        this.loanController = new LoanController();
        this.saleController = new SaleController();
        buyController.getView().visibleProperty().bind(model.buyProperty());
        loanController.getView().visibleProperty().bind(model.loanProperty());
        saleController.getView().visibleProperty().bind(model.saleProperty());

        this.view = new DashboardView(
            buyController.getView(),
            loanController.getView(),
            saleController.getView()

        );
        
    }
    
    public Region getView(){
        return view.build();
    }

    private void buyView(){
        Task<Void> openView=new Task<Void>() {

            @Override
            protected Void call() throws Exception {

                

                return null;
            }
           

        };
    }
}
