package sample;

import java.awt.*;
import java.util.ArrayList;

public class Pawns {
    protected int row,columns;
    Player player; //player

    public Pawns(int row, int columns, Player player) {
        this.row = row;
        this.columns = columns;
        this.player = player;
    }

    // permet de manger un pion si il n'est pas de la même couleur et renvoie le tab contenant les nouvelles cordonées tab[0] = row et tab[1] = columns
    //si on peut le mange on supprime le pion p de la liste de pion du joueur concerné
    public int[] eatPawns(Pawns p){
        if (p.player.color != player.color){
            row=p.row;
            columns=p.columns;
            p.player.removePawns(p);
            p= null;

             int tab[] ={row,columns};
             return tab;
        }
        return null;
    }

    // permet de deplacer le pions sur i et j, renvoie le tab contenant les nouvelles cordonées tab[0] = row et tab[1] = columns
    public int[] movePawns(int i, int j){
        row=i;
        columns=j;
        int tab[] ={row,columns};
        return tab;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

}
