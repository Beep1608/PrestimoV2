package views;

import java.util.HashMap;
import java.util.function.Function;

import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.util.Builder;
import models.DashboardModel;
import models.DashboardModel.Views;
import views.dashboard.Option;
import views.dashboard.SideBar;
import views.dashboard.TopBar;
import views.utils.ResourceLoader;
import views.utils.Responsive;

/**
 * Clase que representa la vista del dashboard.
 */
public class DashboardView implements Builder<Region> {
    private final Region buyView;
    private final Region loanView;
    private final Region saleView;
    private final Region metalSalesView;
    private final TopBar topBar;
    private final HashMap<String, Function<?, ?>> service;
    private final DashboardModel model;
    private StackPane contentContainer;

    /**
     * Constructor de la vista del dashboard.
     *
     * @param buyView  Vista de la sección de compras.
     * @param loanView Vista de la sección de préstamos.
     * @param saleView Vista de la sección de ventas.
     * @param service  Mapa de servicios disponibles.
     * @param model    Modelo del dashboard.
     */
    public DashboardView(Region buyView, Region loanView, Region saleView, Region metalSalesView,
                         HashMap<String, Function<?, ?>> service, DashboardModel model, StringProperty searchText) {
        this.buyView = buyView;
        this.loanView = loanView;
        this.saleView = saleView;
        this.metalSalesView = metalSalesView;
        this.topBar = new TopBar(searchText);
        this.topBar.currentView().set("Dashboard");
        this.service = service;
        this.model = model;
    }

    @Override
    public Region build() {
        return (Region) mainContainer();
    }

    /**
     * Crea el contenedor principal del dashboard.
     *
     * @return Nodo que representa el contenedor principal.
     */
    private Node mainContainer() {
        HBox container = new HBox(
                createSideBar(),
                createContentContainer()
        );
        container.getStylesheets().add(ResourceLoader.load("/css/dashboard/dashboard.css"));
        container.getStyleClass().add("container");
        container.setPadding(new Insets(10, 10, 10, 10));
        return container;
    }

    /**
     * Crea la barra lateral del dashboard con las opciones de navegación.
     *
     * @return Nodo que representa la barra lateral.
     */
    private Node createSideBar() {
        Node buy = new Option("Compra", "/dashboard/shopping-cart.png", "/dashboard/shopping-cart-h.png").createOption();
        buy.setOnMouseClicked(evt -> {
            showView(Views.BUY);
            topBar.currentView().set("Compra");
        });

        Node loan = new Option("Prestamo", "/dashboard/loan.png", "/dashboard/loan-h.png").createOption();
        loan.setOnMouseClicked(evt -> {
            showView(Views.LOAN);
            topBar.currentView().set("Préstamo");
        });

        Node sale = new Option("Venta", "/dashboard/price-tag.png", "/dashboard/price-tag-h.png").createOption();
        sale.setOnMouseClicked(evt -> {
            showView(Views.SALE);
            topBar.currentView().set("Venta");
        });

        // Creamos el node para las metal sales
        Node metalSales = new Option("Ventas Metales", "/dashboard/profit.png","/dashboard/profit.png" ).createOption();
        metalSales.setOnMouseClicked(evt -> {
            showView(Views.METALSALES);
            topBar.currentView().set("Ventas Metales");
        });
        return new SideBar(buy, loan, sale, metalSales).createSideBar();
    }

    /**
     * Crea el contenedor de contenido principal.
     *
     * @return Nodo que representa el contenedor de contenido.
     */
    private Node createContentContainer() {
        VBox innerContentContainer = new VBox(
                topBar.createTopBar(),
                createContent()
        );
        Responsive.bindingToParentWidth(innerContentContainer, 1);
        HBox contentContainer = new HBox(innerContentContainer);
        contentContainer.setHgrow(contentContainer, Priority.ALWAYS);
        contentContainer.getStyleClass().add("content");
        contentContainer.setPadding(new Insets(0, 0, 0, 15));
        return contentContainer;
    }

    /**
     * Crea el área de contenido donde se mostrarán las vistas.
     *
     * @return Nodo que representa el área de contenido.
     */
    private Node createContent() {
        contentContainer = new StackPane();
        Responsive.bindingToParent(contentContainer, 1, 1);
        contentContainer.getChildren().add(getViewByType(model.getCurrentView()));

        // Listener para cambios en la vista activa
        model.currentViewProperty().addListener((obs, oldView, newView) -> switchRightView(getViewByType(newView)));

        return contentContainer;
    }

    /**
     * Cambia la vista activa en el contenedor de contenido.
     *
     * @param activeView La nueva vista activa.
     */
    private void switchRightView(Region activeView) {
        contentContainer.getChildren().setAll(activeView);
    }

    /**
     * Obtiene la vista correspondiente a un tipo específico.
     *
     * @param view Tipo de vista a obtener.
     * @return La vista correspondiente al tipo indicado.
     */
    private Region getViewByType(Views view) {
        return switch (view) {
            case BUY -> buyView;
            case LOAN -> loanView;
            case SALE -> saleView;
            case METALSALES -> metalSalesView;
        };
    }

    /**
     * Cambia la vista activa en el modelo del dashboard.
     *
     * @param view La vista a mostrar.
     */
    private void showView(Views view) {
        model.setCurrentView(view);
    }

}