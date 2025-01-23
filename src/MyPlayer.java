import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;

    public ArrayList<Board> losers = new ArrayList<>(); // losing boards
    public ArrayList<Board> winners = new ArrayList<>();// winning boards

    public MyPlayer() {
        columns = new int[10];

        int array[][] = new int[3][3];

        Board d = new Board(1,0,0,0,0);
        losers.add(d);

        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */

        print3x3boards(); // all possible boards and how to manipulate them into losers

        System.out.println("winners");

        for(int x = 0; x < winners.size(); x++){
            winners.get(x).printInfo();
        }

        System.out.println("losers");

        for (int x = 0; x < losers.size(); x++){
            losers.get(x).printInfo();
        }
        System.out.println();
    }

    public Point move(Chip[][] pBoard) {

//        System.out.println("MyPlayer Move");

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
        System.out.println();
        System.out.println("MY PLAYER CLICKED");

        for (int c = 0; c < columns.length; c++) {
            int count = 0;
            for (int r = 0; r < gameBoard.length; r++) {
                if (gameBoard[r][c].isAlive) {
                    count++;
                }
            }
            columns[c] = count;
        }
        System.out.println(Arrays.toString(columns));

        System.out.println();


        Point myMove = new Point(row, column);
        return myMove;
    }

    public void print3x3boards() {
        for (int i = 1; i <= 3; i++) {
            for (int j = 0; j <= 3; j++) {
                for (int k = 0; k <= 3; k++) {
                    if (i >= j && j >= k) {
                        System.out.println("board");
                        System.out.println(i + " " + j + " " + k);
                        oneMove(i, j, k);
                        System.out.println();
                    }
                }
            }
        } // all 3x3 boards
        System.out.println();
    }


    public void oneMove(int i, int j, int k) {
        boolean isLoser = false;
        System.out.println("one move");
        int r = 0;
        int c = 0;


        int m;
        int t;
        if(k > 0) {
            for (m = k - 1; m >= 0; m--) {
                System.out.println(i + " " + j + " " + m + " (" + m + ", " + 2 + ")");
                for(t = 0; t < losers.size(); t++) { // all losing boards
                    if (i == losers.get(t).cols[0] && j == losers.get(t).cols[1] &&
                            m == losers.get(t).cols[2]) {
                        isLoser = true;
                        r = m;
                        c = 2;
                    }
                }
            }
        }

        int n;
        if(j > 0) {
            for (n = j - 1; n >= 0; n--) {
                if (n < k) {
                    System.out.println(i + " " + n + " " + n + " (" + n + ", " + 1 + ")");
                    for(t = 0; t < losers.size(); t++) {
                        if(i == losers.get(t).cols[0] && n == losers.get(t).cols[1] &&
                                n == losers.get(t).cols[2]) {
                            isLoser = true;
                            r = n;
                            c = 1;
                        }
                    }
                } else {
                    System.out.println(i + " " + n + " " + k + " (" + n + ", " + 1 + ")");
                    for(t = 0; t < losers.size(); t++) {
                        if (i == losers.get(t).cols[0] && n == losers.get(t).cols[1] &&
                                k == losers.get(t).cols[2]) {
                            isLoser = true;
                            r = n;
                            c = 1;
                        }
                    }
                }
            }
        }

        int p;
        if(i >= 2) {
            for (p = i - 1; p >= 1; p--) {
                if (p < j) {
                    System.out.println(p + " " + p + " " + p + " (" + p + ", " + 0 + ")");
                    for(t = 0; t < losers.size(); t++) {
                        if (p == losers.get(t).cols[0] && p == losers.get(t).cols[1] &&
                                p == losers.get(t).cols[2]) {
                            isLoser = true;
                            r = p;
                            c = 0;
                        }
                    }
                } else {
                    System.out.println(p + " " + j + " " + k + " (" + p + ", " + 0 + ")");
                    for(t = 0; t < losers.size(); t++) {
                        if (p == losers.get(t).cols[0] && j == losers.get(t).cols[1] &&
                                k == losers.get(t).cols[2]) {
                            isLoser = true;
                            r = p;
                            c = 0;
                        }
                    }
                }
            }
        }
        int x;
        int y;

        if(isLoser){
            winners.add(new Board(i, j, k, r, c));
        } else {
           c = 0;

           if(i > 1){
                x = 1;
                y = 0;
           } else{
                x = 0;
                y = 1;
           }

            losers.add(new Board(i, j, k, x, y));
        }

    }
}