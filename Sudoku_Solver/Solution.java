/*Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution. */

public class Solution {
    public void solveSudoku(char[][] board) {
        ArrayList<HashSet<Integer>> row = new ArrayList<HashSet<Integer>>(); 
        ArrayList<HashSet<Integer>> column = new ArrayList<HashSet<Integer>>();
        ArrayList<HashSet<Integer>> square = new ArrayList<HashSet<Integer>>();
        
        int i = 0; 
        int j = 0; 
        int k = 0; 
        for(i = 0; i < 9; i++) {
            HashSet<Integer> hashSet = new HashSet<Integer>(); 
            row.add(hashSet); 
            HashSet<Integer> hashSet1 = new HashSet<Integer>(); 
            column.add(hashSet1); 
            HashSet<Integer> hashSet2 = new HashSet<Integer>(); 
            square.add(hashSet2); 
        }
        for(i = 0; i < 9; i++) {
            for(j = 0; j < 9; j++) {
                if(board[i][j] != '.') {
                    // set up set
                    HashSet<Integer> set = row.get(i); 
                    int num = Character.getNumericValue(board[i][j]); 
                    set.add(num); 
                    set = column.get(j); 
                    set.add(num); 
                    set = square.get(i / 3 * 3 + j / 3 ); 
                    set.add(num); 
                }
            }
        }
        
        sudoku(board, row, column, square);
    }
    public boolean sudoku(char[][] board, ArrayList<HashSet<Integer>> row, ArrayList<HashSet<Integer>> column , ArrayList<HashSet<Integer>> square) {
        // find the first cell which is '.'
        int i = 0; 
        int j = 0; 
        for(i = 0; i < 9; i++) {
            for(j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    break; 
                }
            }
            if(j < 9) {
                break;
            }
        }
        if(i >= 9 && j >= 9) {
            // find the answer 
            return true; 
        }
        
        // try 1~9 and find an available one
        int k = 0;
        for(k = 1; k <= 9; k++) {
            if(!row.get(i).contains(k) 
                && !column.get(j).contains(k) 
                && !square.get(i / 3 * 3 + j / 3).contains(k)) {
                    row.get(i).add(k);
                    column.get(j).add(k);
                    square.get(i / 3 * 3 + j / 3).add(k);
                    board[i][j] = Character.forDigit(k, 10); 
                    if(sudoku(board, row, column, square) == true) {
                        return true; 
                    } else {
                        row.get(i).remove(k);
                        column.get(j).remove(k); 
                        square.get(i / 3 * 3 + j / 3).remove(k); 
                        board[i][j] = '.';
                    }
            }
        }
        return false;
    }
}