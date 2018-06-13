package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    public void movePion (ActionEvent event){
        if(event.getSource() instanceof Circle){
            System.out.println("click");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
