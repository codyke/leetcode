package com.company;

import java.util.*;

/**
 On an infinite plane, a robot initially stands at (0, 0) and faces north. The robot can receive one of three instructions:

 "G": go straight 1 unit;
 "L": turn 90 degrees to the left;
 "R": turn 90 degrees to the right.
 The robot performs the instructions given in order, and repeats them forever.

 Return true if and only if there exists a circle in the plane such that the robot never leaves the circle.



 Example 1:

 Input: instructions = "GGLLGG"
 Output: true
 Explanation: The robot moves from (0,0) to (0,2), turns 180 degrees, and then returns to (0,0).
 When repeating these instructions, the robot remains in the circle of radius 2 centered at the origin.
 Example 2:

 Input: instructions = "GG"
 Output: false
 Explanation: The robot moves north indefinitely.
 Example 3:

 Input: instructions = "GL"
 Output: true
 Explanation: The robot moves from (0, 0) -> (0, 1) -> (-1, 1) -> (-1, 0) -> (0, 0) -> ...
 */
class Solution {
    public boolean isRobotBounded(String instructions) {
        int sn = 1;
        int ew = 0;
        int x = 0;
        int y = 0;

        for(char c : instructions.toCharArray()) {
            if (c == 'G') {
                y += sn;
                x += ew;
            } else if (c == 'L') {
                int tmp = sn;
                sn = sn == 0 ? ew : 0;
                ew = ew == 0 ? -tmp : 0;
            } else if (c == 'R') {
                int tmp = sn;
                sn = sn == 0 ? -ew : 0;
                ew = ew == 0 ? tmp : 0;
            }
        }

        return sn != 1 || (x == 0 && y ==0);
    }
}