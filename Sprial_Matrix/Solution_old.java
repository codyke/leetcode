/*Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

You should return [1,2,3,6,9,8,7,4,5]. */

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>(); 
        int m = matrix.length; 
        int n = 0;
        if(m != 0) {
            n = matrix[0].length; 
        }
        if(m == 0 || n == 0) {
            return result; 
        }
        
        int stepX = m; 
        int stepY = n; 
        int startX = 0; 
        int startY = 0; 
        while(stepX > 0 && stepY > 0) {
            int i = startX; 
            int j = startY; 
            for(; j < stepY + startY; j++) {
                result.add(matrix[i][j]); 
            }
            j--;
            for(i++; i < stepX + startX; i++) {
                result.add(matrix[i][j]);
            }
            i--; 
            for(j--; j >= startY; j--) {
                if(i != startX) {
                    result.add(matrix[i][j]); 
                }
            }
            j++; 
            for(i--; i > startX; i--) {
                if(!(j == startY && stepY == 1)) {
                    result.add(matrix[i][j]);
                }
            }
            startX++;
            startY++; 
            stepX -= 2; 
            stepY -= 2; 
        }
        return result;
    }
}