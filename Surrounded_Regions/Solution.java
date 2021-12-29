package com.company;

import java.util.*;

/**
 Given an m x n matrix board containing 'X' and 'O', capture all regions surrounded by 'X'.

 A region is captured by flipping all 'O's into 'X's in that surrounded region.



 Example 1:


 Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
 Example 2:

 Input: board = [["X"]]
 Output: [["X"]]
 */

class Solution {
    public void solve(char[][] board) {
        // check borders
        for(int j = 0; j < board[0].length; j++) {
            if(isValid(board, 0, j)) {
                dfs(board, 0, j);
            }

            if(isValid(board, board.length - 1, j)) {
                dfs(board, board.length - 1, j);
            }
        }

        for(int i = 0; i < board.length; i++) {
            if (isValid(board, i, 0)) {
                dfs(board, i, 0);
            }

            if(isValid(board, i, board[0].length - 1)) {
                dfs(board, i, board[0].length - 1);
            }

        }

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '1') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private boolean isValid(char[][] board, int i, int j) {
        return board[i][j] != 'X' && board[i][j] != '1';
    }

    private void dfs(char[][] board, int i, int j) {
        board[i][j] = '1';
        if(i - 1 >= 0 && isValid(board, i - 1, j)) {
            dfs(board, i - 1, j);
        }

        if (i + 1 < board.length && isValid(board, i + 1, j)) {
            dfs(board, i + 1, j);
        }

        if (j - 1 >= 0 && isValid(board, i, j - 1)) {
            dfs(board, i, j - 1);
        }
        if (j + 1 < board[0].length && isValid(board, i, j + 1)) {
            dfs(board, i, j + 1);
        }
    }
}