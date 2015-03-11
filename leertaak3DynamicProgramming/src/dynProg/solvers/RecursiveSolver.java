package dynProg.solvers;

import dynProg.Solver;

/**
 * Created by Tanja en Njiek
 */
public class RecursiveSolver implements Solver {

    public RecursiveSolver() {}

    @Override
    public boolean solve(int[] numbers, int sum) {

        if(sum == 0) return true;
        else if(sum<0)return false;
        else if(numbers.length == 0)return false;

        int[] newNumbers = new int[numbers.length-1];
        for (int i = numbers.length; i>0; i--){
            int newSum = sum - numbers[i-1];
            for (int j=0; j<numbers.length; j++)
            {
                if (j>i-1) {
                    newNumbers[j-1] = numbers[j];
                } else if (j<i-1) {
                    newNumbers[j] = numbers[j];
                }
            }
            if (solve(newNumbers,newSum)) {
                return true;
            }

        }
        return false;
    }
}