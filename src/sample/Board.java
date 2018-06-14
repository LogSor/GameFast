package sample;

import java.awt.*;
import java.util.ArrayList;

public class Board {
    protected ArrayList<Pawns> pawns;
    protected Box[][] boxs;
    protected Player redPlayer,bluePlayer; //players

    public Board(ArrayList<Pawns> pawns, Box[][] boxs) {
        this.pawns = pawns;
        this.boxs = boxs;
    }

    public Board(){
        pawns= new ArrayList<>();
        boxs = new Box[8][8];
        redPlayer = new Player("Joueur Blue",Color.RED);
        bluePlayer = new Player("Joueur Rouge",Color.BLUE);

        initalisationBoard();
    }

    public void initalisationBoard(){
        for (int i=0;i<8;i++){

            for (int j=0;j<8;j++){
                if (i<3 || i>4){
                    if (i % 2 ==0){
                        if (j%2 ==0){
                            Pawns p;
                            if (i<3){
                                p = new Pawns(i,j,redPlayer);
                                redPlayer.addPawns(p);
                            }else{
                                p = new Pawns(i,j,bluePlayer);
                                bluePlayer.addPawns(p);
                            }

                            boxs[i][j]= new Box(i,j,p);
                        }else {
                            boxs[i][j]= new Box(i,j);
                        }

                    }else {
                        if (j%2 !=0){
                            Pawns p;
                            if (i<3){
                                p = new Pawns(i,j,redPlayer);
                                redPlayer.addPawns(p);
                            }else{
                                p = new Pawns(i,j,bluePlayer);
                                bluePlayer.addPawns(p);
                            }

                            boxs[i][j]= new Box(i,j,p);
                        }else {
                            boxs[i][j]= new Box(i,j);
                        }
                    }
                } else {
                    boxs[i][j]= new Box(i,j);
                }
            }
        }
    }

    public ArrayList<Box> findMovePawn(Pawns p){
        ArrayList<Box> findBox = new ArrayList<>();
        int i,j;
        i=p.row;
        j=p.columns;
        Color opposingColor;

        if (Color.RED.equals(p.player.color)){
            opposingColor=Color.blue;
        }
        else{
            opposingColor=Color.RED;
        }

        //diagonale avant gauche
        while (boxs[i][j].pawns==null && i<8 && j>-1){
            findBox.add(boxs[i][j]);
            i++;
            j--;
        }

        if (boxs[i][j].pawns.player.color==opposingColor){
            findBox.add(boxs[i][j]);
        }



        //diagonale avant droite
        i=p.row;
        j=p.columns;
        while (boxs[i][j].pawns==null && i<8 && j<8){
            findBox.add(boxs[i][j]);
            i++;
            j++;
        }

        if (boxs[i][j].pawns.player.color==opposingColor){
            findBox.add(boxs[i][j]);
        }

        //diagonale arrière gauche
        i=p.row;
        j=p.columns;
        while (boxs[i][j].pawns==null && i>-1 && j>-1){
            findBox.add(boxs[i][j]);
            i--;
            j--;
        }

        if (boxs[i][j].pawns.player.color==opposingColor){
            findBox.add(boxs[i][j]);
        }

        //diagonal arrière droite
        i=p.row;
        j=p.columns;
        while (boxs[i][j].pawns==null && i>-1 && j<8){
            findBox.add(boxs[i][j]);
            i--;
            j++;
        }

        if (boxs[i][j].pawns.player.color==opposingColor){
            findBox.add(boxs[i][j]);
        }
        return findBox;
    }

    public Player cannotMove(){
        int nbPawns=0;
        for (Pawns p : bluePlayer.pawns
             ) {
            if (findMovePawn(p).isEmpty()){
                nbPawns++;
            }
        }
        if (nbPawns==bluePlayer.pawns.size()){
            return bluePlayer;
        }

        nbPawns=0;
        for (Pawns p : redPlayer.pawns
                ) {
            if (findMovePawn(p).isEmpty()){
                nbPawns++;
            }
        }
        if (nbPawns==redPlayer.pawns.size()){
            return redPlayer;
        }

        return null;
    }

    public Box movePawns(Pawns p ,Box b){
        if (b != null) {

            if (b.pawns != null) {
                p.eatPawns(b.pawns);
                b.pawns = p;
            } else {
                p.movePawns(b.row, b.columns);
                b.pawns = p;
            }
            return b;
        }

        return null;
    }

    public ArrayList<Pawns> getPawns() {
        return pawns;
    }

    public void setPawns(ArrayList<Pawns> pawns) {
        this.pawns = pawns;
    }

    public Box[][] getBoxs() {
        return boxs;
    }

    public void setBoxs(Box[][] boxs) {
        this.boxs = boxs;
    }
}
