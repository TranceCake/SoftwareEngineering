package dynProg.solvers;

import dynProg.Solver;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tanja on 7-3-2015.
 */

// M(i, j) = M(rij, sum)
// 1: pak eerste getal en tel die op
// 2: pak twee getallen en voeg alle sommen hiervan toe

// getallen: 3, 5, 7, 9, 11
// 1: 3 (numbers[i])
// 2: 3, 5
// 3: 3, 5, 7
// 4: 3, 5, 7, 9
// 5: 3, 5, 7, 9, 11
public class TopDownSolver implements Solver {

    private int[][] matrix;
    private static List<Solution> solutions;
    public TopDownSolver(){

    }

    @Override
    public boolean solve(int[] numbers, int sum) {
        try {
            int tmpSum = 0;
            for (int i = 0; i < numbers.length; i++) {
                if (numbers[i] >= 0) {
                    tmpSum += numbers[i];
                }
            }
            if(solutions == null){
                solutions = new ArrayList<Solution>();
            }
            for (Solution solution : solutions) {
                if(solution.numbers == numbers && solution.sum == sum){
                    return solution.result;
                }
            }
            matrix = new int[numbers.length][tmpSum];

            for (int i = 0; i < numbers.length; i++) {
                int sumB = 0;
                for (int j = 0; j <= i; j++) {
                    // Place current
                    matrix[i][numbers[j] - 1] = 1;

                    // do SumB
                    sumB += numbers[j];
                    matrix[i][sumB - 1] = 1;

                    // do SumB - current
                    if (j > 0) {
                        tmpSum = sumB - numbers[j - 1];
                        matrix[i][tmpSum - 1] = 1;
                    }
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        if (sum <= matrix[0].length) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][sum - 1] != 0) {
                   solutions.add(new Solution(numbers,sum,true));
                    return true;
                }
                else{
                    solutions.add(new Solution(numbers,sum,false));
                }
            }

        }

        return false;
    }
}

class Solution{
    public int[] numbers;
    public int sum;
    public boolean result;

        public Solution(int[] numbers, int sum, boolean result){

            this.numbers = numbers;
            this.sum = sum;
            this.result = result;
        }
}