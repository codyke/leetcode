/*The gray code is a binary numeral system where two successive values differ in only one bit.

Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.

For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:

00 - 0
01 - 1
11 - 3
10 - 2

Note:
For a given n, a gray code sequence is not uniquely defined.

For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.

For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.*/

import java.util.*;
import java.lang.*;

public class Solution {
    public ArrayList<Integer> grayCode(int n) {
        Set<String> graycodeset = new HashSet<String>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        int num = (int)Math.pow(2,n);
        int i = 0;
        int j = 0;
        BitSet t = new BitSet(n);
        for(i = 0; i < num; i++) {
            if (graycodeset.contains(t.toString())) {
                for(j = 0; j < n; j++) {
                    t.flip(j); 
                    if (graycodeset.contains(t.toString())) {
                        t.flip(j);
                    } else {
                        break;
                    }
                }
                result.add(toInt(t));
                graycodeset.add(t.toString());
            } else {
                result.add(toInt(t));
                graycodeset.add(t.toString());
            }
        }
        return result;
    }
    
    public int toInt(BitSet t){
        int i = 0; 
        int result = 0;
        for(i = 0; i < 32; i++) {
            if (t.get(i)) {
                result |= (1 << i);
            }
        }
        return result;
    }
}