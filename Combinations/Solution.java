/* Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
*/

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        List<List<Integer>> tmpResult = new ArrayList<List<Integer>>();
        if(n == 0 || k == 0) {
            return result; 
        }
        
        // initialization 
        for(int i = 1; i <= n - k + 1; i++) {
            List<Integer> tmp = new ArrayList<Integer>(); 
            tmp.add(i); 
            result.add(tmp); 
        }
        int cur = 2; 
        while(cur <= k) { 
            List<List<Integer>> t = result; 
            result = tmpResult; 
            result.clear();
            tmpResult = t; 
            // go through every List in tmpResult and add next 
            int size = tmpResult.size(); 
            for(int i = 0; i < size; i++) {
                List<Integer> list = tmpResult.get(i); 
                int next = list.get(list.size() - 1); 
                for(int j = next + 1; j + k - cur <= n; j++) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.addAll(list); 
                    tmp.add(j); 
                    result.add(tmp); 
                }
            }
            cur++; 
        }
        return result; 
    }
}