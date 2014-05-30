/* Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100". */

public class Solution {
    public String addBinary(String a, String b) {
        int index = -1; 
        int ia = a.length() - 1; 
        int ib = b.length() - 1; 
        char carry = '0';
        int count = 0; 
        String result = "";
        String leftover = "";
        
        
        while(ia >= 0 && ib >= 0) {
            count = 0;
            if(a.charAt(ia--) == '1') {
                count++;
            }
            if(b.charAt(ib--) == '1') {
                count++;
            }
            if(carry == '1') {
                count++;
            }
            
            if(count < 2) {
                carry = '0'; 
              
            } else {
                carry = '1'; 
            }
            if(count %2 == 0) {
                result = "0" + result; 
            } else {
                result = "1" + result; 
            }
        }
        
        if(ia >= 0) {
            index = ia; 
            leftover = a;
        } else if (ib >=0) {
            index = ib; 
            leftover = b; 
        }
        
        while(index >= 0) {
            count = 0;
            if(leftover.charAt(index--) == '1') {
                count++;
            }
            if(carry == '1') {
                count++;
            }
            
            if(count < 2) {
                carry = '0'; 
            } else {
                carry = '1'; 
            }
            if(count %2 == 0) {
                result = "0" + result; 
            } else {
                result = "1" + result; 
            }
            
        }
        if(carry == '1'){
            result = "1" + result; 
        }
        return result;
    }
}