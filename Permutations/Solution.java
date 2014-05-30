/* Given a collection of numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1]. */

public class Solution {
    public ArrayList<ArrayList<Integer>> permute(int[] num) {
        return mypermute(num, 0);
    }
    
    public ArrayList<ArrayList<Integer>> mypermute(int[] num, int start) {
        int i = start;
        int j = start;
        int k;
        ArrayList<ArrayList<Integer>> final_result = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> result = null;
        if (start == num.length - 1) {
            ArrayList<Integer> oneItem = new ArrayList<Integer>(1);
            oneItem.add(num[start]);
            final_result.add(oneItem);
        }
        for(i = start, j = start; i < num.length; i++) {
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