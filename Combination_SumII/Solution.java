/* Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:

    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, ¡­ , ak) must be in non-descending order. (ie, a1 ¡Ü a2 ¡Ü ¡­ ¡Ü ak).
    The solution set must not contain duplicate combinations.

For example, given candidate set 10,1,2,7,6,1,5 and target 8,
A solution set is:
[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6] */

public class Solution {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
    	List<Integer> mystack = new ArrayList<Integer>();
    	int end = num.length; 
    	if(end == 0) {
    		return result; 
    	}
    	Arrays.sort(num); 
    	combinationSum(mystack, 0, end, num, target, result);
    	return result; 
    }
    public void combinationSum(List<Integer> mystack, int start, int end, int[] candidates, int target, List<List<Integer>> result) {
    	if(target == 0) {
    		// find the answer 
    		List<Integer> r = new ArrayList<Integer>(mystack); 
    		result.add(r);
    		return; 
    	} else if (target < 0) {
    		return; 
    	}
    	
    	int i = start; 
    	while(i < end) {
    		mystack.add(candidates[i]); 
    		target -= candidates[i]; 
    		combinationSum(mystack, i + 1, end, candidates, target, result); 
    		mystack.remove(mystack.size() - 1); 
    		target += candidates[i]; 
    		i++;
     		while(i > 0 && i < end && candidates[i] == candidates[i - 1]) {
    			i++; 
    		}	
    	}
    	
    	return; 
    }
}