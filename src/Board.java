public class Board {
    int[] cols = new int[3]; // columns in the board
    int winRow, winCol; // coordinate move I want to make

    public Board( int x,int y, int z, int pWinRow, int pWinCol ){

        cols[0]=x;
        cols[1]=y;
        cols[2]=z;
        winRow= pWinRow;
        winCol= pWinCol;
    }

    public void printInfo(){
        System.out.println("("+cols[0]+","+cols[1]+","+cols[2]+") ("+winRow+","+winCol+")");
    }

}
