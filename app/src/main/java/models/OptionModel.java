package models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

public abstract class OptionModel {

    
    public enum Views {
        ELECTRONICS, WHITEGOODS, JELWERY,PARENT
    }

    
    private final ObjectProperty<Views> currentView = new SimpleObjectProperty<>();

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
    public Void setCurrentView(Views view) {
        currentView.set(view);
        return null;

    }


}


