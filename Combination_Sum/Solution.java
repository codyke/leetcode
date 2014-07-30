/* Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
    The solution set must not contain duplicate combinations.

For example, given candidate set 2,3,6,7 and target 7,
A solution set is:
[7]
[2, 2, 3] 
*/
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
   	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> mystack = new ArrayList<Integer>();
    	int end = candidates.length; 
    	if(end == 0) {
    		return result; 
    	}
    	Arrays.sort(candidates); 
    	combinationSum2(mystack, 0, end, candidates, target, result);
    	return result; 
    }

   public void combinationSum2(List<Integer> mystack, int start, int end, int[] candidates, int target, List<List<Integer>> result) {
    	if(target == 0) {
    		// find the answer 
    		List<Integer> r = new ArrayList<Integer>(mystack); 
    		result.add(r);
    		return; 
    	} else if (target < 0) {
    		return; 
    	}
    	
    	for(int i = start; i < end; i++) {
    		if(i > 0) {
    			while(candidates[i] == candidates[i - 1]) {
    				i++; 
    			}
    		}
    		
    		mystack.add(candidates[i]); 
    		target -= candidates[i]; 
    		combinationSum2(mystack, i, end, candidates, target, result); 
    		mystack.remove(mystack.size() - 1); 
    		target += candidates[i]; 
    	}
    	
    	return; 
    }
     
}