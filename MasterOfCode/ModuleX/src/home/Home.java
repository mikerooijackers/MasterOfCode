package home;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gebruiker
 */
public class Home extends Stage {
    public Home() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));            
            
            Parent root = loader.load();
            
            HomeController controller = (HomeController) loader.getController();
            controller.setParentWindow(this);
            
            Scene scene = new Scene(root);
//            scene.getStylesheets().add("style/style.css");
//            this.getIcons().add(new Image("/style/icon-camera-128.png"));
            this.setTitle("Home");
            this.setScene(scene);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.show();
    }
}
