/* There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

Note:
The solution is guaranteed to be unique. */

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length; 
        if(len == 0) {
            return -1;
        }
        
        int start = 0; 
        int end = 0; 
        int leftGas = 0; 
        while(start < len) {
            leftGas += (gas[end] - cost[end]); 
            end++; 
            if(end >= len) {
                end -= len; 
                
            }
            if(leftGas < 0) {
                leftGas = 0; 
                if(end <= start) {
                    start = len; 
                    break; 
                }
                start = end; 
            } else if (end == start) {
                break; 
            }
        }
        
        if(leftGas < 0 || start >= len) {
            return -1;
        } else {
            return start; 
        }
    }
}