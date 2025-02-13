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
        /**
         * Configura las columnas de la tabla de ventas.
         * Actualmente, solo se configura una columna para mostrar el id de
         * cada venta.
         * 
         * @param table La tabla de la que se van a configurar las columnas.
         * @return null
         */
    private Void configureColumns(TableComponent<BuyModel> table) {
            table.addColumn("ID", cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().idProperty().get()));
            return null;
        }
        

        /**
         * Establece un listener para cambios en el texto de búsqueda y actualiza
         * el filtro de la tabla de ventas en consecuencia.
         * Si el texto de búsqueda es nulo o vacío, se utiliza un predicado que
         * devuelve true para todos los elementos.
         * Si el texto de búsqueda es un número válido, se utiliza un predicado que
         * filtra los elementos en la tabla según el id de la venta.
         * Si el texto de búsqueda no es un número válido, se utiliza un predicado
         * que devuelve false para todos los elementos.
         */
        private void configureFilter() {
            // Listener para cambios en el texto de búsqueda
            searchText.addListener((observable, oldValue, newValue) -> {
                salesTable.setFilter(createFilter(newValue));
            });
        }

        /**
         * Crea un predicado que se utiliza para filtrar los elementos en la tabla
         * según el texto de búsqueda.
         * 
         * @param search El texto de búsqueda. Si es nulo o vacío, se devolverá
         *               un predicado que devuelve true para todos los elementos.
         * @return Un predicado que se utiliza para filtrar los elementos en la
         *         tabla.
         */
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
