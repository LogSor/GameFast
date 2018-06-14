package sample;


import java.awt.*;
import java.util.ArrayList;

public class Player {
    protected String name;
    protected Color color; // couleur du joueur rouge ou bleu
    ArrayList<Pawns> pawns;

    public Player(String n ,Color c) {
        this.name=n;
        this.color=c;
        pawns= new ArrayList<>();
    }

    //add un pion p
    public Pawns addPawns(Pawns p ){

        pawns.add(p);
        return p;
    }

    //supprile le pion p de la liste
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

    // verifie si il lui reste des pions
    public boolean emptyPawns(){
        if (pawns.isEmpty()){
            return true;
        }
        return false;
    }
}
