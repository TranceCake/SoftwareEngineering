package cards;
import java.util.Stack;
/** the solution is a sequence of cards placed on the board according to the card positions
 example without border
 */
public class Solution extends Stack<Candidate>
{
    // The board is an 2D array.
    //   0 1 2 3
    // 0 . . - .
    // 1 - - - .
    // 2 . - - -
    // 3 . . - .
    private Candidate[][] board = new Candidate[4][4];

    // card positions on the board
    // the first card position on the board are
    // {0,2}, {1,0}. {1,1}
    private int[] row    = { 0, 1, 1, 1, 2, 2, 2, 3 };
    private int[] column = { 2, 0, 1, 2, 1, 2, 3, 2 };
    //  indices of adjacent cards in the solution.
    //                 0   1  2   3   4    5     6    7
    int [] [] check = {{},{},{1},{0},{2},{3,4},{5,6},{7}};

    public static void main(String[] args){
        Problem p = new Problem();
        p.solve();
    }

    public Solution(){
    }


    // Checks whether a candidate with card CardChar is in
    // an adjacent position of the board position (row, column)
    // @param row, column, candidate
    // @return Boolean indicating if cardChar is found.
    // can be used in the methods fits and isCorrect
    private boolean bordersCard(int row, int column, char cardChar) {

        boolean found = false;
        //make list for all 4 sides (north, south, west, east)
        Candidate [] temp = new Candidate[4];

        //check North and add to list (temp) by asking if the row is
        if(row-1 > -1){
            temp[0] = board[row-1][column];
        }

        //check South and add to list (temp)
        if(row+1<4){
            temp[1] = board[row+1][column];
        }

        //check West and add to list (temp)
        if(column-1>-1){
            temp[2] = board[row][column-1];
        }

        //check East and add to list (temp)
        if(column+1<4){
            temp[3] = board[row][column+1];
        }

        //go through loop to find if they are matching with cardChar
        for(int i=0;i<4;i++){
            if(temp[i] != null && cardChar == temp[i].getCardChar()){
                found = true;
            }
        }
        return found;
    }


    /**
     * Checks whether candidate card of same kind.
     * Checks whether by placing candidate the solution sofar still complies with the rules
     * @param candidate
     * @return boolean indicating whether this candidate can be put in the
     * next free position.
     */
    public boolean fits(Candidate candidate){

        int i = this.size();

        if (bordersCard(row[i], column[i], candidate.getCardChar())) {
            return false;
        }

        return true;
    }

    public void record(Candidate candidate)
    {
        int i=this.size(); // i= index in this stack of next for the next candidate
        board [row[i]] [column[i]] = candidate; //x=row, y=column
        this.push(candidate);

    }

    public boolean complete()
    {
        return this.size()==8;
    }

    public void show()
    {
        if(isCorrect()) {
            System.out.println(this);
        }
    }

    public Candidate eraseRecording()
    {
        int i=this.size()-1;           // i= index of the candidate that is removed from this Stack;
        board[row[i]][column[i]]=null; // remove candidate from board
        return this.pop();
    }

    // can be used in method isCorrect
    private char mustBeAdjacentTo(char card)
    {
        if (card=='A') return 'K';
        if (card=='K') return 'Q';
        if (card=='Q') return 'J';
        return '?'; //error
    }

    /**
     * Checks whether the rules below are fulfilled
     * For the positions that can be checked for solution sofar.
     * Rules:
     * Elke aas (ace) grenst (horizontaal of verticaal) aan een heer (king).
     * Elke heer grenst aan een vrouw (queen).
     * Elke vrouw grenst aan een boer (jack).
     * @return true if all checks are correct.
     */
    // uses methods borderCard and mustBeAdjacent to
    private boolean isCorrect() {

        for (int i = 0; i < row.length; i++) {

            int row = this.row[i];
            int col = this.column[i];

            Candidate c = board[row][col];
            char adjacentChar = mustBeAdjacentTo(c.getCardChar());

            if (adjacentChar != '?' && c != null) {

                if (!bordersCard(row, col, adjacentChar)) {
                    return false;
                }
            }
        }
        return true;
    }


    /**
     * @return a representation of the solution on the board
     */
    public String toString(){
        String result ="";

        //taking the r for rows and c for columns
        for(int r = 0; r<4; r++){
            for(int c = 0; c<4; c++){

                if(board[r][c] != null){
                    result += "|"+board[r][c].getCardChar() + "|";
                } else {
                    result += "|_|";
                }
            }
            result += "\n";
        }

        return result;
    }
}