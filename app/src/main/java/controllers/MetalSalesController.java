package controllers;


import java.util.HashMap;
import java.util.function.Consumer;

import javafx.concurrent.Task;
import javafx.scene.layout.Region;
import javafx.util.Builder;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import models.local.MetalSales;
import views.MetalSalesView;


public class MetalSalesController {
    private final Builder<Region> metalSalesView;
    private final MetalSales model;
    private final ObservableList<MetalSales> items = FXCollections.observableArrayList();

    public MetalSalesController(StringProperty searchText) {
        this.model = new MetalSales();
        this.metalSalesView = new MetalSalesView(
            model, 
            new HashMap<>(), 
            searchText, 
            items  // Pasa la lista observable
        );
    }

    public Region getView() {
        return metalSalesView.build();
    }

    public void loadSalesData() {
        items.setAll(model.getMetalSalesList());  // Actualiza la lista observable
    }
}
