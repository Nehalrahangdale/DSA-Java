class Solution {

    List<String> ans = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, new ArrayList<>());
        return ans;
    }

    private void backtrack(String s, int index, List<String> path) {

        // Base Case
        if (path.size() == 4) {
            if (index == s.length()) {
                ans.add(String.join(".", path));
            }
            return;
        }

        // Try segments of length 1, 2, and 3
        for (int len = 1; len <= 3 && index + len <= s.length(); len++) {

            String part = s.substring(index, index + len);

            if (isValid(part)) {

                path.add(part);

                backtrack(s, index + len, path);

                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isValid(String part) {

        // Leading zero check
        if (part.length() > 1 && part.charAt(0) == '0')
            return false;

        int num = Integer.parseInt(part);

        return num >= 0 && num <= 255;
    }
}
