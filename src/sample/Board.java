package sample;

import java.awt.*;
import java.util.ArrayList;

public class Board {
    protected ArrayList<Pawns> pawns;
    protected Square[][] squares;
    protected Player redPlayer,bluePlayer; //players

    public Board(ArrayList<Pawns> pawns, Square[][] squares) {
        this.pawns = pawns;
        this.squares = squares;
    }

    public Board(){
        pawns= new ArrayList<>();
        squares = new Square[8][8];
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

                            squares[i][j]= new Square(i,j,p);
                        }else {
                            squares[i][j]= new Square(i,j);
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

                            squares[i][j]= new Square(i,j,p);
                        }else {
                            squares[i][j]= new Square(i,j);
                        }
                    }
                } else {
                    squares[i][j]= new Square(i,j);
                }
            }
        }
    }

    public ArrayList<Square> findMovePawn(Pawns p){
        ArrayList<Square> findSquares = new ArrayList<>();
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
        while (squares[i][j].pawns==null && i<8 && j>-1){
            findSquares.add(squares[i][j]);
            i++;
            j--;
        }

        if (squares[i][j].pawns.player.color==opposingColor){
            findSquares.add(squares[i][j]);
        }



        //diagonale avant droite
        i=p.row;
        j=p.columns;
        while (squares[i][j].pawns==null && i<8 && j<8){
            findSquares.add(squares[i][j]);
            i++;
            j++;
        }

        if (squares[i][j].pawns.player.color==opposingColor){
            findSquares.add(squares[i][j]);
        }

        //diagonale arrière gauche
        i=p.row;
        j=p.columns;
        while (squares[i][j].pawns==null && i>-1 && j>-1){
            findSquares.add(squares[i][j]);
            i--;
            j--;
        }

        if (squares[i][j].pawns.player.color==opposingColor){
            findSquares.add(squares[i][j]);
        }

        //diagonal arrière droite
        i=p.row;
        j=p.columns;
        while (squares[i][j].pawns==null && i>-1 && j<8){
            findSquares.add(squares[i][j]);
            i--;
            j++;
        }

        if (squares[i][j].pawns.player.color==opposingColor){
            findSquares.add(squares[i][j]);
        }
        return findSquares;
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

    public Square movePawns(Pawns p , Square b){
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

    public Square[][] getSquares() {
        return squares;
    }

    public void setSquares(Square[][] squares) {
        this.squares = squares;
    }
}
