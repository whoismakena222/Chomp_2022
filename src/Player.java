import java.awt.*;

// this class runs when the "Computer" button is pressed
// the computer will make a random move

public class Player {

    public Chip[][] gameBoard;


    public Point move(Chip[][] pBoard){

        gameBoard = pBoard;
        Point myMove = new Point(0,0);
        //return a random move in the form of x, y or row, column

            System.out.println("Player");

            int randomCol;
            int randomRow;

            do {
                randomRow = (int) (Math.random() * 10);
                randomCol = (int) (Math.random() * 10);
            }while(!gameBoard[randomRow][randomCol].isAlive);

            myMove = new Point(randomRow,randomCol);


        return myMove;
    }



}
