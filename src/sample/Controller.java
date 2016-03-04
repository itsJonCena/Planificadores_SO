package sample;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    Modelo nuevo = new Modelo();


    @FXML public static ListView lsNuevos= new ListView();

    @Override
    public void initialize(URL arg, ResourceBundle rb) {
    }

    @FXML
    public void crearProcesos() throws Exception {

        nuevo.run();

    }



}