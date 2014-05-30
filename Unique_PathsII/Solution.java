/*Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,

There is one obstacle in the middle of a 3x3 grid as illustrated below.

[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]

The total number of unique paths is 2.

Note: m and n will be at most 100.*/

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length; 
        int n = obstacleGrid[0].length; 
        int i, j;
        
        int[][] uPath = new int[m][n];
        if (obstacleGrid[0][0] == 0) {
            uPath[0][0] = 1;
        } else {
            uPath[0][0] = 0;
        }
        
        // initialize the uPath[i][0] and uPath[0][j]
        for(i = 1; i < m; i++) {
            if (obstacleGrid[i][0] == 0 && uPath[i -1][0] == 1) {
                uPath[i][0] = 1;
            }else {
                uPath[i][0] = 0;
            }
        }
        
        for(j = 1; j < n; j++) {
            if (obstacleGrid[0][j] == 0 && uPath[0][j - 1] == 1) {
                uPath[0][j] = 1; 
            } else {
                uPath[0][j] = 0;
            }
        }
        
        for(i = 1; i < m; i++) {
            for(j = 1; j < n; j++) {
                if(obstacleGrid[i][j] == 0) {
                    uPath[i][j] = uPath[i - 1][j] + uPath[i][j - 1]; 
                } else {
                    uPath[i][j] = 0;
                }
            }
        }
        return uPath[m - 1][n - 1];
    }
}