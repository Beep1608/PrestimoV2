package models.local;

import java.sql.Connection;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import models.database.DatabaseInit;
import models.database.DatabaseVariables;

public class PorcentajesCompra {
    private final SimpleIntegerProperty id = new SimpleIntegerProperty(0);
    private final SimpleDoubleProperty porcentaje_min = new SimpleDoubleProperty(0.0);
    private final SimpleDoubleProperty porcentaje_medio = new SimpleDoubleProperty(0.0);
    private final SimpleDoubleProperty porcentaje_max = new SimpleDoubleProperty(0.0);
    private final SimpleDoubleProperty porcentaje_aplicado = new SimpleDoubleProperty(0.0);
    private final SimpleIntegerProperty id_venta = new SimpleIntegerProperty(0);
    
    private DatabaseInit dbInit = new DatabaseInit(DatabaseVariables.getDATABASE(), DatabaseVariables.getUSER(), DatabaseVariables.getPASSWORD());
    private Connection connection;

    public PorcentajesCompra() {}

    private void setConnection(){
        connection = dbInit.getConnection();
    }

    
}
