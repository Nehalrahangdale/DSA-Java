import java.util.*;

class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        findPermutation(nums, new ArrayList<>(), result, used);

        return result;
    }

    public void findPermutation(int[] nums, List<Integer> ans,
                                List<List<Integer>> result,
                                boolean[] used) {

        // Base Case
        if (ans.size() == nums.length) {
            result.add(new ArrayList<>(ans));
            return;
        }

        // Recursion
        for (int i = 0; i < nums.length; i++) {

            if (used[i]) {
                continue;
            }

            used[i] = true;
            ans.add(nums[i]);

            findPermutation(nums, ans, result, used);

            // Backtracking
            ans.remove(ans.size() - 1);
            used[i] = false;
        }
    }
}
