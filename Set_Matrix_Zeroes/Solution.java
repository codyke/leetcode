/* Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.

click to show follow up.
Follow up:

Did you use extra space?
A straight forward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
*/

public class Solution {
    public void setZeroes(int[][] matrix) {
        int row = matrix.length; 
        int column = 0; 
        if(row != 0) {
            column = matrix[0].length; 
        }
        if(row == 0 || column == 0) {
            return; 
        }
        // usr first row and first column to record 
        int firstRow = 1; 
        int firstColumn = 1; 
        // check first row and column 
        for(int i = 0; i < row; i++) {
            if(matrix[i][0] == 0) {
                firstColumn = 0; 
                break;
            }
        }
        for(int i = 0; i < column; i++) {
            if(matrix[0][i] == 0) {
                firstRow = 0; 
                break;
            }
        }
        for(int i = 1; i < row; i++) {
            for(int j = 1; j < column; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0; 
                    matrix[i][0] = 0; 
                }
            }
        }
        
        // set 0 
        for(int i = 1; i< row; i++) {
            if(matrix[i][0] == 0) {
                for(int j = 1; j < column; j++) {
                    matrix[i][j] = 0; 
                }
            }
        }
        
        for(int j = 1; j < column; j++) {
            if(matrix[0][j] == 0) {
                for(int i = 1; i < row; i++) {
                    matrix[i][j] = 0; 
                }
            }
        }
        if(firstRow == 0) {
            for(int j = 0; j < column; j++) {
                matrix[0][j] = 0; 
            } 
        }
        if(firstColumn == 0) {
            for(int i = 0; i < row; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}