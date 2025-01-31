package controllers;


import java.util.HashMap;
import java.util.function.Consumer;

import javafx.concurrent.Task;
import javafx.scene.layout.Region;
import javafx.util.Builder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import models.local.MetalSales;
import views.MetalSalesView;


public class MetalSalesController {
    private final Builder<Region> metalSalesView;
    private final MetalSales model;


    public MetalSalesController(){
        this.model = new MetalSales();
        HashMap<String, Consumer<Runnable>> map =new HashMap<String, Consumer<Runnable>>();
        this.metalSalesView = new MetalSalesView(model, map);
    }

    public Region getView() {
        return metalSalesView.build();
    }

    public void loadSalesData() {
        Task<ObservableList<MetalSales>> loadTask = new Task<>() {
            @Override
            protected ObservableList<MetalSales> call() {
                return FXCollections.observableArrayList(model.getMetalSalesList());
            }
        };

        loadTask.setOnSucceeded(e -> {
            ((MetalSalesView) metalSalesView).comprasList.setAll(loadTask.getValue());
        });

        new Thread(loadTask).start();
    }
}
