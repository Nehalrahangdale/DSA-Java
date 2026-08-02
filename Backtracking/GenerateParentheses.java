class Solution {

    public List<String> generateParenthesis(int n) {

        List<String> ans = new ArrayList<>();

        solve(ans, "", 0, 0, n);

        return ans;
    }

    public void solve(List<String> ans,
                      String curr,
                      int open,
                      int close,
                      int n) {

        // Base Case
        if (curr.length() == 2 * n) {
            ans.add(curr);
            return;
        }

        // Add '('
        if (open < n) {
            solve(ans,
                  curr + "(",
                  open + 1,
                  close,
                  n);
        }

        // Add ')'
        if (close < open) {
            solve(ans,
                  curr + ")",
                  open,
                  close + 1,
                  n);
        }
    }
}
