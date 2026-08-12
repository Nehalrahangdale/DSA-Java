class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        backtrack(nums, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int[] nums, int start,
                           List<Integer> current,
                           List<List<Integer>> ans) {

        // Every current combination is a valid subset
        ans.add(new ArrayList<>(current));

        for (int i = start; i < nums.length; i++) {

            // Skip duplicate at the same level
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }

            // Choose
            current.add(nums[i]);

            // Explore
            backtrack(nums, i + 1, current, ans);

            // Undo
            current.remove(current.size() - 1);
        }
    }
}
