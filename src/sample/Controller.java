package sample;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    GridPane gridPane;

    Model model;
    Pawns firstPawns=null;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = new Model();
    }

    @FXML
    public void movePion(Event event){

        double rowActual;
        double columnsActual;

        /*--------------------Use parent and children for recup square and position--------------------
        if (event.getSource() instanceof Circle) {
            for (Node node : gridPane.getChildren()){
                if (node.equals(((Circle) event.getSource()).getParent())){
                    rowActual=node.getScaleX();
                    columnsActual=node.getScaleY();
                    System.out.println(((Circle) event.getSource()).getScaleX());
                }
            }
        }
        =================================================================================================

        --------------------------Recuperation directly position of circle------------------------------
        if (event.getSource() instanceof Circle){
            rowActual=((Circle) event.getSource()).getScaleX();
            columnsActual=((Circle) event.getSource()).getScaleY();
        }
        ===============================================================================================

        -------------------------------------------Begin manage the game--------------------------------
        if (firstPawns == null){

            if (model.board.getPawns())
        }

*/
    }
}
