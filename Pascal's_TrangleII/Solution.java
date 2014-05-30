/*Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space? */

public class Solution {
    public ArrayList<Integer> getRow(int rowIndex) {
        int i = 0; 
        int j = 0; 
        ArrayList<Integer> result = new ArrayList<Integer>(); 
        result.add(1); 
        for(i = 1; i <= rowIndex; i++) {
            int num = i + 1; 
            ArrayList<Integer> tmp = new ArrayList<Integer>(); 
            for(j = 0; j < num; j++) {
                if(j == 0 || j == num - 1) {
                    tmp.add(result.get(j == 0?0:i-1)); 
                } else {
                    tmp.add(result.get(j -1 ) + result.get(j)); 
                }
            }
            result.clear();
            result.addAll(tmp); 
        }
        return result; 
    }
}