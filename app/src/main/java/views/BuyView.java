package views;


import java.util.function.Predicate;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.layout.Region;
import models.BuyModel;
import views.components.TableComponent;
import views.dashboard.ViewDashboard;


public class BuyView extends ViewDashboard {

    private final TableComponent<BuyModel> salesTable;
    private final StringProperty searchText;

    public BuyView(Region cards, 
                  Region electronics, 
                  Region whiteGoods, 
                  Region jewelry,
                  BuyModel model, 
                  StringProperty searchText, 
                  ObservableList<BuyModel> items) {
        super("buy", electronics, whiteGoods, jewelry, model);
        this.searchText = searchText;
        this.salesTable = new TableComponent<>(
            items,
            searchText, 
            this::configureColumns
        );
        
        this.container.getChildren().addAll(cards, salesTable);
        configureFilter();
    }
    private Void configureColumns(TableComponent<BuyModel> table) {
            table.addColumn("ID", cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().idProperty().get()));
            return null;
        }
        

        private void configureFilter() {
            // Listener para cambios en el texto de búsqueda
            searchText.addListener((observable, oldValue, newValue) -> {
                salesTable.setFilter(createFilter(newValue));
            });
        }

        private Predicate<BuyModel> createFilter(String search) {
            return buy -> {
                if (search == null || search.isEmpty()) {
                    return true; // Mostrar todos los elementos si no hay texto de búsqueda
                }
                try {
                    int searchId = Integer.parseInt(search); // Convertir el texto a número
                    return buy.idProperty().get() == searchId; // Filtrar por id
                } catch (NumberFormatException e) {
                    return false; // Si no es un número válido, no mostrar nada
                }
            };
    }
}
