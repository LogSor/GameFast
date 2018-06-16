package sample;


import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    GridPane gridPane;

    Model model;
    Pawns tmpPawns=null;
    ArrayList<Square> possibleMoves;
    boolean roundBlue = true;
    boolean roundRed = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        model = new Model();
    }

    @FXML
    public void movePion(Event event){

        int rowActual=0;
        int columnsActual=0;

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

        --------------------------Recuperation directly position of circle------------------------------*/
        if (event.getSource() instanceof Circle) {
            Node tmpNode = ((Circle) event.getSource()).getParent();
            rowActual = gridPane.getRowIndex(tmpNode);
            columnsActual = gridPane.getColumnIndex(tmpNode);
            // ===============================================================================================

            //-------------------------------------------Begin manage the game--------------------------------
            if (tmpPawns == null) { // If no pawn was choosen before
                if(roundBlue){ // If it's the turn of blue player to play
                    detectionMove(rowActual,columnsActual);
                }
            }

        }
    }

    public void detectionMove(int rowActual, int columnsActual){
        for (Pawns pawn : model.board.getPawns()){ // Check all pawns of the board
            if (pawn.comparePawns(rowActual,columnsActual)){ // Check if the pawn have the same coordinate as the mouse click
                tmpPawns = pawn; // Save the pawn in a tampon
                possibleMoves = model.board.findMovePawn(tmpPawns); // Check all the possibility of path for the pawn
                for (Node node : gridPane.getChildren()){ // this iteration is to compare all Square with the coordinate of the list possibleMoves and make a border around the square
                    for (Square tmpSquare : possibleMoves) {
                        if (node.contains((double) tmpSquare.row, (double) tmpSquare.columns)) {
                            node.setStyle("-fx-border-color: red;");
                        }
                    }
                }
            }
        }
    }
}
