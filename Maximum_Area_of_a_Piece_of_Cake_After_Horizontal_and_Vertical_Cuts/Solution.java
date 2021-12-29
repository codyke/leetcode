package com.company;

import java.util.*;

/**
 Given a rectangular cake with height h and width w, and two arrays of integers horizontalCuts and verticalCuts where horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly, verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.

 Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in the arrays horizontalCuts and verticalCuts. Since the answer can be a huge number, return this modulo 10^9 + 7.



 Example 1:



 Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
 Output: 4
 Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green piece of cake has the maximum area.
 Example 2:



 Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
 Output: 6
 Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green and yellow pieces of cake have the maximum area.
 Example 3:

 Input: h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
 Output: 9
 */
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);

        long maxHCut = findMaxCut(horizontalCuts, h);

        long maxVCut = findMaxCut(verticalCuts, w);

        long area = maxHCut * maxVCut;
        return (int)(area % (1e9 + 7));
    }

    public int findMaxCut(int[] cuts, int hw) {
        int maxCut = 0;
        for(int i = 0; i <= cuts.length; i++) {
            int size = 0;
            if(i == 0) {
                size = cuts[i];
            } else if (i == cuts.length) {
                size = hw - cuts[i - 1];
            } else {
                size = cuts[i] - cuts[i - 1];
            }
            maxCut = Math.max(maxCut, size);
        }
        return maxCut;
    }
}