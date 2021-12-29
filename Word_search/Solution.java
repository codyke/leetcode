package com.company;

import java.util.*;

/**
 Given an m x n grid of characters board and a string word, return true if word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.



 Example 1:


 Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 Output: true
 Example 2:


 Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 Output: true
 Example 3:


 Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 Output: false
 */


class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int columns = board[0].length;
        char[][] visited = new char[rows][columns];
        for(int i = 0; i < rows; i++) {
            Arrays.fill(visited[i], '0');
        }

        for(int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (checkExist(board, i, j, word, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkExist(char[][] board, int curRow, int curCol, String word, int curIndex, char[][] visited) {
        if (board[curRow][curCol] != word.charAt(curIndex)) {
            return false;
        }

        boolean found = curIndex == word.length() - 1 ? true : false;
        int rows = board.length;
        int columns = board[0].length;
        visited[curRow][curCol] = '1';

        if (!found && curRow - 1 >= 0 && visited[curRow - 1][curCol] == '0') {
            found = checkExist(board, curRow - 1, curCol, word, curIndex + 1, visited);
        }

        if (!found && curRow + 1 < rows && visited[curRow + 1][curCol] == '0') {
            found = checkExist(board, curRow + 1, curCol, word, curIndex + 1, visited);
        }

        if (!found && curCol - 1 >= 0 && visited[curRow][curCol - 1] == '0') {
            found = checkExist(board, curRow, curCol - 1, word, curIndex + 1, visited);
        }

        if (!found && curCol + 1 < columns && visited[curRow][curCol + 1] == '0') {
            found = checkExist(board, curRow, curCol + 1, word, curIndex + 1, visited);
        }

        visited[curRow][curCol] = '0';
        return found;
    }
}