package com.company;

/*
According to Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

The board is made up of an m x n grid of cells, where each cell has an initial state: live (represented by a 1) or dead (represented by a 0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

Any live cell with fewer than two live neighbors dies as if caused by under-population.
Any live cell with two or three live neighbors lives on to the next generation.
Any live cell with more than three live neighbors dies, as if by over-population.
Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.



Example 1:

Input: board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
Output: [[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
Example 2:


Input: board = [[1,1],[1,0]]
Output: [[1,1],[1,1]]
*/


import java.util.*;

class Solution {
    public void gameOfLife(int[][] board) {
        /* if 0->1, new value is 11;
           if 0->0, new value is 0;
           if 1->1, new value is 1;
           if 1->0, new value is 10;
         */

        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int liveCount = countLiveNeighbor(board, i ,j);
                if (board[i][j] == 0) {
                    /* dead cell reproduction*/
                    board[i][j] = liveCount == 3? 11 : 0;
                } else {
                    if (liveCount < 2 || liveCount > 3) {
                        /* livecell under-population or over-population */
                        board[i][j] = 10;
                    }
                }
            }
        }
        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] >= 10) {
                    board[i][j] -= 10;
                }
            }
        }
    }

    private int countLiveNeighbor(int[][] board, int i, int j) {
        int liveCount = 0;
        int maxRow = board.length - 1;
        int maxColumn = board[i].length - 1;
        if (j > 0) {
            if (isLive(board[i][j - 1])) {
                liveCount++;
            }
            if (i > 0 && isLive(board[i - 1][j - 1])) {
                liveCount++;
            }
            if (i < maxRow && isLive(board[i + 1][j - 1])) {
                liveCount++;
            }
        }
        if (i > 0 && isLive(board[i - 1][j])) {
            liveCount++;
        }
        if (i < maxRow && isLive(board[i + 1][j])) {
            liveCount++;
        }

        if (j < maxColumn) {
            if (isLive(board[i][j + 1])) {
                liveCount++;
            }
            if (i > 0 && isLive(board[i - 1][j + 1])) {
                liveCount++;
            }
            if (i < maxRow && isLive(board[i + 1][j + 1])) {
                liveCount++;
            }
        }
        return liveCount;
    }

    private boolean isLive(int cellValue) {
        if (cellValue == 1 || cellValue == 10) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] str) {
        Solution s = new Solution();
        int[][] board = {{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
        s.gameOfLife(board);
        for(int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}