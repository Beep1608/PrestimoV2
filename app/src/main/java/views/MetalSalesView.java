package views;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.util.Builder;
import models.local.MetalSales;
import views.utils.ResourceLoader;
import views.utils.Responsive;

import java.util.HashMap;
import java.util.function.Consumer;

public class MetalSalesView implements Builder<Region> {
    private final MetalSales model;
    private final HashMap<String, Consumer<Runnable>> map;
    private final ObservableList<MetalSales> comprasList;
    private final FilteredList<MetalSales> filteredComprasList;
    private final StringProperty searchText;
    private TableView<MetalSales> salesTable;

    public MetalSalesView(MetalSales model, HashMap<String, Consumer<Runnable>> map, StringProperty searchText) {
        this.model = model;
        this.map = map;
        this.searchText = searchText;
        
        // Inicializar las listas
        this.comprasList = FXCollections.observableArrayList();
        this.filteredComprasList = new FilteredList<>(comprasList);
        
        // Configurar el filtrado reactivo
        this.searchText.addListener((observable, oldValue, newValue) -> filterTable(newValue));
    }

    @Override
    public Region build() {
        VBox root = new VBox(createSalesTable());
        root.setSpacing(20);
        root.setPadding(new Insets(20));
        root.getStylesheets().add(ResourceLoader.load("/css/dashboard/views/metal.css"));
        root.getStyleClass().add("metal-sales-view");
        Responsive.bindingToParent(root, 1, 1);

        loadSalesData();
        return root;
    }

    @SuppressWarnings("unchecked")
    private Node createSalesTable() {
        salesTable = new TableView<>();
        salesTable.setItems(filteredComprasList);  // Usar la lista filtrada

        // Configurar columnas
        TableColumn<MetalSales, Number> idColumn = new TableColumn<>("ID");
        idColumn.setMinWidth(100);
        idColumn.setCellValueFactory(cellData -> cellData.getValue().getIdProperty());

        TableColumn<MetalSales, String> dateColumn = new TableColumn<>("Fecha");
        dateColumn.setMinWidth(300);
        dateColumn.setCellValueFactory(cellData -> cellData.getValue().getFechaHoraProperty());

        TableColumn<MetalSales, Number> totalColumn = new TableColumn<>("Total");
        totalColumn.setMinWidth(300);
        totalColumn.setCellValueFactory(cellData -> cellData.getValue().getMontoProperty());

        salesTable.getColumns().addAll(idColumn, dateColumn, totalColumn);
        return salesTable;
    }

    public void loadSalesData() {
        comprasList.setAll(model.getMetalSalesList());  // Cargar datos desde el modelo
        filterTable(searchText.get());  // Aplicar filtro inicial
    }

    private void filterTable(String searchText) {
        filteredComprasList.setPredicate(compra -> {
            if (searchText == null || searchText.isEmpty()) {
                return true;
            }
            
            try {
                int searchId = Integer.parseInt(searchText);
                return compra.getIdProperty().get() == searchId;
            } catch (NumberFormatException e) {
                return false;
            }
        });
    }

    public ObservableList<MetalSales> getSalesTable() {
        return comprasList;
    }
}
