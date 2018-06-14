package sample;


import java.awt.*;
import java.util.ArrayList;

public class Player {
    protected String name;
    protected Color color;
    ArrayList<Pawns> pawns;

    public Player(String n ,Color c) {
        this.name=n;
        this.color=c;
        pawns= new ArrayList<>();
    }

    public Pawns addPawns(Pawns p ){

        pawns.add(p);
        return p;
    }
    public Pawns removePawns(Pawns p){
        for (Pawns tmp: pawns
             ) {
            if(tmp.equals(p)){
                pawns.remove(p);
                return p;
            }
        }

        return null;
    }

    public boolean emptyPawns(){
        if (pawns.isEmpty()){
            return true;
        }
        return false;
    }
}
