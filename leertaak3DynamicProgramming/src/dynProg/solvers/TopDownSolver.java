package dynProg.solvers;

import dynProg.Solver;

/**
 * Created by Tanja on 7-3-2015.
 */
public class TopDownSolver implements Solver {

    private TopDownSolver solver;

    public TopDownSolver(){

    }

    @Override
    public boolean solve(int[] numbers, int sum) {

        if (sum == 0) return true; //no need to count, 0 is 0
        else if (sum < 0) return false; //base condition
        else if (numbers.length == 0) return false; // there's no base case

        int[] newNumbers = new int[numbers.length - 1]; //make sub problem
        for (int i = numbers.length; i > 0; i--) {
            for (int j = 0; j < numbers.length; j++) {
                if (j == i - 1) ;
                else if (j > i - 1) newNumbers[j - 1] = numbers[j];
                else newNumbers[j] = numbers[j];
            }

        }
        return false;
    }

}
