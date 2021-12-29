package com.company;

/**
 Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

 An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.



 Example 1:

 Input: grid = [
 ["1","1","1","1","0"],
 ["1","1","0","1","0"],
 ["1","1","0","0","0"],
 ["0","0","0","0","0"]
 ]
 Output: 1
 Example 2:

 Input: grid = [
 ["1","1","0","0","0"],
 ["1","1","0","0","0"],
 ["0","0","1","0","0"],
 ["0","0","0","1","1"]
 ]
 Output: 3
 */
class Solution {
    int[][] marks;
    public int numIslands(char[][] grid) {

        marks = new int[grid.length][grid[0].length];
        int numIsland = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(marks[i][j] == 0 && grid[i][j] == '1') {
                    numIsland++;
                    propogate(grid, i, j);
                }
            }
        }
        return numIsland;
    }

    private void propogate(char[][] grid, int i, int j) {
        if(marks[i][j] == 1 || grid[i][j] == '0') {
            return;
        }

        marks[i][j] = 1;
        if (i > 0) {
            propogate(grid, i - 1, j);
        }

        if (i < grid.length - 1) {
            propogate(grid, i + 1, j);
        }

        if (j > 0) {
            propogate(grid, i, j - 1);
        }

        if (j < grid[i].length - 1) {
            propogate(grid, i, j + 1);
        }

        return;
    }
    
    public static void main(String[] str) {
        Solution s = new Solution();
        char[][] grid = {{'1','1','1','1','0'},
                         {'1','1','0','1','0'},
                         {'1','1','0','0','0'},
                         {'0','0','0','0','0'}};
        System.out.println(s.numIslands(grid));
    }
}