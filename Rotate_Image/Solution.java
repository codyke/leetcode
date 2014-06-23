/*You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?*/

public class Solution {
    public void rotate(int[][] matrix) {
        // two setps
        
        // first step: switch matrix[i][j] and matrix[j][i] 
        if(matrix == null) {
            return; 
        }
        int x = matrix.length; 
        if (x == 0) {
            return; 
        }
        int y = matrix[0].length; 
        for(int i = 0; i < x; i++) {
            for(int j = 0; j <= i; j++) {
                int tmp = matrix[i][j]; 
                matrix[i][j] = matrix[j][i]; 
                matrix[j][i] = tmp;
            }
        }
        
        // second step: mirror the matrix 
        for(int j = 0; j < y / 2; j++) {
            for(int i = 0; i < x; i++) {
                int tmp = matrix[i][j]; 
                matrix[i][j] = matrix[i][y - j - 1]; 
                matrix[i][y - j - 1] = tmp;
            }
        }
    }
}