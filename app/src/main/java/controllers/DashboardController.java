package controllers;

import java.util.HashMap;
import java.util.function.Function;

import javafx.scene.layout.Region;
import models.DashboardModel;
import models.DashboardModel.Views;
import views.DashboardView;

/**
 * Controlador para gestionar el dashboard y sus vistas.
 */
public class DashboardController {
    private final DashboardView view;
    private final DashboardModel model;
    private final BuyController buyController;
    private final LoanController loanController;
    private final SaleController saleController;
    private final HashMap<String, Function<?, ?>> service = new HashMap<>();

    /**
     * Constructor del DashboardController. Inicializa el modelo y las vistas.
     */
    public DashboardController() {
        this.buyController = new BuyController();
        this.model = new DashboardModel();
        this.loanController = new LoanController();
        this.saleController = new SaleController();

        service.put("showView", this::showView);

        this.view = new DashboardView(
                buyController.getView(),
                loanController.getView(),
                saleController.getView(),
                service,
                model
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
