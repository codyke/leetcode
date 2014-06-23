/*Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.

For example, given the following triangle

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]

The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).

Note:
Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle. */

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size(); 
        if(n == 0) {
            return 0; 
        }
        int[] result = new int[n]; 
        int[] result2 = new int[n]; 
        for(int i = 0; i < n; i++) {
            List<Integer> row = triangle.get(i); 
            int num = row.size(); 
            for(int j = 0; j < num; j++) {
                if(j == 0) {
                    result2[j] = result[0] + row.get(0); 
                } else if (j == num - 1) {
                    result2[j] = result[j - 1] + row.get(j);
                } else {
                    result2[j] = (result[j - 1] < result[j] ? result[j - 1] : result[j]) + row.get(j); 
                }
            }
            // reset result 
            int[] tmp = result2; 
            result2 = result; 
            result = tmp; 
            Arrays.fill(result2, 0); 
        }
        int minSum = result[0]; 
        for(int i = 1; i < n; i++) {
            if (minSum > result[i]) {
                minSum = result[i];
            }
        }
        
        return minSum; 
    }
}