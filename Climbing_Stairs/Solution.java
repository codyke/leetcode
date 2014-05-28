/*You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top? */

public class Solution {
    public int climbStairs(int n) {
        int ways[] = new int[n+1];
        int i = 0;
        ways[0] = 1;
        for(i = 1; i <= n; i++) {
            ways[i] = 0;
            if (i - 1 >= 0) {
                ways[i] += ways[i - 1];
            }
            if (i - 2 >= 0) {
                ways[i] += ways[i - 2];
            }
        }
        return ways[n];
    }
}