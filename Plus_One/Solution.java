/*Given a non-negative number represented as an array of digits, plus one to the number.

The digits are stored such that the most significant digit is at the head of the list.*/

public class Solution {
    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        int carry = 1;
        while(carry != 0 && i >= 0) {
            digits[i] += carry;
            if (digits[i] > 9 ) {
                digits[i] -= 10;
                i--;
                carry = 1;
            } else {
                carry = 0;
            }
        }
        if (i < 0) {
            int[] result = new int[digits.length + 1]; 
            result[0] = carry;
            for(i = 0; i < digits.length; i++) {
                result[i + 1] = digits[i];
            }
            return result;
        } else {
            return digits; 
        }
    }
}