package sample;

public class Box {
    /*
    Box of board (case du plateau)
     */


    protected int row,columns ; // Row, columns
    protected Pawns pawns; // pawns of box


    public Box(int row, int columns) {

        this.row = row;
        this.columns = columns;
        this.pawns=null;
    }

    public Box(int row, int columns, Pawns pawns) {

        this.row = row;
        this.columns = columns;
        this.pawns = pawns;
    }

    // getters setters
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

    public Pawns getPawns() {
        return pawns;
    }

    public void setPawns(Pawns pawns) {
        this.pawns = pawns;
    }

    public String toString() {

        return "Row:"+row+"Colums:" +columns+" Pawns :"+ pawns.toString();
    }
}
