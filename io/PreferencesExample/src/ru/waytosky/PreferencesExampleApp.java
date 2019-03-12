package ru.waytosky;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author BikchentaevAA
 */
public class PreferencesExampleApp extends Application {

    
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));

        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String os = System.getProperty("os.name").toLowerCase();
        System.out.println(os);
        if (os.contains("win")) {
            System.out.println("OS is Windows");
        }
//         System.getProperties().list(System.out);
        String userDir = System.getProperty("user.home");
        System.out.println(userDir);
        launch(args);
    }

}
