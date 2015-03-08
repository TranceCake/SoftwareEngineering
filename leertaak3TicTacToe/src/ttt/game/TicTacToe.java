package ttt.game;

import java.util.Random;
public class TicTacToe
{
    private static final int HUMAN        = 0;
    private static final int COMPUTER     = 1;
    public  static final int EMPTY        = 2;

    public  static final int HUMAN_WIN    = 0;
    public  static final int DRAW         = 1;
    public  static final int UNCLEAR      = 2;
    public  static final int COMPUTER_WIN = 3;

    private int [ ] [ ] board = new int[ 3 ][ 3 ];
    private Random random=new Random();
    private int side=random.nextInt(2);
    private int position=UNCLEAR;
    private char computerChar,humanChar;

    // Constructor
    public TicTacToe( )
    {
        clearBoard( );
        initSide();
    }

    private void initSide()
    {
        if (this.side==COMPUTER) { computerChar='X'; humanChar='O'; }
        else                     { computerChar='O'; humanChar='X'; }
    }

    public void setComputerPlays()
    {
        this.side=COMPUTER;
        initSide();
    }

    public void setHumanPlays()
    {
        this.side=HUMAN;
        initSide();
    }

    public boolean computerPlays()
    {
        return side==COMPUTER;
    }

    public int chooseMove()
    {
        Best best=chooseMove(COMPUTER);
        return best.row*3+best.column;
        //return 0;
    }

    // Find optimal move
    private Best chooseMove( int side )
    {
        int opp;              // The other side
        Best reply;           // Opponent's best reply
        int simpleEval;       // Result of an immediate evaluation
        int bestRow = 0;
        int bestColumn = 0;
        int value = 0;

        if( ( simpleEval = positionValue( ) ) != UNCLEAR )
            return new Best( simpleEval );

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (squareIsEmpty(i, j)) {
                    //System.out.println("pass emty");
                    place(i, j, side);
                    if (side == 1) {
                        reply = chooseMove(0);
                        if (reply.val > value) {
                            bestRow = i;
                            bestColumn = j;
                            value = reply.val;
                        }
                    } else {
                        reply = chooseMove(1);
                        if (reply.val < value) {
                            bestRow = i;
                            bestColumn = j;
                            value = reply.val;
                        }
                    }
                    place(i,j,2);
                } else {
                    System.out.println("pass full: " + i + "." + j);
                }
            }
        }

        return new Best(value, bestRow, bestColumn);
    }

    //check if move ok
    public boolean moveOk(int move)
    {
        return ( move>=0 && move <=8 && board[move/3 ][ move%3 ] == EMPTY );
        //return true;
    }

    // play move
    public void playMove(int move)
    {
        board[move/3][ move%3] = this.side;
        if (side==COMPUTER) this.side=HUMAN;  else this.side=COMPUTER;
    }

    // Simple supporting routines
    public void clearBoard( )
    {
        for(int i = 0; i < 3; i++) {
            board[0][i] = 2;
            board[1][i] = 2;
            board[2][i] = 2;
        }
    }

    private boolean boardIsFull( )
    {
        for(int i  = 0; i < 2; i++) {
            for(int j = 0; j < 2; j++) {
                if(board[i][j] == 2)
                    return false;
            }
        }
        return true;
    }

    // Returns whether 'side' has won in this position
    public boolean isAWin( int side )
    {
        for(int i = 0; i < 3; i++) {
            if((board[i][0] == side) && (board[i][1] == side) && (board[i][2] == side)) {
                return true;
            }
        }

        for(int i = 0; i < 3; i++) {
            if((board[0][i] == side) && (board[1][i] == side) && (board[2][i] == side)) {
                return true;
            }
        }

        return ((side == board[0][0]) && (side == board[1][1]) && (side == board[2][2])) || ((side == board[2][0]) && (side == board[1][1]) && (side == board[0][2]));
    }

    // Play a move, possibly clearing a square
    public void place( int row, int column, int piece )
    {
        board[ row ][ column ] = piece;
    }

    private boolean squareIsEmpty( int row, int column )
    {
        return board[ row ][ column ] == EMPTY;
    }

    // Compute static value of current position (win, draw, etc.)
    public int positionValue( )
    {
        if (isAWin(0))
            return HUMAN_WIN;

        if (isAWin(1))
            return COMPUTER_WIN;

        if (boardIsFull() && !isAWin(0) && !isAWin(1))
            return DRAW;

        return UNCLEAR;
    }

    public String toString()
    {
        String piece = "";

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                switch (board[i][j]) {
                    case 0:
                        piece = piece + humanChar;
                        break;
                    case 1:
                        piece = piece + computerChar;
                        break;
                    case 2:
                        piece = piece + ".";
                }
            }
            piece = piece + "\n";
        }
        return piece;
    }

    public boolean gameOver()
    {
        this.position=positionValue();
        return this.position!=UNCLEAR;
    }

    public String winner()
    {
        if      (this.position==COMPUTER_WIN) return "computer";
        else if (this.position==HUMAN_WIN   ) return "human";
        else                                  return "nobody";
    }

    private class Best
    {
        int row;
        int column;
        int val;

        public Best( int v )
        { this( v, 0, 0 ); }

        public Best( int v, int r, int c )
        { val = v; row = r; column = c; }
    }
}

