package controllers;

import java.util.function.Consumer;

import javafx.scene.layout.Region;
import models.OptionModel.Views;
import views.CardsOptionView;

public class CardsOptionController {

    private final CardsOptionView view;

    /**
     *  Data referente a Electronica
     */
    private final CardOptionController electronics;
    private final String electroncisResource  ="/option/electronics.png";
    private final String electronicsTitle = "Electrónica";
    private final String electroncisDescription  ="🔹 Smartphones\n"+ //
"🔹 Tablets\n"+ //
"🔹 Computadoras de escritorio\n"+ //
"🔹 Televisores (LED, OLED, QLED)\n"+ //
"🔹 Consolas de videojuegos (PlayStation, Xbox, Nintendo)";


 /**
     *  Data referente a Linea Blanca
     */
    private final CardOptionController whiteGoods;
    private final String whiteGoodsResource  ="/option/whiteGoods.png";
    private final String whiteGoodsTitle = "Línea Blanca";
    private final String whiteGoodsDescription  ="🔹 Refrigeradores\n" + //
                "🔹 Lavadoras\n" + //
                "🔹 Secadoras\n" + //
                "🔹 Estufas\n" + //
                "🔹 Hornos de microondas";


    
    /**
     *  Data referente a Joyería
     */
    private final CardOptionController jewelry;
    private final String jewelryResource  ="/option/jewelry.png";
    private final String jewelryTitle = "Joyería";
    private final String jewelryDescription  ="🔹 Collares\n" + //
                "🔹 Pulseras\n" + //
                "🔹 Anillos\n" + //
                "🔹 Cadenas\n" + //
                "🔹 Joyas personalizadas";
                

    public CardsOptionController(Consumer<Views>setCurrentView ){
        this.electronics = new CardOptionController(electroncisResource, electronicsTitle,electroncisDescription);
        this.electronics.getView().setOnMouseClicked(evt->{
            setCurrentView.accept(Views.ELECTRONICS);
        });
        this.whiteGoods = new CardOptionController(whiteGoodsResource, whiteGoodsTitle, whiteGoodsDescription);
        this.whiteGoods.getView().setOnMouseClicked(evt->{
            setCurrentView.accept(Views.WHITEGOODS);
        });
        this.jewelry = new CardOptionController(jewelryResource, jewelryTitle, jewelryDescription);
        this.jewelry.getView().setOnMouseClicked(evt->{
            setCurrentView.accept(Views.JELWERY);
        });
        this.view = new CardsOptionView(electronics.getView(), whiteGoods.getView(), jewelry.getView());
        
        
        
    }

    public Region getView(){
        return view.build();
    }
    
}
