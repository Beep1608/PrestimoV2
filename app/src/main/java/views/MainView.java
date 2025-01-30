package views;

import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.util.Builder;

public class MainView implements Builder<Region> {
    private final Region dashboard;

    public MainView(Region dashboard){
        this.dashboard= dashboard;
    }

    @Override
    public Region build() {
      StackPane container = new StackPane(
        dashboard
      );
      return container;
    }
    
}
