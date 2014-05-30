/* The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R

And then read line by line: "PAHNAPLSIIGYIR"

Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);

convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR". */

public class Solution {
    public String convert(String s, int nRows) {
        int i = 0; 
        int k = 1; 
        int n = nRows - 1; 
        int index = 0; 
        int turn = 0; 
        StringBuffer[] zigZag = new StringBuffer[nRows]; 
        for(i = 0; i < nRows; i++) {
            zigZag[i] = new StringBuffer();
        }
        String result = ""; 
        if(n == 0) {
            result = s; 
            return result; 
        }
        for(i = 0; i < s.length(); i++) {
            if(turn == 0) {
                //index = i % ((((k - 1) != 0)?(k - 1):1) * n); 
                zigZag[index].append(s.charAt(i)); 
                index++;
            } else {
                //index = k * n - (i % (k * n)); 
                zigZag[index].append(s.charAt(i)); 
                index--;
            }
            if ((i + 1) % n == 0) {
                k++;
                if(k % 2 == 1) {
                    index = 0; 
                    turn = 0; 
                } else {
                    index = n; 
                    turn = 1;
                }
            }
        }
        for(i = 0; i < nRows; i++) {
            result += zigZag[i].toString(); 
        }
        return result; 
    }
}