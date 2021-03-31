import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(result, nums, 0);
        return  result;
    }

    private void permuteHelper(List<List<Integer>> result, int[] nums, int index) {
        if (index == nums.length - 1) {
            List<Integer> onePermutation = new ArrayList<>();
            onePermutation.add(nums[index]);
            result.add(onePermutation);
            return;
        } else {
            int curNum = nums[index];
            List<List<Integer>> tmpResult = new ArrayList<>();
            permuteHelper(tmpResult, nums, index + 1);
            for (List<Integer> subPermutation : tmpResult) {
                for(int idx = 0; idx <= subPermutation.size(); idx++) {
                    List<Integer> permutationCopy = new ArrayList<>(subPermutation);
                    permutationCopy.add(idx, curNum);
                    result.add(permutationCopy);
                }
            }
        }
    }

    public static void main(String[] arg) {
        int[] nums = {1, 2, 3};
        Solution2 solution = new Solution2();
        List<List<Integer>> result = solution.permute(nums);
        System.out.println(result);
    }
}
