package sample;

public class Party {

    protected Board board;
    protected Boolean isFinish;
    protected Player winner;
    protected int nbRound;

    public Party(Board board) {
        this.board = board;
        this.isFinish = false;
    }

    public boolean partyIsFinish() {
        if (board.redPlayer.emptyPawns()) {

            winner=board.bluePlayer;
            return true;
        }
        else if( board.bluePlayer.emptyPawns()){
            winner=board.redPlayer;
            return true;
        }

        Player p = board.cannotMove();
        if (p!=null){
            if (p==board.bluePlayer){
                winner=board.redPlayer;
            }else {
                winner=board.bluePlayer;
            }
            return true;
        }

        return false;
    }

    public void resultOfparty(){
        if(partyIsFinish()){
            System.out.println("winner is "+ winner);
        }
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Boolean getFinish() {
        return isFinish;
    }

    public void setFinish(Boolean finish) {
        isFinish = finish;
    }
}
