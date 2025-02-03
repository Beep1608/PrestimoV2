package models.local;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import models.database.DatabaseInit;
import models.database.DatabaseVariables;

public class Instancia {
    
    private final SimpleIntegerProperty id = new SimpleIntegerProperty(0);
    private final SimpleStringProperty token = new SimpleStringProperty("");
    private final SimpleStringProperty time = new SimpleStringProperty("");

    private DatabaseInit dbInit = new DatabaseInit(DatabaseVariables.getDATABASE(), DatabaseVariables.getUSER(), DatabaseVariables.getPASSWORD());
    private Connection connection;

    public Instancia(SimpleStringProperty token) {
        this.token.set(token.get());
    }

    private void setConnection(){
        connection = dbInit.getConnection();
    }

    /**
     * Inserta el token en la base de datos
     */
    public void insertarInstancia(){
        String sql = "INSERT INTO instancia (token) VALUES (?)";
        try {
            setConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, this.token.get());
            statement.executeUpdate();
            dbInit.close();
            System.out.println("Instancia insertada correctamente");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Getters 
    public SimpleIntegerProperty getId() {return this.id;}
    public SimpleStringProperty getToken() {return this.token;}
    public SimpleStringProperty getTime() {return this.time;}
}
