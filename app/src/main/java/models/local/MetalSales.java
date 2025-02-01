package models.local;

import javafx.beans.property.*;
import models.database.DatabaseInit;
import models.database.DatabaseVariables;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MetalSales {
    private final SimpleIntegerProperty id = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty kilataje = new SimpleIntegerProperty(0);
    private final SimpleDoubleProperty peso = new SimpleDoubleProperty(0.0);
    private final SimpleDoubleProperty precio_oz_inter = new SimpleDoubleProperty(0.0);
    private final SimpleDoubleProperty precio_gr_inter = new SimpleDoubleProperty(0.0);
    private final SimpleDoubleProperty precio_gr_local = new SimpleDoubleProperty(0.0);
    private final SimpleDoubleProperty precio_kilataje = new SimpleDoubleProperty(0.0);
    private final SimpleDoubleProperty precio_kilataje_total = new SimpleDoubleProperty(0.0);
    private final SimpleDoubleProperty precio_gr_final = new SimpleDoubleProperty(0.0);
    private final SimpleDoubleProperty monto_max_compra = new SimpleDoubleProperty(0.0);
    private final SimpleDoubleProperty monto = new SimpleDoubleProperty(0.0);
    private final SimpleStringProperty fecha_hora = new SimpleStringProperty("");
    // Foreign Keys
    private final SimpleIntegerProperty id_materiales = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty id_usuario = new SimpleIntegerProperty(0);
    private final SimpleIntegerProperty id_variables = new SimpleIntegerProperty(0);

    private final DatabaseInit dbInit = new DatabaseInit(DatabaseVariables.getDATABASE(), DatabaseVariables.getUSER(), DatabaseVariables.getPASSWORD());
    private Connection connection;


    public MetalSales() {}

    // Conexion a la base de datos
    private void setConnection(){
        connection = dbInit.getConnection();
    }

    public List<MetalSales> getMetalSalesList() {
        List<MetalSales> comprasMetalesList = new ArrayList<>();
        String sql = "SELECT id, monto, fecha_hora FROM compras_metales";

        try {
            setConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                MetalSales compra = new MetalSales();
                compra.id.set(resultSet.getInt("id"));
                compra.monto.set(resultSet.getDouble("monto"));
                compra.fecha_hora.set(resultSet.getString("fecha_hora"));
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


    // Getters

    public SimpleIntegerProperty getIdProperty() {return this.id;}

    public IntegerProperty getKilatajeProperty() {return this.kilataje;}

    public DoubleProperty getPesoProperty() {return this.peso;}

    public DoubleProperty getPrecioOzInterProperty() {return this.precio_oz_inter;}

    public DoubleProperty getPrecioGrInterProperty() {return this.precio_gr_inter;}

    public DoubleProperty getPrecioGrLocalProperty() {return this.precio_gr_local;}

    public DoubleProperty getPrecioKilatajeProperty() {return this.precio_kilataje;}

    public DoubleProperty getPrecioKilatajeTotalProperty() {return this.precio_kilataje_total;}

    public DoubleProperty getPrecioGrFinalProperty() {return this.precio_gr_final;}

    public DoubleProperty getMontoMaxCompraProperty() {return this.monto_max_compra;}

    public DoubleProperty getMontoProperty() {return this.monto;}

    public StringProperty getFechaHoraProperty() {return this.fecha_hora;}

    public IntegerProperty getIdMaterialesProperty() {return this.id_materiales;}

    public IntegerProperty getIdUsuarioProperty() {return this.id_usuario;}

    public IntegerProperty getIdVariablesProperty() {return this.id_variables;}

}
