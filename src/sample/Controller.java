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

        /*
        for (Pawns p:model.board.pawns
                ) {
            System.out.println(p);
        }

        System.out.println("coordonné du pion:"+model.board.pawns.get(10).row+ ":"+ model.board.pawns.get(10).columns);

        System.out.println("case en +1,+1 :"+model.board.squares[model.board.pawns.get(10).row+1][model.board.pawns.get(10).row+1]); // case en +1, +1
        model.board.movePawns(model.board.pawns.get(10),model.board.squares[model.board.pawns.get(10).row+1][model.board.pawns.get(10).row+1]); //avance en +1,+1
        System.out.println("nouvelle coordonée du pion:"+model.board.pawns.get(10).row+ ":"+ model.board.pawns.get(10).columns); // il est en +1, +1
        System.out.println("Ancienne case du pion ne possède plus de pion donc null :"+model.board.squares[2][4].pawns);

        System.out.println("*******************************");
        System.out.println("Ancienne coordonnée:"+model.board.pawns.get(10).row+ ":"+ model.board.pawns.get(10).columns);
        System.out.println("Case à atteindre :"+ model.board.squares[5][7].pawns);
        model.board.movePawns(model.board.pawns.get(10),model.board.squares[5][7]); //avance sur 5,7
        System.out.println("ancienne case ne possède plus de pion donc null :" + model.board.squares[2][4].pawns);
        System.out.println("Nouvelle case(case atteinte) on a bien mange le blue :"+ model.board.squares[5][7].pawns);

        System.out.println("*******************************");
        System.out.println("Ancienne coordonnée:"+model.board.pawns.get(10).row+ ":"+ model.board.pawns.get(10).columns);
        System.out.println("Case à atteindre :"+ model.board.squares[0][0].pawns);
        model.board.movePawns(model.board.pawns.get(10),model.board.squares[0][0]); //avance sur 0,0
        System.out.println("ancienne case  possède   pion donc  :" + model.board.squares[5][7].pawns);
        System.out.println("Nouvelle case non atteinte car allié:"+ model.board.squares[0][0].pawns);

        System.out.println(model.board.pawns.get(0) + ":");
        System.out.println(model.board.findMovePawn(model.board.pawns.get(0)));

         System.out.println("coordonné du pion:"+model.board.pawns.get(10).row+ ":"+ model.board.pawns.get(10).columns);
        System.out.println(model.board.findMovePawn(model.board.pawns.get(10)));
        */
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
