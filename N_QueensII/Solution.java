/*Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.*/

public class Solution {
    int result; 
    public int totalNQueens(int n) {
        result = 0; 
        if(n == 0) {
            return result; 
        }

        int[][] board = new int[n][n]; 
        int[] row = new int[n]; 
        int[] column = new int[n]; 
        placeQueens(n, 0, board, row, column, n); 
        return result; 
    }
    
    public void placeQueens(int n, int startRow, int[][] board, int[] row, int[] column, int leftQueen) {
        if(leftQueen == 0) {
            result++;
            return; 
        }
        int i = startRow; 
        for(int j = 0; j < n; j++) {
            if(row[i] != 1 && column[j] != 1) {
                // check diagonal 
                boolean valid = true;
                int k = i; 
                int l = j; 
                while(++k < n && ++l < n) {
                    if(board[k][l] == 1) {
                        valid = false; 
                        break;
                    }
                }
                if(valid == false) {
                    continue; 
                } 
                k = i; 
                l = j; 
                while(--k >= 0 && --l >=0) {
                    if(board[k][l] == 1) {
                        valid = false; 
                        break; 
                    }
                }
                if(valid == false) {
                    continue; 
                }
                k = i; 
                l = j; 
                while(--k >=0 && ++l < n) {
                    if(board[k][l] == 1) {
                        valid = false; 
                        break;
                    }
                }
                if(valid == false) {
                    continue; 
                } 
                k = i; 
                l = j; 
                while(++k < n && --l >=0) {
                    if(board[k][l] == 1) {
                        valid = false; 
                        break;
                    }
                }
                if(valid == false) {
                    continue; 
                } 
                
                board[i][j] = 1; 
                row[i] = 1; 
                column[j] = 1; 
                placeQueens(n, startRow + 1, board, row, column, leftQueen - 1);
                board[i][j] = 0; 
                row[i] = 0; 
                column[j] = 0; 
            }
        }
    }
}