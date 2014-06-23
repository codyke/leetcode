/* Given a set of distinct integers, S, return all possible subsets.

Note:

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.

For example,
If S = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
*/

public class Solution {
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        List<List<Integer>> tmpResult = new ArrayList<List<Integer>>(); 
        List<List<Integer>> r = new ArrayList<List<Integer>>(); 
        int len = S.length; 
        if(len == 0) {
            return result; 
        }
        Arrays.sort(S); 
        for(int i = 0; i < len; i++) {
            List<Integer> n = new ArrayList<Integer>(); 
            n.add(S[i]); 
            result.add(n); 
        }
        r.addAll(result); 
        int iter = 2; 
        while(iter <= len) {
            List<List<Integer>> tmp = result; 
            result = tmpResult; 
            tmpResult = tmp; 
            int num = tmpResult.size();  
            for(int i = 0; i < num; i++) {
                List<Integer> n = tmpResult.get(i); 
                int maxNum = n.get(n.size() - 1); 
                for(int j = 0; j < len; j++) {
                    if(S[j] <= maxNum) {
                        continue; 
                    } else {
                        List<Integer> m = new ArrayList<Integer>(); 
                        m.addAll(n); 
                        m.add(S[j]); 
                        result.add(m); 
                    }
                }
            }
            tmpResult.clear(); 
            r.addAll(result); 
            iter++;
        }
        List<Integer> empty = new ArrayList<Integer>(); 
        r.add(empty);
        return r; 

    }
}