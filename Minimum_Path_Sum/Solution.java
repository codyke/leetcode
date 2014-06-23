/*Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.*/

public class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length; 
        int column = 0; 
        if(row != 0) {
            column = grid[0].length;
        }
        if(row == 0 || column == 0) {
            return 0; 
        }
        int[][] result = new int[row][column]; 
        
        // initialize first row and first column 
        result[0][0] = grid[0][0];
        for(int j = 1; j < column; j++) {
            result[0][j] = grid[0][j] + result[0][j - 1]; 
        }
        for(int i = 1; i < row; i++) {
            result[i][0] = grid[i][0] + result[i - 1][0]; 
        }
        
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < column; j++) {
                result[i][j] = grid[i][j] + (result[i - 1][j] < result[i][j - 1] ? result[i - 1][j] : result[i][j - 1]); 
            }
        }
        return result[row - 1][column - 1];
    }
}