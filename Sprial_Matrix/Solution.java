package com.company;

import java.util.*;

/**
 Given an m x n matrix, return all elements of the matrix in spiral order.



 Example 1:


 Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
 Output: [1,2,3,6,9,8,7,4,5]
 Example 2:


 Input: matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */


class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int minRow = 0;
        int maxRow = matrix.length - 1;
        int minCol = 0;
        int maxCol = matrix[0].length - 1;
        List<Integer> result = new ArrayList<>();

        do {
            int curCol = minCol;
            while(curCol <= maxCol && minRow <= maxRow) {
                result.add(matrix[minRow][curCol]);
                curCol++;
            }
            minRow++;

            int curRow = minRow;
            while(curRow <= maxRow && minCol <= maxCol) {
                result.add(matrix[curRow][maxCol]);
                curRow++;
            }
            maxCol--;

            curCol = maxCol;
            while(curCol >= minCol && minRow <= maxRow) {
                result.add(matrix[maxRow][curCol]);
                curCol--;
            }
            maxRow--;

            curRow = maxRow;
            while(curRow >= minRow && minCol <= maxCol) {
                result.add(matrix[curRow][minCol]);
                curRow--;
            }
            minCol++;
        } while(maxRow >= minRow && maxCol >= minCol);
        return result;
    }
}