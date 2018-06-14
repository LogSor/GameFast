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
