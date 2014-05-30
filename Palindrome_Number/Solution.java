/*Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.
Some hints:

Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
*/

public class Solution {
    public boolean isPalindrome(int x) {
        int length = 0; 
        int a = x; 
        int i; 
        if (x < 0) {
            return false;
        }
        while(a != 0) {
            a /= 10; 
            length++;
        }
        int middle = length / 2; 
        int left = x; 
        for(i = 0; i < length - middle; i++){
            left /= 10;
        }
        int right = 0; 
        for(i = 0; i < middle; i++) {
            right = right * 10 + x % 10; 
            x /= 10;
        } 
        return (left == right);
    }
}