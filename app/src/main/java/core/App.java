/*
 * This source file was generated by the Gradle 'init' task
 */
package core;

import controllers.MainController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application {
   

    public static void main(String[] args) {
           
            launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
    
        Scene scene = new Scene(new MainController().getView());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
