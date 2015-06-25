/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modulex;

import home.Home;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Gebruiker
 */
public class ModuleX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
//        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
//        
//        Scene scene = new Scene(root);
//        
//        stage.setScene(scene);
//        scene.getStylesheets().add("style/style.css");
//        stage.setTitle("Login to FotoPro!");
//        stage.getIcons().add(new Image("/style/icon-camera-128.png"));
//        stage.show();
        new Home();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
