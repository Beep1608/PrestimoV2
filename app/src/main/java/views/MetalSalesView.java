package views;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;
import models.local.MetalSales;
import views.components.TableComponent;
import views.utils.ResourceLoader;
import views.utils.Responsive;

import java.util.HashMap;       
import java.util.function.Consumer;

public class MetalSalesView implements Builder<Region> {
    private final MetalSales model;
    private final TableComponent<MetalSales> tableComponent;
    private final StringProperty searchText;
    private final ObservableList<MetalSales> items;
    
    public MetalSalesView(MetalSales model, 
                         HashMap<String, Consumer<Runnable>> map, 
                         StringProperty searchText, 
                         ObservableList<MetalSales> items) {
        this.model = model;
        this.searchText = searchText;
        this.items = items;

        this.tableComponent = new TableComponent<>(
            items,
            searchText,
            this::configureColumns
        );
        
        configureTable();
    }

    

    @Override
    public Region build() {
        VBox root = new VBox(tableComponent);
        root.setSpacing(20);
        root.setPadding(new Insets(20));
        root.getStylesheets().add(ResourceLoader.load("/css/dashboard/views/metal.css"));
        root.getStyleClass().add("metal-sales-view");
        Responsive.bindingToParent(root, 1, 1);

        loadSalesData();
        return root;
    }

    private Void configureColumns(TableComponent<MetalSales> table) {
        table.addColumn("ID", cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().idProperty().get()));
        // table.addColumn("Fecha", cellData -> cellData.getValue().getFechaHoraProperty());
        // table.addColumn("Total", cellData -> cellData.getValue().getMontoProperty().asObject());
        return null;
    }

    private void configureTable() {
        // Listener para cambios en el texto de búsqueda
        searchText.addListener((observable, oldValue, newValue) -> {
            updateFilter(newValue);
        });
        // Filtro inicial
        updateFilter(searchText.get());
    }

    private void updateFilter(String search) {
        tableComponent.setFilter(compra -> {
            if (search == null || search.isEmpty()) return true;
            
            try {
                int searchId = Integer.parseInt(search);
                return compra.idProperty().get() == searchId;
            } catch (NumberFormatException e) {
                return false;
            }
        });
    }

    public void loadSalesData() {
        items.setAll(model.getMetalSalesList());
    }
}
