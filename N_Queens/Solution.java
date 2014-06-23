/*The n-queens puzzle is the problem of placing n queens on an n¡Án chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
*/

public class Solution {
    List<String[]> result = new ArrayList<String[]>(); 
    
    public List<String[]> solveNQueens(int n) {
        if(n == 0) {
            return result; 
        }
        char[][] board = new char[n][n]; 
        int[] row = new int[n]; 
        int[] column = new int[n]; 
        for(int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        placeQueens(n, 0, board, row, column, n); 
        return result; 
    }
    public void placeQueens(int n, int startRow, char[][] board, int[] row, int[] column, int leftQueen) {
        if(leftQueen == 0) {
            String[] s = new String[n]; 
            for(int i = 0; i < n; i++) {
                s[i] = String.valueOf(board[i]); 
            }
            result.add(s); 
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
                    if(board[k][l] == 'Q') {
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
                    if(board[k][l] == 'Q') {
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
                    if(board[k][l] == 'Q') {
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
                    if(board[k][l] == 'Q') {
                        valid = false; 
                        break;
                    }
                }
                if(valid == false) {
                    continue; 
                } 
                
                board[i][j] = 'Q'; 
                row[i] = 1; 
                column[j] = 1; 
                placeQueens(n, startRow + 1, board, row, column, leftQueen - 1);
                board[i][j] = '.'; 
                row[i] = 0; 
                column[j] = 0; 
            }
        }
    }
}