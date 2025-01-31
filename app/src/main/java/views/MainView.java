package views;

import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Builder;

public class MainView implements Builder<Region> {
    private final double height = 568;
    private final double width = 1000;
    private final Region dashboard;


    public MainView(Region dashboard){
        this.dashboard= dashboard;
    }

    @Override
    public Region build() {
      StackPane container = new StackPane(
        dashboard
      );
      container.setMinHeight(height);
      container.setMinWidth(width);
      return container;
    }
    
}
