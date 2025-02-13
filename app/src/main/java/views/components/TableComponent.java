package views.components;

import java.util.function.Predicate;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Callback;
import models.BaseModel;

public class TableComponent<T extends BaseModel> extends VBox {
    private final TableView<T> table;
    private final FilteredList<T> filteredData;
    

    public TableComponent(ObservableList<T> items, 
                         StringProperty searchProperty,
                         Callback<TableComponent<T>, Void> columnConfigurator) {
        
        this.filteredData = new FilteredList<>(items);
        this.table = new TableView<>(filteredData);
        
        
        configureColumns(columnConfigurator);
        setupLayout();
    }

    private void configureColumns(Callback<TableComponent<T>, Void> columnConfigurator) {
        columnConfigurator.call(this);
    }

    private void setupLayout() {
        this.getChildren().addAll(table);
        this.setSpacing(10);
        this.getStyleClass().add("table-component");
    }

    /**
     * Agrega una columna a la tabla.
     * 
     * @param title El t tulo de la columna.
     * @param valueFactory La f brica de valores para cada celda de la columna.
     */
    public <S> void addColumn(String title, 
                         Callback<TableColumn.CellDataFeatures<T, S>, ObservableValue<S>> valueFactory) {
    TableColumn<T, S> col = new TableColumn<>(title);
    col.setCellValueFactory(valueFactory);
    col.setMinWidth(200);
    table.getColumns().add(col);
}

    public void setFilter(Predicate<T> filter) {
        filteredData.setPredicate(filter);
    }

    public TableView<T> getTable() {
        return table;
    }
}