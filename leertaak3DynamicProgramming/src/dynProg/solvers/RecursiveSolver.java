package dynProg.solvers;

import dynProg.Solver;

/**
 * Created by Tanja on 7-3-2015.
 */
public class RecursiveSolver implements Solver {

    public RecursiveSolver() {

    }

    @Override
    public boolean solve(int[] numbers, int sum) {
        if (sum == 0) { //without adding anything you have 0 as a sum
            return true;
        }
        if (numbers.length == 0) { //you can't make a sum without any numbers
            return false;
        }

        int n = numbers.length - 1; //make a subproblem with 1 less in the int array
        int[] rec = new int[n];
        for (int i = 0; i < n; i++) { //loop through the array
            rec[i] = numbers[i];
        }

        return solve(rec, sum) || solve(rec, sum - numbers[n]);
    }
}