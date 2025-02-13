package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import models.database.DatabaseInit;
import models.database.DatabaseVariables;

public class BuyModel extends OptionModel implements BaseModel {
    
    private final SimpleIntegerProperty id = new SimpleIntegerProperty(0);
    
    private final DatabaseInit dbInit = new DatabaseInit(DatabaseVariables.getDATABASE(), DatabaseVariables.getUSER(), DatabaseVariables.getPASSWORD());
    private Connection connection;

    public BuyModel(){
        
    }

    // Conexion a la base de datos
    private void setConnection(){
        connection = dbInit.getConnection();
    }

    @Override
    public IntegerProperty idProperty() {  
        return id;
    }

    @Override
    public StringProperty searchStringProperty() {  
        return new SimpleStringProperty(String.valueOf(id.get()));
    }

    // TODO: Tengo que poner todos los atributos de la compra
    public List<BuyModel> getBuyData() {
        List<BuyModel> comprasMetalesList = new ArrayList<>();
        String sql = "SELECT id, monto, fecha_hora FROM compras_metales";

        try {
            setConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                BuyModel compra = new BuyModel();
                compra.id.set(resultSet.getInt("id"));
                comprasMetalesList.add(compra);
            }

            resultSet.close();
            statement.close();
            dbInit.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return comprasMetalesList;
    } 
}
