package controllers;

import java.util.HashMap;
import java.util.function.Function;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.layout.Region;
import models.DashboardModel;
import models.DashboardModel.Views;
import views.DashboardView;
import views.dashboard.SearchBar;

/**
 * Controlador para gestionar el dashboard y sus vistas.
 */
public class DashboardController {
    private final DashboardView view;
    private final DashboardModel model;
    private final BuyController buyController;
    private final LoanController loanController;
    private final SaleController saleController;
    private final MetalSalesController metalSalesController;
    private final HashMap<String, Function<?, ?>> service = new HashMap<>();
    private final StringProperty searchText = new SimpleStringProperty("");
    /**
     * Constructor del DashboardController. Inicializa el modelo y las vistas.
     */
    public DashboardController() {
        
        this.metalSalesController = new MetalSalesController(searchText);
        this.buyController = new BuyController();
        this.loanController = new LoanController();
        this.saleController = new SaleController();
        
        this.model = new DashboardModel();
        

        service.put("showView", this::showView);

        this.view = new DashboardView(
                buyController.getView(),
                loanController.getView(),
                saleController.getView(),
                metalSalesController.getView(),
                service,
                model, 
                searchText
        );
    }

    /**
     * Obtiene la vista principal del dashboard.
     *
     * @return La vista del dashboard.
     */
    public Region getView() {
        return view.build();
    }

    /**
     * Cambia la vista actual del dashboard.
     *
     * @param view La nueva vista a mostrar.
     * @return Siempre retorna null (uso en programación funcional).
     */
    private Void showView(Object view) {
        if (view instanceof Views newView) {
            model.setCurrentView(newView);
        }
        return null;
    }
}
