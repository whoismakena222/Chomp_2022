import java.awt.*;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    public int[] rows;

    public MyPlayer() {
        columns = new int[10];
        rows = new int[10];

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */

        for(int i = 0; i < columns.length; i++){
            columns[i] = 0;
            for(int j = 0; j < rows.length; i++){
                if (gameBoard[i][j].isAlive == true){
                    System.out.println("chip at row: " + i + "column: " + j);
                }
            }
        }
    }

    public Point move(Chip[][] pBoard) {

        System.out.println("MyPlayer Move");

        gameBoard = pBoard;
        int column = 0;
        int row = 0;

        row = 1;
        column = 1;

        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */

        // add code to fill in the columns array
        // so that it represents the gameBoard in number form
        // print your columns array to show its working
        System.out.println("MY PLAYER CLICKED");



        Point myMove = new Point(row, column);
        return myMove;
    }

}
