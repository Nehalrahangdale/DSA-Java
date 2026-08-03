class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);

        List<List<Integer>> ans = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void backtrack(int[] arr, int target, int start,
                           List<Integer> curr,
                           List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i < arr.length; i++) {

            // Skip duplicate values at the same recursion level
            if (i > start && arr[i] == arr[i - 1])
                continue;

            // No need to continue if the number is too large
            if (arr[i] > target)
                break;

            curr.add(arr[i]);

            backtrack(arr, target - arr[i], i + 1, curr, ans);

            curr.remove(curr.size() - 1);
        }
    }
}
