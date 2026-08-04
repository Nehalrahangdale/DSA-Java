class Solution {

    public List<List<String>> partition(String s) {

        List<List<String>> ans = new ArrayList<>();

        backtrack(0, s, new ArrayList<>(), ans);

        return ans;
    }

    void backtrack(int start, String s,
                   List<String> path,
                   List<List<String>> ans) {

        // Base Case
        if (start == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        // Try every possible substring
        for (int end = start; end < s.length(); end++) {

            if (isPalindrome(s, start, end)) {

                path.add(s.substring(start, end + 1));

                backtrack(end + 1, s, path, ans);

                path.remove(path.size() - 1); // Backtrack
            }
        }
    }

    boolean isPalindrome(String s, int left, int right) {

        while (left < right) {

            if (s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }
}
