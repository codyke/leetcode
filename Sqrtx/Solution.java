/*Implement int sqrt(int x).

Compute and return the square root of x.*/

public class Solution {
    public int sqrt(int x) {
        long start = 1;
        long end = x; 
        int root = 0;
        
        while(start <= end) {
            long mid = (start + end) /  2; 
            if(mid * mid == x) {
                root = (int)mid;
                break;
            } else if (mid * mid > x) {
                end = mid;
            } else {
                if(start == mid) {
                    root = (int)mid;
                    break;
                }
                start = mid; 
            }
        }
        
        return root; 
    }
}