/*You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?*/

import java.util.Arrays;

public class Solution {
    public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = tmp;
            }
        }
    }

    public static void main(String[] args) {
        com.company.Solution s = new com.company.Solution();
        int[][] maxtrix = {{1,2}, {3, 4}};//{{1,2,3}, {4, 5, 6}, {7, 8, 9}};
        s.rotate(maxtrix);
        for(int i = 0; i < maxtrix.length; i++) {
            System.out.println(Arrays.toString(maxtrix[i]));
        }
    }
}