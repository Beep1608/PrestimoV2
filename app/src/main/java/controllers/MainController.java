package controllers;

import javafx.scene.layout.Region;
import views.MainView;

public class MainController {
    private final MainView view;
    private final DashboardController dashboardController;

    public MainController(){
        this.dashboardController = new DashboardController();
        this.view = new MainView(
           dashboardController.getView()
        );
    }


    public Region getView(){
        return view.build();
    }
    
}
