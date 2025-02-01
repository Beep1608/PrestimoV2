package models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Modelo para el dashboard que gestiona la vista actual del sistema.
 */
public class DashboardModel {
    /**
     * Enumeración de las vistas disponibles en el dashboard.
     */
    public enum Views {
        BUY, LOAN, SALE
    }

    private final ObjectProperty<Views> currentView = new SimpleObjectProperty<>(Views.BUY);

    /**
     * Obtiene la propiedad de la vista actual.
     *
     * @return La propiedad de la vista actual.
     */
    public ObjectProperty<Views> currentViewProperty() {
        return currentView;
    }

    /**
     * Obtiene la vista actual.
     *
     * @return La vista actual del dashboard.
     */
    public Views getCurrentView() {
        return currentView.get();
    }

    /**
     * Establece una nueva vista en el dashboard.
     *
     * @param view La vista a establecer.
     */
    public void setCurrentView(Views view) {
        currentView.set(view);
    }
}
