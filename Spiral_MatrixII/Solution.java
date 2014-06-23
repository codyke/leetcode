/*Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,
You should return the following matrix:

[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
*/

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n]; 
        
        int step = n; 
        int startX = 0; 
        int startY = 0; 
        int num = 1;
        while(step > 0) {
            int i = startX; 
            int j = startY; 
            for(; j < step + startY; j++) {
                result[i][j] = num++; 
            }
            j--; 
            for(i++; i < step + startX; i++) {
                result[i][j] = num++; 
            }
            i--;
            for(j--; j >= startY; j--) {
                result[i][j] = num++; 
            }
            j++;
            for(i--; i >= startX + 1; i--) {
                result[i][j] = num++; 
            }
            startX++;
            startY++; 
            step -= 2; 
        }
        return result;
    }
}