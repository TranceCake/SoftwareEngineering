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
    }

    // Find optimal move
    private Best chooseMove( int side )
    {
        int opp;              // The other side
        Best reply;           // Opponent's best reply
        int simpleEval;       // Result of an immediate evaluation
        int bestRow = 0;
        int bestColumn = 0;
        int value;

        if( ( simpleEval = positionValue( ) ) != UNCLEAR )
            return new Best(simpleEval);

        if(side == HUMAN) {
            value = COMPUTER_WIN;
            opp = COMPUTER;
        } else {
            value = HUMAN_WIN;
            opp = HUMAN;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (squareIsEmpty(i, j)) {

                    place(i, j, side);
                    if (side == HUMAN) {
                        reply = chooseMove(opp);
                        if (reply.val < value) {
                            bestRow = i;
                            bestColumn = j;
                            value = reply.val;
                        }
                    } else {
                        reply = chooseMove(opp);
                        if (reply.val > value) {
                            bestRow = i;
                            bestColumn = j;
                            value = reply.val;
                        }
                    }
                    place(i,j,EMPTY);
                }
            }
        }

        return new Best(value, bestRow, bestColumn);
    }

    //check if move ok
    public boolean moveOk(int move)
    {
        return ( move>=0 && move <=8 && board[move/3 ][ move%3 ] == EMPTY );
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
                if(board[i][j] == EMPTY)
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

        for(int j = 0; j < 3; j++) {
            if((board[0][j] == side) && (board[1][j] == side) && (board[2][j] == side)) {
                return true;
            }
        }

        if((side == board[0][0]) && (side == board[1][1]) && (side == board[2][2])) {
            return true;
        } else if((side == board[2][0]) && (side == board[1][1]) && (side == board[0][2])) {
            return true;
        }

        return false;
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
        if (isAWin(HUMAN)) {
            return HUMAN_WIN;
        } else if (isAWin(COMPUTER)) {
            return COMPUTER_WIN;
        } else if (boardIsFull()) {
            return DRAW;
        } else {
            return UNCLEAR;
        }
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

