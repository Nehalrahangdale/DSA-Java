class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        solve(candidates, target, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void solve(int[] candidates, int target, int index,
                       List<Integer> temp,
                       List<List<Integer>> ans) {

        // Base Case
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (target < 0) {
            return;
        }

        // Try every candidate from current index
        for (int i = index; i < candidates.length; i++) {

            temp.add(candidates[i]);

            // Reuse same element
            solve(candidates, target - candidates[i], i, temp, ans);

            // Backtrack
            temp.remove(temp.size() - 1);
        }
    }
}
