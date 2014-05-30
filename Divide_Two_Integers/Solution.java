/*Divide two integers without using multiplication, division and mod operator. */
public class Solution {
    public int divide(int dividend, int divisor) {
        int result = 0; 
        int sign = 0; 
        long tmp = 0;  
        long sum = 0;
        int intermediaResult = 0; 
        long udivisor = divisor;
        long udividend = dividend; 
        if (dividend == 0) {
            return 0; 
        }
        if (divisor == 1) {
            return dividend; 
        }
        
        if (divisor < 0 && dividend > 0) {
            sign = 1; 
            udivisor = -udivisor; 
        } else if(dividend < 0 && divisor > 0) {
            sign = 1; 
            udividend = -udividend;
        } else if(dividend < 0 && divisor < 0) {
            udividend = -udividend; 
            udivisor = -udivisor;
        }
        while ((sum + udivisor) <= udividend) {
            tmp = udivisor;
            intermediaResult = 1;
            while((sum + tmp) <= udividend) {
                sum += tmp; 
                result += intermediaResult; 
                tmp += tmp; 
                intermediaResult += intermediaResult;
            }
        }

        if (sign == 1) {
            return -result;
        } else {
            return result; 
        }
    }
}