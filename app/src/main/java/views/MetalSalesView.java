package views;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
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
    public ObservableList<MetalSales> comprasList;
    private javafx.scene.control.TableView<MetalSales> salesTable;
    private TextField searchField; // Campo de búsqueda

    public MetalSalesView(MetalSales model, HashMap<String, Consumer<Runnable>> map){
        this.model = model;
        this.map = map;
        this.comprasList = FXCollections.observableArrayList();
    }

    @Override
    public Region build() {
        VBox root = new VBox(createSearchBar(), createSalesTable());
        root.setSpacing(20);
        root.setPadding(new Insets(20));
        root.getStylesheets().add(ResourceLoader.load("/css/dashboard/views/metal.css"));
        root.getStyleClass().add("metal-sales-view");
        Responsive.bindingToParent(root, 1, 1);

        loadSalesData(); // Cargamos los datos de la tabla
        return root;
    }

    private Node createSearchBar() {
        HBox searchBar = new HBox();
        searchBar.setSpacing(20);

        Label searchLabel = new Label("Buscar por ID:");
        searchField = new TextField();
        searchField.setPromptText("Ingrese el ID de la venta");

        Button searchButton = new Button("Buscar");
        searchBar.setPrefHeight(10);

        searchField.textProperty().addListener((observable, oldValue, newValue) -> filterTable(newValue));

        searchBar.getChildren().addAll(searchLabel, searchField, searchButton);
        return searchBar;
    }

    private Node createSalesTable() {
        salesTable = new TableView<>();
        salesTable.setItems(comprasList); // Conectar la lista de datos a la tabla

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
        comprasList.setAll(model.getMetalSalesList()); // Cargar datos desde la BD
    }

    private void filterTable(String searchText) {
        if (searchText.isEmpty()) {
            salesTable.setItems(comprasList); // Restaurar todos los datos si el campo está vacío
            return;
        }

        try {
            int searchId = Integer.parseInt(searchText);
            ObservableList<MetalSales> filteredList = comprasList.filtered(compra -> compra.getIdProperty().get() == searchId);
            salesTable.setItems(filteredList);
        } catch (NumberFormatException e) {
            // Si el usuario ingresa algo que no es un número, ignoramos el error y no filtramos nada
            salesTable.setItems(FXCollections.observableArrayList()); // Tabla vacía si la entrada es inválida
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
