public class Solution {
    public double pow(double x, int n) {
        double result = 1.0; 
        int sign = 0; 
        long nn = n;
        if(n == 0) {
            result = 1.0; 
        } else {
            if (n < 0) {
                nn = -1L * n;
                sign = 1; 
            }
            double remain = 1.0;
            double r = x; 
            while(nn > 1) {
                if(nn % 2 == 1) {
                    remain *= r;
                } 
                r *= r; 
                nn /= 2; 
                
            }
            result = r * remain; 
            
        }
        
        if(sign == 1) {
            result = 1 / result; 
        }
        return result; 
    }
}