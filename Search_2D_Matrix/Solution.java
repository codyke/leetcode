/*Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]

Given target = 3, return true.*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length; 
        int n = matrix[0].length; 
        boolean result = false;
        if (m == 0 || n == 0) {
            return result; 
        }
        int i, j;
        for(i = 0; i < m; i++) {
            if (target == matrix[i][n -1]) {
                result = true;
                return result;
            } else if (target < matrix[i][n - 1]) {
                // the target is in current row
                // search the current row 
                for(j = n -1; j >= 0; j--) {
                    if (target == matrix[i][j]) {
                        result = true; 
                        return result;
                    }
                }
                // if not found, return false 
                return result; 
            }
        }
        return result;
        
    }
}