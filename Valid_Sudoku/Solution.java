/*Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

*/
import java.util.*;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        return check(board);
    }
    
    public boolean check(char[][] board) {
        int m = board.length; 
        int n = board[0].length; 
        int i = 0; 
        int j = 0;
        int[] rowRecord = new int[m]; 
        int[] columnRecord = new int[n]; 
        int[][] subBoxRecord = new int[m/3][n/3]; 
        
        // initialize the record 
        for(i = 0; i < m; i++) {
            rowRecord[i] = 0;
        }
        for(i = 0; i < n; i++) {
            columnRecord[i] = 0;
        }
        for(i = 0; i < m/3; i++) {
            for(j = 0; j < n/3; j++){
                subBoxRecord[i][j] = 0;
            }
        }
        
        // scan the board 
        for(i = 0; i < m; i++){
            for(j = 0; j < n; j++) {
                if(board[i][j] != '.') {
                    int p = 1 << Character.getNumericValue(board[i][j]); 
                    // check row and column 
                    if((rowRecord[i] & p) != 0
                        || (columnRecord[j] & p) != 0
                        || (subBoxRecord[i/3][j/3] & p) != 0) {
                        return false; 
                    } else {
                        rowRecord[i] |= p;
                        columnRecord[j] |= p; 
                        subBoxRecord[i/3][j/3] |= p; 
                    }
                } 
            }
        }
        return true; 
    }
}