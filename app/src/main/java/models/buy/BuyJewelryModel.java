package models.buy;

import javafx.beans.binding.Bindings;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import models.percentages.PercentagesBuyJewelry;
import models.percentages.PercentagesCaratageJewelry;

public class BuyJewelryModel {

    private final SimpleIntegerProperty caratage = new SimpleIntegerProperty(0);
    private final SimpleDoubleProperty weight = new SimpleDoubleProperty(0); //Automatico
    private final SimpleDoubleProperty price_onz = new SimpleDoubleProperty(54379.26); // Automatico
    private final SimpleDoubleProperty conversion_factor = new SimpleDoubleProperty(31.1); //Constante
    private final SimpleDoubleProperty price_gr_inter = new SimpleDoubleProperty(0); //Calculado
    private final SimpleDoubleProperty security_value = new SimpleDoubleProperty(100); // Setteable   
    private final SimpleDoubleProperty revenue_extern_sale = new SimpleDoubleProperty(0); //Calculado
    private final SimpleDoubleProperty revenue_gr= new SimpleDoubleProperty(100); //Setteable 
    private final SimpleDoubleProperty price_local_gr = new SimpleDoubleProperty(0); //Calculado 
    private final SimpleDoubleProperty caratage_price = new SimpleDoubleProperty(0); //Calculado 
    private final SimpleDoubleProperty caratage_price_final = new SimpleDoubleProperty(0); //Calculado
    private final SimpleDoubleProperty price_gr_final  =new SimpleDoubleProperty(0); //Calculado
    private final SimpleDoubleProperty max_purchase_amount = new SimpleDoubleProperty(0); //Calculado

    private final PercentagesBuyJewelry percentages_buy = new PercentagesBuyJewelry();
    private final PercentagesCaratageJewelry percentages_caratage = new PercentagesCaratageJewelry();



    //GUI /*Las siguientes propiedades afectan el comportamiento de la interfaz correspondiente a la compra de joyas */
    private final SimpleBooleanProperty caratage_node = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty weight_node = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty selectors_caratage_node = new SimpleBooleanProperty(false);
    private final SimpleBooleanProperty selectors_purchase_node = new SimpleBooleanProperty(false);

    public BuyJewelryModel(){
    

        selectors_purchase_node.bind(Bindings.createBooleanBinding(
            () -> !(caratage_node.get() && weight_node.get()), // Condición: ambos deben ser verdaderos
            caratage_node, weight_node // Observa cambios en estas propiedades
        ));

    }

    public IntegerProperty caratage(){
        return caratage;
    }
    public DoubleProperty weight(){
        return weight;
    }
    public DoubleProperty price_onz(){
        return price_onz;
    }

    public DoubleProperty conversion_factor(){
        return conversion_factor;
    }

    public DoubleProperty price_gr_inter(){
        return price_gr_inter;
    }
    
    public DoubleProperty security_value(){
        return security_value;
    }

    public DoubleProperty revenue_extern_sale(){
        return revenue_extern_sale;
    }

    public DoubleProperty revenue_gr(){
        return revenue_gr;
    }

    public DoubleProperty price_local_gr(){
        return price_local_gr;
    }

    public DoubleProperty caratage_price(){
        return caratage_price;
    }

    public DoubleProperty caratage_price_final(){
        return caratage_price_final;
    }

    public DoubleProperty price_gr_final(){
        return price_gr_final;
    }

    public DoubleProperty max_purchase_amount(){
        return max_purchase_amount;
    }

    public PercentagesBuyJewelry percentages_buy(){
        return percentages_buy;
    }

    public PercentagesCaratageJewelry percentages_caratage(){
        return percentages_caratage;
    }

    //GUI

    public BooleanProperty caratage_node(){
        return caratage_node;
    }

    public BooleanProperty weight_node(){
        return weight_node;
    }

    public BooleanProperty selectors_caratage_node(){
        return selectors_caratage_node;
    }

    public BooleanProperty selectors_purchase_node(){
        return selectors_purchase_node;
    }



    
}
