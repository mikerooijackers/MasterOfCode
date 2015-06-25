package home;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Domein.AnnotationData;
import com.mycompany.annotations.AssignCreator;
import com.mycompany.annotations.AssignInformation;
import com.mycompany.annotations.Hints;
import com.sun.glass.ui.Window;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.ReflectionUtils;

/**
 * FXML Controller class
 *
 * @author Gebruiker
 */
public class HomeController implements Initializable {

    @FXML
    private Button btnSelectFolder;
    
    @FXML
    private TextField textFieldAssgnmentFolder;
    
    private Stage parentWindow;
    
    
    @FXML
    void btnSelectFolderClicked(ActionEvent event) {
        DirectoryChooser dirChooser = new DirectoryChooser();
        dirChooser.setInitialDirectory(new File("C:\\"));
        textFieldAssgnmentFolder.setText(dirChooser.showDialog(parentWindow).getAbsolutePath());
    }
    
    @FXML
    void btnReadMetaDataClicked(ActionEvent event) {
        this.readAssignmentMetaData();
        final Stage dialog = new Stage();
                dialog.initModality(Modality.APPLICATION_MODAL);
                dialog.initOwner(parentWindow);
                VBox dialogVbox = new VBox(20);
                dialogVbox.getChildren().add(new Text("The following file has succesfully been generated : " + this.textFieldAssgnmentFolder.getText() + File.separator + "assignment2.tmp"));
                Scene dialogScene = new Scene(dialogVbox, 600, 200);
                dialog.setScene(dialogScene);
                dialog.show();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        textFieldAssgnmentFolder.setEditable(false);
    }    

    void setParentWindow(Stage home) {
        this.parentWindow = home;
    }
    
    public void readAssignmentMetaData() {
        String path = textFieldAssgnmentFolder.getText();
        
        List<AnnotationData> annotationData = null;
        annotationData = ReflectionUtils.readTestAnnotationData(path, org.testng.annotations.Test.class);
        annotationData.addAll(ReflectionUtils.readAnnotationData(path, AssignCreator.class, AssignInformation.class, Hints.class));
            try {
                FileOutputStream fos = new FileOutputStream(path + File.separator + "assignment.tmp");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(annotationData);
                oos.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        
    }
}
