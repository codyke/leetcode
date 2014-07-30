/*
 Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1]. */

public class Solution {
    public List<List<Integer>> permuteUnique(int[] num) {
        Arrays.sort(num); 
        return mypermute(num, 0);     
    }
    
    public ArrayList<List<Integer>> mypermute(int[] num, int start) {
        int i = start;
        int j = start;
        ArrayList<List<Integer>> final_result = new ArrayList<List<Integer>>();
        ArrayList<List<Integer>> result = null;
        if (start == num.length - 1) {
            ArrayList<Integer> oneItem = new ArrayList<Integer>(1);
            oneItem.add(num[start]);
            final_result.add(oneItem);
        }
        for(i = start, j = start; i < num.length; i++) {
            int k = start;
            for(k = start; k < i; k++) {
                if(num[k] == num[i]) {
                    break; 
                }
            }
            if(k != i) {
                continue; 
            }
            //swap
            int tmp = num[j];
            num[j] = num[i];
            num[i] = tmp;
            
            result = mypermute(num, start + 1);
            for(k = 0; k < result.size(); k++) {
                result.get(k).add(0, num[start]);
                final_result.add(result.get(k));
            }
            
            //swap back
            tmp = num[j];
            num[j] = num[i];
            num[i] = tmp;
        }
        return final_result;
    }
}