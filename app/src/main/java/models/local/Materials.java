package models.local;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import models.database.DatabaseInit;
import models.database.DatabaseVariables;

import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 * Para poder crear un material es necesario instancia un objeto de esta clase
 * y llamar al metodo insertarMaterial
 */
public class Materials {
    private final SimpleIntegerProperty id = new SimpleIntegerProperty(0);
    private final SimpleStringProperty nombre = new SimpleStringProperty("");
    private DatabaseInit dbInit = new DatabaseInit(DatabaseVariables.getDATABASE(), DatabaseVariables.getUSER(), DatabaseVariables.getPASSWORD());
    private Connection connection;

    public Materials() {}

    // Conexion a la base de datos
    private void setConnection(){
        connection = dbInit.getConnection();
    }

    /**
     * Inserta un material a la base de datos
     */
    public void insertarMaterial(){
        String sql = "INSERT INTO materiales (nombre) VALUES (?)";
        try {
            setConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, this.nombre.get());
            statement.executeUpdate();
            dbInit.close();
            System.out.println("Material insertado correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Getters
    public SimpleIntegerProperty getId() {return this.id;}
    public SimpleStringProperty getNombre() {return this.nombre;}

}
