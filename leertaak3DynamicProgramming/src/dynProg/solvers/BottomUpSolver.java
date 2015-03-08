package dynProg.solvers;

import dynProg.Solver;

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
public class BottomUpSolver implements Solver {

    private int[][] matrix;
    public BottomUpSolver(){

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
        System.out.println(isSolved(sum));
        return isSolved(sum);
    }

    private boolean isSolved(int sum) {
        if (sum <= matrix[0].length) {
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][sum - 1] != 0)
                    return true;
            }
        }
        return false;
    }
}
