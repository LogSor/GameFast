package sample;

public class Model {
    protected Board board;
    protected Party party;

    public Model() {
        board=new Board(); // initialisation of board
        party= new Party(board); // too party
    }


}
