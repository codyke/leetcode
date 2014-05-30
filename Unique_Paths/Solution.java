/*A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?*/

public class Solution {
    public int uniquePaths(int m, int n) {
        // DP: for any grid[m][n], the unique path to this
        // grid is equal to the sum of unique paths from left grid
        // and upper grid to it
        // so grid[m][n] = grid[m-1][n] + grid[m][n-1]
        
        int[][] grid = new int[m][n];
        int i, j;
        
        for(i = 0; i < m; i++) {
            grid[i][0] = 1;
        }
        
        for(j = 0; j < n; j++) {
            grid[0][j] = 1;
        }
        
        for(i = 1; i < m; i++) 
            for(j = 1; j < n; j++) {
                grid[i][j] = grid[i-1][j] + grid[i][j-1];
            }
        return grid[m-1][n-1];
    }
    /* may pass the small test case, but time limit erro for large test case
    public class node {
        int m;
        int n;
        int step; // 0 for down node, 1 for right node
                  // -1 for not start yet
        node(int M, int N){
            m = M;
            n = N;
            step = -1;
        }
    }
    
    public int uniquePaths(int m, int n) {
        // DFS non recursive version
        ArrayList<node> nodeStack = new ArrayList<node>();
        int pathNum = 0;
        // 0 for available, 1 for unavailable
        int[][] availableGrid = new int[m][n];
        
        // initialize the array
        int i, j;
        for(i = 0; i < m; i++){
            for(j = 0; j < n; j++){
                availableGrid[i][j] = 0;
            }
        }
        
        // push first node to stack
        node startPoint = new node(0, 0); 
        nodeStack.add(startPoint); 
        availableGrid[0][0] = 1;
        int nextM; 
        int nextN;
        while(!nodeStack.isEmpty()){
            node tmp = nodeStack.get(nodeStack.size() - 1);
            // if we reach the finish point, pop the node and increase pathNum;
            if (tmp.m == m - 1 && tmp.n == n - 1){
                availableGrid[tmp.m][tmp.n] = 0;
                nodeStack.remove(nodeStack.size() - 1);
                pathNum++;
                continue;
            }
            // otherwise continue to search
            nextM = -1;
            nextN = -1;
            switch(tmp.step) {
                case -1:
                    // try down neighbor 
                    tmp.step++;
                    if(tmp.n + 1 < n && availableGrid[tmp.m][tmp.n + 1] == 0) {
                        // below neighbor available 
                        nextM = tmp.m;
                        nextN = tmp.n + 1;
                        break;
                    }
                case 0:
                    // try upper neighbor
                    tmp.step++;                    
                    if(tmp.m + 1 < m && availableGrid[tmp.m + 1][tmp.n] == 0) {
                        //right neighbor available
                        nextM = tmp.m + 1;
                        nextN = tmp.n;
                        break;
                    }
                 default:
                    break;
            }
            if (nextM != -1 && nextN != -1) {
                // find available neighbor
                // push it to stack
                node nextNeighbor = new node(nextM, nextN);
                nodeStack.add(nextNeighbor);
                availableGrid[nextM][nextN] = 1;
            } else {
                // no available neighbor 
                // pop it and reset the grid
                availableGrid[tmp.m][tmp.n] = 0;
                nodeStack.remove(nodeStack.size() - 1);
            }
        }
        return pathNum;
    }*/
}