package dynProg.solvers;

import dynProg.Solver;

/**
 * Created by Tanja on 7-3-2015.
 */
public class RecursiveSolver implements Solver {

    public RecursiveSolver(){

    }

    @Override
    public boolean solve(int[] numbers, int sum) {
        if (numbers.length != 0) { // Check if there's a base case reached
            for (int i = 0; i < numbers.length; i++) { // loop through the given numbers
                int sumB = numbers[i];

                for (int j = i + 1; j < numbers.length; j++) { // j = i because all numbers below equal i have been looped through
                    sumB += numbers[j];

                    if (sumB == sum || sumB - numbers[j - 1] == sum) { // Can the given numbers produce the wanted sum?
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
