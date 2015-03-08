package ttt.test;

import org.junit.Test;
import ttt.game.*;
import junit.framework.TestCase;

/**
 * @author Niek
 */
public class TicTacTest extends TestCase {

    public void testIsAWin() {
        TicTacToe t = new TicTacToe();

        System.out.println("testing rows");
        t.place(0,0,1);
        t.place(0,1,1);
        t.place(0,2,1);

        if(!t.isAWin(1))
            fail();

        t.clearBoard();
        t.place(1,0,1);
        t.place(1,1,1);
        t.place(1,2,1);

        if(!t.isAWin(1))
            fail();

        t.clearBoard();
        t.place(2,0,1);
        t.place(2,1,1);
        t.place(2,2,1);

        if(!t.isAWin(1))
            fail();

        System.out.println("testing columns");
        t.clearBoard();
        t.place(0,0,1);
        t.place(1,0,1);
        t.place(2,0,1);

        if(!t.isAWin(1))
            fail();

        t.clearBoard();
        t.place(0,1,1);
        t.place(1,1,1);
        t.place(2,1,1);

        if(!t.isAWin(1))
            fail();

        t.clearBoard();
        t.place(0,2,1);
        t.place(1,2,1);
        t.place(2,2,1);

        if(!t.isAWin(1))
            fail();

        System.out.println("testing diagonals");
        t.clearBoard();
        t.place(0,0,1);
        t.place(1,1,1);
        t.place(2,2,1);

        if(!t.isAWin(1))
            fail();

        t.clearBoard();
        t.place(0,2,1);
        t.place(1,1,1);
        t.place(2,0,1);

        if(!t.isAWin(1))
            fail();

        System.out.println("testing false positives");
        t.clearBoard();
        t.place(0,0,1);
        t.place(1,1,1);
        t.place(2,0,1);

        if(t.isAWin(1))
            fail();
    }

    public void testPositionValue() {
        TicTacToe t = new TicTacToe();

        System.out.println("testing human win");
        t.place(0,0,0);
        t.place(0,1,0);
        t.place(0,2,0);

        if(t.positionValue() != 0)
            fail();

        System.out.println("testing draw");
        t.clearBoard();
        t.place(0,0,1);
        t.place(0,1,1);
        t.place(0,2,0);
        t.place(1,0,0);
        t.place(1,1,0);
        t.place(1,2,1);
        t.place(2,0,1);
        t.place(2,1,0);
        t.place(2,2,1);

        if(t.positionValue() != 1)
            fail();

        System.out.println("testing unclear");
        t.clearBoard();
        if(t.positionValue() != 2)
            fail();

        System.out.println("testing computer win");
        t.clearBoard();
        t.place(0,0,1);
        t.place(0,1,1);
        t.place(0,2,1);

        if(t.positionValue() != 3)
            fail();
    }

    public void testChooseMove() {
        TicTacToe t = new TicTacToe();
        t.place(0,0,0);
        t.place(1,1,1);
        t.place(1,0,0);

        System.out.print(t.toString());
        //t.setComputerPlays();

        int compMove=t.chooseMove();
        System.out.println("Computer Move = " + compMove);

        if(!(compMove == 6))
        {
            fail("Computer made the wrong move: "+ compMove);
        }
    }
}

