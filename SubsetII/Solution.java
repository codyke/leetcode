/* Given a collection of integers that might contain duplicates, S, return all possible subsets.

Note:

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.

For example,
If S = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]
*/

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] S) {
        List<List<Integer>> result = new ArrayList<List<Integer>>(); 
        List<List<Integer>> tmpResult = new ArrayList<List<Integer>>(); 
        List<List<Integer>> r = new ArrayList<List<Integer>>(); 
        int len = S.length; 
        if(len == 0) {
            return result; 
        }
        Arrays.sort(S); 
        int pre = S[0] - 1;
        for(int i = 0; i < len; i++) {
            if(pre == S[i]) {
                continue; 
            }
            List<Integer> n = new ArrayList<Integer>(); 
            n.add(S[i]); 
            pre = S[i]; 
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
                int repeat = 1; 
                for(int j = n.size() - 2; j >= 0; j--) {
                    if(n.get(j) == maxNum) {
                        repeat++; 
                    } else {
                        break; 
                    }
                }
                pre = S[0] - 1; 
                int first = 0;
                for(int j = 0; j < len; j++) {
                    if(S[j] < maxNum) {
                        continue; 
                    } else if(S[j] == maxNum) {
                        if(first == 0) {
                            first = 1; 
                            j += repeat - 1; 
                            continue; 
                        }
                    }
                    {
                        if(pre == S[j]) {
                            continue; 
                        }
                        List<Integer> m = new ArrayList<Integer>(); 
                        m.addAll(n); 
                        m.add(S[j]); 
                        pre = S[j]; 
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