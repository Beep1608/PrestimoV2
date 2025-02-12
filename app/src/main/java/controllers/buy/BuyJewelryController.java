package controllers.buy;

import java.util.HashMap;
import java.util.function.Consumer;
import java.util.function.Supplier;



import javafx.application.Platform;
import javafx.scene.layout.Region;
import models.OptionModel.Views;
import models.buy.BuyJewelryModel;
import views.buy.BuyJewelry;

public class BuyJewelryController {

    private final BuyJewelryModel model;
    private final BuyJewelry view;
    private final HashMap<String,Supplier<Void>> services = new HashMap<>();
    private final Supplier<Void> prev;
    public BuyJewelryController(Supplier<Void> prev){
        this.prev = prev;
        this.model = new BuyJewelryModel();
        this.services.put("calculateJewelry", this::calculateJewelry);
        this.services.put("prev", prev);
        this.view = new BuyJewelry(model,services);
    }
    public Region getView(){
        return view.build();
    }

    private Void calculateJewelry(){
        /*
         * Pienso que sera mejor guardar los datos de la tabla variables en la base de datos
         */
        
        /*
         * TODO: Debemos extraer los datos de seguridad de la base de datos de la tabla variables
         * para poder hacer los calculos, esto se hara una vez dado los valores
         * los traeremos, creo que una opcion sera una vez iniciada la app, aplicar persistencia
         * para los valores y no hacer una consulta diaria.
         */
        Platform.runLater(()->{
            model.price_gr_inter().set(
                model.price_onz().divide(model.conversion_factor().get()).get()
            ); // precio x gramos
            model.revenue_extern_sale().set(
                model.price_gr_inter().subtract(model.security_value().get()).get()
            ); // ganancia de venta externa
           model.price_local_gr().set(
            model.revenue_extern_sale().subtract(model.revenue_gr().get()).get()
           ); //precio gramo local
    
           model.caratage_price().set(
            model.price_local_gr().divide(24).get()
           ); // precio kilataje
            double caratagePriceFinal = model.caratage_price().get() * model.caratage().get() * model.percentages_caratage().applied().get();
          
            // Vincula el resultado al precio final
            model.caratage_price_final().set(caratagePriceFinal);// Precio a pagar por kilataje (min,inter,max)
    
    
        model.price_gr_final().set(
            model.weight().multiply(
                model.caratage_price_final().get()
            ).get()
    
        ); // Precio a pagar por gramo Final
    
        model.max_purchase_amount().set(
            model.price_gr_final().multiply(
                model.percentages_buy().applied().get()
            ).get()
        ); // Monto maximo a pagar por compra
    
        });

        return null;
    }
    
}
